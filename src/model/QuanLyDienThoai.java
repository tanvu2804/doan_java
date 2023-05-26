package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DataBaseUtil;

public class QuanLyDienThoai {
	public static boolean themDienThoai(ModelDienThoai dt) throws Exception {
		// sử dụng query
		try {
			Connection conn = DataBaseUtil.getConnection();
			String sql_them = "INSERT INTO dienthoai (madienthoai, tendienthoai, giatien, namsanxuat)"
					+ " values (?, ?, ?, ?)";
//			Statement statement = conn .createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(sql_them);
			preparedStmt.setString(1, dt.getMaDienThoai());
			preparedStmt.setString(2, dt.getTenDienThoai());
			preparedStmt.setDouble(3, dt.getGiaTien());
			preparedStmt.setInt(4, dt.getNamSX());
			Boolean isAdd = preparedStmt.execute();
			return isAdd;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean xoaDienThoai(String maDienThoai) throws Exception {
		try {
			Connection con = DataBaseUtil.getConnection();
			String sql_xoa = "DELETE FROM dienthoai Where maDienThoai='" + maDienThoai + "'";
			Statement statement = (Statement) con.createStatement();
			int i = ((java.sql.Statement) statement).executeUpdate(sql_xoa);
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean suaDienThoai(ModelDienThoai dt) throws Exception {
		// sử dụng Store Procedure
		try {
			Connection con = DataBaseUtil.getConnection();
			String sql_sua = "UPDATE dienthoai SET tendienthoai=?,namsanxuat=?,giatien=? WHERE madienthoai=?";
			PreparedStatement prepared = con.prepareStatement(sql_sua);
			prepared.setString(4, dt.getMaDienThoai());
			prepared.setString(1, dt.getTenDienThoai());
			prepared.setInt(2, dt.getNamSX());
			prepared.setDouble(3, dt.getGiaTien());
			int i = prepared.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

// DOc 
	public static ArrayList<ModelDienThoai> getDanhSach() throws Exception {
		// //sử dụng Stored Procedure
		ArrayList<ModelDienThoai> dsdt = new ArrayList<>();
		try {
			Connection con = DataBaseUtil.getConnection();
			String sql_laydsdt = "SELECT* FROM dienthoai";
			PreparedStatement prepared = con.prepareStatement(sql_laydsdt);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				String maDT = rs.getString("madienthoai");
				String tenDT = rs.getString("tendienthoai");
				int namSX = rs.getInt("namsanxuat");
				double giaTien = rs.getDouble("giatien");
				dsdt.add(new ModelDienThoai(maDT, tenDT, namSX, giaTien));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdt;
	}
}
