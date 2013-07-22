package org.springside.examples.quickstart.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 基本crud接口 User: qingang Date: 13-4-23 Time: 下午3:20
 */
public interface BaseDao<T, PK extends Serializable> extends
        PagingAndSortingRepository<T, PK>, JpaSpecificationExecutor<T>
{
}
