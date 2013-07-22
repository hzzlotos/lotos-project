package org.springside.examples.quickstart.repository;

import org.springside.examples.quickstart.entity.User;

public interface UserDao extends BaseDao<User, Long>
{
    public User findByLoginName(String loginName);
}
