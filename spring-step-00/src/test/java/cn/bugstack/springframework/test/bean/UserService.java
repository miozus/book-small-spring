package cn.bugstack.springframework.test.bean;

import lombok.Data;

/**
 * 模拟用户 Bean 对象
 */
@Data
public class UserService {

    private String id;
    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.getById(id));
    }

    public void insertUserInfo(String age) {
        System.out.println("插入用户信息，年龄" + age);
    }

}
