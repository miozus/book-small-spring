package cn.bugstack.springframework.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性值
 *
 * @author miozus
 * @date 2022/12/04
 */
@Data
public class PropertyValues {


    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    /**
     * 获取属性值
     * 类型占位符： String[] y = x.toArray(new String[0]);
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public Object getPropertyValue(String propertyName) {

        for (PropertyValue pv : this.propertyValues) {
            if (pv.getName().equalsIgnoreCase(propertyName)){
                return pv.getValue();
            }
        }
        return null;
    }
}
