package cn.newtouch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springside.examples.quickstart.entity.Task;

public interface TaskDao extends BaseDao<Task, Long>
{

    public Page<Task> findByUserId(Long id, Pageable pageRequest);

    @Modifying
    @Query("delete from Task task where task.user.id=?1")
    public void deleteByUserId(Long id);
}
