package com.greywolf.community.dbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class datalayout {
    Map<String,Object> map=new HashMap<>();
    private  final Integer code=0;
    private  final String msg="";
    public  Map<String,Object> getDataLayout(Integer page,List<UserQuestionDTO> data,Integer count){
        map.put("code",code);
        map.put("msg",msg);
        map.put("pages",page);
        map.put("data",data);
        map.put("count",count);
      return map;
    }

}
