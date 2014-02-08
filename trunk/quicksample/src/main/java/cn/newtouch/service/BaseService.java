package cn.newtouch.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.repository.BaseDao;
import cn.newtouch.util.DynamicSpecifications;
import cn.newtouch.util.SearchFilter;

import com.google.common.collect.Maps;

public abstract class BaseService<T, PK extends Serializable>
{
    protected abstract BaseDao<T, PK> getEntityDao();

    protected abstract Class getEntityClass();

    protected Logger logger = LoggerFactory.getLogger(this.getEntityClass());

    // CRUD函数 //

    /**
     * 根据主键id查询对象
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public T get(final PK id)
    {
        return this.getEntityDao().findOne(id);
    }

    /**
     * 取出所有数据
     * 
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getAll()
    {
        return (List<T>) this.getEntityDao().findAll();
    }

    /**
     * 通过主键id列表查询对象列表
     * 
     * @param ids
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getAll(final List<PK> ids)
    {
        return (List<T>) this.getEntityDao().findAll(ids);
    }

    /**
     * 排序查询
     * 
     * @param sort
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getAll(Sort sort)
    {
        return (List<T>) this.getEntityDao().findAll(sort);
    }

    /**
     * 带参数分页查询
     * 
     * @param pageable
     * @param searchParams
     *            查询条件map
     * @param clazz
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> search(int pageNumber, int pagzSize, String sortStr, boolean asc, Map<String, Object> searchParams)
    {
        Specification<T> spec = this.buildSpecification(searchParams);
        PageRequest pageRequest = this.buildPageRequest(pageNumber, pagzSize, sortStr, asc);
        return this.getEntityDao().findAll(spec, pageRequest);
    }

    /**
     * 带参数分页查询
     * 
     * @param pageable
     * @param searchParams
     *            查询条件map
     * @param clazz
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> search(int pageNumber, int pagzSize, Map<String, Object> searchParams)
    {
        Specification<T> spec = this.buildSpecification(searchParams);
        PageRequest pageRequest = this.buildPageRequest(pageNumber, pagzSize);
        return this.getEntityDao().findAll(spec, pageRequest);
    }

    /**
     * 分页查询
     * 
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> search(int pageNumber, int pagzSize, String sortStr, boolean asc)
    {
        PageRequest pageRequest = this.buildPageRequest(pageNumber, pagzSize, sortStr, asc);
        return this.getEntityDao().findAll(pageRequest);
    }

    /**
     * 分页查询
     * 
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> search(int pageNumber, int pagzSize)
    {
        PageRequest pageRequest = this.buildPageRequest(pageNumber, pagzSize);
        return this.getEntityDao().findAll(pageRequest);
    }

    /**
     * 保存或更新对象
     * 
     * @param entity
     */
    public T save(final T entity)
    {
        return this.getEntityDao().save(entity);
    }

    /**
     * 通过主键id删除对象
     * 
     * @param id
     */
    public void delete(final PK id)
    {
        this.getEntityDao().delete(id);
    }

    /**
     * 创建分页请求.
     */
    public PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortStr, boolean asc)
    {
        Sort sort = new Sort(asc ? Direction.ASC : Direction.DESC, sortStr);
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }

    /**
     * 创建分页请求.
     */
    public PageRequest buildPageRequest(int pageNumber, int pagzSize)
    {
        return this.buildPageRequest(pageNumber, pagzSize, "id", false);
    }

    /**
     * 创建动态查询条件组合
     * 
     * @param searchParams
     * @return Specification<T>
     */
    public Specification<T> buildSpecification(Map<String, Object> searchParams)
    {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), this.getEntityClass());
        return spec;
    }

    public boolean isPropertyUnique(String propertyName, Object newValue, Object oldValue)
    {
        if (newValue == null || newValue.equals(oldValue))
        {
            return true;
        }
        Map<String, SearchFilter> filters = Maps.newHashMap();
        filters.put(propertyName, new SearchFilter(propertyName, SearchFilter.Operator.EQ, newValue));
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), this.getEntityClass());
        Object object = this.getEntityDao().findOne(spec);
        return (object == null);
    }

    public boolean isPropertyUnique(String propertyName, Object newValue, Object oldValue,
            Map<String, Object> searchParams)
    {
        if (newValue == null || newValue.equals(oldValue))
        {
            return true;
        }
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put(propertyName, new SearchFilter(propertyName, SearchFilter.Operator.EQ, newValue));
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), this.getEntityClass());
        Object object = this.getEntityDao().findOne(spec);
        return (object == null);
    }

    public List<T> search(Map<String, Object> searchParams)
    {
        Specification<T> spec = this.buildSpecification(searchParams);
        return this.getEntityDao().findAll(spec);
    }

    public long count()
    {
        return this.getEntityDao().count();
    }

    public long count(Map<String, Object> searchParams)
    {
        Specification<T> spec = this.buildSpecification(searchParams);
        return this.getEntityDao().count(spec);
    }
}
