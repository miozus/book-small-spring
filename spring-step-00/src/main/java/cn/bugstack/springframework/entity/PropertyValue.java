package cn.bugstack.springframework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 属性值
 *
 * @author miozus
 * @date 2022/12/04
 */
@Data
@AllArgsConstructor
public class PropertyValue {

    String name;
    Object value;
}
