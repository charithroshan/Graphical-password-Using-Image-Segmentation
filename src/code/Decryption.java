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

public class Decryption { 
    public String PATH;
    public long key;
    public String message;
    
    public Decryption(){
        PATH = "";
        key = 0;
    }
    public Decryption(String PATH, long key){
        this.PATH = PATH;
        this.key = key;
    }
    
    public String decrypt(String PATH, long key)throws FileNotFoundException, IOException {
        
        if(PATH.length() > 1){
            FileInputStream fis = new FileInputStream(PATH); 
            
            // Converting image into byte array,it will 
		// Create a array of same size as image. 
		byte data[] = new byte[fis.available()]; 
			
		// Read the array 
			
		fis.read(data); 
		int i = 0; 
			
		// Performing an XOR operation 
		// on each value of 
		// byte array to Decrypt it. 
		for (byte b : data) { 
			data[i] = (byte)(b ^ key); 
			i++; 
		} 
			
		// Opening file for writting purpose 
		FileOutputStream fos = new FileOutputStream(PATH); 
			
		// Writting Decrypted data on Image 
		fos.write(data); 
		fos.close(); 
		fis.close(); 
		message = "Decyption Done..."; 
        }else{
            message = "..Please enter file";
        }
        return message;
    }
	
	public static void main(String[] args)
	{ 
		
	} 
}

