package view;

import controller.ControllerDangNhap;

public class Main {
	public static void main(String[] args) {	
		new ControllerDangNhap(new GUI_DangNhap()); 
	}
}