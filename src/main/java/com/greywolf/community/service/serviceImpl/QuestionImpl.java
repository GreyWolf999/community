package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.questionMapper;
import com.greywolf.community.mapper.userMapper;
import com.greywolf.community.model.question;
import com.greywolf.community.model.questionExample;
import com.greywolf.community.model.user;
import com.greywolf.community.model.userExample;
import com.greywolf.community.service.QuestionService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionImpl implements QuestionService {
    private final Integer number=0;
    private Integer idPrimy;
    @Autowired
    questionMapper questionMapper;
    @Autowired
    userMapper userMapper;
    @Override
    public void doPublish(question question, String creatorToken) {
        question.setCommentCount(number);
        question.setLikeCount(number);
        question.setViewCount(number);
        question.setCreator(creatorToken);
        question.setGmtcreate(System.currentTimeMillis());
        question.setGmtmodified(question.getGmtcreate());
        questionMapper.insert(question);
    }


    @Cacheable(value = "questionList")
    @Override
    public List<UserQuestionDTO> doshow(int page) {
//        自定义分页数目
        int limits=5;
        Date date=new Date();
        //        获取分页开始的数字
        int offset=(page-1)*limits;
        List<UserQuestionDTO> UserQuestionlist=new ArrayList<>();
        questionExample example1 = new questionExample();
//        排序
        example1.setOrderByClause("gmtcreate DESC");
        List<question> questions = questionMapper.selectByExampleWithRowbounds(example1,new RowBounds(offset, limits));
        for (question UserQuestion:questions) {
            UserQuestionDTO userQuestionDTO=new UserQuestionDTO();
            userExample example = new userExample();
            example.createCriteria().andTokenEqualTo(UserQuestion.getCreator());
            List<user> users = userMapper.selectByExample(example);
            user userData =users.get(0);
            userQuestionDTO.setAvatarUrl("images/"+userData.getAvatarurl());
            //将毫秒值转化成日期
            date.setTime(UserQuestion.getGmtcreate());
            userQuestionDTO.setGmtCreate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            BeanUtils.copyProperties(UserQuestion,userQuestionDTO);
            UserQuestionlist.add(userQuestionDTO);
        }
        return UserQuestionlist;
    }
    @Cacheable(value = "count")
    @Override
    public int getCount(){
        return (int)questionMapper.countByExample(new questionExample());
    }
    @Override
    public int getPages(){
        int count = getCount();
        if (count%5==0){
            return count/5;
        }else return count/5+1;
    }
    @Cacheable(value = "questionListByToken")
    @Override
    public List<UserQuestionDTO> getQuestionByToken(int page,String token){
        int limits=5;
        Date date=new Date();
        //        获取分页开始的数字
        int offset=(page-1)*limits;
        List<UserQuestionDTO> UserQuestionlist=new ArrayList<>();
        questionExample example = new questionExample();
        example.createCriteria().andCreatorEqualTo(token);
        example.setOrderByClause("gmtcreate DESC");
        List<question> questions = questionMapper.selectByExampleWithRowbounds(example,
                new RowBounds(offset, limits));
        for (question question :questions) {
            UserQuestionDTO userQuestionDTO=new UserQuestionDTO();
            userExample example1 = new userExample();
            example1.createCriteria().andTokenEqualTo(token);
            List<user> users = userMapper.selectByExample(example1);
            user userData=users.get(0);
            userQuestionDTO.setAvatarUrl("/images/"+userData.getAvatarurl());
            date.setTime(question.getGmtcreate());
            userQuestionDTO.setGmtCreate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//            这个方法是将第一个对象中的与第二个对象中的属性相同的属性复制到第二个对象中
            BeanUtils.copyProperties(question,userQuestionDTO);
            UserQuestionlist.add(userQuestionDTO);
        }
        return UserQuestionlist;
    }
    /*
    * 根据点击标题回显问题信息*/
    @Override
    public question getSelectedQuestionByTitle(String title){
        questionExample example = new questionExample();
        example.createCriteria().andTitleEqualTo(title);
        List<question> questions=questionMapper.selectByExampleWithBLOBs(example);
        idPrimy=questions.get(0).getId();
        return questions.get(0);
    }
    /*
    * 根据主键进行更新问题*/
    @Override
    public void updateQuestion(String title, String description, String tag){
        question record = new question();
        record.setId(idPrimy);
        record.setTitle(title);
        record.setDescription(description);
        record.setTag(tag);
       questionMapper.updateByPrimaryKeySelective(record);
    }
    //根据标题进行查询 用来展示想要查看的问题
    @Override
    public UserQuestionDTO getQuestionDto(String title){
        UserQuestionDTO userQuestionDTO=new UserQuestionDTO();
        question selectedQuestionByTitle = getSelectedQuestionByTitle(title);
        userExample example = new userExample();
        example.createCriteria().andTokenEqualTo(selectedQuestionByTitle.getCreator());
        List<user> users = userMapper.selectByExample(example);
        BeanUtils.copyProperties(selectedQuestionByTitle,userQuestionDTO);
        userQuestionDTO.setAvatarUrl("images/"+users.get(0).getAvatarurl());
        return userQuestionDTO;
    }
    @Override
    public void updateViewCount(Integer viewCount,Integer idPrimy){
        question record = new question();
        record.setId(idPrimy);
        record.setViewCount(viewCount);
        questionMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public Integer getCommentCounts(Integer PrimyId){
        return questionMapper.selectByPrimaryKey(PrimyId).getCommentCount();
    }
    @Override
    public void updateCommentCounts(Integer CommentCounts, Integer PrimyId){
        question record = new question();
        record.setId(PrimyId);
        record.setCommentCount(CommentCounts);
        questionMapper.updateByPrimaryKeySelective(record);
    }
    //用来清除更新了相关属性的缓存
    @CacheEvict(value = "questionList",allEntries = true)
    @Override
    public void cleanCache(){
    }

    @CacheEvict(value = "questionListByToken",allEntries = true)
    @Override
    public void cleanCacheByToken(){}
    @CacheEvict(value = "count",allEntries = true)
    @Override
    public void cleanCount(){}
}
