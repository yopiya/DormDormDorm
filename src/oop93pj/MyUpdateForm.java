package oop93pj;


import java.awt.Color;
import java.awt.Font;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Piya Rongnaimeang
 */
public class MyUpdateForm extends JDialog{
    
                public MyUpdateForm(String sCustomerID) {
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720,640 );
		getContentPane().setLayout(null);
		setResizable(false);
                
                                 Color c1 = new Color(0,51,51);
                                 getContentPane().setBackground(c1);

		// Header Customer Update
		JLabel hCustomerUpdate = new JLabel("อัพเดทข้อมูลรายชื่อในระบบ");
		hCustomerUpdate.setBounds(225, 50, 250, 32);
                                hCustomerUpdate.setFont(new Font("Angsana New",Font.PLAIN,32));
                                hCustomerUpdate.setForeground(Color.white);
                                                               


		getContentPane().add(hCustomerUpdate);

		// *** Header ***//
		JLabel hCustomerID = new JLabel("CustomerID :");
		hCustomerID.setBounds(100, 100, 89, 32);
                                hCustomerID.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hCustomerID.setForeground(Color.white);
		getContentPane().add(hCustomerID);

		JLabel hName = new JLabel("Name :");
		hName.setBounds(100, 150, 89, 32);
                                hName.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hName.setForeground(Color.white);
		getContentPane().add(hName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(100, 200, 89, 32);
                                hEmail.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hEmail.setForeground(Color.white);
		getContentPane().add(hEmail);

		JLabel hCountryCode = new JLabel("CountryCode :");
		hCountryCode.setBounds(100, 250, 150, 32);
                                hCountryCode.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hCountryCode.setForeground(Color.white);
		getContentPane().add(hCountryCode);

		JLabel hBudget = new JLabel("Budget :");
		hBudget.setBounds(100, 300, 89, 32);
                                  hBudget.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hBudget.setForeground(Color.white);
		getContentPane().add(hBudget);

		JLabel hUsed = new JLabel("Used :");
		hUsed.setBounds(100, 350, 89, 32);
                                  hUsed.setFont(new Font("Angsana New",Font.PLAIN,24));
                                hUsed.setForeground(Color.white);
		getContentPane().add(hUsed);

		// *** Update Form ***//
		// CustomerID
		final JLabel lblCustomerID = new JLabel("lblCustomerID");
		lblCustomerID.setBounds(300, 107, 99, 20);
                                lblCustomerID.setFont(new Font("Angsana New",Font.PLAIN,24));
                                lblCustomerID.setForeground(Color.white);
		getContentPane().add(lblCustomerID);

		// Name
		final JTextField txtName = new JTextField("");
		txtName.setBounds(300, 160, 99, 20);
                                txtName.setFont(new Font("Angsana New",Font.PLAIN,24));
                                txtName.setForeground(Color.white);
                                
		getContentPane().add(txtName);

		// Email
		final JTextField txtEmail = new JTextField("");
		txtEmail.setBounds(300, 210, 176, 20);
                                txtEmail.setFont(new Font("Angsana New",Font.PLAIN,24));
                                txtEmail.setForeground(Color.white);
		getContentPane().add(txtEmail);

		// CountryCode
		final JTextField txtCountryCode = new JTextField("");
		txtCountryCode.setBounds(300, 260, 50, 20);
                                txtCountryCode.setFont(new Font("Angsana New",Font.PLAIN,24));
                                txtCountryCode.setForeground(Color.white);
		getContentPane().add(txtCountryCode);

		// Budget
		final JTextField txtBudget = new JTextField("");
		txtBudget.setBounds(300, 310, 99, 20);
		txtBudget.setFont(new Font("Angsana New",Font.PLAIN,24));
                                txtBudget.setForeground(Color.white);
                                getContentPane().add(txtBudget);

		// Used
		final JTextField txtUsed = new JTextField("");
		txtUsed.setBounds(300, 360, 99, 20);
                                txtUsed.setFont(new Font("Angsana New",Font.PLAIN,24));
                                txtUsed.setForeground(Color.white);
		getContentPane().add(txtUsed);

		// *** Bind Data ***//
		Connection connect = null;
		Statement s = null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/namedb" +  "?user=root&password=admin");

			s = connect.createStatement();

			String sql = "SELECT * FROM  customer " + "WHERE id = '"+ sCustomerID + "' ";

			ResultSet rec = s.executeQuery(sql);

			if (rec != null) {
				rec.next();
				lblCustomerID.setText(rec.getString("id"));
				txtName.setText(rec.getString("firstname"));
				txtEmail.setText(rec.getString("lastname"));
				
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
						txtEmail.getText());
				dispose();
			}
		});
		btnSave.setBounds(131, 420, 69, 23);
		getContentPane().add(btnSave);

		// Button Close
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(217, 420, 69, 23);
		getContentPane().add(btnClose);
                                setLocationRelativeTo(null);

	}
                
                // Update
	private void SaveData(String strCustomerID, String strName, String strEmail) {
		
		Connection connect = null;
		Statement s = null;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/namedb" +
					"?user=root&password=admin");
			
			s = connect.createStatement();
			
			String sql = "UPDATE customer " +
                                                                                "SET firstname = '" + strName +  "' " + 
                                                                                ", lastname = '" + strEmail + "' " +
                                                                                " WHERE id = '"+strCustomerID+"' ";
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
