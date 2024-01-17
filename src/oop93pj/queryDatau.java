/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;

//general libary
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


//libary mysql connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

//libary mysql log
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Piya Rongnaimeang
 */
public class queryDatau extends JFrame {
    
        JRadioButton rb1,rb2; 
    
        Connection connect = null;
        Statement s = null;
        
        static JTable table;
        
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
    
       public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                        queryDatau frame = new queryDatau();
                        frame.setVisible(true);
                        
                        
                    }
            });
        }
       
    public queryDatau() {
        
        Color c1 = new Color(0,51,51);
        
                                getContentPane().setBackground(c1);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1280,720);
                                setTitle("Customer List");
                                getContentPane().setLayout(null);
                                setResizable(false);
		
		// Customer List
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setBounds(550, 20, 200, 54);
                                lblCustomerList.setFont(new Font("Angsana New",Font.PLAIN,48));
                                lblCustomerList.setForeground(Color.white);
		getContentPane().add(lblCustomerList);

		// ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 84, 1180, 480);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
                                Font font = new Font("Angsana New", Font.PLAIN, 24);
                                table.setFont(font);
                                table.setRowHeight(30);
                                table.setBackground(Color.white);
                                table.setForeground(Color.black);
                                
                                JTableHeader tableHeader = table.getTableHeader();
                                tableHeader.setBackground(Color.gray);
                                tableHeader.setForeground(Color.white);
                                Font headerFont = new Font("Verdana", Font.PLAIN, 14);
                                tableHeader.setFont(headerFont);
                                
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
		model.addColumn("Lastame");
		model.addColumn("Date Born");
		model.addColumn("Occupation");
		model.addColumn("Address");
                                model.addColumn("Citizen ID");
                                model.addColumn("Phone Number");
                                model.addColumn("Sex");
                                model.addColumn("Phone Other Contact");
                                model.addColumn("Social Other Contact");
                                model.addColumn("Address Other Contact");
                                

		Connection connect = null;
		Statement s = null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/namedb" + "?user=root&password=admin");

			s = connect.createStatement();

			String sql = "SELECT * FROM  customer ORDER BY id ";

			ResultSet rec = s.executeQuery(sql);
			int row = 0;
			while ((rec != null) && (rec.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(rec.getString("id"), row, 0);
				model.setValueAt(rec.getString("Firstname"), row, 1);
				model.setValueAt(rec.getString("Lastname"), row, 2);
                                                                model.setValueAt(rec.getString("date_born"), row, 3);
                                                                model.setValueAt(rec.getString("occupation"), row, 4);
                                                                model.setValueAt(rec.getString("address"), row, 5);
                                                                model.setValueAt(rec.getString("citizen_id"), row, 6);
                                                                model.setValueAt(rec.getString("phone_number"), row, 7);
                                                                model.setValueAt(rec.getString("sex"), row, 8);
                                                                model.setValueAt(rec.getString("ph_ot"), row, 9);
                                                                model.setValueAt(rec.getString("sc_ot"), row, 10);
                                                                model.setValueAt(rec.getString("ad_ot"), row, 11);
				
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
