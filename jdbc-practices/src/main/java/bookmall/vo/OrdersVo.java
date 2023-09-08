package bookmall.vo;

public class OrdersVo {
	private Long no;
	private Long member_no;
	private Long order_code;
	private String address;
	private Long total_price;
	private String member_name;
	private String member_email;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public Long getOrder_code() {
		return order_code;
	}
	public void setOrder_code(Long order_code) {
		this.order_code = order_code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Long total_price) {
		this.total_price = total_price;
	}
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String toString() {
		return "Orders [order_code=" + order_code + ", member_name=" + member_name + ", member_email=" + member_email + ", total_price=" + total_price  + ", address=" + address + "]";
	}
}
