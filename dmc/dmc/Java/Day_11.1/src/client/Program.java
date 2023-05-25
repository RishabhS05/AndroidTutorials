package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Program
{
	public static final String HOST = "localhost";
	public static final int PORT = 5413;
	public static void main(String[] args) 
	{
		Socket socket = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		try
		{
			socket = new Socket(HOST, PORT);
			inputStream = new DataInputStream( new BufferedInputStream(socket.getInputStream()));
			outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			try( Scanner sc = new Scanner(System.in))
			{
				String text = "";
				
				do
				{
					text = inputStream.readUTF();
					System.out.println("C:Server	:	"+text);
					
					System.out.print("C:Client	:	");
					text = sc.nextLine();
					outputStream.writeUTF(text);
					outputStream.flush();
				}while( !text.equalsIgnoreCase("end"));
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			try
			{
				socket.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
