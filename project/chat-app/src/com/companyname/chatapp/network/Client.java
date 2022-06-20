package com.companyname.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.companyname.chatapp.utils.ConfigReader;

public class Client {
	ClientWorker worker;
    Socket socket;
    InputStream in;
    OutputStream out;
    JTextArea textArea;
    
    /////
	  public Client(JTextArea textArea) throws UnknownHostException, IOException{//constructor 
		int port=Integer.parseInt(ConfigReader.getValue("portno"));
		socket = new Socket(ConfigReader.getValue("ServerIp"),port);//  connection created 
		System.out.println("client comes...");
		this.textArea =textArea;
		in=socket.getInputStream();
		out=socket.getOutputStream();
		readMessage();
			
	}
	
	public void sendMessage(String message) throws IOException {
		message=message+"\n";
		out.write(message.getBytes());
	}
	
	public void readMessage() {
		worker=new ClientWorker(in,textArea);//calling the thread
		worker.start();
	}
	
	
//		System.out.println("client comes...");
//		System.out.println("Enter the message ");
//		Scanner scanner =new Scanner(System.in);
//		String message =scanner.nextLine();
//		OutputStream out =socket.getOutputStream();//writes bytes on network
//		out.write(message.getBytes());
//		System.out.println("message send to server");
//		out.close();
//		scanner.close();
//		socket.close();
		
	
	public static void  main(String[] args) throws UnknownHostException, IOException {
		Client client =new Client();
		
	}
}
