package tw.com.demo.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import tw.com.demo.web.dao.iampl.CommodityDaoIampl;
import tw.com.demo.web.dao.iampl.StudentDaoIampl;
import tw.com.demo.web.javabean.Commodity;
import tw.com.demo.web.javabean.Student;

/**
 * Servlet implementation class ServletDemo01
 */
@WebServlet("/sd01")
public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 登入頁面判斷
	 */
	public void getLogin(HttpServletRequest request, HttpServletResponse response) {
		try{
			//取得前台輸入的帳號(sName)密碼(sPass)
			String sName = request.getParameter("sName");
			String sPass = request.getParameter("sPass");
			
			//宣告一個比對資料庫內帳號密碼的方法
			StudentDaoIampl sdi =new StudentDaoIampl();
			
			//將前台的值送入方法內，若成功會回傳OK，失敗或沒有帳密會回傳NO(String型態)
			String s = sdi.StudentLogin(sName, sPass);
			
			if(s!=null) {
				if(s.equals("OK")) {
					//增加一個Session的狀態來表示登入
					request.getSession().setAttribute("loginState", "OK");
					request.getSession().setAttribute("studentName", sName);
					//登入成功轉跳到後台
					request.getRequestDispatcher("./index.jsp").forward(request, response);
					return;
				}
			}
			//若錯誤的會將錯誤訊息傳到登入畫面內(login.jsp)
			request.setAttribute("mags", "帳號或密碼錯誤");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 註冊頁面判斷
	 */
	public void getAddStudent(HttpServletRequest request, HttpServletResponse response) {
		
		//將前台輸入的資料傳送到Student(Java Bean)裡面
		Student std =new Student();
		std.setUserAccount(request.getParameter("userAccount"));
		std.setUserPass(request.getParameter("userPass"));
		std.setUserEmail(request.getParameter("userEmail"));
		std.setUserName(request.getParameter("userName"));
		std.setUserTel(request.getParameter("userTel"));
		std.setStoreName(request.getParameter("storeName"));
		std.setUserCity(request.getParameter("userCity"));
		std.setUserAddress(request.getParameter("userAddress"));
		
		//判斷註冊頁面的我同意是否有勾選
		if(request.getParameter("cbox1")==null) {
			try {
				request.setAttribute("User", std);
				request.setAttribute("mags", "請勾選我同意");
				request.getRequestDispatcher("./addStudent.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			return;
		}
		//呼叫上傳資料庫的方法，並法Student(java bean)傳進去
		StudentDaoIampl sdi = new StudentDaoIampl();
		sdi.addStudent(std);
		
		//上傳完資料庫後轉發到首頁
		try {
			response.sendRedirect("./index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
	/**
	 * 新增商品判斷
	 */
	public void addCom(HttpServletRequest request, HttpServletResponse response) {
		//將前台輸入的資料傳送到Commodity(Java Bean)裡面
		Commodity com = new Commodity();
		com.setComName((request.getParameter("comName")));
		com.setComNumber(Integer.parseInt(request.getParameter("comNumber")));
		com.setComPrice(Integer.parseInt(request.getParameter("comPrice"))); 
		com.setComImage(request.getParameter("comImage"));
		
		//取得前台使用者的帳號
		String userAccount = request.getSession().getAttribute("studentName").toString();
		
		//呼叫上傳資料庫的方法，並把Commodity(java bean)傳進去
		CommodityDaoIampl cdi =new CommodityDaoIampl();
		cdi.addCommodity(com,userAccount);
		
		//新增完資料後回傳訊息(成功)並轉跳到查詢全部商品(商品列表)的方法
		request.getSession().setAttribute("msg", "成功新增商品");
		inquireCom(request, response);
		return;
	}
	
	/**
	 * 查詢全部商品
	 */
	public void inquireCom(HttpServletRequest request, HttpServletResponse response) {
		//宣告一個陣列，以便後續取得的資料放入
		List<Commodity> comList=null;
		//建立一個查詢商品的實體
		CommodityDaoIampl com = new CommodityDaoIampl();
		//取得使用者的帳號
		String studentName = request.getSession().getAttribute("studentName").toString();
		
		if(studentName != null) {
			//呼叫取得全部商品的方法，並把取得的商品資料傳到一個List裡面
			comList = com.inquireAllCommodity(studentName);
			//將取得的商品全部傳入一個標籤裡面
			request.setAttribute("comList", comList);
			try {
				//將資料轉發到商品頁面
				request.getRequestDispatcher("./mycom.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				//判斷若沒有登入帳號會直接轉發到登入頁面
				response.sendRedirect("./login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	/**
	 * 更新商品內容
	 */
	public void updateCom(HttpServletRequest request, HttpServletResponse response) {
		//將前台接收到的資料傳送到Commodity(Java Bean)裡面
		Commodity com = new Commodity();
		com.setComName(request.getParameter("comName"));
		com.setComNumber(Integer.parseInt(request.getParameter("comNumber")));
		com.setComPrice(Integer.parseInt(request.getParameter("comPrice")));
		com.setId(Integer.parseInt(request.getParameter("comId")));
		com.setComImage(request.getParameter("comImage"));
		
		//將Commodity(Java Bean)裡面的資料傳送到 "更新資料庫(updateCommodity)" 的方法內處理。
		CommodityDaoIampl cdi = new CommodityDaoIampl();
		cdi.updateCommodity(com);
		
		//上傳結束後，轉到查詢全部商品的方法。
		inquireCom(request, response);
		return;
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//抓取前台進入的狀態，來判斷目前的動作(登入、註冊)
		String uri = request.getParameter("state");
		//System.out.println("本體");
		if(uri !=null) {
			if(uri.equals("login")) {
				getLogin(request,response);
			}else if(uri.equals("addStudent")) {
				getAddStudent(request,response);
			}else if(uri.equals("addCom")) {
				addCom(request,response);
			}else if(uri.equals("inquireCom")) {
				inquireCom(request, response);
			}else if(uri.equals("updateCom")) {
				updateCom(request, response);
			}
		}else {
			response.sendRedirect("./login.jsp");
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
