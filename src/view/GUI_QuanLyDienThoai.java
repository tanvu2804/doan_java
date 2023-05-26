package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class GUI_QuanLyDienThoai extends JFrame{
    private static final long serialVersionUID = 1L;
    private JButton btn_tim;    
    private JButton btn_them;
    private JButton btn_xoa;
    private JButton btn_sua;
    private JButton btn_moi;
    private JButton btn_sapXep1;
    private JButton btn_sapXep2;
    private JScrollPane sp_bangDienThoai;
    private JTable tb_dienThoai;
    
    private JLabel lbl_title;   
    private JLabel lbl_maDthoai;
    private JLabel lbl_tenDThoai;
    private JLabel lbl_namSX;
    private JLabel lbl_giaTien;
    
    private JTextField txt_maDthoai;
    private JTextField txt_tenDThoai;
    private JTextField txt_namSX;
    private JTextField txt_giaTien;
    private JTextField txt_tim;
    
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "Ma Dien Thoai", "Ten Dien Thoai", "Ten Dien Thoai", "Gia tien"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
    public GUI_QuanLyDienThoai() {
        initComponents();
    }

    private void initComponents() {
		this.setSize(650, 400);
		this.setTitle("Sign in");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		lbl_title = new JLabel("QUAN LY DIEN THOAI");
		lbl_title.setForeground(Color.BLUE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
		
		
        // khởi tạo các phím chức năng
        btn_them = new JButton("Them");
        btn_xoa = new JButton("Xoa");
        btn_sua = new JButton("Sua");
        btn_moi = new JButton("Moi");
        btn_sapXep1 = new JButton("Sắp xếp");
        btn_sapXep2 = new JButton("Sắp xếp");
        btn_tim = new JButton("Tim");
        // khởi tạo bảng student
        sp_bangDienThoai = new JScrollPane();
        tb_dienThoai = new JTable();
        
        // khởi tạo các label
        lbl_maDthoai = new JLabel("Ma Dien Thoai");
        lbl_tenDThoai = new JLabel("Ten Dien Thoai");
        lbl_namSX = new JLabel("Nam san xuat");
        lbl_giaTien = new JLabel("Gia tien");
        
        
        // khởi tạo các trường nhập dữ liệu cho student
        txt_maDthoai = new JTextField(15);
        txt_tenDThoai = new JTextField(15);
        txt_namSX = new JTextField(15);
        txt_giaTien = new JTextField(15);
        txt_tim = new JTextField(17);
        
        // cài đặt các cột và data cho bảng student
        tb_dienThoai.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        sp_bangDienThoai.setViewportView(tb_dienThoai);
        sp_bangDienThoai.setPreferredSize(new Dimension (480, 300));
        
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
        panel.add(btn_sapXep1);
        panel.add(btn_sapXep2);
        
        panel.add(lbl_maDthoai);
        panel.add(lbl_tenDThoai);
        panel.add(lbl_namSX);
        panel.add(lbl_giaTien);
        panel.add(btn_tim);
        
        panel.add(txt_maDthoai);
        panel.add(txt_tenDThoai);
        panel.add(txt_namSX);
        panel.add(txt_giaTien);
        panel.add(txt_tim);
        
        panel.add(lbl_title);
        
        // cài đặt vị trí các thành phần trên màn hình login
        
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
        
        layout.putConstraint(SpringLayout.NORTH, btn_moi, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btn_moi, 60, SpringLayout.WEST, btn_sua);
        
        layout.putConstraint(SpringLayout.NORTH, btn_sua, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btn_sapXep1, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btn_sapXep1, 360, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btn_sapXep2, 115, SpringLayout.WEST, btn_sapXep1);
        layout.putConstraint(SpringLayout.NORTH, btn_sapXep2, 360, SpringLayout.NORTH, panel);
        
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
    

    public JButton getBtn_them() {
		return btn_them;
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
	
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddStudentListener(ActionListener listener) {
        btn_them.addActionListener(listener);
    }
    
    public void addEdiStudentListener(ActionListener listener) {
        btn_xoa.addActionListener(listener);
    }
    
    public void addDeleteStudentListener(ActionListener listener) {
        btn_sua.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        btn_moi.addActionListener(listener);
    }
    
    public void addSortStudentGPAListener(ActionListener listener) {
        btn_sapXep1.addActionListener(listener);
    }
    
    public void addSortStudentNameListener(ActionListener listener) {
        btn_sapXep2.addActionListener(listener);
    }
    
    public void addListStudentSelectionListener(ListSelectionListener listener) {
        tb_dienThoai.getSelectionModel().addListSelectionListener(listener);
    }
}
