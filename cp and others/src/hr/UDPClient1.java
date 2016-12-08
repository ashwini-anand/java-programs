//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient1 {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(args[0]);
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		System.out.println("Enter IP1");
		String ip1 = s.nextLine();
		System.out.println("Enter ip2");
		String ip2 = s.nextLine();
		System.out.println("Enter subnet mask");
		String smask = s.nextLine();
		
		String msg = ip1+" "+ip2+" "+smask;
		sendData = msg.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);
		System.out.println("Data sent to server");
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData,
				receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}
}
