package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("INSERT INTO question(title,description,gmtCreate,gmtModified,creator,tag) VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
      public void create(Question question);
    @Select("SELECT * FROM question ORDER BY gmtCreate DESC")
      public List<Question> getQuestion();

}
