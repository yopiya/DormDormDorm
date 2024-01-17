/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Piya Rongnaimeang
 */
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyUpdateForm extends JDialog {

	/**
	 * Create the dialog.
	 */
	public MyUpdateForm(String sCustomerID) {
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 285);
		getContentPane().setLayout(null);
		setResizable(false);

		// Header Customer Update
		JLabel hCustomerUpdate = new JLabel("Customer Update");
		hCustomerUpdate.setBounds(144, 21, 132, 14);
		getContentPane().add(hCustomerUpdate);

		// *** Header ***//
		JLabel hCustomerID = new JLabel("CustomerID :");
		hCustomerID.setBounds(100, 51, 89, 14);
		getContentPane().add(hCustomerID);

		JLabel hName = new JLabel("Name :");
		hName.setBounds(100, 76, 89, 14);
		getContentPane().add(hName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(100, 100, 89, 14);
		getContentPane().add(hEmail);

		JLabel hCountryCode = new JLabel("CountryCode :");
		hCountryCode.setBounds(100, 123, 89, 14);
		getContentPane().add(hCountryCode);

		JLabel hBudget = new JLabel("Budget :");
		hBudget.setBounds(100, 146, 89, 14);
		getContentPane().add(hBudget);

		JLabel hUsed = new JLabel("Used :");
		hUsed.setBounds(100, 171, 89, 14);
		getContentPane().add(hUsed);

		// *** Update Form ***//
		// CustomerID
		final JLabel lblCustomerID = new JLabel("lblCustomerID");
		lblCustomerID.setBounds(207, 51, 99, 20);
		getContentPane().add(lblCustomerID);

		// Name
		final JTextField txtName = new JTextField("");
		txtName.setBounds(207, 76, 99, 20);
		getContentPane().add(txtName);

		// Email
		final JTextField txtEmail = new JTextField("");
		txtEmail.setBounds(207, 100, 176, 20);
		getContentPane().add(txtEmail);

		// CountryCode
		final JTextField txtCountryCode = new JTextField("");
		txtCountryCode.setBounds(207, 123, 99, 20);
		getContentPane().add(txtCountryCode);

		// Budget
		final JTextField txtBudget = new JTextField("");
		txtBudget.setBounds(207, 146, 99, 20);
		getContentPane().add(txtBudget);

		// Used
		final JTextField txtUsed = new JTextField("");
		txtUsed.setBounds(207, 171, 99, 20);
		getContentPane().add(txtUsed);

		// *** Bind Data ***//
		Connection connect = null;
		Statement s = null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/mydatabase"
							+ "?user=root&password=admin");

			s = connect.createStatement();

			String sql = "SELECT * FROM  customer " + "WHERE CustomerID = '"
					+ sCustomerID + "' ";

			ResultSet rec = s.executeQuery(sql);

			if (rec != null) {
				rec.next();
				lblCustomerID.setText(rec.getString("CustomerID"));
				txtName.setText(rec.getString("Name"));
				txtEmail.setText(rec.getString("Email"));
				txtCountryCode.setText(rec.getString("CountryCode"));
				txtBudget.setText(rec.getString("Budget"));
				txtUsed.setText(rec.getString("Used"));
			}
			rec.close();

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
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveData(lblCustomerID.getText(), txtName.getText(),
						txtEmail.getText(), txtCountryCode.getText(),
						txtBudget.getText(), txtUsed.getText());
				dispose();
			}
		});
		btnSave.setBounds(131, 206, 69, 23);
		getContentPane().add(btnSave);

		// Button Close
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(217, 206, 69, 23);
		getContentPane().add(btnClose);

	}

	// Update
	private void SaveData(String strCustomerID, String strName, String strEmail,
			String strCountryCode, String strBudget, String strUsed) {
		
		Connection connect = null;
		Statement s = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect =  DriverManager.getConnection("jdbc:mysql://localhost/mydatabase" +
					"?user=root&password=admin");
			
			s = connect.createStatement();
			
			String sql = "UPDATE customer " +
					"SET Name = '" + strName + "' " +
					", Email = '" + strEmail + "' " +
					", CountryCode = '" + strCountryCode + "' " +
					", Budget = '" + strBudget + "' " +
					", Used = '" + strUsed + "' " +
					" WHERE CustomerID = '"+strCustomerID+"' ";
             s.execute(sql);
            
     		JOptionPane.showMessageDialog(null, "Record Update Successfully");
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			if(s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}
}
