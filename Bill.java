import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Date;
import java.awt.Color;


public class Bill extends JFrame{

	private JPanel contentPane;
	JTextArea area;
	public JLabel lblNewLabel;
	private JTextArea textArea;
	private JTextArea textArea_1;
	JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
		initComponents();
	}
	
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setBounds(0, 0, 526, 108);
		area.setEditable(false);
		area.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(area);
		area.setText("**********************************************************\r\n");
		area.setText(area.getText()+"                             Grocery Shop           "+"\n");
		area.setText(area.getText()+"**********************************************************\n\n");
		//area.setText(area.getText()+"           Your bill is           "+"\n");
		//area.setText(area.getText()+"                      "+"\n");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(170, 176, 112, 27);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		textArea.setBounds(0, 107, 255, 211);
		contentPane.add(textArea);
		textArea.setText("\n");
		textArea.setText(textArea.getText()+"    "+"Customer name:\n\n");
		textArea.setText(textArea.getText()+"    "+"Total amount:\n");
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Sitka Banner", Font.BOLD, 25));
		textArea_1.setBounds(0, 316, 526, 79);
		contentPane.add(textArea_1);
		textArea_1.setText("\n"+"                  Thank you for visiting.....");
		
	   textPane = new JTextPane();
	   textPane.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		textPane.setBounds(253, 106, 273, 212);
		contentPane.add(textPane);
		//area.setText(area.getText()+"           Thank you for visiting.....          "+"\n");
		try {
			area.print();
			}
			catch(Exception ea) {
				JOptionPane.showMessageDialog(null,ea);
			}
	}
}