package cn.bugstack.springframework.service.impl;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.service.InstantiationStrategy;
import com.sun.xml.internal.ws.api.server.BoundEndpoint;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * 简单实例化策略
 *
 * @author miozus
 * @date 2022/12/04
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, Constructor ctor, String beanName, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            // 无参构造：默认
            if (Objects.isNull(ctor)) {
                return clazz.getDeclaredConstructor().newInstance();
            }
            // 有参构造
            return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new BeansException("实例化[" + clazz.getName() + "]失败");
        }
    }
}
