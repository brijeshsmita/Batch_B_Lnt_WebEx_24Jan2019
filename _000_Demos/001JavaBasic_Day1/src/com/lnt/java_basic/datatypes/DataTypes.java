package com.lnt.java_basic.datatypes;
/**
 * @author Smita
 *
 */
public class DataTypes {
	//variables created inside the method and passed in the arguments/parameter are known as "Local variables"
	//local variable have life/access only within that method not outside the method
	//local variable must be initialized before use
	public static void main(String  args []) {
		//data types in java - which type of data to be stored
		//variables - to stores any data inside your program		
		//numeric data types
		byte  tokenNo= 100; // 1 byte -8 bit
		short age =90;//2 bytes 
		int empId=1001;// 4 bytes
		long phoneNo=7738206222L ;// 8 bytes - long literal/values must be suffixed with 'l' or 'L'
		
		// decimal data types
		float weight=60.6f;//4 bytes -- float literal/values must be suffixed with 'f' or 'F'
		double salary=9999.99d;//8 bytes -by default all decimal literals/values are by default double in java.
		//not-mandatory to suffix double value with 'd' or 'D'
		
		//character data types - single quotes
		char garde='A'; //2 bytes 
		
		//boolean data types
		boolean status=true; // 1 bit - 0/1 - true/false 
		//note : dont ever provide quotes
		
		//number of characters to stored
		String name="Smita Kumar";//String is a class in java which can be treated as primitives
		String email="brijeshsmita@gmail.com";
		//local variable must be initialized before use
		//local variable not not have any default value
		//type sysout + Ctrl+Space
		
		System.out.println("Hello , "+name +" , we will keep in touch with you at : "+email);
	}
}






