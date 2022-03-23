package tw.com.demo.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import tw.com.demo.web.dao.StudentDao;
import tw.com.demo.web.dao.iampl.CommodityDaoIampl;
import tw.com.demo.web.dao.iampl.StudentDaoIampl;
import tw.com.demo.web.javabean.Commodity;
import tw.com.demo.web.javabean.Order;
import tw.com.demo.web.javabean.Student;

/**
 * Servlet implementation class AndroidServlet
 */
@WebServlet("/AS")
public class AndroidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = request.getParameter("state");
		CommodityDaoIampl cdi = new CommodityDaoIampl();
		StudentDaoIampl sdi = new StudentDaoIampl();
		if("login".equals(state)) {		
			//登入判斷
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("userPass");
			String result = sdi.StudentLogin(userName, userPass);
			response.getWriter().print(result);
			
		}else if("getData".equals(state)) {
			//取得商品資訊
			HashMap<String,List<Commodity>> allDataMap= new HashMap<String,List<Commodity>>();
			List<Student> studentData = sdi.getStudentData();
			for(Student s:studentData) {
				String account = s.getUserAccount();
				List<Commodity> comData = cdi.inquireAllCommodity(account);
				allDataMap.put(s.getStoreName(), comData);
			}
			Gson gson = new Gson();
			System.out.println(allDataMap.toString());
			String comJson = gson.toJson(allDataMap);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(comJson);
			
		}else if("addOrder".equals(state)) {
			//新增訂單
			response.setCharacterEncoding("UTF-8");
			String DataJson = request.getParameter("jsonArrayData");
			Gson gson = new Gson();
			if(DataJson != null) {
				JsonArray jsonArray = new JsonParser().parse(DataJson).getAsJsonArray();
				for(int i=0;i<jsonArray.size();i++) {
					System.out.println(jsonArray.get(i));
					Order order = gson.fromJson(jsonArray.get(i),Order.class);
					System.out.println(order.getComName());
					System.out.println(order.getOrderId());
				}				
			}			
		}
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
