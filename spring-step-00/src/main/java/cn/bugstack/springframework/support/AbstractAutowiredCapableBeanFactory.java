package cn.bugstack.springframework.support;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import com.sun.istack.internal.Nullable;

/**
 * 抽象的自动装配能力种子工厂
 * NOTE：抽象类可以继承抽象类，只实现部分方法
 *
 * @author miozus
 * @date 2022/12/03
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 创建种子
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("种子实例化失败", e);
        }
        // 注册为单例，再返回
        registerSingleton(beanName, beanDefinition);
        return bean;
    }
}
