package cn.newtouch.util;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import cn.newtouch.contants.Contants;
import cn.newtouch.util.utils.Collections3;

import com.google.common.collect.Lists;

public class DynamicSpecifications
{
    public static <T> Specification<T> bySearchFilter(
            final Collection<SearchFilter> filters, final Class<T> clazz)
    {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                    CriteriaBuilder builder)
            {
                if (Collections3.isNotEmpty(filters))
                {

                    List<Predicate> predicates = Lists.newArrayList();
                    List<Predicate> orps = Lists.newArrayList();
                    for (SearchFilter filter : filters)
                    {
                        // nested path translate, 如Task的名为"user.name"的filedName,
                        // 转换为Task.user.name属性
                        if (filter.operator == SearchFilter.Operator.EQOR)
                        {
                            String[] orName = StringUtils.split(
                                    filter.fieldName, SearchFilter.OR_TAG);
                            for (String name : orName)
                            {
                                String[] names = StringUtils.split(name,
                                        Contants.POINT);
                                Path expression = root.get(names[0]);
                                for (int i = 1; i < names.length; i++)
                                {
                                    expression = expression.get(names[i]);
                                }
                                if ("null".equals(filter.value))
                                {
                                    orps.add(builder.isNull(expression));
                                }
                                else
                                {
                                    orps.add(builder.equal(expression,
                                            filter.value));
                                }
                            }
                            if (orps.size() > 0)
                            {
                                predicates.add(builder.or(orps
                                        .toArray(new Predicate[orps.size()])));
                            }
                        }
                        else
                        {
                            String[] names = StringUtils.split(
                                    filter.fieldName, Contants.POINT);
                            Path expression = root.get(names[0]);
                            for (int i = 1; i < names.length; i++)
                            {
                                expression = expression.get(names[i]);
                            }
                            if ("null".equals(filter.value))
                            {
                                predicates.add(builder.isNull(expression));
                            }
                            else
                            {
                                // logic operator
                                switch (filter.operator)
                                {
                                case EQ:
                                    predicates.add(builder.equal(expression,
                                            filter.value));
                                    break;
                                case LIKE:
                                    predicates.add(builder.like(expression, "%"
                                            + filter.value + "%"));
                                    break;
                                case GT:
                                    predicates.add(builder.greaterThan(
                                            expression,
                                            (Comparable) filter.value));
                                    break;
                                case LT:
                                    predicates.add(builder.lessThan(expression,
                                            (Comparable) filter.value));
                                    break;
                                case GTE:
                                    predicates.add(builder
                                            .greaterThanOrEqualTo(expression,
                                                    (Comparable) filter.value));
                                    break;
                                case LTE:
                                    predicates.add(builder.lessThanOrEqualTo(
                                            expression,
                                            (Comparable) filter.value));
                                    break;
                                case IN:
                                    predicates.add(expression
                                            .in(filter.listValue));
                                    break;
                                }
                            }
                        }
                    }

                    // 将所有条件用 and 联合起来
                    if (predicates.size() > 0)
                    {
                        return builder.and(predicates
                                .toArray(new Predicate[predicates.size()]));
                    }
                }
                return builder.conjunction();
            }
        };
    }
}
