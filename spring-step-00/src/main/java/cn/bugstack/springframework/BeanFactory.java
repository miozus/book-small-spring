package cn.bugstack.springframework;

import cn.bugstack.springframework.exception.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单的 Bean 工厂 接口
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

}
