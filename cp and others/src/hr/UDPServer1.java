//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer1 {
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
			String rcvedmsg = new String(receivePacket.getData());
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			System.out.println("Data from client "+IPAddress+" :");
			String[] strarr = rcvedmsg.split(" ");
			System.out.println("IP1: " + strarr[0]);
			System.out.println("IP2: " + strarr[1]);
			System.out.println("subnet mask: " + strarr[2]);

			System.out.println("Logic for subnet processing...");
			
			String msg;
			int[] arr0 = new int[4];
			int[] arr1 = new int[4];
			int[] arr2 = new int[4];
			try {
				String[] str0 = strarr[0].split("\\.");
				String[] str1 = strarr[1].split("\\.");
				String[] str2 = strarr[2].split("\\.");

				// System.out.println(Arrays.toString(str0));

				for (int i = 0; i < arr2.length; i++) {
					arr0[i] = Integer.parseInt(str0[i].trim());
					arr1[i] = Integer.parseInt(str1[i].trim());
					arr2[i] = Integer.parseInt(str2[i].trim());
				}
			} catch (Exception nfe) {
				msg = "Please enter valid IP address or subnet mask";
				sendData = msg.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
				System.out.println("Data sent to client");
				receiveData = new byte[1024];
				continue;
			}
			int flag = 0;
			for (int i = 0; i < arr2.length; i++) {
				int t0 = (arr0[i] & arr2[i]);
				int t1 = (arr1[i] & arr2[i]);
				if (t1 != t0) {
					flag = 1;
					break;
				}
			}

			System.out.println("Logic for subnet check done");

			if (flag == 0) {
				msg = "Both the IP addresses are in same network.";
			} else {
				msg = "Both the IP addresses are not in same network.";
			}
			sendData = msg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			System.out.println("Data sent to client");
			receiveData = new byte[1024];
		}
	}
}
