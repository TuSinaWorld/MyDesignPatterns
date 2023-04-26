package test;

import com.yc.AppConfig;
import com.yc.AppConfig2;
import com.yc.bean.Apple;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

public class TestMySpring {
    private Logger logger = LoggerFactory.getLogger(TestMySpring.class);
    @Test
    public void test1(){
//        ApplicationContext xxx = new AnnotationConfigurationContext(xxx.class)
        YcApplicationContext yc = new YcAnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);
        System.out.println("容器启动");
        System.out.println(yc.getBean("st"));
        System.out.println(yc.getBean("st"));
        Apple apple = (Apple) yc.getBean("apple");
        Apple apple2 = (Apple) yc.getBean("apple");
        yc.getBean("apple");
        apple.setId(1);
        System.out.println(apple);
        System.out.println(yc.getBean("pear"));
//        yc.showBeanMap();
        apple.setId(1);
        System.out.println(apple.getId());
        logger.info(apple.toString());
    }
}
