/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;
import com.mysql.cj.Constants;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Piya Rongnaimeang
 */
public class WelcomePage {

    public String uId;
    
    public WelcomePage(String userID) {
        showWindow1(userID);
    }
    
    public String setUserId(String userID) {
        return uId;
    }
    
    public static void showWindow1(String userID) {
       
        // สร้าง construnger
                JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	JButton addButton = new JButton("เพิ่มข้อมูลรายชื่อ");
	JButton delButton = new JButton("ลบข้อมูลรายชื่อ");
                JButton roominfoButton = new JButton("ข้อมูลห้องพัก");
                JButton queryData = new JButton("เรียกดูข้อมูลรายชื่อ");
                JButton billData = new JButton("บิลค่าใช้จ่าย");
                JButton editBillData = new JButton("แก้ไขหน่วยค่าน้ำ ค่าไฟ");
                Color bg = new Color(0,51,51);
                
	
	HashMap<String,String> addinfo = new HashMap<String,String>();
	
        //ป้ายแสดงข้อความ
        welcomeLabel.setBounds(960,0,300,35);
        welcomeLabel.setFont(new Font("Angsana New",Font.BOLD,32));
        welcomeLabel.setText("สวัสดีท่านผู้ใช้งาน: "+ userID );
        welcomeLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //test แบ่งกรอบ
        
        
        JPanel sidePanel = new JPanel();
        Color svDc = new Color(203,203,203);
        //sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBackground(svDc);
        sidePanel.setBounds(0,100,250,600);
        sidePanel.setSize(250,600);
        
        JPanel topPanel = new JPanel();
        Color sdDc = new Color(203,203,203);
        topPanel.setBackground(sdDc);
        topPanel.setBounds(0,0,1280,100);
        //topPanel.setSize(600,100);
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\point\\Downloads\\Untitled-1 (1)g.png")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(0, 0, 1270, 100);
        
                                
         //ปุ่ม adduser
        addButton.setBounds(0,100,250,50);
        addButton.setFont(new Font("Angsana New",Font.PLAIN,25));
        addButton.setFocusable(false);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    AddUser addUser = new AddUser();
                    addUser.setVisible(true);
                }
        });
        
        //ปุ่ม del	
        delButton.setBounds(0,150,250,50);
        delButton.setFont(new Font("Angsana New",Font.PLAIN,25));
        delButton.setFocusable(false);
        frame.getContentPane().add(delButton);
        delButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    delUser delUser = new delUser();
                    delUser.del(); 
            }
        });
                
                
        // ปุ่ม room info	
        roominfoButton.setBounds(0,200,250,50);
        roominfoButton.setFont(new Font("Angsana New",Font.PLAIN,25));
        roominfoButton.setFocusable(false);
        frame.getContentPane().add(roominfoButton);
        roominfoButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    frame.setVisible(true);
                    infoRoom infoRoom = new infoRoom();
                    infoRoom.roomInf();   
            }
        });
                
        // ปุ่ม queryData	
                queryData.setBounds(0,250,250,50);
                queryData.setFont(new Font("Angsana New",Font.PLAIN,25));
	queryData.setFocusable(false);
	frame.getContentPane().add( queryData);
                queryData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                //frame.setVisible(true);
                queryDatau queryDatab = new queryDatau();
                queryDatab.setVisible(true);
                
                
                
            }
        });
                // ปุ่ม billData	
                billData.setBounds(0,300,250,50);
                billData.setFont(new Font("Angsana New",Font.PLAIN,25));
	billData.setFocusable(false);
	frame.getContentPane().add( billData);
                billData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                //frame.setVisible(true);
                BillPrint billDatab = new BillPrint();
                billDatab.setVisible(true);
                
                
                
            }
        });
                //editFaciUnit
                editBillData.setBounds(0,350,250,50);
                editBillData.setFont(new Font("Angsana New",Font.PLAIN,25));
	editBillData.setFocusable(false);
	frame.getContentPane().add( editBillData);
                editBillData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                //frame.setVisible(true);
                editFaci editFaci = new editFaci();
                editFaci.setVisible(true);
                
                
                
            }
        });
                
                //แสดงกรอบ
                	
                
                frame.add(welcomeLabel);
	frame.add(addButton);
	frame.add(delButton);
                frame.add(queryData);
                frame.add(roominfoButton);
                frame.add(label);
                frame.add(sidePanel);
                frame.add(topPanel);
                
                frame.setTitle("Dashbroad");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(0, 0, 1300, 700);
                //fix windows
                frame.setResizable(false);
                //open in middle on screen
                frame.setLocationRelativeTo(null);
                //set background color
                frame.getContentPane().setBackground(bg);
                //set size of program
	frame.setSize(1280,720);
	frame.setLayout(null);
	frame.setVisible(true);
	
		
    }

  



	
}
