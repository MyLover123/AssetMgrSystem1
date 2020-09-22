package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.model.Staff;
import org.service.SearchStaffService;
import org.service.impl.SearchStaffServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/searchStaff.ajax")
public class SearchStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        SearchStaffService ss=new SearchStaffServiceImpl();
        List<Staff> staff =ss.getStaff(account);

        JSONObject data = new JSONObject();
        data.put("list", staff);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
