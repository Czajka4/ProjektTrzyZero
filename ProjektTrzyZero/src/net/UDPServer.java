package net;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class UDPServer {

	 static DatagramSocket datagramSocket;
	 static Random rand;
	 static int port;
	 public static ArrayList<InetAddress> clientAddresses; // dane do zak³adek --  maks 32 userów na raz
	 public static ArrayList<Integer> clientPorts;
	 public static ArrayList<String> existingClients;
	 
	 public UDPServer(int port)
	 {
		 this.port = port;
		 clientAddresses = new ArrayList(32); 
	     clientPorts = new ArrayList(32);
	     existingClients = new ArrayList(32);
	 }
	
	
    public static void serwer() throws Exception{

        //Otwarcie gniazda z portem 9000 - tam szukamy nowych userów
    	try{
    		datagramSocket = new DatagramSocket(port);
    		System.out.println(datagramSocket.getLocalPort() + "port");
    		}
    	catch (Exception BindException)
    	{
    		
    		
    		System.out.println("port nie dzia³a");// jezeli sprobujesz uruchomic dwa razy ten program to siê skraszuje bo nie mozna miec dwoch
    	} 											// wtyczek o tym samym porcie
    	
        byte[] byteResponse = "OK".getBytes("utf8"); 

        while (true){

            DatagramPacket reclievedPacket
                    = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

            datagramSocket.receive(reclievedPacket);

            int length = reclievedPacket.getLength();
            String message =
                    new String(reclievedPacket.getData(), 0, length, "utf8");
            System.out.println(message);
             // Port i host ktÃ³ry wysÅ‚aÅ‚ nam zapytanie
            InetAddress address = reclievedPacket.getAddress();
            int port = reclievedPacket.getPort();
           
            existingClients.add(message); // dodanie do arraylist danych potrzebnych do stworzenia zak³adek
            clientAddresses.add(address);
            clientPorts.add(port);
            
           
           

            
           

            DatagramPacket response
                    = new DatagramPacket(
                        byteResponse, byteResponse.length, address, port); // wysy³a okeja, ale nie mamy jeszcze s³uchania

            datagramSocket.send(response);
            System.out.println("wys³a³em wiadomoœæ na: "+address+ "port: " + port); //potwierdzenie wys³ania okeja na adres ip i port
        }
    }
    
}