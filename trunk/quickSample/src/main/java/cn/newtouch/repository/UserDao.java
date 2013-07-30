package cn.newtouch.repository;

import cn.newtouch.entity.User;

public interface UserDao extends BaseDao<User, Long>
{
    public User findByLoginName(String loginName);
}
