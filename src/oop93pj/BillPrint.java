/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author Piya Rongnaimeang
 */
public class BillPrint extends JFrame {
        public static void main(String[] args){
                BillPrint frame = new BillPrint();
                
        }
        
        public BillPrint(){
            
        //Frame Build
        setBounds(100,100,1280,720);
        setTitle("แสดงบิลค่าใช้จ่ายต่างๆ");
        setFont(new Font("Angsana New",Font.PLAIN,48));
        getContentPane().setLayout(null);
        setResizable(false);
        
        //Set color frame backgroud
        Color c1 = new Color(0,51,51);
        getContentPane().setBackground(c1);
        
        
        }
        
}
