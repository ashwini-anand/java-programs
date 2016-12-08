//package hr;
//Ashwini Anand MT2015032
//Paresh Pankhaniya  MT2015073
import java.net.*;
import java.util.Arrays;
import java.io.*;

public class TCPArrayServer extends Thread {
	private ServerSocket serverSocket;

	public TCPArrayServer(int port) throws IOException {
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
				System.out.println("Data from client:" + rcvedmsg);

				System.out.println("Processing...");

				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());

				String sortedarr;
				try {
					String[] strarr = rcvedmsg.split("\\s+");
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
					out.writeUTF(msg);
					System.out.println("Data sent to client");
					continue;
                
				}
				System.out.println("Processing done");

				out.writeUTF("Sorted array is " + sortedarr + "\n");

				System.out.println("Data sent to client");

				server.close();
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
			Thread t = new TCPArrayServer(port);
			t.start();
			// t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
