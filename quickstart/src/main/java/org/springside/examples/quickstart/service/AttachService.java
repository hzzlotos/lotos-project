package org.springside.examples.quickstart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.repository.AttachDao;
import org.springside.examples.quickstart.repository.BaseDao;
import org.springside.examples.quickstart.util.SearchFilter;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AttachService extends BaseService<Attach, Long>
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

    @Transactional(readOnly = false)
    public void deleteAttach(Long id)
    {
        attachDao.delete(id);
    }

    public List<Attach> getAllAttach()
    {
        return (List<Attach>) attachDao.findAll();
    }

    public Page<Attach> getUserAttach(Long parentId,
            Map<String, Object> searchParams, int pageNumber, int pageSize,
            String sortType)
    {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
                sortType);
        if (null != parentId)
        {
            searchParams.put("EQL_parent.id", parentId);
        }
        else
        {
            searchParams.put("EQL_parent.id", SearchFilter.IS_NULL);
        }
        Specification<Attach> spec = buildSpecification(searchParams);

        return attachDao.findAll(spec, pageRequest);
    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pagzSize,
            String sortType)
    {
        Sort sort = null;
        if ("auto".equals(sortType))
        {
            sort = new Sort(Direction.DESC, "id");
        }
        else
            if ("title".equals(sortType))
            {
                sort = new Sort(Direction.ASC, "title");
            }

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
