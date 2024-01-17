/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oop93pj;

/**
 *
 * @author Piya Rongnaimeang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       IDandPasswords idandPasswords = new IDandPasswords();
		
		
		
       LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    }
    
}
