package org.springside.examples.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.repository.AttachDao;
import org.springside.examples.quickstart.repository.BaseDao;

@Component
@Transactional(readOnly = true)
public class MaterialService extends BaseService<Attach, Long>
{
    private AttachDao attachDao;

    public Attach getAttach(Long id)
    {
        return attachDao.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveAttach(Attach entity)
    {
        attachDao.save(entity);
    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pagzSize)
    {
        Sort sort = new Sort(Direction.DESC, "id");
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }

    @Autowired
    public void setattachDao(AttachDao attachDao)
    {
        this.attachDao = attachDao;
    }

    @Override
    protected Class getEntityClass()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected BaseDao<Attach, Long> getEntityDao()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
