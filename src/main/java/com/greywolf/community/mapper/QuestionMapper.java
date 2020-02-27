package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface QuestionMapper {
    @Insert("INSERT INTO question(title,description,gmt_creat,gmt_modified,creator,tag) VALUES(#{title},#{description},#{gmt_creat},#{gmt_modified},#{creator},#{tag})")
      public void create(Question question);
}
