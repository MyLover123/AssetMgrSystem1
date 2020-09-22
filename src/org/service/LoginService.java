package org.service;

public interface LoginService {

    /**
     * 登录校验
     *
     * @param name   用户名
     * @param passwd 密码
     * @param role 角色
     * @return 校验结果
     */
    boolean doLogin(String name, String passwd , int role);
}
