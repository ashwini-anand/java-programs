//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073

import java.net.*;
import java.util.Arrays;

class UDPServer {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			System.out.println("Waiting for client on port "
					+ serverSocket.getLocalPort() + "...");
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("Data received from client: " + sentence);

			System.out.println("Processing...");

			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			String sortedarr;
			DatagramPacket sendPacket;
			try {
				String[] strarr = sentence.split("\\s+");
				if (strarr.length > 5) {
					throw new Exception("Array length more than 5");
				}
				int[] arr = new int[5];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(strarr[i].trim());
				}
				Arrays.sort(arr);
				sortedarr = Arrays.toString(arr);
			} catch (Exception ee) {
				String msg = "Please enter valid Integer array of size 5";
				sendData = msg.getBytes();
				sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
				System.out.println("Data sent to client");
				receiveData = new byte[1024];
				continue;
			}
			System.out.println("Processing done");

			sendData = sortedarr.getBytes();
			sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			System.out.println("Data sent to client");
			receiveData = new byte[1024];
		}
	}
}