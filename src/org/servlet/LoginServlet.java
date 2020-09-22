package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.LoginService;
import org.service.impl.LoginServiceImpl;
import org.utils.JsonUtils;
import org.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录
 */
@WebServlet(urlPatterns = "/login.ajax")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String passwd = request.getParameter("passwd");
        String role = request.getParameter("role");

        int code = 0;

        if (!StringUtils.isAllNotEmpty(uname, passwd)) {
            code = -1;
        } else {
            LoginService ls = new LoginServiceImpl();
            boolean login = ls.doLogin(uname, passwd,Integer.parseInt(role));
            if (login) {
                code = 0;
            } else {
                code = -2;
            }
        }
        JSONObject data = new JSONObject();
        data.put("code", code);
        JsonUtils.outJson(data, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
