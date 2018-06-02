package net;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Config {
    public static final int PORT = 9000;
    public static final int BUFFER_SIZE = 1024;
    public static final InetAddress MULTICAST_ADDRESS;
    public static final InetAddress IP_ADDRESS;
    public static final int MULTICAST_PORT = 9000;
    public static final InetAddress BROADCAST_ADDRESS;
    static {
        try{
            MULTICAST_ADDRESS = InetAddress.getByName("239.255.42.99");
            IP_ADDRESS = InetAddress.getByName("192.168.1.208");
            BROADCAST_ADDRESS = InetAddress.getByName("192.168.1.255");
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }
    }
}