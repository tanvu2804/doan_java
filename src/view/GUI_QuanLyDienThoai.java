package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.print.attribute.AttributeSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import model.ModelDienThoai;

public class GUI_QuanLyDienThoai extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btn_tim;
	private JButton btn_them;
	private JButton btn_xoa;
	private JButton btn_sua;
	private JButton btn_moi;
	private JButton btn_sapXep;
	private JScrollPane sp_bangDienThoai;
	private JTable tb_dienThoai;

	private JLabel lbl_title;
	private JLabel lbl_maDthoai;
	private JLabel lbl_tenDThoai;
	private JLabel lbl_namSX;
	private JLabel lbl_giaTien;
	private JLabel lbl_sapXep;

	private JTextField txt_maDthoai;
	private JTextField txt_tenDThoai;
	private JTextField txt_namSX;
	private JTextField txt_giaTien;
	private JTextField txt_tim;

	private JComboBox<String> cb_sapXep;

	// định nghĩa các cột của bảng điện thoại
	private String[] columnNames = new String[] { "Mã Điện Thoại", "Tên Điện Thoại", "Năm Sản Xuất", "Giá Tiền" };

	// dữ liệu combobox
	String[] sapXep = { "Mã Điện Thoại", "Tên Điện Thoại", "Năm Sản Xuất", "Giá Tiền" };

	// định nghĩa dữ liệu mặc định của bẳng điện thoại là rỗng
	private Object data = new Object[][] {};

	public GUI_QuanLyDienThoai() {
		initComponents();
	}

	private void initComponents() {
		this.setSize(650, 400);
		this.setTitle("Sign in");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		lbl_title = new JLabel("QUẢN LÝ ĐIỆN THOẠI");
		lbl_title.setForeground(Color.BLUE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 20));

		// khởi tạo các phím chức năng
		btn_them = new JButton("Thêm");
		btn_xoa = new JButton("Xóa");
		btn_sua = new JButton("Sửa");
		btn_moi = new JButton("Mới");
		btn_sapXep = new JButton("Sắp xếp");
		btn_tim = new JButton("Tìm");
		// khởi tạo bảng điện thoại
		sp_bangDienThoai = new JScrollPane();
		tb_dienThoai = new JTable();

		// khởi tạo các label
		lbl_maDthoai = new JLabel("Mã Điện Thoại");
		lbl_tenDThoai = new JLabel("Tên Điện Thoại");
		lbl_namSX = new JLabel("Năm Sản Xuất");
		lbl_giaTien = new JLabel("Giá Tiền");
		lbl_sapXep = new JLabel("Sắp Xếp");

		// khởi tạo các trường nhập dữ liệu cho điện thoại
		txt_maDthoai = new JTextField(15);
		txt_tenDThoai = new JTextField(15);
		txt_namSX = new JTextField(15);
		txt_giaTien = new JTextField(15);
		txt_tim = new JTextField(17);

		// Khởi tạo combobox
		cb_sapXep = new JComboBox<String>(sapXep);

		// cài đặt các cột và data cho bảng student
		tb_dienThoai.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		sp_bangDienThoai.setViewportView(tb_dienThoai);
		sp_bangDienThoai.setPreferredSize(new Dimension(480, 300));

		// tạo spring layout
		SpringLayout layout = new SpringLayout();
		// tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
		JPanel panel = new JPanel();
		panel.setSize(800, 450);
		panel.setLayout(layout);

		panel.add(sp_bangDienThoai);

		panel.add(btn_them);
		panel.add(btn_xoa);
		panel.add(btn_sua);
		panel.add(btn_moi);
		panel.add(btn_sapXep);
		panel.add(btn_tim);

		panel.add(lbl_maDthoai);
		panel.add(lbl_tenDThoai);
		panel.add(lbl_namSX);
		panel.add(lbl_giaTien);
		panel.add(lbl_sapXep);

		panel.add(txt_maDthoai);
		panel.add(txt_tenDThoai);
		panel.add(txt_namSX);
		panel.add(txt_giaTien);
		panel.add(txt_tim);

		panel.add(cb_sapXep);

		panel.add(lbl_title);

		// cài đặt vị trí các thành phần trên màn hình điện thoại

		layout.putConstraint(SpringLayout.WEST, lbl_title, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_title, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, lbl_maDthoai, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_maDthoai, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, lbl_tenDThoai, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_tenDThoai, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, lbl_namSX, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_namSX, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, lbl_giaTien, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_giaTien, 130, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, btn_tim, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, btn_tim, 200, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, txt_maDthoai, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txt_maDthoai, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txt_tenDThoai, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txt_tenDThoai, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txt_namSX, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txt_namSX, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txt_giaTien, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txt_giaTien, 130, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txt_tim, 80, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txt_tim, 203, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, sp_bangDienThoai, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, sp_bangDienThoai, 40, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, btn_them, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, btn_them, 270, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, btn_xoa, 70, SpringLayout.WEST, btn_them);
		layout.putConstraint(SpringLayout.NORTH, btn_xoa, 270, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, btn_sua, 60, SpringLayout.WEST, btn_xoa);
		layout.putConstraint(SpringLayout.NORTH, btn_sua, 270, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, btn_moi, 270, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, btn_moi, 60, SpringLayout.WEST, btn_sua);

		layout.putConstraint(SpringLayout.WEST, lbl_sapXep, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, lbl_sapXep, 360, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, cb_sapXep, 60, SpringLayout.WEST, lbl_sapXep);
		layout.putConstraint(SpringLayout.NORTH, cb_sapXep, 360, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, btn_sapXep, 120, SpringLayout.WEST, cb_sapXep);
		layout.putConstraint(SpringLayout.NORTH, btn_sapXep, 360, SpringLayout.NORTH, panel);

