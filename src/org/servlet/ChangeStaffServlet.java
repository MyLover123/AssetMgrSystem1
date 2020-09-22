package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.ChangeStaffService;
import org.service.impl.ChangeStaffServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeStaff.ajax")
public class ChangeStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("staffName");
        String sex = request.getParameter("staffSex");
        String staffPassword = request.getParameter("staffPassword");
        String account = request.getParameter("account");
        int code = -1;

        ChangeStaffService cs = new ChangeStaffServiceImpl();
        boolean change = cs.doChange(name,sex,staffPassword,account);
        if (change) {
            code = 0;
        } else {
            code = -2;
        }

        JSONObject data = new JSONObject();
        data.put("code", code);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
