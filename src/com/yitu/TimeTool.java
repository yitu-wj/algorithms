package com.yitu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
    private static final SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

    public interface Task{
        void execute();
    }

    public static void check(String title,Task task){
        if(task==null) return;
        title=(title==null)?"":("["+title+"]");
        System.out.println(title);
        System.out.println("开始："+simpleDateFormat.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束："+simpleDateFormat.format(new Date()));
        double delta=(end-begin)/1000.0;
        System.out.println("耗时："+delta+"秒");
        System.out.println("-----------------------------");
    }
}
