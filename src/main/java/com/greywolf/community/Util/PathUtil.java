package com.greywolf.community.Util;
import java.io.File;
public class PathUtil {
    public final static String iamgeReal="static/images";
    public static File getImageFile(){
        String Path=new String("src/main/resources/"+iamgeReal);
        File image=new File(Path);
        if(!image.exists()){
            // 递归生成文件夹
            image.mkdirs();
        }
        return image;
    }
}
