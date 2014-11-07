package com.hnmlip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class usersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public usersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("COMPANY_ID =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("COMPANY_ID <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("COMPANY_ID >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("COMPANY_ID >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("COMPANY_ID <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("COMPANY_ID <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("COMPANY_ID in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("COMPANY_ID not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("COMPANY_ID between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("COMPANY_ID not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("LAST_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("LAST_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("LAST_LOGIN_IP >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("LAST_LOGIN_IP <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("LAST_LOGIN_IP like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("LAST_LOGIN_IP not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("LOGIN_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("LOGIN_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("LOGIN_PASSWORD =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("LOGIN_PASSWORD <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("LOGIN_PASSWORD >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_PASSWORD >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("LOGIN_PASSWORD <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_PASSWORD <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("LOGIN_PASSWORD like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("LOGIN_PASSWORD not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("LOGIN_PASSWORD in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("LOGIN_PASSWORD not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("LOGIN_PASSWORD between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("LOGIN_PASSWORD not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("MOBILE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("MOBILE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("MOBILE_PHONE =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("MOBILE_PHONE <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("MOBILE_PHONE >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("MOBILE_PHONE <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("MOBILE_PHONE like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("MOBILE_PHONE not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("MOBILE_PHONE in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("MOBILE_PHONE not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdIsNull() {
            addCriterion("PORTRAIT_IMAGE_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdIsNotNull() {
            addCriterion("PORTRAIT_IMAGE_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdEqualTo(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID =", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdNotEqualTo(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID <>", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdGreaterThan(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID >", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID >=", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdLessThan(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID <", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdLessThanOrEqualTo(Long value) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID <=", value, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdIn(List<Long> values) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID in", values, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdNotIn(List<Long> values) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID not in", values, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdBetween(Long value1, Long value2) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID between", value1, value2, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andPortraitImageFileIdNotBetween(Long value1, Long value2) {
            addCriterion("PORTRAIT_IMAGE_FILE_ID not between", value1, value2, "portraitImageFileId");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNull() {
            addCriterion("IS_ADMIN is null");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNotNull() {
            addCriterion("IS_ADMIN is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdminEqualTo(String value) {
            addCriterion("IS_ADMIN =", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotEqualTo(String value) {
            addCriterion("IS_ADMIN <>", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThan(String value) {
            addCriterion("IS_ADMIN >", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThanOrEqualTo(String value) {
            addCriterion("IS_ADMIN >=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThan(String value) {
            addCriterion("IS_ADMIN <", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThanOrEqualTo(String value) {
            addCriterion("IS_ADMIN <=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLike(String value) {
            addCriterion("IS_ADMIN like", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotLike(String value) {
            addCriterion("IS_ADMIN not like", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminIn(List<String> values) {
            addCriterion("IS_ADMIN in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotIn(List<String> values) {
            addCriterion("IS_ADMIN not in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminBetween(String value1, String value2) {
            addCriterion("IS_ADMIN between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotBetween(String value1, String value2) {
            addCriterion("IS_ADMIN not between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdIsNull() {
            addCriterion("LOGISTICS_ADDRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdIsNotNull() {
            addCriterion("LOGISTICS_ADDRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdEqualTo(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID =", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdNotEqualTo(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID <>", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdGreaterThan(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID >", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID >=", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdLessThan(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID <", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("LOGISTICS_ADDRESS_ID <=", value, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdIn(List<Long> values) {
            addCriterion("LOGISTICS_ADDRESS_ID in", values, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdNotIn(List<Long> values) {
            addCriterion("LOGISTICS_ADDRESS_ID not in", values, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdBetween(Long value1, Long value2) {
            addCriterion("LOGISTICS_ADDRESS_ID between", value1, value2, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andLogisticsAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("LOGISTICS_ADDRESS_ID not between", value1, value2, "logisticsAddressId");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andQqCodeIsNull() {
            addCriterion("QQ_CODE is null");
            return (Criteria) this;
        }

        public Criteria andQqCodeIsNotNull() {
            addCriterion("QQ_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andQqCodeEqualTo(String value) {
            addCriterion("QQ_CODE =", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeNotEqualTo(String value) {
            addCriterion("QQ_CODE <>", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeGreaterThan(String value) {
            addCriterion("QQ_CODE >", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QQ_CODE >=", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeLessThan(String value) {
            addCriterion("QQ_CODE <", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeLessThanOrEqualTo(String value) {
            addCriterion("QQ_CODE <=", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeLike(String value) {
            addCriterion("QQ_CODE like", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeNotLike(String value) {
            addCriterion("QQ_CODE not like", value, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeIn(List<String> values) {
            addCriterion("QQ_CODE in", values, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeNotIn(List<String> values) {
            addCriterion("QQ_CODE not in", values, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeBetween(String value1, String value2) {
            addCriterion("QQ_CODE between", value1, value2, "qqCode");
            return (Criteria) this;
        }

        public Criteria andQqCodeNotBetween(String value1, String value2) {
            addCriterion("QQ_CODE not between", value1, value2, "qqCode");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("BIRTH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("BIRTH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(String value) {
            addCriterion("BIRTH_DATE =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(String value) {
            addCriterion("BIRTH_DATE <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(String value) {
            addCriterion("BIRTH_DATE >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTH_DATE >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(String value) {
            addCriterion("BIRTH_DATE <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(String value) {
            addCriterion("BIRTH_DATE <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLike(String value) {
            addCriterion("BIRTH_DATE like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotLike(String value) {
            addCriterion("BIRTH_DATE not like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<String> values) {
            addCriterion("BIRTH_DATE in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<String> values) {
            addCriterion("BIRTH_DATE not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(String value1, String value2) {
            addCriterion("BIRTH_DATE between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(String value1, String value2) {
            addCriterion("BIRTH_DATE not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingIsNull() {
            addCriterion("MICROBLOGGING is null");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingIsNotNull() {
            addCriterion("MICROBLOGGING is not null");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingEqualTo(String value) {
            addCriterion("MICROBLOGGING =", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingNotEqualTo(String value) {
            addCriterion("MICROBLOGGING <>", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingGreaterThan(String value) {
            addCriterion("MICROBLOGGING >", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingGreaterThanOrEqualTo(String value) {
            addCriterion("MICROBLOGGING >=", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingLessThan(String value) {
            addCriterion("MICROBLOGGING <", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingLessThanOrEqualTo(String value) {
            addCriterion("MICROBLOGGING <=", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingLike(String value) {
            addCriterion("MICROBLOGGING like", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingNotLike(String value) {
            addCriterion("MICROBLOGGING not like", value, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingIn(List<String> values) {
            addCriterion("MICROBLOGGING in", values, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingNotIn(List<String> values) {
            addCriterion("MICROBLOGGING not in", values, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingBetween(String value1, String value2) {
            addCriterion("MICROBLOGGING between", value1, value2, "microblogging");
            return (Criteria) this;
        }

        public Criteria andMicrobloggingNotBetween(String value1, String value2) {
            addCriterion("MICROBLOGGING not between", value1, value2, "microblogging");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeIsNull() {
            addCriterion("ID_CARD_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeIsNotNull() {
            addCriterion("ID_CARD_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeEqualTo(String value) {
            addCriterion("ID_CARD_CODE =", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeNotEqualTo(String value) {
            addCriterion("ID_CARD_CODE <>", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeGreaterThan(String value) {
            addCriterion("ID_CARD_CODE >", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_CODE >=", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeLessThan(String value) {
            addCriterion("ID_CARD_CODE <", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_CODE <=", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeLike(String value) {
            addCriterion("ID_CARD_CODE like", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeNotLike(String value) {
            addCriterion("ID_CARD_CODE not like", value, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeIn(List<String> values) {
            addCriterion("ID_CARD_CODE in", values, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeNotIn(List<String> values) {
            addCriterion("ID_CARD_CODE not in", values, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeBetween(String value1, String value2) {
            addCriterion("ID_CARD_CODE between", value1, value2, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardCodeNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_CODE not between", value1, value2, "idCardCode");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdIsNull() {
            addCriterion("ID_CARD_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdIsNotNull() {
            addCriterion("ID_CARD_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdEqualTo(Long value) {
            addCriterion("ID_CARD_FILE_ID =", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdNotEqualTo(Long value) {
            addCriterion("ID_CARD_FILE_ID <>", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdGreaterThan(Long value) {
            addCriterion("ID_CARD_FILE_ID >", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_CARD_FILE_ID >=", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdLessThan(Long value) {
            addCriterion("ID_CARD_FILE_ID <", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdLessThanOrEqualTo(Long value) {
            addCriterion("ID_CARD_FILE_ID <=", value, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdIn(List<Long> values) {
            addCriterion("ID_CARD_FILE_ID in", values, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdNotIn(List<Long> values) {
            addCriterion("ID_CARD_FILE_ID not in", values, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdBetween(Long value1, Long value2) {
            addCriterion("ID_CARD_FILE_ID between", value1, value2, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andIdCardFileIdNotBetween(Long value1, Long value2) {
            addCriterion("ID_CARD_FILE_ID not between", value1, value2, "idCardFileId");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateIsNull() {
            addCriterion("RRGISTRATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateIsNotNull() {
            addCriterion("RRGISTRATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateEqualTo(Date value) {
            addCriterion("RRGISTRATION_DATE =", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateNotEqualTo(Date value) {
            addCriterion("RRGISTRATION_DATE <>", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateGreaterThan(Date value) {
            addCriterion("RRGISTRATION_DATE >", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RRGISTRATION_DATE >=", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateLessThan(Date value) {
            addCriterion("RRGISTRATION_DATE <", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateLessThanOrEqualTo(Date value) {
            addCriterion("RRGISTRATION_DATE <=", value, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateIn(List<Date> values) {
            addCriterion("RRGISTRATION_DATE in", values, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateNotIn(List<Date> values) {
            addCriterion("RRGISTRATION_DATE not in", values, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateBetween(Date value1, Date value2) {
            addCriterion("RRGISTRATION_DATE between", value1, value2, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andRrgistrationDateNotBetween(Date value1, Date value2) {
            addCriterion("RRGISTRATION_DATE not between", value1, value2, "rrgistrationDate");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordIsNull() {
            addCriterion("IS_MODIFIED_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordIsNotNull() {
            addCriterion("IS_MODIFIED_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordEqualTo(String value) {
            addCriterion("IS_MODIFIED_PASSWORD =", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordNotEqualTo(String value) {
            addCriterion("IS_MODIFIED_PASSWORD <>", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordGreaterThan(String value) {
            addCriterion("IS_MODIFIED_PASSWORD >", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MODIFIED_PASSWORD >=", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordLessThan(String value) {
            addCriterion("IS_MODIFIED_PASSWORD <", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordLessThanOrEqualTo(String value) {
            addCriterion("IS_MODIFIED_PASSWORD <=", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordLike(String value) {
            addCriterion("IS_MODIFIED_PASSWORD like", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordNotLike(String value) {
            addCriterion("IS_MODIFIED_PASSWORD not like", value, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordIn(List<String> values) {
            addCriterion("IS_MODIFIED_PASSWORD in", values, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordNotIn(List<String> values) {
            addCriterion("IS_MODIFIED_PASSWORD not in", values, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordBetween(String value1, String value2) {
            addCriterion("IS_MODIFIED_PASSWORD between", value1, value2, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andIsModifiedPasswordNotBetween(String value1, String value2) {
            addCriterion("IS_MODIFIED_PASSWORD not between", value1, value2, "isModifiedPassword");
            return (Criteria) this;
        }

        public Criteria andWorkbenchIsNull() {
            addCriterion("WORKBENCH is null");
            return (Criteria) this;
        }

        public Criteria andWorkbenchIsNotNull() {
            addCriterion("WORKBENCH is not null");
            return (Criteria) this;
        }

        public Criteria andWorkbenchEqualTo(String value) {
            addCriterion("WORKBENCH =", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchNotEqualTo(String value) {
            addCriterion("WORKBENCH <>", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchGreaterThan(String value) {
            addCriterion("WORKBENCH >", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchGreaterThanOrEqualTo(String value) {
            addCriterion("WORKBENCH >=", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchLessThan(String value) {
            addCriterion("WORKBENCH <", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchLessThanOrEqualTo(String value) {
            addCriterion("WORKBENCH <=", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchLike(String value) {
            addCriterion("WORKBENCH like", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchNotLike(String value) {
            addCriterion("WORKBENCH not like", value, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchIn(List<String> values) {
            addCriterion("WORKBENCH in", values, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchNotIn(List<String> values) {
            addCriterion("WORKBENCH not in", values, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchBetween(String value1, String value2) {
            addCriterion("WORKBENCH between", value1, value2, "workbench");
            return (Criteria) this;
        }

        public Criteria andWorkbenchNotBetween(String value1, String value2) {
            addCriterion("WORKBENCH not between", value1, value2, "workbench");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNull() {
            addCriterion("IS_OLD is null");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNotNull() {
            addCriterion("IS_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andIsOldEqualTo(String value) {
            addCriterion("IS_OLD =", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotEqualTo(String value) {
            addCriterion("IS_OLD <>", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThan(String value) {
            addCriterion("IS_OLD >", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThanOrEqualTo(String value) {
            addCriterion("IS_OLD >=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThan(String value) {
            addCriterion("IS_OLD <", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThanOrEqualTo(String value) {
            addCriterion("IS_OLD <=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLike(String value) {
            addCriterion("IS_OLD like", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotLike(String value) {
            addCriterion("IS_OLD not like", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldIn(List<String> values) {
            addCriterion("IS_OLD in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotIn(List<String> values) {
            addCriterion("IS_OLD not in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldBetween(String value1, String value2) {
            addCriterion("IS_OLD between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotBetween(String value1, String value2) {
            addCriterion("IS_OLD not between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andDataVerIsNull() {
            addCriterion("DATA_VER is null");
            return (Criteria) this;
        }

        public Criteria andDataVerIsNotNull() {
            addCriterion("DATA_VER is not null");
            return (Criteria) this;
        }

        public Criteria andDataVerEqualTo(Long value) {
            addCriterion("DATA_VER =", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerNotEqualTo(Long value) {
            addCriterion("DATA_VER <>", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerGreaterThan(Long value) {
            addCriterion("DATA_VER >", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_VER >=", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerLessThan(Long value) {
            addCriterion("DATA_VER <", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerLessThanOrEqualTo(Long value) {
            addCriterion("DATA_VER <=", value, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerIn(List<Long> values) {
            addCriterion("DATA_VER in", values, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerNotIn(List<Long> values) {
            addCriterion("DATA_VER not in", values, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerBetween(Long value1, Long value2) {
            addCriterion("DATA_VER between", value1, value2, "dataVer");
            return (Criteria) this;
        }

        public Criteria andDataVerNotBetween(Long value1, Long value2) {
            addCriterion("DATA_VER not between", value1, value2, "dataVer");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}