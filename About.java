import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 64));
		panel_1.setBounds(0, 66, 25, 371);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 64));
		panel_2.setBounds(10, 427, 730, 10);
		contentPane.add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 128, 64));
		panel_1_1.setBounds(737, 66, 25, 371);
		contentPane.add(panel_1_1);
		
		JLabel mainhead = new JLabel("Grocery Shop");
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		mainhead.setBounds(297, 21, 208, 38);
		contentPane.add(mainhead);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 762, 85);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nsidd\\OneDrive\\Desktop\\Supermarkt.jpg"));
		lblNewLabel.setBounds(59, 110, 244, 252);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(370, 124, 345, 275);
		contentPane.add(scrollPane);
		
		JTextPane txtpnAtGroceryShop = new JTextPane();
		txtpnAtGroceryShop.setFont(new Font("Sitka Display", Font.PLAIN, 16));
		txtpnAtGroceryShop.setText("India's most convenient online grocery channel.\r\n\r\nAt Grocery shop, we value our customers so much that we have engrained our customer service into our core values. Everything we do stems from our desire to make shopping at Grocery shop the best shopping experience you can get anywhere. If there is anything we can do to better serve you, please let us know.\r\n\r\nOur promise is to exceed your expectations by combining the best customer service with the freshest foods. Fresh Market is locally owned and we support local suppliers. When you shop here your money stays here. Our team is committed to buying the freshest foods and bringing them to you for a great price.");
		scrollPane.setViewportView(txtpnAtGroceryShop);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Main.main(null);
			}
		});
		logout.setBackground(new Color(0, 128, 64));
		logout.setForeground(SystemColor.inactiveCaptionBorder);
		logout.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		logout.setBounds(126, 387, 105, 29);
		contentPane.add(logout);
	}
}