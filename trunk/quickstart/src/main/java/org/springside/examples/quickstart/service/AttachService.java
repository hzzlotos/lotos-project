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
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AttachService
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

    public Page<Attach> getUserAttach(Long userId,
            Map<String, Object> searchParams, int pageNumber, int pageSize,
            String sortType)
    {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
                sortType);
        Specification<Attach> spec = buildSpecification(userId, searchParams);

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

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Attach> buildSpecification(Long userId,
            Map<String, Object> searchParams)
    {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters
                .put("user.id",
                        new SearchFilter("user.id", Operator.EQ, userId));
        Specification<Attach> spec = DynamicSpecifications.bySearchFilter(
                filters.values(), Attach.class);
        return spec;
    }

    @Autowired
    public void setattachDao(AttachDao attachDao)
    {
        this.attachDao = attachDao;
    }

}
