package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelDangNhap;
import model.ModelDienThoai;
import model.QuanLyDienThoai;
import view.GUI_QuanLyDienThoai;

public class ControllerQuanLyDienThoai {
	private GUI_QuanLyDienThoai formQuanLyDienThoai;

	public ControllerQuanLyDienThoai(GUI_QuanLyDienThoai formQuanLyDienThoai) {
		this.formQuanLyDienThoai = formQuanLyDienThoai;
		ControllerThemDienThoai();
	} 

	public void ControllerThemDienThoai() {
		formQuanLyDienThoai.getBtn_them().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maDThoai = formQuanLyDienThoai.getTxt_maDThoai().getText();
				String tenDThoai = formQuanLyDienThoai.getTxt_tenDThoai().getText();
				String giaTien = formQuanLyDienThoai.getTxt_giaTien().getText();
				String namSX = formQuanLyDienThoai.getTxt_namSX().getText();

				ModelDienThoai modelDienThoai = new ModelDienThoai(maDThoai, tenDThoai, Integer.parseInt(namSX),
						Double.parseDouble(giaTien));

				try {
					Boolean isThemDienThoai = QuanLyDienThoai.themDienThoai(modelDienThoai);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
