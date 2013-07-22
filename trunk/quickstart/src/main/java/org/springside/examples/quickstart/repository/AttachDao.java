package org.springside.examples.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Attach;

public interface AttachDao extends PagingAndSortingRepository<Attach, Long>,
        JpaSpecificationExecutor<Attach>
{

}
