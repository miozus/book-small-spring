package cn.bugstack.springframework.test;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.BeanFactory;
import cn.bugstack.springframework.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 */
public class ApiTest {


    @Test
    public void testBeanFactoryI() {
//        BeanFactory beanFactory = new BeanFactory();
//
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        UserService service = (UserService) beanFactory.getBean("userService");
//        service.insertUserInfo("20");

    }

    @Test
    public void testBeanFactoryII() {

        // 1.初始化种子工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册种子
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("UserService", beanDefinition);

        // 3.首次获取种子
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();

        // 4.第二次获取种子，但是单例模式
        UserService userServiceSingleton = (UserService)beanFactory.getSingleton("userService");
        userServiceSingleton.queryUserInfo();

    }
}
