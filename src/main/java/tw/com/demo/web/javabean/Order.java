package tw.com.demo.web.javabean;

public class Order {
	private String orderId,userAccount,comName,comNo;
	private int comNumber,comTotal;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String id) {
		this.orderId = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComNo() {
		return comNo;
	}
	public void setComNo(String comNo) {
		this.comNo = comNo;
	}
	public int getComNumber() {
		return comNumber;
	}
	public void setComNumber(int comNumber) {
		this.comNumber = comNumber;
	}
	public int getComTotal() {
		return comTotal;
	}
	public void setComTotal(int comTotal) {
		this.comTotal = comTotal;
	}
	public Order(String orderId, String userAccount, String comName, String comNo, int comNumber, int comTotal) {
		super();
		this.orderId = orderId;
		this.userAccount = userAccount;
		this.comName = comName;
		this.comNo = comNo;
		this.comNumber = comNumber;
		this.comTotal = comTotal;
	}
	
	public Order() {
		super();
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userAccount=" + userAccount + ", comName=" + comName + ", comNo="
				+ comNo + ", comNumber=" + comNumber + ", comTotal=" + comTotal + "]";
	}
	

	
	
}
