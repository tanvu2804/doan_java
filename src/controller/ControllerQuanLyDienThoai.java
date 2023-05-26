package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import model.ModelDienThoai;
import model.QuanLyDienThoai;
import view.GUI_QuanLyDienThoai;

public class ControllerQuanLyDienThoai {
	private GUI_QuanLyDienThoai formQuanLyDienThoai;
	private List<ModelDienThoai> listDienThoai;

	public ControllerQuanLyDienThoai(GUI_QuanLyDienThoai formQuanLyDienThoai) {
		this.formQuanLyDienThoai = formQuanLyDienThoai;
		showListDienThoai();
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

				List<ModelDienThoai> result = listDienThoai.stream()
						.filter(item -> item.getMaDienThoai().equals(maDThoai)).collect(Collectors.toList());
				if (result.size() == 0) {
					try {
						Boolean isThemDienThoai = QuanLyDienThoai.themDienThoai(modelDienThoai);
						if (isThemDienThoai) {
							formQuanLyDienThoai.showMessage("thêm thành công");
							showListDienThoai();
						} else {
							formQuanLyDienThoai.showMessage("lỗi");
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					formQuanLyDienThoai.showMessage("mã trùng");
				}

			}
		});
	}

	public void controllerTimKiemTheoTen() {
		formQuanLyDienThoai.getBtn_tim().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String kw = formQuanLyDienThoai.getTxt_tim().getText();
				if (kw != null && kw.length() != 0) {
					List<ModelDienThoai> result = listDienThoai.stream()
							.filter(item -> item.getTenDienThoai().equals(kw)).collect(Collectors.toList());
					formQuanLyDienThoai.showListDienThoai(result);
				} else {
					showListDienThoai();
				}
			}
		});

	}

	public void showListDienThoai() {
		try {
			listDienThoai = QuanLyDienThoai.getDanhSach();
			formQuanLyDienThoai.setVisible(true);
			formQuanLyDienThoai.showListDienThoai(listDienThoai);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
