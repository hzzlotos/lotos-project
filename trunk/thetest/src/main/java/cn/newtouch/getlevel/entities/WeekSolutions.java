package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class WeekSolutions implements Serializable
{
    private static final long  serialVersionUID = 1L;

    private Long               id;

    private Long               weekday;

    private Long               logisticsSolutionId;

    private LogisticsSolutions logisticsSolutionsLogisticsSolutionId;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getWeekday()
    {
        return this.weekday;
    }

    public void setWeekday(Long weekday)
    {
        this.weekday = weekday;
    }

    public Long getLogisticsSolutionId()
    {
        return this.logisticsSolutionId;
    }

    public void setLogisticsSolutionId(Long logisticsSolutionId)
    {
        this.logisticsSolutionId = logisticsSolutionId;
    }

    public void setLogisticsSolutionsLogisticsSolutionId(LogisticsSolutions logisticsSolutionsLogisticsSolutionId)
    {
        this.logisticsSolutionsLogisticsSolutionId = logisticsSolutionsLogisticsSolutionId;
    }

    public LogisticsSolutions getLogisticsSolutionsLogisticsSolutionId()
    {
        return this.logisticsSolutionsLogisticsSolutionId;
    }
}