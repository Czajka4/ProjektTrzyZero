package net;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	 static DatagramSocket datagramSocket;
	
	
    public static void serwer() throws Exception{

        //Otwarcie gniazda z okreslonym portem
    	try{
    		datagramSocket = new DatagramSocket(Config.PORT);
    		}
    	catch (Exception BindException)
    	{
    		datagramSocket = new DatagramSocket(9001);
    	}
    	
        byte[] byteResponse = "OK".getBytes("utf8");

        while (true){

            DatagramPacket reclievedPacket
                    = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

            datagramSocket.receive(reclievedPacket);

            int length = reclievedPacket.getLength();
            String message =
                    new String(reclievedPacket.getData(), 0, length, "utf8");

            // Port i host który wysłał nam zapytanie
            InetAddress address = reclievedPacket.getAddress();
            int port = reclievedPacket.getPort();

            System.out.println(message);
           

            DatagramPacket response
                    = new DatagramPacket(
                        byteResponse, byteResponse.length, address, port);

            datagramSocket.send(response);
        }
    }
    
}