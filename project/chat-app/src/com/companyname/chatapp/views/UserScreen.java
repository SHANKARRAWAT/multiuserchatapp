package com.companyname.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.companyname.chatapp.dao.UserDAO;
import com.companyname.chatapp.dto.UserDTO;
import com.companyname.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField Useridfield;
	private JPasswordField Passwordfield;
	UserDAO userDAO=new UserDAO();
		public static void main(String[] args) {
							UserScreen window = new UserScreen();
				}
		
		    private void islogin() {
			  
			  String userid = Useridfield.getText();
			  UserInfo.USER_NAME = userid;
        	//String password=Passwordfield.getText(); due to toString = meaningfull values;
        	  char password[]= Passwordfield.getPassword();
        	  UserDTO userDTO=new UserDTO(userid,password);
        	  try {
        		 String message="";
				if(userDAO.islogin(userDTO))
				{
					message="Welcome "+userid;
					JOptionPane.showMessageDialog(this,message);
					setVisible(false);
					dispose();
					DashBoard dashboard= new DashBoard(message);
					dashboard.setVisible(true);
					
				}
				else
				{
					message ="invalid username or password";
					JOptionPane.showMessageDialog(this,message);
				}
//				JOptionPane.showMessageDialog(this,message);
			  } 
        	  
        	  catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
        	  catch(Exception exe)
        	  {
        		  exe.printStackTrace();
        	  }
        	  
        	  
        	  
		}
        private void  register() {
        	String userid = Useridfield.getText();
        	//String password=Passwordfield.getText(); due to toString = meaningfull values;
        	  char password[]= Passwordfield.getPassword();//return character array ;
        	  UserDTO userDTO=new UserDTO(userid,password);
        	  try {
        	  int result =userDAO.add(userDTO);
        	    if(result==1) {
       	    	//System.out.println("successfully added");
        	        JOptionPane.showMessageDialog(this, "Successfully registered");
        	    }
        	   else
        	    {//System.out.println("NOT added");
        	    	JOptionPane.showMessageDialog(this, "not Registered");
        	    }  
        	  }
        	  catch(ClassNotFoundException exe)
        	  {
        		  System.out.println("Class issue.....");
        		  exe.printStackTrace();
        	  }
        	  catch(SQLException exe)
        	  {
        		  System.out.println("DB issue....");
        		  exe.printStackTrace();
        	  }
        	  catch(Exception exe)
        	  {
        		  exe.printStackTrace();
        	  }
        	  
        	//System.out.println("userid  "+userid+ "\n password  "+password.toString());
        }
		public UserScreen() {
			setResizable(false);
			setTitle("LOGIN");
			getContentPane().setLayout(null);
			JLabel lblNewLabel = new JLabel("LOGIN");
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 40));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(222, 59, 159, 52);
			getContentPane().add(lblNewLabel);
			
			Useridfield = new JTextField();
			Useridfield.setBounds(307, 148, 289, 33);
			getContentPane().add(Useridfield);
			Useridfield.setColumns(10);
			
			JLabel usernamelbl = new JLabel("UserName");
			usernamelbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
			usernamelbl.setBounds(141, 148, 142, 33);
			getContentPane().add(usernamelbl);
			
			JLabel passwordlbl = new JLabel("Password");
			passwordlbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
			passwordlbl.setBounds(141, 214, 121, 23);
			getContentPane().add(passwordlbl);
			
			JButton loginbtn = new JButton("Login");
			loginbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					islogin();
				}
			});
			loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
			loginbtn.setBounds(189, 280, 94, 33);
			getContentPane().add(loginbtn);
			
			Passwordfield = new JPasswordField();
			Passwordfield.setBounds(307, 213, 289, 33);
			getContentPane().add(Passwordfield);
			
			JButton registerbtn = new JButton("Register");
			registerbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					register();
				}
			});
			registerbtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
			registerbtn.setBounds(378, 280, 121, 33);
			getContentPane().add(registerbtn);
			setSize(720,369);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	}
}
