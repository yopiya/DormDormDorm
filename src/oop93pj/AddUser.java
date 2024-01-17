/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;
import com.mysql.cj.xdevapi.Table;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static oop93pj.queryDatau.table;
/**
 *
 * @author Piya Rongnaimeang
 */
public class AddUser extends javax.swing.JFrame {
    
    JRadioButton rb1,rb2; 
    
    Connection connect = null;
    Statement s = null;
    
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                        AddUser frame = new AddUser();
                        frame.setVisible(true);
                        
                        
                        
                    }
            });
        }
    
    public AddUser(){
          
       
        setBounds(100,100,467,315);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(1280,720);
        setTitle("Add User place");
        getContentPane().setLayout(null);
        setResizable(false);
        
        // Customer Label test
        /*JLabel lblCustomer = new JLabel("Add User");
        lblCustomer.setBounds(231, 28, 95, 14);
        lblCustomer.setForeground(Color.white);
        getContentPane().add(lblCustomer);
        */
        
        
        //constractur
        JFrame frame = new JFrame("addUser");
        JButton btnadd = new JButton("add");
        JLabel qeryData = new JLabel("set user");
        JLabel dpData = new JLabel("set user");
        JLabel mainMessage = new JLabel("เพิ่มรายชื่อ");
        Color cm1 = new Color(0,51,51);
        
        //background setting
        getContentPane().setBackground(cm1);
        
        mainMessage.setBounds(850, 20, 200, 54);
        mainMessage.setFont(new Font("Angsana New",Font.PLAIN,48));
        mainMessage.setForeground(Color.white);
        getContentPane().add(mainMessage);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 80, 480, 524);
        getContentPane().add(scrollPane);
        
        //ตาราง
        JTable table = new JTable();
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Firstname");
        model.addColumn("Lastname");
        
        //Varibles
        String url = "jdbc:mysql://localhost:3306/namedb";
        String username = "root";
        String password = "admin";
         
       
        //qurey
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
        
      
        
        // *** Header ***//

        JLabel hCustomerID = new JLabel("รหัสลูกค้า");
        hCustomerID.setBounds(600, 100, 200, 54);
        hCustomerID.setFont(new Font("Angsana New",Font.PLAIN,24));
        hCustomerID.setForeground(Color.white);
        getContentPane().add(hCustomerID);
        
        
        final JTextField txtCustomerID = new JTextField("");
        txtCustomerID.setBounds(600, 150, 250, 30);
        txtCustomerID.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtCustomerID);


        JLabel hName = new JLabel("ชื่อ - นามสกุล");
        hName.setBounds(600, 200, 200, 54);
        hName.setFont(new Font("Angsana New",Font.PLAIN,24));
        hName.setForeground(Color.white);
        getContentPane().add(hName);
        
        final JTextField txtName = new JTextField("");
        txtName.setBounds(600, 250, 250, 30);
        txtName.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtName);


        JLabel hOccr = new JLabel("อาชีพ");
        hOccr.setBounds(600, 300, 200, 54);
        hOccr.setFont(new Font("Angsana New",Font.PLAIN,24));
        hOccr.setForeground(Color.white);
        getContentPane().add(hOccr);
        
        final JTextField txtOccr = new JTextField("");
        txtOccr.setBounds(600, 350, 250, 30);
        txtOccr.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtOccr);

        
        JLabel hAddr = new JLabel("ที่อยู่");
        hAddr.setBounds(600, 375, 200, 100);
        hAddr.setFont(new Font("Angsana New",Font.PLAIN,24));
        hAddr.setForeground(Color.white);
        getContentPane().add(hAddr);
        
        final JTextField txtAddr= new JTextField("");
        txtAddr.setBounds(600, 445, 250, 150);
        txtAddr.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtAddr);

 
        JLabel hNid = new JLabel("รหัสบัตรประชาชน");
        hNid.setBounds(900, 100, 200, 54);
        hNid.setFont(new Font("Angsana New",Font.PLAIN,24));
        hNid.setForeground(Color.white);
        getContentPane().add(hNid);
        
        final JTextField txthNid = new JTextField("");
        txthNid.setBounds(900, 150, 250, 30);
        txthNid.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txthNid);

 
        JLabel hUsed = new JLabel("เบอร์โทรศัพท์");
        hUsed.setBounds(900, 200, 200, 54);
        hUsed.setFont(new Font("Angsana New",Font.PLAIN,24));
        hUsed.setForeground(Color.white);
        getContentPane().add(hUsed);
        
        final JTextField txtUsed = new JTextField("");
        txtUsed.setBounds(900, 250, 250, 30);
        txtUsed.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtUsed);
        
        JLabel hSex = new JLabel("เพศ");
        hSex.setBounds(900, 300, 200, 54);
        hSex.setFont(new Font("Angsana New",Font.PLAIN,24));
        hSex.setForeground(Color.white);
        getContentPane().add(hSex);
        
        rb1=new JRadioButton("Male");    
        rb1.setBounds(900,350,75,30);
        
        
        rb2=new JRadioButton("Female");    
        rb2.setBounds(1000,350,75,30);
        
        ButtonGroup bg=new ButtonGroup();    
        bg.add(rb1);bg.add(rb2); 
        add(rb1);add(rb2);
        
        
        
        JLabel hConty = new JLabel("เบอร์โทรศัพท์ - ผู้ที่ติดต่อได้");
        hConty.setBounds(900, 400, 200, 54);
        hConty.setFont(new Font("Angsana New",Font.PLAIN,24));
        hConty.setForeground(Color.white);
        getContentPane().add(hConty);
        
        final JTextField txtConty = new JTextField("");
        txtConty.setBounds(900, 450, 250, 30);
        txtConty.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtConty);
        
        JLabel hContsocial = new JLabel("ที่อยู่ LINE ผู้ที่ติดต่อได้");
        hContsocial.setBounds(900, 500, 200, 54);
        hContsocial.setFont(new Font("Angsana New",Font.PLAIN,24));
        hContsocial.setForeground(Color.white);
        getContentPane().add(hContsocial);
        
        final JTextField txtContsocial = new JTextField("");
        txtContsocial.setBounds(900, 550, 250, 30);
        txtContsocial.setFont(new Font("Angsana New",Font.PLAIN,24));
        getContentPane().add(txtContsocial);
        
        
        // Save Button

        // Save Button
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
					String sql = "INSERT INTO customer " + "(id,firstname,lastname) "+ "VALUES ('" + txtCustomerID.getText() + "','"+ txtName.getText() + "','"+ txtOccr.getText() +  "') ";
					
					s.execute(sql);
                                        
					// Reset Text Fields
					txtCustomerID.setText("");
					txtName.setText("");
					hOccr.setText("");
					txtAddr.setText("");
					txthNid.setText("");
					txtUsed.setText("");
					
					JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
                                                                                
                                                                                


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
                                dispose();
                                
			}
		});
        
        
        //insert data
        /*try {
                Connection connection = DriverManager.getConnection(url, username, password);
                 //System.out.print("Success connection.");
                String sql = "INSERT INTO customer (firstname, lastname) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "qwe");
                statement.setString(2, "adfrefg");
            
                 int rows = statement.executeUpdate();
                    if (rows > 0){
                        System.out.print("A row has already inserted. ");
                 }
                 
                statement.close();
                connection.close();
            
            } catch (SQLException ex) {
                // Logger.getLogger(queryDatau.class.getName()).log(Level.SEVERE, null, e);
                System.out.print("Can't connect to database, Please check your connection.");
            ex.printStackTrace();
                }
        */
        
        //fix windows
        
        btnSave.setBounds(900, 600, 89, 23);
        getContentPane().add(btnSave);       
        scrollPane.setViewportView(table); 
        
        JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClose.setBounds(0,0 , 69, 23);
		getContentPane().add(btnClose);
        
        
        
    }
    
    
        
         
    }
    
    
    
   /* public void actionPerformed(ActionEvent e) {
       
       
        //Varibles
        String url = "jdbc:mysql://localhost:3306/namedb";
        String username = "root";
        String password = "admin";
         
        //insert data
        try {
                Connection connection = DriverManager.getConnection(url, username, password);
                 //System.out.print("Success connection.");
                String sql = "INSERT INTO customer (firstname, lastname) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "spoile");
                statement.setString(2, "digitech");
            
                 int rows = statement.executeUpdate();
                    if (rows > 0){
                        System.out.print("A row has already inserted. ");
                 }
            
                statement.close();
                connection.close();
            
            } catch (SQLException ex) {
                // Logger.getLogger(queryDatau.class.getName()).log(Level.SEVERE, null, e);
                System.out.print("Can't connect to database, Please check your connection.");
            ex.printStackTrace();
                }
         }*/
    
    
        
        
        
        
    
    



