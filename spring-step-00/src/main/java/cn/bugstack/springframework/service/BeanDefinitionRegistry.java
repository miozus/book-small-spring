package cn.bugstack.springframework.service;

import cn.bugstack.springframework.entity.BeanDefinition;

/**
 * 种子定义注册表
 *
 * @author miozus
 * @date 2022/12/03
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
