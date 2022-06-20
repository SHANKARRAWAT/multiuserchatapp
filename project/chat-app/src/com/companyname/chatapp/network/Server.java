package com.companyname.chatapp.network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.companyname.chatapp.utils.ConfigReader;
public class Server{
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers= new ArrayList<>();// store the detail of serverworker 
	public Server() throws IOException{
		int port=Integer.parseInt(ConfigReader.getValue("portno"));
		serverSocket = new ServerSocket(port);  //running the server to given port number;
		System.out.println("Server started and wating ....");
		handleClientRequest();
	}
	
	
	 public void handleClientRequest() throws IOException {
            while(true) {  		  
			Socket clientSocket =serverSocket.accept();
			// per worker per thread
			//thread creation
			ServerWorker serverworker=new ServerWorker(clientSocket,this); //create thread and pass the object of server to thread
			workers.add(serverworker);
			serverworker.start();
            }	 
      }
	
	

	
	/* single client
    Server() throws IOException{
	int port=Integer.parseInt(ConfigReader.getValue("portno"));
	serverSocket = new ServerSocket(port);  //running the server to given port number;
	System.out.println("server started waiting for client .......");
	Socket socket = serverSocket.accept();    //handshaking
	System.out.println("Client joins the server");
	
	InputStream in=socket.getInputStream();
	byte[] arr=in.readAllBytes();// 
	//String a= arr.toString();
	String a=new String(arr);
	System.out.println(" message received - "+a);
	in.close();
	socket.close();
    }
    */
    public static void main(String[] args) throws IOException
    {
    	Server server =new Server();
    }
}
