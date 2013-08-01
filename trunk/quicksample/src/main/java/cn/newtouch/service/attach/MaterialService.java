package cn.newtouch.service.attach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Material;
import cn.newtouch.repository.MaterialDao;
import cn.newtouch.service.BaseService;

@Component
@Transactional(readOnly = true)
public class MaterialService extends BaseService<Material, Long>
{
    private MaterialDao materialDao;

    @Autowired
    public void setMaterialDao(MaterialDao materialDao)
    {
        this.materialDao = materialDao;
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
