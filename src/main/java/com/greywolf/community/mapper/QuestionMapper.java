package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("INSERT INTO question(title,description,gmtCreate,gmtModified,creator,tag) VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
      public void create(Question question);
    @Select("SELECT * FROM question ORDER BY gmtCreate DESC LIMIT #{first},#{limits}")
      public List<Question> getQuestion(int first,int limits);
    @Select("SELECT COUNT(*) FROM question")
     int getConunt();

}
