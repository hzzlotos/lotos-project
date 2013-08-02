package cn.newtouch.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Attach;
import cn.newtouch.repository.AttachDao;
import cn.newtouch.util.SearchFilter;

import com.google.common.collect.Maps;

@Component
@Transactional(readOnly = true)
public class AttachService extends BaseService<Attach, Long>
{
    private AttachDao attachDao;

    public List<Attach> getAreaList()
    {
        Map<String, Object> searchParams = Maps.newHashMap();
        searchParams.put("EQL_parent.id", SearchFilter.IS_NULL_TAG);
        return this.search(searchParams);
    }

    public List<Attach> getBranchList(Long parentId)
    {
        Map<String, Object> searchParams = Maps.newHashMap();
        searchParams.put("EQL_parent.id", parentId);
        return this.search(searchParams);
    }

    public Attach findByName(String name)
    {
        return attachDao.findByName(name);
    }

    @Autowired
    public void setAttachDao(AttachDao attachDao)
    {
        this.attachDao = attachDao;
    }

    @Override
    protected Class getEntityClass()
    {
        return Attach.class;
    }

    @Override
    protected AttachDao getEntityDao()
    {
        return attachDao;
    }

}
