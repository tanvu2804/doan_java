package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelDangNhap;
import model.DangNhap;
import view.GUI_DangNhap;
import view.GUI_QuanLyDienThoai;

public class ControllerDangNhap {
	private GUI_DangNhap formDangNhap;
	private ModelDangNhap modelDangNhap;
	GUI_QuanLyDienThoai formQuanLyDienThoai;

	public ControllerDangNhap() {

	}

	public ControllerDangNhap(GUI_DangNhap formDangNhap) {
		this.formDangNhap = formDangNhap;
		formDangNhap.getBtn_signin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = formDangNhap.getTxt_user().getText();
				String password = formDangNhap.getTxt_password().getText();
				ModelDangNhap modelDangNhap = new ModelDangNhap(username, password);
				Boolean isDangNhap = DangNhap.dangNhap(modelDangNhap);
				if (isDangNhap) {
					formQuanLyDienThoai = new GUI_QuanLyDienThoai();
					formDangNhap.setVisible(false);// Đóng formDangNhap
					new ControllerQuanLyDienThoai(formQuanLyDienThoai);// Chạy GUI_QL
				} else {
					formDangNhap.getLbl_thongBao().setText("Dang nhap khong thanh cong!");
				}
			}
		});
	}

}
