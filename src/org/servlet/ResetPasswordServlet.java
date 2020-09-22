package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.ResetPasswordService;
import org.service.impl.ResetPasswordServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doReset.ajax")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("staffId");
        int code = -1;

        ResetPasswordService rs = new ResetPasswordServiceImpl();
        boolean reset = rs.doReset(Integer.parseInt(id));
        if (reset) {
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
