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
		//Edit this line with the directory of where til.txt is stored
		File f = new File(parseLoc());
		//
		
		f.createNewFile();
		
		Scanner read = new Scanner(f);
		
		String options[] = {"Quit", "View What I Like", "Add What I Like"};
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(f,true));
		
		boolean b = true;
		int input = 10;
		
		while(b)
		{
			input = JOptionPane.showOptionDialog(null, "Welcome to What I Like", "What I Like", 0, 0, null, options, 0);
			
			if(input == 2)
			{
				addTIL(writer, read, f);
			}
			else if(input == 1)
			{
				String name = JOptionPane.showInputDialog(null, "Enter your name");
				String realName = "";
				
				boolean q = true;
				
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
							
							q = false;
						}
					}
				}
				
				if(name.equals("") || name.equals(null))
				{
					JOptionPane.showMessageDialog(null, "Please search for a real name");
				}
				else if(q)
				{
					JOptionPane.showMessageDialog(null, "Please enter a name in the database");
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
	
	public static void addTIL(BufferedWriter writer, Scanner read, File f) throws IOException
	{	
		boolean t = true;
		
		String name = JOptionPane.showInputDialog(null, "Enter your name");
	
		if(name.equals("") || name.equals(null))
		{
			JOptionPane.showMessageDialog(null, "Please enter a name");
		}
		else
		{
			String fav = JOptionPane.showInputDialog(null, "Enter your favorite thing");
			
			if(checkTIL(read, f, name))
			{
				writer.write(name + " likes " + fav + " *");
				writer.newLine();
						
				writer.close();
			}
			else
				JOptionPane.showMessageDialog(null, "Name already exists");
			}
		}
	

	public static boolean checkTIL(Scanner read, File f, String name) throws IOException
	{
		read = null;
		
		read = new Scanner(f);
		
		while(read.hasNext())
		{
			if(read.next().equals(name))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static String parseLoc()
	{
		String generic = System.getProperty("user.dir");
		boolean b = true;
		int count = 0;
		int i = 0;
		
		while(b)
		{	
			if(generic.charAt(i) == '/')
			{
				count++;
				
				if(count == 3)
				{
					generic = generic.substring(0, i);
					System.out.println(generic);
					b = false;
				}
			}
			
			i++;
		}
		
		String g2 = generic + "/Desktop/til.txt";
		
		return g2;
	}

}
