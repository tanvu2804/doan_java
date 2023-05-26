package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GUI_DangNhap extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_signin;
	private JTextField txt_user, txt_password;
	private JLabel lbl_thongBao;
	
	public GUI_DangNhap() {
		initComponents();	
		
	}
	
	private void initComponents() {
		
		this.setSize(400, 400);
		this.setTitle("Sign in");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(null);
		
		//title
		JLabel lbl_title = new JLabel("ĐĂNG NHẬP");
		lbl_title.setBounds(130, 5, 200, 20);
		lbl_title.setForeground(Color.BLUE);
		lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(lbl_title);
		
		//User
		JLabel lbl_user = new JLabel("User: ");
		txt_user = new JTextField();
		
		lbl_user.setBounds(20, 70,80, 30);
		txt_user.setBounds(100, 70, 200, 30);
		
		this.add(lbl_user);
		this.add(txt_user);
		
		//Password
		JLabel lbl_password = new JLabel("Password: ");
		txt_password = new JTextField();
		
		lbl_password.setBounds(20, 120,80, 30);
		txt_password.setBounds(100, 120, 200, 30);
		
		lbl_thongBao = new JLabel("");
		lbl_thongBao.setBounds(20, 210, 300, 20);
		lbl_thongBao.setForeground(Color.red);
		
		this.add(lbl_password);
		this.add(txt_password);
		this.add(lbl_thongBao);
		
		//button
		btn_signin = new JButton("Sign in");
		btn_signin.setBounds(130, 170, 100, 30);
		this.add(btn_signin);
		this.setVisible(true);
	}
	
	
	
	public JButton getBtn_signin() {
		return btn_signin;
	}

	public JTextField getTxt_user() {
		return txt_user;
	}

	public JTextField getTxt_password() {
		return txt_password;
	}

	public JLabel getLbl_thongBao() {
		return lbl_thongBao;
	}

//	public static void main(String[] args) {
//		new GUI_DangNhap().setVisible(true);
//	}
}
