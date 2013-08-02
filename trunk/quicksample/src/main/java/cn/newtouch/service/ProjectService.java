package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Project;
import cn.newtouch.repository.ProjectDao;

@Component
@Transactional(readOnly = true)
public class ProjectService extends BaseService<Project, Long>
{
    private ProjectDao projectDao;

    @Autowired
    public void setProjectDao(ProjectDao projectDao)
    {
        this.projectDao = projectDao;
    }

    @Override
    protected ProjectDao getEntityDao()
    {
        return projectDao;
    }

    @Override
    protected Class getEntityClass()
    {
        return Project.class;
    }
}