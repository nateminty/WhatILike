//Nate Mintz
//Program Description:
//Dec 11, 2018

package expe;

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class WhatILike {

	public static void main(String[] args) throws IOException
	{	
		Scanner scan = new Scanner(System.in);
		
		File f = new File("/Users/nmintz22/Desktop/hey/til.txt");
		
		Scanner read = new Scanner(f);
		
		String options[] = {"Quit", "View What I Like", "Add What I Like"};
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/nmintz22/Desktop/hey/til.txt",true));
		Scanner reader = new Scanner("/Users/nmintz22/Desktop/hey/til.txt");
		
		boolean b = true;
		int input = 10;
		
		while(b)
		{
			input = JOptionPane.showOptionDialog(null, "Welcome to What I Like", "What I Like", 0, 0, null, options, 0);
			
			if(input == 2)
			{
				addTIL(writer);
			}
			else if(input == 1)
			{
				String name = JOptionPane.showInputDialog(null, "Enter your name");
				String realName = "";
				
				String l = "";
				String til = "";
				
				while(read.hasNext())
				{	
					if(read.next().toLowerCase().equals(name.toLowerCase()))
					{	
						while(!(read.next().equals("*")))
						{
							realName = (name.substring(0, 1).toUpperCase()) + name.substring(1).toLowerCase();
							til = read.next();
							
							l =  realName + " likes " + til;
							
							JOptionPane.showMessageDialog(null, l);
						}
					}
				}

				read = null;
				
				read = new Scanner(f);

			}
			else if(input == 0)
			{
				b = false;
			}
		}
	}
	
	public static void addTIL(BufferedWriter writer) throws IOException
	{
		String name = JOptionPane.showInputDialog(null, "Enter your name");
		
		String fav = JOptionPane.showInputDialog(null, "Enter your favorite thing");
			
		writer.write(name + " likes " + fav + " *");
		writer.newLine();
			
		writer.close();
	}

}
