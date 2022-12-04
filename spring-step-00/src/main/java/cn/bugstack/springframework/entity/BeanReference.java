package cn.bugstack.springframework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 种子参考
 *
 * @author miozus
 * @date 2022/12/04
 */
@AllArgsConstructor
public class BeanReference {

    @Getter
    private String beanName;
}
