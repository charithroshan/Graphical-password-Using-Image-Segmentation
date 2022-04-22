/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author user
 */

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.Scanner; 

public class Encryption {
    public String PATH;
    public long key;
    public String message;
    
    public Encryption(){
        PATH = "";
        key = 0;
    }
    public Encryption(String PATH, long key){
        this.PATH = PATH;
        this.key = key;
    }
    
    
    public String encrypt(String PATH, long key)throws FileNotFoundException, IOException {
        
        if(PATH.length() > 1){
            FileInputStream fis = new FileInputStream(PATH); 

            // Converting Image into byte array, create a 
            // array of same size as Image size 

            byte data[] = new byte[fis.available()]; 

            // Read the array 
            fis.read(data); 
            int i = 0; 

            // Performing an XOR operation on each value of 
            // byte array due to which every value of Image 
            // will change. 
            for (byte b : data) { 
                    data[i] = (byte)(b ^ key); 
                    i++; 
            } 

            // Opening a file for writing purpose 
            FileOutputStream fos = new FileOutputStream(PATH); 

            // Writing new byte array value to image which 
            // will Encrypt it. 

            fos.write(data); 

            // Closing file 
            fos.close(); 
            fis.close(); 
            message = "Encyption Done...";
        }else{
            message = "..Please enter file";
        }
        return message;
    }
	public static void main(String[] args) 
	{ 
		
	} 
}
