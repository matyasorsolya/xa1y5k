package Kod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Betucsere {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("proba.txt"));
		PrintWriter pw = new PrintWriter("uj.txt");
		StringBuilder kodolas = new StringBuilder();

		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			char[] betu = line.toCharArray();

			for (int i = 0; i < betu.length; i++) {
				if (Character.toLowerCase(betu[i]) != 'z' && Character.isLetter(betu[i])) {

					char kovetkezo = (char) ((int) betu[i] + 1);
					kodolas.append(kovetkezo);
				} else {
				
					kodolas.append(betu[i]);
				}

			}

			line = br.readLine();
			
		}
		
		
		System.out.println(kodolas.toString());
		
		pw.println(kodolas.toString());
		
		
		pw.flush();
		pw.close();
		br.close();
		
		

	}

}
