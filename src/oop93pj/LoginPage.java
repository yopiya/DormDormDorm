/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Piya Rongnaimeang
 */
public class LoginPage extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel =  new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
                JLabel mainMessage = new JLabel("ซอร์ฟแวร์ระบบจัดการหอพัก");
	JLabel messageLabel = new JLabel("");
                Color cm1 = new Color(0,51,51);
                JLabel label = new JLabel(); //JLabel Creation
	HashMap<String,String> logininfo = new HashMap<String,String>();
        
        

LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
                                frame.setTitle("Login");
                
		userIDLabel.setBounds(100,265,75,25);
                                userIDLabel.setForeground(Color.white);
                                
                                userIDField.setBounds(180,265,200,25);
		userPasswordField.setBounds(180,320,200,25);
                
		userPasswordLabel.setBounds(100,320,75,25);
                                userPasswordLabel.setForeground(Color.white);
                                
                                mainMessage.setBounds(150, 200, 200, 25);
                                mainMessage.setFont(new Font("Angsana New",Font.ITALIC,25));
                                mainMessage.setForeground(Color.white);
		
		messageLabel.setBounds(125, 600, 250, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		loginButton.setBounds(160,385,75,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		clearButton.setBounds(270,385,75,25);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		
                                frame.getContentPane().setBackground(cm1);
                                
                                
                                label.setIcon(new ImageIcon("C:\\Users\\point\\OneDrive\\Documents\\NetBeansProjects\\oop93pj\\src\\oop93pj\\8.png")); //Sets the image to be displayed as an icon
                                Dimension size = label.getPreferredSize(); //Gets the size of the image
                                label.setBounds(192, 50, 120, 116);
                                
                                
                                frame.add(label);
                                frame.add(userIDLabel);
		frame.add(userPasswordLabel);
                                frame.add(mainMessage);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(clearButton);
                                frame.setBounds(0, 0, 500, 500);
                                //fix windows
                                frame.setResizable(false);
                                frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(524,524);
		frame.setLayout(null);
		frame.setVisible(true);
                                
                                
                             
                                
                                
	}






public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearButton) {
			userIDField.setText("");
			userPasswordField.setText("");
	}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Complete");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
					
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Login Again");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
				
		}
	
}
}
