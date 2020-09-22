package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.ChangeStateService;
import org.service.impl.ChangeStateServiceImpl;
import org.utils.JsonUtils;
import org.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeState.ajax")
public class ChangeStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("staffId");
        int code = -1;

        ChangeStateService cs = new ChangeStateServiceImpl();
        boolean change = cs.changeState(Integer.parseInt(id));
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
