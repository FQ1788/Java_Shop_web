package tw.com.demo.web.javabean;

public class Commodity {
	private int id;
	private String comName;
	private int comNumber;
	private int comPrice;
	private String comImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getComNumber() {
		return comNumber;
	}
	public void setComNumber(int comNumber) {
		this.comNumber = comNumber;
	}
	public int getComPrice() {
		return comPrice;
	}
	public void setComPrice(int comPrice) {
		this.comPrice = comPrice;
	}
	public String getComImage() {
		return comImage;
	}
	public void setComImage(String comImage) {
		this.comImage = comImage;
	}
	public Commodity() {
		super();
	}
	
	public Commodity(int id, String comName, int comNumber, int comPrice, String comImage) {
		super();
		this.id = id;
		this.comName = comName;
		this.comNumber = comNumber;
		this.comPrice = comPrice;
		this.comImage = comImage;
	}
	
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", comName=" + comName + ", comNumber=" + comNumber + ", comPrice=" + comPrice
				+ ", comImage=" + comImage + "]";
	}

}
