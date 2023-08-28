import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.SystemColor;

public class Employ_login extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField enterusr;
	private JPasswordField enterpswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employ_login frame = new Employ_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employ_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 457);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainhead = new JLabel("Grocery Shop");
		mainhead.setForeground(new Color(230, 230, 250));
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		mainhead.setBounds(213, 23, 213, 43);
		contentPane.add(mainhead);
		
		JLabel custlogin = new JLabel("Employee Login");
		custlogin.setForeground(new Color(0, 128, 64));
		custlogin.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		custlogin.setBounds(44, 114, 197, 31);
		contentPane.add(custlogin);
		
		JLabel usrname = new JLabel("User name");
		usrname.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		usrname.setBounds(72, 173, 105, 28);
		contentPane.add(usrname);
		
		JLabel passwrd = new JLabel("Password");
		passwrd.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		passwrd.setBounds(72, 233, 105, 28);
		contentPane.add(passwrd);
		
		enterusr = new JTextField();
		enterusr.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		enterusr.setBounds(213, 174, 129, 25);
		contentPane.add(enterusr);
		enterusr.setColumns(10);
		
		enterpswd = new JPasswordField();
		enterpswd.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		enterpswd.setBounds(213, 234, 129, 25);
		contentPane.add(enterpswd);
		
		JButton login = new JButton("Login");
		login.setForeground(SystemColor.inactiveCaptionBorder);
		login.setBackground(new Color(0, 128, 64));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","Hello@mysql1");
				Statement smt=con.createStatement();
				String sql="select * from logintable where Emp_name='"+enterusr.getText()+"' and Password='"+enterpswd.getText().toString()+"'";
				ResultSet rs=smt.executeQuery(sql);
				if(rs.next()) {
					Billing bp=new Billing();
					bp.setVisible(true);
					JOptionPane.showMessageDialog(null,"Login successful");
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect login");
				}
				con.close();
				}
				catch(Exception ea) {
					System.out.println(ea);
				}
			}
		});
		login.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		login.setBounds(141, 303, 89, 36);
		contentPane.add(login);
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(SystemColor.inactiveCaptionBorder);
		cancel.setBackground(new Color(0, 128, 64));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.main(null);
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,ea);
				}
			}
		});
		cancel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		cancel.setBounds(359, 303, 114, 36);
		contentPane.add(cancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 585, 71);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 64));
		panel_1.setBounds(0, 71, 28, 347);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 128, 64));
		panel_1_1.setBounds(557, 71, 28, 347);
		contentPane.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 64));
		panel_2.setBounds(21, 408, 543, 10);
		contentPane.add(panel_2);
	}
}