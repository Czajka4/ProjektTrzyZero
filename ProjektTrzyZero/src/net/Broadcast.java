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
            		byteMsg, byteMsg.length, serverAddress, Config.PORT);
	        datagramSocket.send(message);
	        
	}
	//public static void main(String[] args) throws IOException {
		 
       // String message = "tekst";
       // InetAddress serverAddress = InetAddress.getByName("localhost");
       

       // DatagramSocket socket = new DatagramSocket(); //Otwarcie gniazda
        //byte[] stringContents = message.getBytes("utf8"); //Pobranie strumienia bajtów z wiadomosci

        //DatagramPacket sentPacket = new DatagramPacket(stringContents, stringContents.length);
       // sentPacket.setAddress(serverAddress);
        //sentPacket.setPort(Config.PORT);
        //socket.send(sentPacket);

        //DatagramPacket recievePacket = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);
        //socket.setSoTimeout(1010);

       // try{
        //    socket.receive(recievePacket);
        //    System.out.println("Serwer otrzymał wiadomość");
       // }catch (SocketTimeoutException ste){
       //     System.out.println("Serwer nie odpowiedział, więc albo dostał wiadomość albo nie...");
      //  }
   // }

}
