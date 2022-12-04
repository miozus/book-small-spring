package cn.bugstack.springframework.service.impl;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.service.factory.AbstractAutowireCapableBeanFactory;
import cn.bugstack.springframework.service.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Objects;

/**
 * 种子定义列表的种子工厂实现类
 *
 * @author miozus
 * @date 2022/12/03
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /** 种子定义哈希字典 */
    HashMap<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionHashMap.get(beanName);
        if (Objects.isNull(beanDefinition)) {
            throw new BeansException("种子[" + beanName + "]未定义");
        }
        return beanDefinition;
    }

    /**
     * 注册种子定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(beanName, beanDefinition);
    }
}
