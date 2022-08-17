package io;

/* https://course.masaischool.com/lectures/32962   0 - 26mins */

/* 
 Using both BufferedWriter & FileWriter classes, there are some drawbacks, 
 we can only write only character data to the file, we cannot write
 primitive data like boolean or integers or float. If you write an integer say 100,
 it will convert it to a char and write 'd' in the file (ASCII conversion)
 
 Thus to overcome these drawbacks we use PrintWriter class
 */

import java.io.*;

public class _1BufferedWriterReader {
    
	public static void main(String[] args) throws IOException  {
        
        /* BufferedWriter cannot directly work on its own, it needs a Writer object, so
           we  use a FileWriter object
           
           Two Ways:
           	1) 
           	FileWriter fileWriter = new FileWriter("nio.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			2) 
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("buffer.text");
			
			NOTE: whenever we use FileWriter object, we must handle the exception ie throw IOException
			or try/catch
         */
        
		/* 
			Two Paths: Absolute & Relative
			
			Absolute example /Users/jai/Desktop/Desktop/Masai Notes/bufferedWriterDemo.txt
			
			Relative: this is when a file is already in the same folder/directory
					  so we don't need to use /// and can just do 'nio.txt; etc
		 */
		
		// Note that we do not need to create a new File object if we want to use an existing file, it is meant only for new files 
		File file = new File("/Users/jai/Desktop/Desktop/Masai Notes/bufferedWriterDemo.txt");
		FileWriter fileWriter=new FileWriter(file);
        BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
        
        bufferedWriter.write('c');  //char 
        bufferedWriter.write("buffered Writer");  //string
        bufferedWriter.newLine();  //to move to the next line on the text file
        
        bufferedWriter.write("it will go to a new line.");
        
        bufferedWriter.newLine();
        char[] chars={'a','b'}; // writing an arr of chars to the file
       
        bufferedWriter.write(chars);
        
        /* Note: it is crucial to flush the BufferedWriter object otherwise the output will be returned to the text file*/
        bufferedWriter.flush();

        /* BufferedReader is an upgrade over FileReder as it allows us to read 
			lines in a batch rather than one by one
			
         */
        
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file)
        );
        
        /* How to iterate through the bufferedReader object and print out the lines */
        bufferedReader
                .lines() /* .lines() returns all the lines in a string of strings */
                        .forEach(System.out::println);
        
        /* you can use this approach, or one above */
        bufferedReader
                .lines()
                .forEach(line-> System.out.println(line));

      
        /* Other way to iterate through bufferedReader object:
        
        String line = bufferedReader.readLine();
        
        while (line != null){
            System.out.println(line);
            line = bufferedReader.readLine(); //readLine takes you to the next line
        }*/
        
        bufferedWriter.close();
        bufferedReader.close();

    }
}