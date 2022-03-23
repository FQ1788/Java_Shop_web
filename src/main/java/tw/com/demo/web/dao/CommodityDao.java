package tw.com.demo.web.dao;

import java.util.List;

import tw.com.demo.web.javabean.Commodity;

public interface CommodityDao {
	//新增商品Commodity
	public void addCommodity(Commodity com,String userAccount);
	//查詢商品Commodity
	public List<Commodity> inquireAllCommodity(String userAccount);
	//更新商品Commodity
	public void updateCommodity(Commodity com);
}
