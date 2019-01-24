/*
 * multi-line comments in java
 */
//single line comments in java
//only one or none package declaration
//must be the first line of code
//Java default package is java.lang package
package com.lnt.java_basic;
/** documentation comments
 * @author Smita
 * Dated : 24-Jan-2019
 */
//there are 3 access specifier in java 
//public ,private,protected
//if you dont mention any access specifier then the access level become package/default
//top level class can only be marked with public
public class HelloWorld {
	/**
	 * @param args
	 */
	//main methid acts an a entry point or execution point to run a class
		//it can be invoked directly that why it is public
		//it dosent return anything that why the return type is void
		//static is a keyword in java - which mean single copy per class
		//String is a class in java to handle String type vaibles
		//main method takes String array as an argument or parameter
	//main Cltr+Space+enter
	//Select the specific in-build class and press F3 to get the detailed info about the class
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		//System is a class in java which is associated to the OS
		//out is a static property of System class which is associated with standard output device
		//println is a method which prints the specific arguments/parameters
		//passed to it on to the output device with a new line
	}
}
