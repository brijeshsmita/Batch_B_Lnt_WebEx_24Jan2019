public class CommandLineArg {

	public static void main(String [] args) {
		// how to accept value through command line arguments and access those values
		//command line arguments are the arg which is passed while running the program
		//and stored String[] args of main method
		String name = args[0];//array index starts with 0;
		double salary = Double.parseDouble(args[1]);//arg is of type string , here we need to convert string to double
		int age = Integer.parseInt(args[2]);//arg is of type string , here we need to convert string to int
		//to store multiple values we declare an array
		System.out.println("Hello ,"+name +" , salary :"+salary+ " , Age : "+age);
//how to pass cmd line arg using eclipse
		//right click -> Run As -> Run Configuration -> In Arguments Tab -> 
		//Pass the arguments and pass multiple args separating them by ' ' space
		
	}

}
/*
 * Using cmd prompt
 * C:\Users\brije>e:

E:\>cd Batch_B_Lnt_WebEx

E:\Batch_B_Lnt_WebEx>set path="c:\Program Files\Java\jdk1.8\bin";

E:\Batch_B_Lnt_WebEx>javac CommandLineArg.java

E:\Batch_B_Lnt_WebEx>java CommandLineArg Smita
*/
