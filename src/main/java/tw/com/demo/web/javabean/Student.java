package tw.com.demo.web.javabean;

public class Student {
	private int id;
	private String userAccount;
	private String userPass;
	private String userEmail;
	private String userName;
	private String userTel;
	private String storeName;
	private String userCity;
	private String userAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Student() {
		super();
	}
	
	
	
	public Student(int id,String userAccount,String storeName) {
		this.id = id;
		this.userAccount = userAccount;
		this.storeName = storeName;
	}
	@Override
	public String toString() {
		return "Student [userAccount=" + userAccount + ", userPass=" + userPass + ", userEmail=" + userEmail
				+ ", userName=" + userName + ", userTel=" + userTel + ", storeName=" + storeName + ", userCity="
				+ userCity + ", userAddress=" + userAddress + "]";
	}
	
	
	
}
