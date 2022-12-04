package cn.bugstack.springframework.service.factory;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.service.InstantiationStrategy;
import cn.bugstack.springframework.service.impl.CglibSubclassingInstantiationStrategy;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * 抽象的自动装配能力种子工厂
 * NOTE：抽象类可以继承抽象类，只实现部分方法
 *
 * @author miozus
 * @date 2022/12/03
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /** 调用接口：实例化策略 */
    @Getter
    @Setter
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建种子
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("种子实例化失败", e);
        }
        // 注册为单例，再返回
        registerSingleton(beanName, beanDefinition);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        // 无参构造：默认
        Constructor constructorToUse = null;
        Class<?> clazz = beanDefinition.getBeanClass();
        // 获取多个构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            // 有参构造：参数数量相等、且每个类型相同
            if (Objects.nonNull(args) && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        // 缓存：默认Cglib策略，始终函数，比直接引用全局变量更好，或者可以拓展获取方法。
        return getInstantiationStrategy().instantiate(beanDefinition, constructorToUse, beanName, args);
    }

}
