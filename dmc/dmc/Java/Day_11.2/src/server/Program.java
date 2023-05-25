package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Program 
{
	public static final int PORT = 5241;
	public static void main(String[] args) 
	{
		DatagramSocket serverSocket = null;
		try( Scanner sc = new Scanner(System.in))
		{
			serverSocket = new DatagramSocket( PORT );
			String text = "";
			byte[] buffer = null;
			
			while( true )
			{
				buffer = new byte[ 1024 ];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				serverSocket.receive(receivePacket);
				text = new String( receivePacket.getData());
				System.out.println("S:Client	:	"+text);
				
				System.out.print("S:Server	:	");
				text = sc.nextLine();
				buffer = text.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, receivePacket.getAddress(), receivePacket.getPort());
				serverSocket.send(sendPacket);
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			serverSocket.close();
		}
	}
}
