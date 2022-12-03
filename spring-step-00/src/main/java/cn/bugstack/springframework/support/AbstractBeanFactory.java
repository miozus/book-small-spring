package cn.bugstack.springframework.support;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.BeanFactory;
import cn.bugstack.springframework.exception.BeansException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.util.Objects;

/**
 * 抽象种子工厂
 *
 * @author miozus
 * @date 2022/12/03
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 得到种子
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);

        // 已注册
        if (Objects.nonNull(bean)) {
            return bean;
        }
        // 未注册：
        // 1. 查找定义
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        // 2. 根据定义创建、注册
        return createBean(beanName, beanDefinition);
    }

    /**
     * NOTE:根据上述逻辑梳理出来的必备方法
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
