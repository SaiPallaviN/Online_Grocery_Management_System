import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSetMetaData;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Billing extends JFrame {

	private JPanel contentPane;
	private JTextField i1;
	private JTextField q1;
	private JTextField p1;
	private JTextField c1;
	private JTable table;
	DefaultTableModel model;
	private JTable table_1;
	private JTextField grandtotal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing();
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
	public Billing() {
		initComponents();

	}
		private void initComponents() {
		Object[] row=new Object[5];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainhead = new JLabel("Grocery shop");
		mainhead.setBounds(305, 33, 201, 33);
		mainhead.setForeground(SystemColor.inactiveCaptionBorder);
		mainhead.setFont(new Font("Sitka Banner", Font.BOLD, 30));
		contentPane.add(mainhead);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 799, 76);
		panel.setBackground(new Color(0, 128, 64));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 63, 31, 402);
		panel_1.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(768, 63, 31, 402);
		panel_1_1.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(27, 455, 748, 10);
		panel_2.setBackground(new Color(0, 128, 64));
		contentPane.add(panel_2);
		
		JLabel billing = new JLabel("Billing");
		billing.setBounds(346, 87, 100, 33);
		billing.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		billing.setForeground(new Color(0, 128, 64));
		contentPane.add(billing);
		
		JLabel item = new JLabel("Item");
		item.setBounds(58, 118, 73, 26);
		item.setForeground(new Color(0, 128, 64));
		item.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		contentPane.add(item);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(178, 118, 100, 26);
		quantity.setForeground(new Color(0, 128, 64));
		quantity.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		contentPane.add(quantity);
		
		JLabel price = new JLabel("Price");
		price.setBounds(58, 181, 73, 26);
		price.setForeground(new Color(0, 128, 64));
		price.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		contentPane.add(price);
		
		JLabel client = new JLabel("Client Name");
		client.setBounds(178, 181, 124, 26);
		client.setForeground(new Color(0, 128, 64));
		client.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		contentPane.add(client);
		
		i1 = new JTextField();
		i1.setBounds(58, 144, 86, 26);
		i1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		contentPane.add(i1);
		/*i1.addActionListener(new java.awt.event.ActionListener() {
		  public void actionPerformed(ActionEvent event) {
		    p1.setText(getName());
		  }
		});*/
		i1.setColumns(10);
		
		q1 = new JTextField();
		q1.setBounds(178, 143, 100, 27);
		q1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		q1.setColumns(10);
		contentPane.add(q1);
		
		p1 = new JTextField();
		p1.setBounds(58, 218, 86, 26);
		p1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		p1.setColumns(10);
		contentPane.add(p1);
		
		c1 = new JTextField();
		c1.setBounds(178, 218, 100, 26);
		c1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		c1.setColumns(10);
		contentPane.add(c1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(373, 131, 372, 156);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Item_name", "Quantity", "Price", "Total"
				}
			));
		
		
		JButton add = new JButton("Add to Bill");
		add.setBounds(59, 272, 148, 33);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i1.getText().equals("")||q1.getText().equals("")||p1.getText().equals("")||c1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter all the fields...");
				}
				else {
					DefaultTableModel model=(DefaultTableModel)table_1.getModel();
					String name,quan,price;
					Double subtotal=0.0;
					name=i1.getText();
					quan=q1.getText();
					price=p1.getText();
				 DefaultTableModel recordtable=(DefaultTableModel)table.getModel();
				int selectedrows=table.getSelectedRow();
					subtotal=Double.valueOf(quan)*((Double.valueOf(price))/Double.valueOf(recordtable.getValueAt(selectedrows, 2).toString()));
					String[] row= {name,quan,price,subtotal.toString()};
					model.addRow(row);
				}
			}
		});
		add.setBackground(new Color(0, 128, 64));
		add.setForeground(SystemColor.inactiveCaptionBorder);
		add.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		contentPane.add(add);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(242, 272, 100, 33);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i1.setText(null);
				q1.setText(null);
				p1.setText(null);
				c1.setText(null);
			}
		});
		reset.setForeground(SystemColor.inactiveCaptionBorder);
		reset.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		reset.setBackground(new Color(0, 128, 64));
		contentPane.add(reset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 361, 359, 70);
		contentPane.add(scrollPane);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel recordtable=(DefaultTableModel)table.getModel();
				int selectedrows=table.getSelectedRow();
				i1.setText(recordtable.getValueAt(selectedrows, 1).toString());
				q1.setText(recordtable.getValueAt(selectedrows, 2).toString());
				p1.setText(recordtable.getValueAt(selectedrows, 3).toString());
			}
		});
		
		JButton itemlist = new JButton("Items List");
		itemlist.setBounds(155, 316, 134, 34);
		itemlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","Hello@mysql1");
					Statement st=con.createStatement();
					String query="Select * from item_list order by item_id";
					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int col=rsmd.getColumnCount();
					String[] col_name=new String[col];
					for(int i=0;i<col;i++)
						col_name[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(col_name);
					String id,name,quan,price,category;
					while(rs.next()) {
						id=rs.getString(1);
						name=rs.getString(2);
						quan=rs.getString(3);
						price=rs.getString(4);
						category=rs.getString(5);
						String[] row= {id,name,quan,price,category};
						model.addRow(row);
					}
					st.close();
					con.close();
				}
					catch(Exception ea) {
						JOptionPane.showMessageDialog(null,"Error exists...");
					}
			}
		});
		itemlist.setBackground(SystemColor.inactiveCaptionBorder);
		itemlist.setForeground(new Color(128, 0, 0));
		itemlist.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		contentPane.add(itemlist);
		model=new DefaultTableModel();
		Object[] col= {"Id","Items","Price","Qty","Total"};
		model.setColumnIdentifiers(col);
		
		JButton logout = new JButton("LogOut");
		logout.setBounds(651, 411, 107, 33);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Main.main(null);
			}
		});
		logout.setForeground(new Color(0, 128, 64));
		logout.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		contentPane.add(logout);
		
		JButton print = new JButton("Print");
		print.setBounds(534, 338, 107, 33);
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double sum=0.0;
					for(int i=0;i<table_1.getRowCount();i++) {
						sum+=Double.valueOf(table_1.getValueAt(i,3).toString());
					}
					grandtotal.setText(sum.toString());
					String name=c1.getText();
					String amount=grandtotal.getText();
					Bill b=new Bill();
					b.textPane.setText("\n"+name+"\n\n");
					b.textPane.setText(b.textPane.getText()+amount);
					b.setVisible(true);
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null, ea);
				}
			}
		});
		print.setBackground(new Color(0, 128, 64));
		print.setForeground(SystemColor.inactiveCaptionBorder);
		print.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		contentPane.add(print);
		
		grandtotal = new JTextField();
		grandtotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		grandtotal.setForeground(SystemColor.inactiveCaptionBorder);
		grandtotal.setBackground(new Color(0, 128, 64));
		grandtotal.setBounds(560, 298, 56, 29);
		contentPane.add(grandtotal);
		grandtotal.setColumns(10);
	}
}