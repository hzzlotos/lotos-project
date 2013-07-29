package org.springside.examples.quickstart.service.attach;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.repository.AttachDao;
import org.springside.examples.quickstart.service.BaseService;
import org.springside.examples.quickstart.util.SearchFilter;

import com.google.common.collect.Maps;

@Component
@Transactional(readOnly = true)
public class AttachService extends BaseService<Attach, Long>
{
    private AttachDao attachDao;

    public List<Attach> getAreaList()
    {
        Map<String, Object> searchParams = Maps.newHashMap();
        searchParams.put("EQL_parent.id", SearchFilter.IS_NULL);
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
    public void setattachDao(AttachDao attachDao)
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
