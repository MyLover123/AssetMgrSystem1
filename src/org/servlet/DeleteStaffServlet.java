package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.DeleteStaffService;
import org.service.impl.DeleteStaffServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doDelete.ajax")
public class DeleteStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("staffId");
        int code = -1;

        DeleteStaffService ds = new DeleteStaffServiceImpl();
        boolean delete = ds.doDelete(Integer.parseInt(id));
        if (delete) {
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
