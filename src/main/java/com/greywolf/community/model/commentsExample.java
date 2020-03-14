package com.greywolf.community.model;

import java.util.ArrayList;
import java.util.List;

public class commentsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public commentsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andGmcreatcIsNull() {
            addCriterion("gmCreatC is null");
            return (Criteria) this;
        }

        public Criteria andGmcreatcIsNotNull() {
            addCriterion("gmCreatC is not null");
            return (Criteria) this;
        }

        public Criteria andGmcreatcEqualTo(Long value) {
            addCriterion("gmCreatC =", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcNotEqualTo(Long value) {
            addCriterion("gmCreatC <>", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcGreaterThan(Long value) {
            addCriterion("gmCreatC >", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcGreaterThanOrEqualTo(Long value) {
            addCriterion("gmCreatC >=", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcLessThan(Long value) {
            addCriterion("gmCreatC <", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcLessThanOrEqualTo(Long value) {
            addCriterion("gmCreatC <=", value, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcIn(List<Long> values) {
            addCriterion("gmCreatC in", values, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcNotIn(List<Long> values) {
            addCriterion("gmCreatC not in", values, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcBetween(Long value1, Long value2) {
            addCriterion("gmCreatC between", value1, value2, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andGmcreatcNotBetween(Long value1, Long value2) {
            addCriterion("gmCreatC not between", value1, value2, "gmcreatc");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andComwhoidIsNull() {
            addCriterion("comWhoID is null");
            return (Criteria) this;
        }

        public Criteria andComwhoidIsNotNull() {
            addCriterion("comWhoID is not null");
            return (Criteria) this;
        }

        public Criteria andComwhoidEqualTo(Integer value) {
            addCriterion("comWhoID =", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidNotEqualTo(Integer value) {
            addCriterion("comWhoID <>", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidGreaterThan(Integer value) {
            addCriterion("comWhoID >", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comWhoID >=", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidLessThan(Integer value) {
            addCriterion("comWhoID <", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidLessThanOrEqualTo(Integer value) {
            addCriterion("comWhoID <=", value, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidIn(List<Integer> values) {
            addCriterion("comWhoID in", values, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidNotIn(List<Integer> values) {
            addCriterion("comWhoID not in", values, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidBetween(Integer value1, Integer value2) {
            addCriterion("comWhoID between", value1, value2, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andComwhoidNotBetween(Integer value1, Integer value2) {
            addCriterion("comWhoID not between", value1, value2, "comwhoid");
            return (Criteria) this;
        }

        public Criteria andLikencountIsNull() {
            addCriterion("likenCount is null");
            return (Criteria) this;
        }

        public Criteria andLikencountIsNotNull() {
            addCriterion("likenCount is not null");
            return (Criteria) this;
        }

        public Criteria andLikencountEqualTo(Integer value) {
            addCriterion("likenCount =", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountNotEqualTo(Integer value) {
            addCriterion("likenCount <>", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountGreaterThan(Integer value) {
            addCriterion("likenCount >", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountGreaterThanOrEqualTo(Integer value) {
            addCriterion("likenCount >=", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountLessThan(Integer value) {
            addCriterion("likenCount <", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountLessThanOrEqualTo(Integer value) {
            addCriterion("likenCount <=", value, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountIn(List<Integer> values) {
            addCriterion("likenCount in", values, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountNotIn(List<Integer> values) {
            addCriterion("likenCount not in", values, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountBetween(Integer value1, Integer value2) {
            addCriterion("likenCount between", value1, value2, "likencount");
            return (Criteria) this;
        }

        public Criteria andLikencountNotBetween(Integer value1, Integer value2) {
            addCriterion("likenCount not between", value1, value2, "likencount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comments
     *
     * @mbg.generated do_not_delete_during_merge Wed Mar 11 17:21:11 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table comments
     *
     * @mbg.generated Wed Mar 11 17:21:11 CST 2020
     */
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