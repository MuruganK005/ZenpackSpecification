package com.example.specification.repository;

import com.example.specification.dao.Zenpack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ZenpackRepository extends JpaSpecificationExecutor<Zenpack>, PagingAndSortingRepository<Zenpack, Integer> {

    @Query("select p from Zenpack p where p.updatedTime >= :startDate and p.updatedTime <= :endDate")
    public Page<Zenpack> getZenpackByDateRange(Timestamp startDate, Timestamp endDate, Specification<Zenpack> spec, PageRequest pageRequest);
}
