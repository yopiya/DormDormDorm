/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
public class editFaci extends JFrame {
    public static void main(String[] args){
         EventQueue.invokeLater(new Runnable() {
                public void run() {
                        editFaci frame = new editFaci();
                       
                    }
            });
    }
    
    public editFaci(){
        
        //Frame Build
        setBounds(100,100,1280,720);
        setTitle("แก้ไขค่าหน่วยต่างๆ");
        setFont(new Font("Angsana New",Font.PLAIN,48));
        getContentPane().setLayout(null);
        setResizable(false);
        
        //Set color frame backgroud
        Color c1 = new Color(0,51,51);
        getContentPane().setBackground(c1);
        
    }
}
