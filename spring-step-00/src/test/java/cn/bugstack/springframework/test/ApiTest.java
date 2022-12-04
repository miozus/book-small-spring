package cn.bugstack.springframework.test;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.service.impl.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 测试类
 */
public class ApiTest {


    /** 正常创建种子工厂 */
    @Test
    public void testBeanFactoryAllArgsConstructor() {

        // 1.初始化种子工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册种子
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("UserService", beanDefinition);
        // 3.首次获取种子
        UserService userService = (UserService) beanFactory.getBean("UserService", "miozus");
        userService.queryUserInfo();
        // 4.第二次获取种子，但是单例模式
        UserService userServiceSingleton = (UserService) beanFactory.getSingleton("userService");
        userServiceSingleton.queryUserInfo();

    }
    @Test
    public void testBeanFactoryNoArgsConstructor() {

        // 1.初始化种子工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册种子
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("UserService", beanDefinition);
        // 3.首次获取种子
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
        // 4.第二次获取种子，但是单例模式
        UserService userServiceSingleton = (UserService) beanFactory.getSingleton("userService");
        userServiceSingleton.queryUserInfo();

    }

    /** 反射：Cglib库增强构造，父类和回调 */
    @Test
    public void testCglibInstantiation(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"miozus"});
        System.out.println("obj = " + obj);
    }

    /** 反射：无参构造，失败，因为有参构造回收了无参构造 */
    @Test
    public void testSimpleInstantiation() throws InstantiationException, IllegalAccessException {
        UserService userService = UserService.class.newInstance();
        System.out.println("userService = " + userService);
    }

    /** 构造器，指定参数类型，也能实例化 */
    @SneakyThrows
    @Test
    public void testConstructor() {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("miozus");
        System.out.println("userService = " + userService);
    }

    /** 构造器，数组选第一个，也能实例化 */
    @SneakyThrows
    @Test
    public void testParameterTypes() {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("miozus");
        System.out.println("userService = " + userService);
    }


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
}
