package org.dao;

public interface LoginDao {
    /**
     * 登录校验
     *
     * @param username 用户名
     * @param password 密码
     * @param role 角色
     * @return 校验结果
     */
    boolean doLogin(String username, String password, int role);
}
