package bookmall.vo;

public class MemberVo {
	private Long no;
	private String name;
	private String phone;
	private String email;
	private String pw;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + ", email=" + email + ", pw=" + pw + "]";
	}
}