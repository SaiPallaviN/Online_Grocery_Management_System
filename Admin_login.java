import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.SystemColor;

public class Admin_login extends JFrame {

	private JPanel contentPane;
	private JPasswordField enterpswd;
	private JTextField enterusr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 444);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminlogin = new JLabel("Admin Login");
		adminlogin.setForeground(new Color(0, 128, 64));
		adminlogin.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		adminlogin.setBounds(35, 105, 167, 31);
		contentPane.add(adminlogin);
		
		JLabel usrname = new JLabel("User name");
		usrname.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		usrname.setBounds(59, 160, 128, 28);
		contentPane.add(usrname);
		
		JLabel passwrd = new JLabel("Password");
		passwrd.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		passwrd.setBounds(59, 226, 103, 28);
		contentPane.add(passwrd);
		
		enterpswd = new JPasswordField();
		enterpswd.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		enterpswd.setBounds(206, 226, 128, 28);
		contentPane.add(enterpswd);
		
		JButton login = new JButton("Login");
		login.setForeground(SystemColor.inactiveCaptionBorder);
		login.setBackground(new Color(0, 128, 64));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String u="Admin";
					String p="123";
					if(enterusr.getText().equals(u) && enterpswd.getText().toString().equals(p)) {
						contentPane.setVisible(false);
		                Groc_page gop=new Groc_page();
		                gop.setVisible(true);
		                JOptionPane.showMessageDialog(null, "Login successfull....");
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password..");
					}
				}
				catch(Exception ea) {
					System.out.println(ea);
				}
			}
		});
		login.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		login.setBounds(132, 297, 93, 38);
		contentPane.add(login);
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(SystemColor.inactiveCaptionBorder);
		cancel.setBackground(new Color(0, 128, 64));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//contentPane.setVisible(false);
					Main.main(null);
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,ea);
				}
			}
		});
		cancel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		cancel.setBounds(347, 297, 109, 38);
		contentPane.add(cancel);
		
		enterusr = new JTextField();
		enterusr.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		enterusr.setBounds(206, 160, 128, 28);
		contentPane.add(enterusr);
		enterusr.setColumns(10);
		
		JLabel mainhead = new JLabel("Grocery Shop");
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		mainhead.setBounds(222, 29, 213, 31);
		contentPane.add(mainhead);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 581, 81);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 64));
		panel_1.setBounds(0, 66, 27, 339);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 128, 64));
		panel_1_1.setBounds(554, 66, 27, 339);
		contentPane.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(35, 395, 63, -1);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 64));
		panel_3.setBounds(17, 395, 539, 10);
		contentPane.add(panel_3);
	}
}