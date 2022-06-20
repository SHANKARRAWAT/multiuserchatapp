package com.companyname.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.companyname.chatapp.network.Client;
import com.companyname.chatapp.network.ClientWorker;
import com.companyname.chatapp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private ClientWorker clientwoker;
	private Client client;

	public static void main(String[] args) {	
		try {
			ClientChatScreen frame = new ClientChatScreen();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
	public void sendIt() throws IOException {
		String message=UserInfo.USER_NAME+" : "+ textField.getText();
		
		client.sendMessage(message);
	}
	
	public ClientChatScreen() throws UnknownHostException, IOException {
		//
		textArea=new JTextArea();
		client =new Client(textArea);
		setTitle("Chit chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 25, 722, 288);
		contentPane.add(scrollPane);
		
		
		textArea.setBounds(50, 32, 655, 262);
	    scrollPane.setViewportView(textArea);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField.setBounds(18, 338, 604, 32);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton = new JButton("Send");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					sendIt();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    btnNewButton.setBounds(659, 346, 85, 24);
	    contentPane.add(btnNewButton);
		setVisible(true);
	}
}
