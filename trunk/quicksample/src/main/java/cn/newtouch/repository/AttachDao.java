package cn.newtouch.repository;

import cn.newtouch.entity.Attach;

public interface AttachDao extends BaseDao<Attach, Long>
{

    public Attach findByName(String name);

}
