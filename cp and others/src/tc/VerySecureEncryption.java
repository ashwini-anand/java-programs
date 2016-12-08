package tc;

public class VerySecureEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] key = {1,2,0};
//		System.out.println(encrypt("abc",key,1));

	}

	public static String encrypt(String message, int[] key, int K) {

		char[] msg = message.toCharArray();

		char[] msg1 = new char[msg.length];

		for (int i = 0; i < msg1.length; i++) {
			msg1[i] = msg[i];
		}

		for (int j = 0; j < K; j++) {

			for (int i = 0; i < key.length; i++) {
				msg1[key[i]] = msg[i];
			}
			for (int i = 0; i < msg1.length; i++) {
				msg[i] = msg1[i];
			}
		}
		
		String b = new String(msg);
		return b;

	}
}
