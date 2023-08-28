import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
public class Main {
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 64, 128));
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 713, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton employlogin = new JButton("Employee Login");
		employlogin.setBounds(394, 177, 218, 39);
		employlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				frame.dispose();
				Employ_login emplgn =new Employ_login();
				emplgn.setVisible(true);
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,ea);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		employlogin.setForeground(SystemColor.inactiveCaptionBorder);
		employlogin.setBackground(new Color(0, 128, 64));
		employlogin.setFont(new Font("Sitka Banner", Font.PLAIN, 24));
		frame.getContentPane().add(employlogin);
		JButton about = new JButton("About");
		about.setBounds(255, 281, 194, 39);
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				About ab=new About();
				ab.setVisible(true);
			}
		});
		about.setForeground(SystemColor.inactiveCaptionBorder);
		about.setBackground(new Color(0, 128, 64));
		about.setFont(new Font("Sitka Banner", Font.PLAIN, 24));
		frame.getContentPane().add(about);
		JButton adminlogin = new JButton("Admin Login");
		adminlogin.setBounds(101, 177, 194, 39);
		adminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Admin_login admlgn=new Admin_login();
					admlgn.setVisible(true);
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,ea);
				}
			}
		});
		adminlogin.setVerticalAlignment(SwingConstants.BOTTOM);
		adminlogin.setForeground(SystemColor.inactiveCaptionBorder);
		adminlogin.setBackground(new Color(0, 128, 64));
		adminlogin.setFont(new Font("Sitka Banner", Font.PLAIN, 24));
		frame.getContentPane().add(adminlogin);
		JLabel mainhead = new JLabel("Grocery Shop");
		mainhead.setBounds(214, 39, 218, 39);
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		frame.getContentPane().add(mainhead);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 699, 96);
		panel.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 93, 32, 313);
		panel_1.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel_1);
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(667, 93, 32, 313);
		panel_1_1.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel_1_1);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 396, 535, -1);
		panel_2.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel_2);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(33, 396, 634, 10);
		panel_3.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel_3);
	}
}