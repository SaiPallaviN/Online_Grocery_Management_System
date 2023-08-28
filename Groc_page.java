import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JTable.*;
import javax.swing.table.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.border.MatteBorder;


public class Groc_page extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField eid;
	private JTextField ename;
	private JTextField eaddress;
	private JPasswordField epswd;
	private static final String username="root";
	private static final String password="Hello@mysql1";
	private static final String con="jdbc:mysql://localhost:3306/logininfo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	Connection sqlcon=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	int i,q,id;
	private JTextField phone;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Groc_page frame = new Groc_page();
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
	public Groc_page() {
		initComponents();
	}
		public void Updatedb() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				sqlcon=DriverManager.getConnection(con,username,password);
				pst=sqlcon.prepareStatement("Select * from logininfo.logintable");
				rs=pst.executeQuery();
				ResultSetMetaData stdata=rs.getMetaData();
				q=stdata.getColumnCount();
				DefaultTableModel recordtable=(DefaultTableModel)table_2.getModel();
				recordtable.setRowCount(0);
				while(rs.next()) {
					Vector columndata=new Vector();
					for(i=1;i<=q;i++) {
						columndata.add(rs.getString("Emp_ID"));
						columndata.add(rs.getString("Emp_name"));
						columndata.add(rs.getString("Address"));
						columndata.add(rs.getString("Phone"));
						columndata.add(rs.getString("Password"));
					}
					recordtable.addRow(columndata);
				}
			}
			catch(Exception ea) {
				JOptionPane.showMessageDialog(null, ea);
			}
		}
		private void initComponents() {
		Object[] row=new Object[4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 509);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 37, 424);
		panel_1.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(826, 55, 43, 415);
		panel_2.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_2);
		
		JButton employ = new JButton("Employees");
		employ.setBounds(206, 75, 153, 32);
		employ.setSelected(true);
		employ.setBackground(SystemColor.inactiveCaptionBorder);
		employ.setForeground(new Color(0, 128, 64));
		employ.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(employ);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(34, 420, 633, -1);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(34, 420, 633, -20);
		panel_4.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_4);
		
		JButton items = new JButton("Items");
		items.setBounds(455, 75, 141, 32);
		items.setSelected(true);
		items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Items_page item=new Items_page();
				item.setVisible(true);
			}
		});
		items.setIgnoreRepaint(true);
		items.setBackground(SystemColor.inactiveCaptionBorder);
		items.setForeground(new Color(0, 128, 64));
		items.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(items);
		
		JLabel id = new JLabel("Emp_ID");
		id.setBounds(92, 140, 88, 28);
		id.setForeground(new Color(0, 128, 64));
		id.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(id);
		
		JLabel name = new JLabel("Name");
		name.setBounds(251, 140, 88, 28);
		name.setForeground(new Color(0, 128, 64));
		name.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(name);
		
		JLabel address = new JLabel("Address");
		address.setBounds(384, 140, 88, 28);
		address.setForeground(new Color(0, 128, 64));
		address.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(address);
		
		JLabel pswd = new JLabel("Password");
		pswd.setBounds(674, 140, 106, 28);
		pswd.setForeground(new Color(0, 128, 64));
		pswd.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(pswd);
		
		eid = new JTextField();
		eid.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		eid.setBounds(67, 179, 113, 28);
		contentPane.add(eid);
		eid.setColumns(10);
		
		ename = new JTextField();
		ename.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		ename.setBounds(206, 179, 113, 28);
		ename.setColumns(10);
		contentPane.add(ename);
		
		eaddress = new JTextField();
		eaddress.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		eaddress.setBounds(359, 179, 113, 28);
		eaddress.setColumns(10);
		contentPane.add(eaddress);
		
		epswd = new JPasswordField();
		epswd.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		epswd.setBounds(660, 179, 120, 28);
		contentPane.add(epswd);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(eid.getText().equals("")||ename.getText().equals("")||eaddress.getText().equals("")||epswd.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill all the details...");
				}
				else {
					Class.forName("com.mysql.cj.jdbc.Driver");
					sqlcon=DriverManager.getConnection(con,username,password);
					pst=sqlcon.prepareStatement("insert into logintable(Emp_ID,Emp_name,Address,Phone,Password) values(?,?,?,?,?)");
					pst.setString(1,eid.getText());
					pst.setString(2,ename.getText());
					pst.setString(3,eaddress.getText());
					pst.setString(4,phone.getText());
					pst.setString(5,epswd.getText().toString());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved successfully...");
					Updatedb();
				}
				}
				catch(Exception ea) {
					System.out.println(ea);
				}
			}
		});
		save.setBounds(200, 243, 89, 32);
		save.setBackground(new Color(0, 128, 64));
		save.setForeground(SystemColor.inactiveCaptionBorder);
		save.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(save);
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				sqlcon=DriverManager.getConnection(con,username,password);
				pst=sqlcon.prepareStatement("update logintable set Emp_ID=?,Emp_name=?,Address=?,Phone=?,Password=? where Emp_ID=?");
				pst.setString(1,eid.getText());
				pst.setString(2,ename.getText());
				pst.setString(3,eaddress.getText());
				pst.setString(4,phone.getText());
				pst.setString(5,epswd.getText().toString());
				pst.setString(6, eid.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Edited successfully...");
				Updatedb();
			}
			catch(Exception ea) {
				System.out.println(ea);
			}
			}
		});
		edit.setBounds(383, 243, 89, 32);
		edit.setForeground(SystemColor.inactiveCaptionBorder);
		edit.setFont(new Font("Sitka Display", Font.BOLD, 20));
		edit.setBackground(new Color(0, 128, 64));
		contentPane.add(edit);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedrows=table_2.getSelectedRow();
				try {	
					Class.forName("com.mysql.cj.jdbc.Driver");
					sqlcon=DriverManager.getConnection(con,username,password);
					int row=table_2.getSelectedRow();
					String query="delete from logintable where Emp_ID=?";
					pst=sqlcon.prepareStatement(query);
					pst.setString(1, eid.getText());
					pst.executeUpdate();
					DefaultTableModel recordtable=(DefaultTableModel)table_2.getModel();
					recordtable.setRowCount(0);
					Updatedb();
					JOptionPane.showMessageDialog(null,"Deleted successfully...");
					eid.setText("");
					ename.setText("");
					eaddress.setText("");
					phone.setText("");
					epswd.setText("");
					}
				catch(Exception ea) {
					System.out.println(ea);
				}
			}
		});
		delete.setBounds(558, 243, 109, 32);
		delete.setForeground(SystemColor.inactiveCaptionBorder);
		delete.setFont(new Font("Sitka Display", Font.BOLD, 20));
		delete.setBackground(new Color(0, 128, 64));
		contentPane.add(delete);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.setVisible(false);
				Main.main(null);
			}
		});
		logout.setBounds(660, 420, 120, 32);
		logout.setForeground(new Color(0, 128, 64));
		logout.setFont(new Font("Sitka Small", Font.BOLD, 20));
		contentPane.add(logout);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(34, 460, 795, 10);
		panel_5.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_5);
		
		JLabel ephone = new JLabel("Phone");
		ephone.setForeground(new Color(0, 128, 64));
		ephone.setFont(new Font("Sitka Display", Font.BOLD, 22));
		ephone.setBounds(526, 140, 106, 28);
		contentPane.add(ephone);
		
		phone = new JTextField();
		phone.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(501, 179, 113, 28);
		contentPane.add(phone);
		
		JLabel mainhead = new JLabel("Grocery Shop");
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		mainhead.setBounds(384, 11, 198, 32);
		contentPane.add(mainhead);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 869, 55);
		contentPane.add(panel);
		
		table = new JTable();
		table.setBounds(79, 311, 1, 1);
		contentPane.add(table);
		
	/*	table_1 = new JTable();
		table_1.setBounds(92, 339, 1, -27);
		contentPane.add(table_1);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 297, 701, 92);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp_ID", "Emp_name", "Address", "Phone", "Password"
			}
		));
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel recordtable=(DefaultTableModel)table_2.getModel();
				int selectedrows=table_2.getSelectedRow();
				eid.setText(recordtable.getValueAt(selectedrows, 0).toString());
				ename.setText(recordtable.getValueAt(selectedrows, 1).toString());
				eaddress.setText(recordtable.getValueAt(selectedrows, 2).toString());
				phone.setText(recordtable.getValueAt(selectedrows, 3).toString());
				epswd.setText(recordtable.getValueAt(selectedrows, 4).toString());
			}
		});
		table_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_2.setFont(new Font("Sitka Display", Font.PLAIN, 16));
	}
}