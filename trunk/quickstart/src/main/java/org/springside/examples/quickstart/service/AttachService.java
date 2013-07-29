package org.springside.examples.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.repository.AttachDao;

@Component
@Transactional(readOnly = true)
public class AttachService extends BaseService<Attach, Long>
{
    private AttachDao attachDao;

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
