package tw.com.demo.web.dao.iampl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.Predicate;

import tw.com.demo.web.dao.StudentDao;
import tw.com.demo.web.dbutils.DBUtil;
import tw.com.demo.web.javabean.Student;

public class StudentDaoIampl implements StudentDao {
	private Connection conn = null; //宣告會連接資料庫
	private PreparedStatement ps =null; //先宣告會將字串轉換為資料庫語法
	private ResultSet rs =null;
	/**
	 * 新增商家註冊資料
	 */
	@Override
	public void addStudent(Student stu) {
		try {
			//建立資料庫連線
			conn = DBUtil.getDB().getConnection();

			//建立一個字串並轉換為SQL語法執行
			String addSQL ="INSERT INTO student(userAccount,userPass,userEmail,userName,userTel,storeName,userCity,userAddress)values(?,?,?,?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(addSQL);
			ps.setString(1,stu.getUserAccount());
			ps.setString(2,stu.getUserPass());
			ps.setString(3,stu.getUserEmail());
			ps.setString(4,stu.getUserName());
			ps.setString(5,stu.getUserTel());
			ps.setString(6,stu.getStoreName());
			ps.setString(7,stu.getUserCity());
			ps.setString(8,stu.getUserAddress());
			//上傳並更新
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.getDB().close(ps);
				DBUtil.getDB().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	
	
	/**
	 * 登入的商家帳號密碼比對
	 * @param sName 商家帳號(userAccount)
	 * @param sPass 商家密碼(userPass)
	 * @return 是否成功的狀態(OK or NO)
	 */
	public String StudentLogin(String sName,String sPass) {
		//宣告狀態的字串
		String state = null;
		try {
			//建立資料庫連線
			conn = DBUtil.getDB().getConnection();
			//建立SQL語法的字串
			String loginSQL = "SELECT userAccount,userPass FROM student WHERE userAccount LIKE ? "; 
			//將字串轉換成SQL語法並執行
			ps=conn.prepareStatement(loginSQL);
			
			//將值填入SQL語法內的問號中。set資料型態( 第幾個? , 值(value) );
			ps.setString(1, sName);
			
			rs = ps.executeQuery();
			//由於取得的資料庫是從第0行(初始行)開始，所以要用next跳到下一行來取得內容
			if(rs.next()) {}
			//使用IF判斷輸入的帳號密碼有沒有與SQL內取得的值一致
			if (rs.getString("userAccount") != null) {
				if (sPass.equals(rs.getString("userPass"))) {
					state ="OK";
				}else {
					state ="NO";
				}
			}else {
				state="NO";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			state ="NO";
		}finally {
			try {
				//將開啟的資料庫連結關閉，先開後關
				DBUtil.getDB().close(rs);
				DBUtil.getDB().close(ps);
				DBUtil.getDB().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//回傳狀態
		return state;
	}
	
	
	public List<Student> getStudentData() {
		List<Student> StudentList = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			StudentList = new ArrayList<Student>();
			conn = DBUtil.getDB().getConnection();
			String SQL = "SELECT id,userAccount,storeName FROM student";
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentList.add(new Student(rs.getInt("id"),rs.getString("userAccount"),rs.getString("storeName")));	
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//關閉建立的資料庫連接
			try {
				DBUtil.getDB().close(rs);
				DBUtil.getDB().close(ps);
				DBUtil.getDB().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return StudentList;
	}

}
