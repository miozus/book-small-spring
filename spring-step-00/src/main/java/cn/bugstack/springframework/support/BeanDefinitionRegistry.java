package cn.bugstack.springframework.support;

import cn.bugstack.springframework.BeanDefinition;
import sun.plugin.com.BeanClass;

/**
 * 种子定义注册表
 *
 * @author miozus
 * @date 2022/12/03
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
