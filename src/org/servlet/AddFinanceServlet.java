package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.AddFinanceService;
import org.service.impl.AddFinanceServiceImpl;
import org.utils.JsonUtils;
import org.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addFinance.ajax")
public class AddFinanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId=request.getParameter("productId");
        String voucherId=request.getParameter("voucherId");
        String account=request.getParameter("account");
        String datetime=request.getParameter("datetime");

        int code = 0;
        if (!StringUtils.isAllNotEmpty(productId, voucherId,account,datetime)) {
            code = -1;
        } else {
            AddFinanceService as = new AddFinanceServiceImpl();
            boolean flag = as.doAdd(Integer.parseInt(productId),voucherId,datetime,account);
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