//        this.add(lbl_title);
		this.add(panel);
		
		this.pack();
		this.setTitle("Student Information");
		this.setSize(800, 450);
		// disable Edit and Delete buttons
		btn_xoa.setEnabled(false);
		btn_sua.setEnabled(false);
		// enable Add button
		btn_them.setEnabled(true);
		this.setVisible(true);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public JButton getBtn_them() {
		return btn_them;
	}

	public JButton getBtn_sua() {
		return btn_sua;
	}

	public JButton getBtn_xoa() {
		return btn_xoa;
	}

	public JButton getBtn_moi() {
		return btn_moi;
	}

	public JButton getBtn_tim() {
		return btn_tim;
	}

	public JButton getBtn_sapXep() {
		return btn_sapXep;
	}

	public JTextField getTxt_maDThoai() {
		return txt_maDthoai;
	}

	public JTextField getTxt_tenDThoai() {
		return txt_tenDThoai;
	}

	public JTextField getTxt_namSX() {
		return txt_namSX;
	}

	public JTextField getTxt_giaTien() {
		return txt_giaTien;
	}

	public JTextField getTxt_tim() {
		return txt_tim;
	}

	public JTable getTb_dienThoai() {
		return tb_dienThoai;
	}

	public JComboBox<String> getCb_sapXep() {
		return cb_sapXep;
	}

	public void showListDienThoai(List<ModelDienThoai> listDienThoai) {
		int size = listDienThoai.size();
		Object[][] dienThoai = new Object[size][4];
		for (int i = 0; i < size; i++) {
			dienThoai[i][0] = listDienThoai.get(i).getMaDienThoai();
			dienThoai[i][1] = listDienThoai.get(i).getTenDienThoai();
			dienThoai[i][2] = listDienThoai.get(i).getNamSX();
			dienThoai[i][3] = String.format("%,.0f", listDienThoai.get(i).getGiaTien());
		}
		tb_dienThoai.setModel(new DefaultTableModel(dienThoai, columnNames));
	}

	public void selectedRowTableDienThoai() {
		// lấy chỉ số của hàng được chọn
		int row = tb_dienThoai.getSelectedRow();
		if (row >= 0) {
			txt_maDthoai.setText(tb_dienThoai.getModel().getValueAt(row, 0).toString());
			txt_tenDThoai.setText(tb_dienThoai.getModel().getValueAt(row, 1).toString());
			txt_namSX.setText(tb_dienThoai.getModel().getValueAt(row, 2).toString());
			txt_giaTien.setText(tb_dienThoai.getModel().getValueAt(row, 3).toString().replaceAll(",", ""));
			// enable Edit and Delete buttons
			btn_sua.setEnabled(true);
			btn_xoa.setEnabled(true);
			// disable Add button
			btn_them.setEnabled(false);

			txt_maDthoai.setEnabled(false);
		}
	}

}
