package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Material;
import cn.newtouch.repository.MaterialDao;

@Component
@Transactional(readOnly = true)
public class MaterialService extends BaseService<Material, Long>
{
    @Autowired
    private MaterialDao materialDao;

    public Material findByName(String name)
    {
        return materialDao.findByName(name);
    }

    @Override
    protected MaterialDao getEntityDao()
    {
        return materialDao;
    }

    @Override
    protected Class getEntityClass()
    {
        return Material.class;
    }
}