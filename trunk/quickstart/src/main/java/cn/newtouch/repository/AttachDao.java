package cn.newtouch.repository;

import org.springside.examples.quickstart.entity.Attach;

public interface AttachDao extends BaseDao<Attach, Long>
{

    public Attach findByName(String name);

}
