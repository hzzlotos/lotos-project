package cn.newtouch.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.newtouch.entity.Material;

public interface MaterialDao extends BaseDao<Material, Long>
{
    @Modifying
    @Query("delete from Material m where m.project.id = :projectId")
    public void deleteByProjectId(@Param("projectId") Long projectId);

    public Material findByName(String name);

}
