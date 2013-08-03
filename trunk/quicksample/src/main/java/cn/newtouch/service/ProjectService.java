package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Project;
import cn.newtouch.repository.MaterialDao;
import cn.newtouch.repository.ProjectDao;

@Component
@Transactional(readOnly = true)
public class ProjectService extends BaseService<Project, Long>
{
    @Autowired
    private ProjectDao  projectDao;

    @Autowired
    private MaterialDao materialDao;

    @Override
    protected ProjectDao getEntityDao()
    {
        return projectDao;
    }

    // @Override
    // public void delete(Long id)
    // {
    // materialDao.deleteByProjectId(id);
    // projectDao.delete(id);
    // }

    @Override
    protected Class getEntityClass()
    {
        return Project.class;
    }

    public Project findByName(String name)
    {
        return projectDao.findByName(name);
    }
}