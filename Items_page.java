import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class Items_page extends JFrame {

	private JPanel contentPane;
	private JTextField iid;
	private JTextField iname;
	private JTextField iquan;
	private JTextField iprice;
	DefaultTableModel model;
	private static final String username="root";
	private static final String password="Hello@mysql1";
	private static final String con="jdbc:mysql://localhost:3306/logininfo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	int i,q;
	Connection sqlcon=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items_page frame = new Items_page();
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
	public Items_page() {
		initComponents();
	}
		public void Updatedb() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				sqlcon=DriverManager.getConnection(con,username,password);
				pst=sqlcon.prepareStatement("Select * from logininfo.item_list");
				rs=pst.executeQuery();
				ResultSetMetaData stdata=rs.getMetaData();
				q=stdata.getColumnCount();
				DefaultTableModel recordtable=(DefaultTableModel)table_1.getModel();
				recordtable.setRowCount(0);
				while(rs.next()) {
					Vector columndata=new Vector();
					for(i=1;i<=q;i++) {
						columndata.add(rs.getString("item_id"));
						columndata.add(rs.getString("Item_name"));
						columndata.add(rs.getString("Item_quan"));
						columndata.add(rs.getString("Item_price"));
						columndata.add(rs.getString("Item_category"));
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
		setBounds(100, 100, 886, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 872, 74);
		panel.setBackground(new Color(0, 128, 64));
		panel.setForeground(new Color(0, 128, 64));
		contentPane.add(panel);
		
		JLabel mainhead = new JLabel("Grocery shop");
		panel.add(mainhead);
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 73, 41, 397);
		panel_1.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(831, 73, 41, 397);
		panel_1_1.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_1_1);
		
		JButton employ = new JButton("Employees");
		employ.setBounds(218, 99, 154, 36);
		employ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Groc_page gp=new Groc_page();
				gp.setVisible(true);
			}
		});
		employ.setForeground(new Color(0, 128, 64));
		employ.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(employ);
		
		JButton items = new JButton("Items");
		items.setBounds(508, 99, 154, 36);
		items.setForeground(new Color(0, 128, 64));
		items.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(items);
		
		JLabel id = new JLabel("Item_ID");
		id.setBounds(79, 168, 93, 28);
		id.setForeground(new Color(0, 128, 64));
		id.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(id);
		
		JLabel name = new JLabel("Item_name");
		name.setBounds(199, 168, 125, 28);
		name.setForeground(new Color(0, 128, 64));
		name.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(name);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(354, 168, 93, 28);
		quantity.setForeground(new Color(0, 128, 64));
		quantity.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(quantity);
		
		JLabel price = new JLabel("Price");
		price.setBounds(503, 168, 70, 28);
		price.setForeground(new Color(0, 128, 64));
		price.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(price);
		
		JLabel category = new JLabel("Categories");
		category.setBounds(630, 168, 124, 28);
		category.setForeground(new Color(0, 128, 64));
		category.setFont(new Font("Sitka Display", Font.BOLD, 22));
		contentPane.add(category);
		
		iid = new JTextField();
		iid.setBounds(66, 207, 86, 28);
		iid.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		contentPane.add(iid);
		iid.setColumns(10);
		
		iname = new JTextField();
		iname.setBounds(199, 207, 100, 28);
		iname.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		iname.setColumns(10);
		contentPane.add(iname);
		
		iquan = new JTextField();
		iquan.setBounds(354, 207, 86, 28);
		iquan.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		iquan.setColumns(10);
		contentPane.add(iquan);
		
		iprice = new JTextField();
		iprice.setBounds(499, 207, 86, 28);
		iprice.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		iprice.setColumns(10);
		contentPane.add(iprice);
		
		JComboBox icategory = new JComboBox();
		icategory.setBounds(640, 207, 96, 24);
		icategory.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		icategory.setModel(new DefaultComboBoxModel(new String[] {"Diary", "Fruits& Vegetables"}));
		contentPane.add(icategory);
		
		
		JButton save = new JButton("Save");
		save.setBounds(179, 263, 86, 37);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(iid.getText().equals("")||iname.getText().equals("")||iquan.getText().equals("")||iprice.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Please fill all the details...");
					}
					else {
						Class.forName("com.mysql.cj.jdbc.Driver");
						sqlcon=DriverManager.getConnection(con,username,password);
						pst=sqlcon.prepareStatement("insert into item_list(item_id,Item_name,Item_quan,Item_price,Item_category) values(?,?,?,?,?)");
						pst.setString(1,iid.getText());
						pst.setString(2,iname.getText());
						pst.setString(3,iquan.getText());
						pst.setString(4,iprice.getText());
						pst.setString(5,icategory.getSelectedItem().toString());
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
		save.setBackground(new Color(0, 128, 64));
		save.setForeground(SystemColor.inactiveCaptionBorder);
		save.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(save);
		
		JButton edit = new JButton("Edit");
		edit.setBounds(378, 263, 86, 37);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					sqlcon=DriverManager.getConnection(con,username,password);
					pst=sqlcon.prepareStatement("update item_list set item_id=?,Item_name=?,Item_quan=?,Item_price=?,Item_category=? where item_id=?");
					pst.setString(1,iid.getText());
					pst.setString(2,iname.getText());
					pst.setString(3,iquan.getText());
					pst.setString(4,iprice.getText());
					pst.setString(5,icategory.getSelectedItem().toString());
					pst.setString(6, iid.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Edited successfully...");
					Updatedb();
				}
				catch(Exception ea) {
					System.out.println(ea);
				}
				}
			});
		edit.setBackground(new Color(0, 128, 64));
		edit.setForeground(SystemColor.inactiveCaptionBorder);
		edit.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(edit);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(562, 263, 100, 37);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedrows=table_1.getSelectedRow();
			try {	
				Class.forName("com.mysql.cj.jdbc.Driver");
				sqlcon=DriverManager.getConnection(con,username,password);
				int row=table_1.getSelectedRow();
				//String value=(table_1.getModel().getValueAt(row,0).toString());
				String query="delete from item_list where item_id=?";
				pst=sqlcon.prepareStatement(query);
				pst.setString(1,iid.getText());
				pst.executeUpdate();
				DefaultTableModel recordtable=(DefaultTableModel)table_1.getModel();
				recordtable.setRowCount( 0);
				Updatedb();
				JOptionPane.showMessageDialog(null,"Deleted successfully...");
				iid.setText("");
				iname.setText("");
				iquan.setText("");
				iprice.setText("");
				icategory.setSelectedItem("");
				}
			catch(Exception ea) {
				System.out.println(ea);
			}
		}
	});
		delete.setBackground(new Color(0, 128, 64));
		delete.setForeground(SystemColor.inactiveCaptionBorder);
		delete.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(delete);
		model=new DefaultTableModel();
		Object[] col= {"Item_ID","Item_name","Quantity","Price","Category"};
		model.setColumnIdentifiers(col);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(634, 412, 120, 37);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Main.main(null);
			}
		});
		logout.setForeground(new Color(0, 128, 64));
		logout.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(logout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 460, 834, 10);
		panel_2.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_2);
		
		
		table = new JTable();
		table.setBounds(79, 315, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 315, 675, 74);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item_ID", "Item_name", "Item_quan", "Item_price", "Category"
			}
		));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel recordtable=(DefaultTableModel)table_1.getModel();
				int selectedrows=table_1.getSelectedRow();
				iid.setText(recordtable.getValueAt(selectedrows, 0).toString());
				iname.setText(recordtable.getValueAt(selectedrows, 1).toString());
				iquan.setText(recordtable.getValueAt(selectedrows, 2).toString());
				iprice.setText(recordtable.getValueAt(selectedrows, 3).toString());
				icategory.setSelectedItem(recordtable.getValueAt(selectedrows, 4).toString());
			}
		});
		
	}
}