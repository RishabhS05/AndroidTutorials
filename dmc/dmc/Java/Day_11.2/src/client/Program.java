package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Program
{
	public static final int PORT = 5241;
	public static void main(String[] args) 
	{
		DatagramSocket clientSocket = null;
		try( Scanner sc = new Scanner(System.in))
		{
			clientSocket = new DatagramSocket();
			String text = "";
			byte[] buffer = null;
			
			while( true )
			{
				System.out.print("C:Client	:	");
				text = sc.nextLine();
				buffer = text.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),PORT);
				clientSocket.send(sendPacket);
				
				buffer = new byte[ 1024 ];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				clientSocket.receive(receivePacket);
				text = new String( receivePacket.getData());
				System.out.println("C:Server	:	"+text);
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			clientSocket.close();
		}
	}
		
}
