/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Piya Rongnaimeang
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.table.JTableHeader;

public class MyForm extends JFrame {

	static JTable table;
               

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyForm frame = new MyForm();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 319);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);
		
		// Customer List
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setBounds(207, 44, 87, 14);
		getContentPane().add(lblCustomerList);

		// ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 84, 440, 89);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				String CustomerID = table.getValueAt(index, 0).toString();
				/*
				 * String Name = table.getValueAt(index, 1).toString(); String
				 * Email = table.getValueAt(index, 2).toString(); String
				 * CountryCode = table.getValueAt(index, 3).toString(); String
				 * Budget = table.getValueAt(index, 4).toString(); String Used =
				 * table.getValueAt(index, 5).toString();
				 */

				MyUpdateForm update = new MyUpdateForm(CustomerID);
				update.setModal(true);
				update.setVisible(true);

				PopulateData(); // Reload Table
			}
		});
		scrollPane.setViewportView(table);

		PopulateData();
	}

	private static void PopulateData() {
		
		// Clear table
		table.setModel(new DefaultTableModel());
		
		// Model for Table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("CustomerID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("CountryCode");
		model.addColumn("Budget");
		model.addColumn("Used");

		Connection connect = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/mydatabase"
							+ "?user=root&password=admin");

			s = connect.createStatement();

			String sql = "SELECT * FROM  customer ORDER BY CustomerID ASC";

			ResultSet rec = s.executeQuery(sql);
			int row = 0;
			while ((rec != null) && (rec.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(rec.getString("CustomerID"), row, 0);
				model.setValueAt(rec.getString("Name"), row, 1);
				model.setValueAt(rec.getString("Email"), row, 2);
				model.setValueAt(rec.getString("CountryCode"), row, 3);
				model.setValueAt(rec.getFloat("Budget"), row, 4);
				model.setValueAt(rec.getFloat("Used"), row, 5);
				row++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
