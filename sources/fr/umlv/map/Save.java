package fr.umlv.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Save {
	
	public static void read(String fileName) {
		try(BufferedReader r = new BufferedReader(new FileReader(fileName))) {
			
			String currentLine;
			
			while((currentLine = r.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read2(String fileName) {
		 	try(Reader r = new FileReader(fileName)){
		 		int data = r.read();
		 		while(data != -1){
		 			char dataChar = (char) data;
		 			System.out.print(dataChar);
		 			data = r.read();
		 		}
		 	} catch(IOException e) {
		 		e.printStackTrace();
		 	}
	}
	
	public static void main(String[] args) {
		read2("C:\\Users\\Tom\\Documents\\eclipse-workspace\\Wall-J\\sources\\fr\\umlv\\map\\level0.txt");

	}

}
