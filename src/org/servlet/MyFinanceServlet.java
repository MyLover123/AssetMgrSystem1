package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.model.Finance;
import org.service.MyFinanceService;
import org.service.impl.MyFinanceServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/myFinance.ajax")
public class MyFinanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        MyFinanceService ms=new MyFinanceServiceImpl();
        List<Finance> list = ms.getFinance(account);
        String indexStr = request.getParameter("index");
        // 第一页
        int index = Integer.parseInt(indexStr);
        // 一页几条数据
        int size = 5;

//        1-1~4，2-5~8，3-9~12，4-13~16

        // 最小值
        int min = (index - 1) * size;
        // 最大值
        int max = ((min + size) > list.size()) ? list.size() : (min + size);
        List<Finance> fd = new ArrayList<>();
        for (int i = min; i < max; i++) {
            fd.add(list.get(i));
        }

        JSONObject data = new JSONObject();
        data.put("list", fd);
        data.put("maxSize", (list.size() % size == 0) ? (list.size() / size) : (list.size() / size + 1) );
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
