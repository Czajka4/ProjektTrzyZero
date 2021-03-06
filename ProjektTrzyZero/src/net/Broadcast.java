package net;

import java.io.IOException; 
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import gui.MainPanelRight;
import gui.MainTabbedPane;

public class Broadcast {
	static DatagramSocket datagramSocket;
	int port;
	
	public Broadcast() throws SocketException //konstruktor przydziela losowy socket
	{
		datagramSocket = new DatagramSocket();
		System.out.println("{Port: " + datagramSocket.getLocalPort());
		port = datagramSocket.getLocalPort();
	}
	
	public static void send_message(String msg, InetAddress dest, int port) throws IOException
	{
		    byte[] byteMsg = msg.getBytes("utf8");
	        InetAddress serverAddress = dest;
	        System.out.println(serverAddress);
	        DatagramPacket message
            = new DatagramPacket(
            		byteMsg, byteMsg.length);
	        message.setAddress(serverAddress);
	        message.setPort(port);
	        datagramSocket.send(message);
	        
	}
	
	public static void hello() throws IOException // hello wysy�a wiadomo�� o dost�pno�ci na porcie 9000
	{
		//	Scanner keyboard = new Scanner(System.in); //zapytanie o nick
		//	System.out.println("Enter your name");
			String nick = MainPanelRight.GetMyLogin();
		 
	        byte[] byteMsg = nick.getBytes("utf8");
	        InetAddress serverAddress = Config.BROADCAST_ADDRESS;
	        
	        DatagramPacket message
            = new DatagramPacket(
            		byteMsg, byteMsg.length);
	        message.setAddress(serverAddress);
	        message.setPort(9000);	        
	        datagramSocket.send(message);
	        System.out.println("nadaję ci imię: "+ nick);	        
	}
	
	
	public void message_listener () throws IOException // zrobi� metod� kt�ra s�ucha na juz przydzielonym w konstruktorze porcie 
	{
		while (true){
			DatagramPacket reclievedPacket
            = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

			datagramSocket.receive(reclievedPacket);

			int length = reclievedPacket.getLength();
			String message = new String(reclievedPacket.getData(), 0, length, "utf8");
			InetAddress address = reclievedPacket.getAddress();
			String IP = address.toString();
			System.out.println(message);	
			MainTabbedPane.writeMessage(IP, message);
		}
	}
	
	int getPort ()
	{
		return port;
	}
	
	
}