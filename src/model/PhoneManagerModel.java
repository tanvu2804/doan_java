package model;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import database.DataBaseUtil;

/**
 * LibraryModel
 */

public class PhoneManagerModel {
	public void insertDataIntoTable(DefaultTableModel tableModel) throws Exception {
		Connection connection = DataBaseUtil.getConnection();
		String query = "SELECT * FROM dienthoai";

		ResultSet result = connection.createStatement().executeQuery(query);
		while (result.next()) {
			String maDienThoai = result.getString(1);
			String tenDienThoai = result.getString(2);
			int namSx = result.getInt(3);
			double gia = result.getDouble(4);
			System.out.println("--------------------");
			System.out.println("MÃ ĐIỆN THOẠI: " + maDienThoai);
			System.out.println("TÊN ĐIỆN THOẠI: " + tenDienThoai);
			System.out.println("NĂM SX: " + namSx);
			System.out.println("GIÁ: " + gia);
			tableModel.addRow(new Object[] { maDienThoai, tenDienThoai, namSx, gia });
		}
	}
}