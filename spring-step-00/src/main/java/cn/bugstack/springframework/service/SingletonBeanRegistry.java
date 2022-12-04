package cn.bugstack.springframework.service;

/**
 * 单例bean注册表
 *
 * @author miozus
 * @date 2022/12/03
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);

}
