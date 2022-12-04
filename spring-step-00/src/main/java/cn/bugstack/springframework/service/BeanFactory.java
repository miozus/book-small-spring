package cn.bugstack.springframework.service;

import cn.bugstack.springframework.exception.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单的 Bean 工厂 接口
 */
public interface BeanFactory {

    /** 得到种子：无参构造 */
    Object getBean(String beanName) throws BeansException;

    /** 得到种子：有参构造
     * 必须写... 可选范围包含数组、任意
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
