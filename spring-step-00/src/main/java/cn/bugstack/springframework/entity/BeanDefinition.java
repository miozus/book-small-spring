package cn.bugstack.springframework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 种子定义
 * Bean 对象信息定义
 *
 * @author miozus
 * @date 2022/12/03
 */
@Data
@AllArgsConstructor
public class BeanDefinition {

    private Class beanClass;


}
