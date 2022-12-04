package cn.bugstack.springframework.service.factory;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.service.BeanFactory;
import cn.bugstack.springframework.service.impl.DefaultSingletonBeanRegistry;
import com.sun.istack.internal.Nullable;

import java.util.Objects;

/**
 * 抽象种子工厂
 *
 * @author miozus
 * @date 2022/12/03
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * 得到种子
     *
     * @param beanName 种子名字
     * @param args     形式参数
     * @return {@link Object} 泛型:向下强制转化
     * @throws BeansException 种子异常
     */
    protected <T> T doGetBean(final String beanName, final @Nullable Object[] args) {
        Object bean = getSingleton(beanName);
        // 已注册
        if (Objects.nonNull(bean)) {
            return (T) bean;
        }
        // 未注册：
        // 1. 查找定义
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        // 2. 根据定义创建、注册
        return (T) createBean(beanName, beanDefinition, args);
    }

    /** NOTE:根据上述逻辑梳理出来的必备方法 */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
