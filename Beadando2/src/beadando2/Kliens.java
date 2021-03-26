package beadando2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Kliens {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		
		Socket s = new Socket("localhost", 1901);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		
		//�zenet bek�r�se a felhaszn�l�t�l
		String uzenet = JOptionPane.showInputDialog("T�rolni k�v�nt �zenet: ");
		
		System.out.println("A t�rolni k�v�nt �zenenet: " + uzenet);
		pw.println(uzenet);
	
		pw.flush();

		//Szerver v�lasz�nak beolvas�sa
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String valasz = br.readLine();

		System.out.println("A szerver valasza: " + valasz);

		br.close();
		pw.close();

	}

}
