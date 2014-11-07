package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class DeliveryPersons implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String personIdNo;

    private String messageCheck;

    private Date actionDate;

    private Long ladingId;

    private Long userId;

    private List<DeliveryPersonDetails> deliveryPersonDetailssCollecterId = null;

    private Ladings ladingsLadingId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonIdNo() {
        return personIdNo;
    }

    public void setPersonIdNo(String personIdNo) {
        this.personIdNo = personIdNo;
    }

    public String getMessageCheck() {
        return messageCheck;
    }

    public void setMessageCheck(String messageCheck) {
        this.messageCheck = messageCheck;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Long getLadingId() {
        return ladingId;
    }

    public void setLadingId(Long ladingId) {
        this.ladingId = ladingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDeliveryPersonDetailssCollecterId(List deliveryPersonDetailssCollecterId) {
        this.deliveryPersonDetailssCollecterId=deliveryPersonDetailssCollecterId;
    }

    public List<DeliveryPersonDetails> getDeliveryPersonDetailssCollecterId() {
        return deliveryPersonDetailssCollecterId;
    }

    public void setLadingsLadingId(Ladings ladingsLadingId) {
        this.ladingsLadingId=ladingsLadingId;
    }

    public Ladings getLadingsLadingId() {
        return ladingsLadingId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}