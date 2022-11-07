package com.example.specification.specification;

import com.example.specification.dao.Zenpack;
import com.example.specification.dto.FilterDTO;
import com.example.specification.dto.ZenpackFilterDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;

@Component
public class ZenpackSpecification {

    public Specification<Zenpack> getZenpacks(FilterDTO zenpackDTO) {
        return (root, query, criteriaBuilder) -> {
            ArrayList<String> names = new ArrayList<>();
            names.add("zenpackName");
            names.add("menuName");
            names.add("featureName");
            if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("contains")) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(zenpackDTO.getKey())), "%"+zenpackDTO.getValue()
                        .toLowerCase()+"%");
            } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("not contains")) {
                return criteriaBuilder.notLike(criteriaBuilder.lower(root.<String>get(zenpackDTO.getKey())), "%"+zenpackDTO.getValue().toLowerCase()+"%");
            } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("equals")) {
                return criteriaBuilder.equal(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
            } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("not equals")) {
                return criteriaBuilder.notEqual(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
            }
            return criteriaBuilder.notEqual(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
        };
    }

    public Specification<Zenpack> getZenpackByDateRange(ZenpackFilterDTO zenpackFilterDTO) {
        Timestamp str = zenpackFilterDTO.getStartDate();
        Timestamp str1 = str;
        return (root, query, criteriaBuilder) -> {
            ArrayList<String> names = new ArrayList<>();
            if (zenpackFilterDTO.getStartDate() != null && zenpackFilterDTO.getEndDate() != null) {
                return criteriaBuilder.between(root.<Timestamp>get("updatedTime"), zenpackFilterDTO.getStartDate(), zenpackFilterDTO.getEndDate());
            }
            return null;
        };
    }

//    private FilterDTO zenpackDTO;
//
////    String key;
////    String value;
////    String operator;
////
//    public ZenpackSpecification(FilterDTO zenpackDTO) {
//        this.zenpackDTO = zenpackDTO;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//        ArrayList<String> names = new ArrayList<>();
//        names.add("zenpackName");
//        names.add("menuName");
//        names.add("featureName");
//        if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("contains")) {
//            return criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(zenpackDTO.getKey())), "%"+zenpackDTO.getValue()
//                    .toLowerCase()+"%");
//        } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("not contains")) {
//            return criteriaBuilder.notLike(criteriaBuilder.lower(root.<String>get(zenpackDTO.getKey())), "%"+zenpackDTO.getValue().toLowerCase()+"%");
//        } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("equals")) {
//            return criteriaBuilder.equal(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
//        } else if (names.contains(zenpackDTO.getKey()) && zenpackDTO.getOperator().equals("not equals")) {
//            return criteriaBuilder.notEqual(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
//        }
////        if (names.contains(key) && operator.equals("like")) {
////            return criteriaBuilder.like(criteriaBuilder.lower(root.get(key)), "%"+value.toLowerCase()+"%");
////        }
////
////        if (names.contains(key) && operator.equals("like")) {
////            return criteriaBuilder.like(criteriaBuilder.lower(root.get(key)), "%"+value.toLowerCase()+"%");
////        }
////
////        if (names.contains(key) && operator.equals("like")) {
////            return criteriaBuilder.like(criteriaBuilder.lower(root.get(key)), "%"+value.toLowerCase()+"%");
////        }
//
////        if ("startDate" == (key)) {
////            return criteriaBuilder.equal( root.join<PlayDAO, PlayRecipientDAO>("recipients").get<PlayRecipientDAO>("recipientId"),
////                    UUIDUtils.sanitize(value));
////        }
////
////        if ("date" == (key)) {
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
////            Timestamp currentTime = Timestamp(dateFormat.parse(value).time);
////            return criteriaBuilder.between(root.<Timestamp>get("createdDate"), currentTime, currentTime);
////        }
////
////        if ("deleted" == (key)) {
////            return criteriaBuilder.equal(root.get<String>(key), value.toBoolean())
////        }
////
////        if ("published" == (key)) {
////            return criteriaBuilder.equal(root.get<String>(key), value.toBoolean())
////        }
////
////        if("id" == key) {
////            return criteriaBuilder.equal(root.get<String>(key), UUID.fromString(value))
////        }
//
//        return criteriaBuilder.equal(root.<String>get(zenpackDTO.getKey()), zenpackDTO.getValue());
//    }
}
