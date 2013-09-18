package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.newtouch.dao.SubjectPoolDao;
import cn.newtouch.entity.SubjectPool;
import cn.newtouch.util.service.EntityService;

@Service
public class SubjectPoolService extends EntityService<SubjectPool, Long>
{

    @Autowired
    private SubjectPoolDao subjectPoolDao;

    @Override
    protected SubjectPoolDao getEntityDao()
    {
        return subjectPoolDao;
    }

    public boolean isNameUnique(String newName, String oldName)
    {
        return subjectPoolDao.isPropertyUnique("name", newName, oldName);
    }

    public Long getMaxSerialNO()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
