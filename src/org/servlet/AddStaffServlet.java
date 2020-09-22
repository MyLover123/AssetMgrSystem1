package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.AddStaffService;
import org.service.impl.AddStaffServiceImpl;
import org.utils.JsonUtils;
import org.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addStaff.ajax")
public class AddStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName=request.getParameter("staffName");
        String staffYear=request.getParameter("staffYear");
        String staffSex=request.getParameter("staffSex");
        String staffAccount=request.getParameter("staffAccount");
        String staffPassword=request.getParameter("staffPassword");
        String staffRole=request.getParameter("staffRole");

        int code = 0;
        if (!StringUtils.isAllNotEmpty(staffName, staffYear,staffSex,staffAccount,staffPassword,staffRole)) {
            code = -1;
        } else {
            AddStaffService as = new AddStaffServiceImpl();
            boolean flag = as.doAdd(staffName,Double.parseDouble(staffYear),staffSex,staffAccount,staffPassword,staffRole);
            if (flag) {
                code = 0;
            } else {
                code = -2;
            }
        }
        JSONObject data = new JSONObject();
        data.put("code", code);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
