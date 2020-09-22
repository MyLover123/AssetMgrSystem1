package org.service.impl;

import org.dao.LoginDao;
import org.dao.impl.LoginDaoImpl;
import org.service.LoginService;

public class LoginServiceImpl implements LoginService {
    /**
     * 登录校验
     * @param name   用户名
     * @param passwd 密码
     * @return 校验结果
     */
    @Override
    public boolean doLogin(String name, String passwd, int role) {
        LoginDao loginDao = new LoginDaoImpl();
        return loginDao.doLogin(name,passwd,role);
    }


}
