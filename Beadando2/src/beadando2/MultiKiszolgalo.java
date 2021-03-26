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
		
		//dátumozás elkészítése
		Date datum = Calendar.getInstance().getTime();
		DateFormat datumforma = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String datumozas = datumforma.format(datum);

		try {
			//beolvassuk az üzenetet, amit a kliens küldött
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String uzenet = br.readLine();
			
			//dátum + üzenet kiiratása a konzolba
			System.out.println(datumozas + " : " + uzenet);

			//naplózó file elkészítése és feltöltése tartalommal
			String szovegesallomany = "naplozas.txt";
			FileWriter fw = new FileWriter(szovegesallomany, true);
			fw.write(datumozas + " : " + uzenet+"\n");
			
			//naplózó file zárása
			fw.close();

			//válaszüzenet a kliensnek
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println("Az üzenetét mentettük");

			pw.flush();
			br.close();
			pw.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
