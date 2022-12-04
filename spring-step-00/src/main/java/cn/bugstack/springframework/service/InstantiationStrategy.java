package cn.bugstack.springframework.service;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author miozus
 * @date 2022/12/04
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, Constructor ctor, String beanName, Object[] args) throws BeansException;
}
