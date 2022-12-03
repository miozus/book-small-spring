package cn.bugstack.springframework.test.bean;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 模拟用户 Bean 对象
 * @date 2022/2/9
 *
 *
 */
public class UserService {

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

    public void insertUserInfo(String age) {
        System.out.println("插入用户信息，年龄"+age);
    }

}
