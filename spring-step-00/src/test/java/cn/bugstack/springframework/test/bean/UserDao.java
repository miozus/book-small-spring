package cn.bugstack.springframework.test.bean;

import java.util.HashMap;

/**
 * 用户数据库衔接对象
 *
 * @author miozus
 * @date 2022/12/04
 */
public class UserDao {
    private static HashMap<String, String > data = new HashMap<>();

    static {
        data.put("10001", "阿猫");
        data.put("10002", "Miozus");
        data.put("10003", "大壮");
    }

    public String getById(String id) {
        return data.getOrDefault(id, "");
    }
}
