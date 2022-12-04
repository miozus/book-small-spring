package cn.bugstack.springframework.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 模拟用户 Bean 对象
 */
@Data
@AllArgsConstructor
public class UserService {

    private  String name;

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

    public void insertUserInfo(String age) {
        System.out.println("插入用户信息，年龄"+age);
    }

}
