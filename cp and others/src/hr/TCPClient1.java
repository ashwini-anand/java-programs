//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class TCPClient1 {
	public static void main(String[] args) {
		String serverName = args[0];
		InetAddress IPAddress=null;
		try {
			IPAddress = InetAddress.getByName(serverName);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		//int port = Integer.parseInt(args[1]);
		int port = 6604;
		
		try {

			System.out.println("Connecting to " + serverName + " on port "
					+ port);
			
			Socket client = new Socket(IPAddress, port);
			System.out.println("Just connected to "
					+ client.getRemoteSocketAddress());
			
			System.out.println("Enter IP1");
			Scanner s= new Scanner(System.in);
			String ip1 = s.nextLine();
			System.out.println("Enter ip2");
			String ip2 = s.nextLine();
			System.out.println("Enter subnet mask");
			String smask = s.nextLine();
			
			String msg = ip1+" "+ip2+" "+smask;
			
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF(msg);
			System.out.println("Data sent to server");
			
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says: " + in.readUTF());
			
			client.close();
			s.close();
		}catch(ConnectException ce){
			System.out.println("Please enter correct port number and IP address");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
