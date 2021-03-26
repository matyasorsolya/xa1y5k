package beadando2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MultiKiszolgalo implements Runnable {

	private Socket s;

	public MultiKiszolgalo(Socket s) {

		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		BufferedReader br;
		
		//d�tumoz�s elk�sz�t�se
		Date datum = Calendar.getInstance().getTime();
		DateFormat datumforma = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String datumozas = datumforma.format(datum);

		try {
			//beolvassuk az �zenetet, amit a kliens k�ld�tt
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String uzenet = br.readLine();
			
			//d�tum + �zenet kiirat�sa a konzolba
			System.out.println(datumozas + " : " + uzenet);

			//napl�z� file elk�sz�t�se �s felt�lt�se tartalommal
			String szovegesallomany = "naplozas.txt";
			FileWriter fw = new FileWriter(szovegesallomany, true);
			fw.write(datumozas + " : " + uzenet+"\n");
			
			//napl�z� file z�r�sa
			fw.close();

			//v�lasz�zenet a kliensnek
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println("Az �zenet�t mentett�k");

			pw.flush();
			br.close();
			pw.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
