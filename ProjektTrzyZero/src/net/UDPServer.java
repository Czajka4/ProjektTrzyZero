package net;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import gui.User;

public class UDPServer {

	 static DatagramSocket datagramSocket;
	 static Random rand;
	 static int port;
	 public static ArrayList<InetAddress> clientAddresses; // dane do zak�adek --  maks 32 user�w na raz
	 public static ArrayList<Integer> clientPorts;
	 public static ArrayList<String> existingClients;
	 static Boolean exist = new Boolean(false);
	 
	 public UDPServer(int port)
	 {
		 this.port = port;
		 clientAddresses = new ArrayList(32);  // IP
	     clientPorts = new ArrayList(32); //port
	     existingClients = new ArrayList(32); //nick
	 }
	
	
    public static void serwer() throws Exception{

    	//Broadcast.hello();
        //Otwarcie gniazda z portem 9000 - tam szukamy nowych user�w
    	try{
    		datagramSocket = new DatagramSocket(port);
    		System.out.println(datagramSocket.getLocalPort() + "port");
    		}
    	catch (Exception BindException)
    	{    		
    		System.out.println("port nie dzia�a");// jezeli sprobujesz uruchomic dwa razy ten program to si� skraszuje bo nie mozna miec dwoch
    	} 											// wtyczek o tym samym porcie
    	
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
            
            for(int i=0;i<clientAddresses.size();i++){
                if(existingClients.get(i).equals(message)){
                    exist=true;
                    break;
                }
            }
            if(exist == false)
            {
            	existingClients.add(message); // dodanie do arraylist danych potrzebnych do stworzenia zak�adek
            	clientAddresses.add(address);
            	clientPorts.add(port);   
            	System.out.println("dodano użytkownika: "+message);
            }
           exist = false;

            DatagramPacket response
                    = new DatagramPacket(
                        byteResponse, byteResponse.length, address, port); // wysy�a okeja, ale nie mamy jeszcze s�uchania

            datagramSocket.send(response);
            System.out.println("wys�a�em wiadomo�� na: "+address+ "port: " + port); //potwierdzenie wys�ania okeja na adres ip i port
            
            
        }
    }
    public static ArrayList<User> sendUserData() {
    	ArrayList<User> UsersList = new ArrayList(32);
    	System.out.println("xd");
    	for(int nn=0; nn < clientAddresses.size(); nn++) {
    		UsersList.add(new User(existingClients.get(nn).toString(), clientAddresses.get(nn).toString(), clientPorts.get(nn)));
    		System.out.println(clientAddresses.get(nn).toString() + "x");
     	}    	 		
    	return UsersList;
    	    	
    }
    
    
    
}