/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author Piya Rongnaimeang
 */
public class NewClass {
     public static void main(String[] args) throws Exception {
  JFrame frame = new JFrame();
  frame.setVisible(true);
  frame.setSize(500, 200);
  frame.setLocation(10, 10);
  frame.setTitle("Frame By Java Code Exam");
  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JPanel container = new JPanel();
  container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
  
  JPanel panel1 = new JPanel();
  panel1.setBorder(BorderFactory.createLineBorder(Color.black));
  panel1.setBackground(Color.BLACK);
  container.add(panel1);
  
  JPanel panel2 = new JPanel();
  panel2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
  panel2.setBackground(Color.BLUE);
  container.add(panel2);
  
  JPanel panel3 = new JPanel();
  panel3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
  panel3.setBackground(Color.CYAN);
  container.add(panel3);
  
  JPanel panel4 = new JPanel();
  panel4.setBorder(BorderFactory.createRaisedBevelBorder());
  panel4.setBackground(Color.DARK_GRAY);
  container.add(panel4);
  
  JPanel panel5 = new JPanel();
  panel5.setBorder(BorderFactory.createLoweredBevelBorder());
  panel5.setBackground(Color.GREEN);
  container.add(panel5);
  
  frame.add(container);
 }
}
