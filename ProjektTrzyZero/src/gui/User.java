package gui;

public class User {
	private String IP;
	private String login;
	private double port;
	
	
	public User() {
		 login = "random";
		 IP = "192.random";		
		 port = 00000;
	}
	
	public User(String login1, String ip,  double port1) {
		 login = login1;
		IP = ip;		
		 port = port1;
	}
	
public void setIP(String ip){
	IP = ip;
}
public void setLogin(String login1){
	login = login1;
}
public void setPort(double port1){
	port = port1;
}

public String getIP(){
	return IP;
}
public String getLogin(){
	return login;
}
public double getPort(){
	return port;
}
}