package com.companyname.chatapp.dto;
// it will take the data from the swing and transfer it to dao
public class UserDTO {
	    private String userid;
	    private char[] pasword;
	    public UserDTO(String userid,char[] password)
	    {
	    	this.userid=userid;
	    	this.pasword=password;
	    }
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public char[] getPasword() {
			return pasword;
		}
		public void setPasword(char[] pasword) {
			this.pasword = pasword;
		}
	    
	    
}
