package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SmsTask implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String policyType;

    private String documentType;

    private String triggerCondition;

    private String additionalFunction;

    private BigDecimal sendNum;

    private BigDecimal interval;

    private Long smsTemplateId;

    private String sendPhone;

    private String informThone;

    private String isReceipt;

    private BigDecimal effectiveTime;

    private Date createDate;

    private Long createUserId;

    private SmsTemplate smsTemplateSmsTemplateId;

    private Users usersCreateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public String getAdditionalFunction() {
        return additionalFunction;
    }

    public void setAdditionalFunction(String additionalFunction) {
        this.additionalFunction = additionalFunction;
    }

    public BigDecimal getSendNum() {
        return sendNum;
    }

    public void setSendNum(BigDecimal sendNum) {
        this.sendNum = sendNum;
    }

    public BigDecimal getInterval() {
        return interval;
    }

    public void setInterval(BigDecimal interval) {
        this.interval = interval;
    }

    public Long getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(Long smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getInformThone() {
        return informThone;
    }

    public void setInformThone(String informThone) {
        this.informThone = informThone;
    }

    public String getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(String isReceipt) {
        this.isReceipt = isReceipt;
    }

    public BigDecimal getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(BigDecimal effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public void setSmsTemplateSmsTemplateId(SmsTemplate smsTemplateSmsTemplateId) {
        this.smsTemplateSmsTemplateId=smsTemplateSmsTemplateId;
    }

    public SmsTemplate getSmsTemplateSmsTemplateId() {
        return smsTemplateSmsTemplateId;
    }

    public void setUsersCreateUserId(Users usersCreateUserId) {
        this.usersCreateUserId=usersCreateUserId;
    }

    public Users getUsersCreateUserId() {
        return usersCreateUserId;
    }
}