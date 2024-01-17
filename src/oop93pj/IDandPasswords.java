/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop93pj;
import java.util.HashMap;
/**
 *
 * @author Piya Rongnaimeang
 */
public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("admin","adminpass");
		logininfo.put("a","a");
		
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
