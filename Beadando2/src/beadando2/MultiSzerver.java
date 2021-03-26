package beadando2;

import java.io.IOException;
import java.net.*;

public class MultiSzerver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket ss = new ServerSocket(1901);

		while (true) {
			new Thread(new MultiKiszolgalo(ss.accept())).start();

		}
	}

}
