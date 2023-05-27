package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		ControllerMoi();
		controllerSelectedTable();
		ControllerSuaDienThoai();
		ControllerXoaDienThoai();
		controllerTimKiemTheoTen();
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

	public void ControllerSuaDienThoai() {
		formQuanLyDienThoai.getBtn_sua().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maDThoai = formQuanLyDienThoai.getTxt_maDThoai().getText();
				String tenDThoai = formQuanLyDienThoai.getTxt_tenDThoai().getText();
				String giaTien = formQuanLyDienThoai.getTxt_giaTien().getText();
				String namSX = formQuanLyDienThoai.getTxt_namSX().getText();
				ModelDienThoai modelDienThoai = new ModelDienThoai(maDThoai, tenDThoai, Integer.parseInt(namSX),
						Double.parseDouble(giaTien));
				try {
					Boolean isSuaDienThoai = QuanLyDienThoai.suaDienThoai(modelDienThoai);
					if (isSuaDienThoai) {
						formQuanLyDienThoai.showMessage("sửa thành công");
						showListDienThoai();
					} else {
						formQuanLyDienThoai.showMessage("lỗi");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void ControllerXoaDienThoai() {
		formQuanLyDienThoai.getBtn_xoa().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maDThoai = formQuanLyDienThoai.getTxt_maDThoai().getText();
				try {
					Boolean isSuaDienThoai = QuanLyDienThoai.xoaDienThoai(maDThoai);
					if (isSuaDienThoai) {
						formQuanLyDienThoai.showMessage("xóa thành công");
						showListDienThoai();
					} else {
						formQuanLyDienThoai.showMessage("lỗi");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void ControllerMoi() {
		formQuanLyDienThoai.getBtn_moi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formQuanLyDienThoai.getTxt_maDThoai().setText("");
				formQuanLyDienThoai.getTxt_tenDThoai().setText("");
				formQuanLyDienThoai.getTxt_namSX().setText("");
				formQuanLyDienThoai.getTxt_giaTien().setText("");
				// disable Edit and Delete buttons
				formQuanLyDienThoai.getBtn_sua().setEnabled(false);
				formQuanLyDienThoai.getBtn_xoa().setEnabled(false);
				// enable Add button
				formQuanLyDienThoai.getBtn_them().setEnabled(true);
				formQuanLyDienThoai.getTxt_maDThoai().setEnabled(true);

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
					List<ModelDienThoai> result;
					try {
						result = QuanLyDienThoai.getTimDienThoai(kw);
						System.out.print(result);
						formQuanLyDienThoai.showListDienThoai(result);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					showListDienThoai();
				}
			}
		});

	}

	public void controllerSelectedTable() {
		formQuanLyDienThoai.getTb_dienThoai().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				formQuanLyDienThoai.selectedRowTableDienThoai();

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
