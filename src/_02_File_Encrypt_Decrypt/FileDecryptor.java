package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;


public class FileDecryptor {
	static // Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	String line;
	static String s = null;
	public static void main(String[] args) {


		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/test2.txt"));

			 line = br.readLine();
			while (line != null) {
				System.out.println(line);
				s+= line;
				line = br.readLine();
				
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String idiot = Utilities.decrypt(s, (byte) 'L');
		 
		 System.out.println(idiot);
	}
}
