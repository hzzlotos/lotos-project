package cn.newtouch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.newtouch.entity.Project;

public interface ProjectDao extends BaseDao<Project, Long>
{

    public Project findByName(String name);

    @Query("delete from Project p where p.attach.id = :attachId")
    public void deleteByAttachId(@Param("attachId") Long attachId);
}