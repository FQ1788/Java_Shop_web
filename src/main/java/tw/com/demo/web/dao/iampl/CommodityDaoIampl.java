package tw.com.demo.web.dao.iampl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;

import tw.com.demo.web.dao.CommodityDao;
import tw.com.demo.web.dbutils.DBUtil;
import tw.com.demo.web.javabean.Commodity;

public class CommodityDaoIampl implements CommodityDao {
	private Connection conn = null; //宣告會連接資料庫
	private Statement st = null; //宣告會將字串轉換為資料庫語法
	private PreparedStatement ps =null; //宣告會將字串轉換為資料庫語法，可以將字串內的?填入值
	private ResultSet rs = null; //宣告接收SQL回傳內容的語法
	
	/**
	 * 新增商品
	 */
	@Override
	public void addCommodity(Commodity com ,String userAccount) {
		
		try {
			//建立資料庫連線
			conn = DBUtil.getDB().getConnection();

			//建立一個字串並轉換為SQL語法執行
			String addSQL ="INSERT INTO commodity(comName,comNumber,comPrice,comImage,userAccount)values(?,?,?,?,?)"; 
			ps = conn.prepareStatement(addSQL);
			ps.setString(1,com.getComName());
			ps.setInt(2,com.getComNumber());
			ps.setInt(3,com.getComPrice());
			ps.setString(4, com.getComImage());
			ps.setString(5, userAccount);
			
			//上傳並更新
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//關閉與資料庫的連線
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
	 * 查詢全部的商品
	 * 回傳list型態
	 */
	public List<Commodity> inquireAllCommodity(String userAccount){
		//宣告一個陣列(list 資料型態為Java Bean<Commodity>)變數，用來存放從SQL裡面取得的資料
		List<Commodity> comList = null;
		try {
			//建立資料連線
			conn = DBUtil.getDB().getConnection();
			
			//建立一個字串並轉換為SQL語法執行
			String addSQL ="SELECT * FROM commodity WHERE userAccount = ? ";
			ps = conn.prepareStatement(addSQL);
			//將SQL語法內的?，填入值(value)
			ps.setString(1, userAccount);
			
			//執行SQL語法，並將取得的商品內容傳入rs中
			rs=ps.executeQuery();
			//宣告要使用的陣列
			comList = new ArrayList<Commodity>();
			//用迴圈將取得的資料放入陣列(list)裡面
			while(rs.next()) {
				comList.add(new Commodity(rs.getInt("cid"), rs.getString("comName"), rs.getInt("comNumber"), rs.getInt("comPrice"), rs.getString("comImage")));
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
		return comList;
	}
	
	/**
	 * 更新商品資料
	 */
	public void updateCommodity(Commodity com) {
		try {
			//建立資料庫連線
			conn = DBUtil.getDB().getConnection();
			//建立一個字串放SQL語法
			String updateCom = "UPDATE commodity SET comName = ? ,comNumber = ? ,comPrice = ? ,comImage=? WHERE cid= ? ";
			//將字串轉換為SQL語法
			ps = conn.prepareStatement(updateCom);
			//將com(Java Bean)內的值填入SQL語法內的 ?
			ps.setString(1, com.getComName());
			ps.setInt(2, com.getComNumber());
			ps.setInt(3, com.getComPrice());
			ps.setString(4, com.getComImage());
			ps.setInt(5, com.getId());
			
			//上傳並更新至資料庫
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//關閉與資料庫的連線
				DBUtil.getDB().close(ps);
				DBUtil.getDB().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}
