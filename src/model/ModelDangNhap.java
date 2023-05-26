package model;

public class ModelDangNhap {

	String username;
	String password;

	public ModelDangNhap() {
	}

	public ModelDangNhap(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean kiemTraDangNhap(String username, String password) {

		if (username.equals("dongochieu") && password.equals("123")) {
			return true;
		} else {
			return false;
		}
	}
}
