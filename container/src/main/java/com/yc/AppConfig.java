package com.yc;


import com.yc.bean.Student;
import org.ycframework.annotation.*;

@YcConfiguration
@YcComponentScan({"com.yc"})
public class AppConfig {
    @YcBean
    @YcScope("prototype")
    public Student st(){
        return new Student();
    }

    public AppConfig(){
        System.out.println("扫描类启动");
    }
}
