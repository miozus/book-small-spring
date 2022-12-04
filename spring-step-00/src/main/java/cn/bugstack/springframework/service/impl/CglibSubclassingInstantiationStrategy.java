package cn.bugstack.springframework.service.impl;

import cn.bugstack.springframework.entity.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.service.InstantiationStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * cglib子类实例化策略
 *
 * @author miozus
 * @date 2022/12/04
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, Constructor ctor, String beanName, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 无参构造
        if (Objects.isNull(ctor)) {
            return enhancer.create();
        }
        // 有参构造
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
