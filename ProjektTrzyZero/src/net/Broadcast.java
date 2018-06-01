package net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Broadcast {
	static DatagramSocket datagramSocket;
	
	public static void send_message(String msg) throws IOException
	{
		 datagramSocket = new DatagramSocket();

	        byte[] byteMsg = msg.getBytes("utf8");
	        InetAddress serverAddress = InetAddress.getByName("localhost");
	        System.out.println(serverAddress);
	        DatagramPacket message
            = new DatagramPacket(
            		byteMsg, byteMsg.length);
	        message.setAddress(serverAddress);
	        message.setPort(Config.PORT);
	        datagramSocket.send(message);
	        
	}
}