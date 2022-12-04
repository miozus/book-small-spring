package cn.bugstack.springframework.entity;

import lombok.*;

import java.util.Objects;

/**
 * 种子定义
 * Bean 对象信息定义
 *
 * @author miozus
 * @date 2022/12/03
 */
@Data
public class BeanDefinition {

    private Class beanClass;
    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = Objects.nonNull(propertyValues) ?
                propertyValues : new PropertyValues();
    }
}
