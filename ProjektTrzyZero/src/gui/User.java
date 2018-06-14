package gui;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class User {
	private InetAddress IP;
	private String login;
	private int port;
	
	
	public User() {
		 login = "random";
		  	
		 port = 00000;
	}
	
	public User(String login1, InetAddress ip,  int port1) {
		 login = login1;
		 IP = ip;		
		 port = port1;
	}
	
public void setIP(String ip) throws UnknownHostException{
	IP = InetAddress.getByName(ip);
}
public void setLogin(String login1){
	login = login1;
}
public void setPort(int port1){
	port = port1;
}

public InetAddress getIP(){
	return IP;
}
public String getLogin(){
	return login;
}
public int getPort(){
	return port;
}
}