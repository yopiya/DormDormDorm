/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Piya Rongnaimeang
 */
public class delUser  {
    
    
    public static void del(){
        
      showWindowdel();
    }
    public static void showWindowdel(){
       
        JFrame frame = new JFrame("addUser");
        JButton btnback = new JButton("back");
        JLabel delUserlabel = new JLabel("set user");
        Color c1 = new Color(0,51,51);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        //Varibles
        String url = "jdbc:mysql://localhost:3306/namedb";
        String username = "root";
        String password = "admin";
      
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 90, 540, 480);
        frame.add(scrollPane);
        
        
        
        JTable table = new JTable();
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
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("id");
        model.addColumn("firstname");
        model.addColumn("lastname");
        
        
        try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM customer";
                ResultSet result = statement.executeQuery(sql);
                
                
                int row = 0;
                while (result.next()){
                        String id = result.getString("id");
                        String firstname = result.getString("firstname");
                        String lastname = result.getString("lastname");
                        
                        
                        //System.out.println(id + " : " +   firstname + " " + lastname );
                        
                        
                        model.addRow(new Object[0]);
                        model.setValueAt(result.getString("id"), row, 0);
                        model.setValueAt(result.getString("firstname"), row, 1);
                        model.setValueAt(result.getString("lastname"), row, 2);
                        row++;
                }
            
                connection.close();
           
            } catch (SQLException e) {
                // Logger.getLogger(queryDatau.class.getName()).log(Level.SEVERE, null, e);
                System.out.print("Can't connect to database, Please check your connection.");
                e.printStackTrace();
                }
        
        
        scrollPane.setViewportView(table); 
        
        
        delUserlabel.setBounds(850,100,500,35);
        delUserlabel.setFont(new Font("Angsana New",Font.PLAIN,36));
        delUserlabel.setForeground(Color.white);
        delUserlabel.setText("ลบรายชื่อ");
        
        //ปุ่มลบรายชื่อ
        
         JLabel hdelId = new JLabel("หมายเลข ID ที่ต้องการลบ");
        hdelId.setBounds(700, 200, 200, 54);
        hdelId.setFont(new Font("Angsana New",Font.PLAIN,24));
        hdelId.setForeground(Color.white);
        frame.add(hdelId);
        
        final JTextField txtdelIdl = new JTextField("");
        txtdelIdl.setBounds(700, 250, 250, 30);
        txtdelIdl.setFont(new Font("Angsana New",Font.PLAIN,24));
        frame.add(txtdelIdl);
        
        JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection connect = null;
				Statement s = null;

				try {
					//Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection(url, username, password);
                                                                                connect = DriverManager.getConnection(""+ "jdbc:mysql://localhost:3306/namedb"+ "?user=root&password=admin");
                                                                                s = connect.createStatement();
					
					
					// SQL Insert
					//String sql = "INSERT INTO customer " + "(id,firstname,lastname) "+ "VALUES ('" + txtCustomerID.getText() + "','"+ txtName.getText() + "','"+ txtOccr.getText() +  "') ";
					
                                        
                                                                                String sql = "DELETE FROM customer  WHERE " +"id = '" + txtdelIdl.getText() + "' ";
					s.execute(sql);
                                        
					
					
					JOptionPane.showMessageDialog(null,"Delete Data Successfully");
                                                                                


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
                                                frame.dispose();
			}
                        
		});
        
        btnSave.setBounds(700, 300, 89, 23);
        frame.add(btnSave);       
        
        scrollPane.setViewportView(table);        
        
        frame.add(delUserlabel);
        
        
        frame.setTitle("Delete User");
        frame.setBounds(100,100,467,315);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(c1);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
}

/*
try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //System.out.print("Success connection.");
          
            
            
            
            
            
            
        } catch (SQLException e) {
           // Logger.getLogger(queryDatau.class.getName()).log(Level.SEVERE, null, e);
            System.out.print("Can't connect to database, Please check your connection.");
            e.printStackTrace();
        }
*/