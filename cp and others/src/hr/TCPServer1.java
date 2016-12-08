//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPServer1 extends Thread {
	private ServerSocket serverSocket;

	public TCPServer1(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(1000000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "
						+ server.getRemoteSocketAddress());

				DataInputStream in = new DataInputStream(
						server.getInputStream());
				String rcvedmsg = in.readUTF();

				System.out.println("Data from client:");
				String[] strarr = rcvedmsg.split(" ");
				System.out.println("IP1: " + strarr[0]);
				System.out.println("IP2: " + strarr[1]);
				System.out.println("subnet mask: " + strarr[2]);

				System.out.println("Logic for subnet processing...");

				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());
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
						arr0[i] = Integer.parseInt(str0[i]);
						arr1[i] = Integer.parseInt(str1[i]);
						arr2[i] = Integer.parseInt(str2[i]);
					}
				} catch (Exception nfe) {
					msg = "Please enter valid IP address or subnet mask";
					out.writeUTF(msg);
					System.out.println("Data sent to client");
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

				out.writeUTF(msg);

				System.out.println("Data sent to client");

				// server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		//int port = Integer.parseInt(args[0]);
		int port = 6604;
		try {
			Thread t = new TCPServer1(port);
			t.start();
			// t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
