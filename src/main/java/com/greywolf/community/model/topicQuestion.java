package com.greywolf.community.model;

public class topicQuestion {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.id
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.title
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.gmtCreate
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Long gmtcreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.gmtModified
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Long gmtmodified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.creator
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.comment_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.view_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.like_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.tag
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topicquestion.description
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.id
     *
     * @return the value of topicquestion.id
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.id
     *
     * @param id the value for topicquestion.id
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.title
     *
     * @return the value of topicquestion.title
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.title
     *
     * @param title the value for topicquestion.title
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.gmtCreate
     *
     * @return the value of topicquestion.gmtCreate
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Long getGmtcreate() {
        return gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.gmtCreate
     *
     * @param gmtcreate the value for topicquestion.gmtCreate
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setGmtcreate(Long gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.gmtModified
     *
     * @return the value of topicquestion.gmtModified
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Long getGmtmodified() {
        return gmtmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.gmtModified
     *
     * @param gmtmodified the value for topicquestion.gmtModified
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setGmtmodified(Long gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.creator
     *
     * @return the value of topicquestion.creator
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.creator
     *
     * @param creator the value for topicquestion.creator
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.comment_count
     *
     * @return the value of topicquestion.comment_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.comment_count
     *
     * @param commentCount the value for topicquestion.comment_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.view_count
     *
     * @return the value of topicquestion.view_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.view_count
     *
     * @param viewCount the value for topicquestion.view_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.like_count
     *
     * @return the value of topicquestion.like_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.like_count
     *
     * @param likeCount the value for topicquestion.like_count
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.tag
     *
     * @return the value of topicquestion.tag
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.tag
     *
     * @param tag the value for topicquestion.tag
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topicquestion.description
     *
     * @return the value of topicquestion.description
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topicquestion.description
     *
     * @param description the value for topicquestion.description
     *
     * @mbg.generated Sat Mar 14 17:55:12 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}