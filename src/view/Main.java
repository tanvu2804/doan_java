package view;

import controller.ControllerDangNhap;
import controller.ControllerQuanLyDienThoai;

public class Main {
	public static void main(String[] args) {	
		new ControllerQuanLyDienThoai(new GUI_QuanLyDienThoai());
//		new ControllerDangNhap(new GUI_DangNhap()); 
	}
}