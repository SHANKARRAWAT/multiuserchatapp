package com.companyname.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	UserView(){
		 counter=0;
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(500, 500);
		 setResizable(false);
		 //setLocation(100,50);
		
		 setLocationRelativeTo(null);
		 setTitle("Login");
		 JLabel welcome=new JLabel("Login");
		 welcome.setFont(new Font("Arial",Font.BOLD,40));
		 Container container = this.getContentPane();
		 container.setLayout(null);
  	     welcome.setBounds( 100,50 ,150,60);
  	     container.add(welcome);
  	     JButton button =new JButton("Count");
  	     button.addActionListener(new ActionListener() {
  	    	@Override
  	    	public void actionPerformed(ActionEvent event) {
  	    	    counter++;
  	    	    welcome.setText("count"+counter);
  	    	}
 
  	     });
  	     
  	      button.setBounds(100, 159, 100, 50);
     	 container.add(button);
	 }
	 
    public static void main(String[] args)
    {
    	UserView  userview=new UserView();
    	
    }
}
