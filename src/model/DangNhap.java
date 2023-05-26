package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DataBaseUtil;

public class DangNhap {
	// Dang nhap
	public static Boolean dangNhap(ModelDangNhap modelDangNhap) {
		// sử dụng Store Procedure
		Boolean isDangNhap = false;
		try {
			Connection conn = DataBaseUtil.getConnection();
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, modelDangNhap.getUsername());
			ps.setString(2, modelDangNhap.getPassword());
			ResultSet rs = ps.executeQuery();
			isDangNhap = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDangNhap;
	}
}
