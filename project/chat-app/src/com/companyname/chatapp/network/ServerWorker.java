package com.companyname.chatapp.network;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
   
	private Socket clientSocket;
    private OutputStream out;
    private InputStream in;
    private Server server;
    
	public ServerWorker(Socket clientSocket,Server server) throws IOException{
	  	this.clientSocket=clientSocket;
	  	this.server=server;
	  	out=clientSocket.getOutputStream();//write the bytes on network 
	  	in=clientSocket.getInputStream();// read the bytes from network
	  	System.out.println("new client comes");
	  }
	
	public void run() {
	 	BufferedReader br= new BufferedReader(new InputStreamReader(in));// read data from the network and convert to string
		String line;
		try 
		{
		  while(true) 
		   { 
			line=br.readLine();//read the data line by line
			System.out.println("Line read...." +line);
			if(line.equalsIgnoreCase("Quit")) {
				break;
			    }
			// out.write(line.getBytes());// send to one  client
			// for broadcasting 
			for(ServerWorker serverworker : server.workers) {// for each(datatype var :name of array)
				System.out.println("server woker ");
				line=line+"\n";
				serverworker.out.write(line.getBytes());// write the data// serverwoker=1st worker info ....2nd...3rd
			     }
			
		   }
		}
		catch(IOException exe) {
			exe.printStackTrace();
		}
		
		finally {
			try {
			if(br!=null)
			  br.close();
			if(in!=null)
			  in.close();
			if(out!=null)
				out.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
