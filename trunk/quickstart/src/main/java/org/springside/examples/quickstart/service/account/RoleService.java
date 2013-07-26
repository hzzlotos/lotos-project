package org.springside.examples.quickstart.service.account;

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
import org.springside.examples.quickstart.entity.Role;
import org.springside.examples.quickstart.repository.RoleDao;
import org.springside.examples.quickstart.service.BaseService;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class RoleService extends BaseService<Role, Long>
{
    private RoleDao roleDao;

    public Role getRole(Long id)
    {
        return roleDao.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveRole(Role entity)
    {
        roleDao.save(entity);
    }

    @Transactional(readOnly = false)
    public void deleteRole(Long id)
    {
        roleDao.delete(id);
    }

    public List<Role> getAllRole()
    {
        return (List<Role>) roleDao.findAll();
    }

    public Page<Role> getRolePage(Map<String, Object> searchParams,
            int pageNumber, int pageSize)
    {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);

        Specification<Role> spec = buildSpecification(searchParams);

        return roleDao.findAll(spec, pageRequest);
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
    public void setRoleDao(RoleDao roleDao)
    {
        this.roleDao = roleDao;
    }

    @Override
    protected Class getEntityClass()
    {
        return Role.class;
    }

    @Override
    protected RoleDao getEntityDao()
    {
        return roleDao;
    }
}
