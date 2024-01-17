/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Piya Rongnaimeang
 */
public class infoRoom {
    public static void roomInf(){
      showWindowroominfo();
    }
    public static void showWindowroominfo(){
        JFrame frame = new JFrame("room information");
        JButton btnback = new JButton("back");
        JLabel roomInfolabel = new JLabel("set room");
        Color c1 = new Color(0,51,51);
        
        
        
        roomInfolabel.setBounds(0,0,500,35);
	roomInfolabel.setFont(new Font(null,Font.PLAIN,25));
	roomInfolabel.setText("This is room information place");
        
        
        frame.add(roomInfolabel);
        
        
        //frame.setBounds(100,100,467,315);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setSize(1280,720);
        frame.getContentPane().setBackground(c1);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
}
