package com.example.specification.service;

import com.example.specification.dao.Zenpack;
import com.example.specification.dto.FilterDTO;
import com.example.specification.dto.ZenpackDTO;
import com.example.specification.dto.ZenpackFilterDTO;
import com.example.specification.repository.ZenpackRepository;
import com.example.specification.specification.ZenpackSpecification;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZenpackService {

    @Autowired
    ZenpackRepository zenpackRepository;

    @Autowired
    private ZenpackSpecification zenpackSpecification;

    public void create(ZenpackDTO zenpackDTO) {
        Zenpack zenpack = new Zenpack();
        zenpack.setZenPackName("name");
        zenpack.setFeatureName("menu name");
        zenpack.setMenuName("feature name");
        zenpackRepository.save(zenpack);
    }

    public List<Zenpack> getList(ZenpackFilterDTO zenpackFilterDTO) {

        ArrayList<Specification<Zenpack>> zenpackSpecifications = new ArrayList<Specification<Zenpack>>();
        for (FilterDTO zenpackDTO : zenpackFilterDTO.getFilterDTOList()) {
//            ZenpackSpecification zenpackSpecification = new ZenpackSpecification(zenpackDTO.getKey(), zenpackDTO.getValue(), zenpackDTO.getOperator());
            zenpackSpecifications.add(zenpackSpecification.getZenpacks(zenpackDTO));
        }
//        Specification<Zenpack> getZenbugsByDateRange = zenpackSpecification.getZenpackByDateRange(zenpackFilterDTO);

        if (zenpackSpecifications.isEmpty()) {
            return null;
        }

        Specification<Zenpack> spec = zenpackSpecifications.get(0);

        if (zenpackSpecifications.size() > 1) {
            for (int i = 0; i<zenpackSpecifications.size(); i++) {
                spec = spec.and(zenpackSpecifications.get(i));
            }
        }
//        if (getZenbugsByDateRange != null) {
//            spec.and(getZenbugsByDateRange);
//        }

        return getPagedPlays(spec, zenpackFilterDTO.getPage(), zenpackFilterDTO.getSize(), zenpackFilterDTO).getContent();
    }

    public Page<Zenpack>  getPagedPlays(Specification<Zenpack> spec, Integer page, Integer size, ZenpackFilterDTO zenpackFilterDTO) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "zenpackName");
        if (zenpackFilterDTO.getSortType() == "desc") {
            pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "zenpackName");
        }
//        return zenpackRepository.getZenpackByDateRange(zenpackFilterDTO.getStartDate(), zenpackFilterDTO.getEndDate(), spec, pageRequest);
        return zenpackRepository.findAll(spec, pageRequest);
    }
}
