package com.companyname.chatapp.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

//Client worker= thread
// user for reading the data
public class ClientWorker extends Thread{
    private InputStream in;
    private JTextArea textArea;
    //constructor
	public ClientWorker(InputStream in,JTextArea textArea){
		this.in=in;
		this.textArea=textArea;
	}
	
	@Override
	public void run() {
		BufferedReader br= new BufferedReader(new InputStreamReader(in));
		String line;
		try{
			
		  while(true) {
		 	line=br.readLine();
		 	System.out.println("Line Read at client side"+line);
		 	textArea.setText(textArea.getText()+line+"\n");// includes the line and previous text in text area
		 	//if()
		     }
		  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try
			{
				if(in!=null)
				 in.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
