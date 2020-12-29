/**






 

**************** COMPUTE STATISTICS *********************





 */

package _MSS_print_to_CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Main {

    public static void main(String[] args) throws IOException {

	// ---------------------------------parse JSON
	// FILE-----------------------------------------
	String windowsPath = "C:\\Users\\marco\\Google Drive\\MS-TesiTriennale-MSSP\\Encoding\\output_MSS.json";

	String content = Files.readString(Paths.get(windowsPath)); // get stringa
	Object obj = JSONValue.parse(content); // parse stringa
	JSONObject json_ob1 = (JSONObject) obj; // cast
	// System.out.println(json_ob1); // stampa
	JSONArray call = (JSONArray) json_ob1.get("Call"); // get array
	Object wit_string = call.get(0); // get element of array

	String content2 = wit_string.toString(); // get stringa
	obj = JSONValue.parse(content2); // parse stringa
	JSONObject json_ob2 = (JSONObject) obj; // cast
	// System.out.println("\n\n\n" + json_ob2); // stampa
	JSONArray witnesses = (JSONArray) json_ob2.get("Witnesses"); // get array
	Object val_String = witnesses.get(0); // get element of array

	String content3 = val_String.toString(); // get stringa
	obj = JSONValue.parse(content3); // parse stringa
	JSONObject json_ob3 = (JSONObject) obj; // cast
	// System.out.println("\n\n\n" + json_ob3 + "\n\n\n"); // stampa
	JSONArray value = (JSONArray) json_ob3.get("Value");
	Iterator<String> iterator = value.iterator();
	StringBuilder sb = new StringBuilder();
	while (iterator.hasNext()) {
	    sb.append(iterator.next() + " ");
	}
	//System.out.println("\n\n\n" + sb.toString() + "\n\n\n"); // stampa

	// SB CONTIENE LA STRINGA VALUE

	JSONObject time = (JSONObject) json_ob1.get("Time");
	Double realtime = (Double) time.get("Total");
	//System.out.println("\n\n\n" + realtime.toString() + "\n\n\n");
	// REALTIME

	// --------------------------------- FORMAT
	// -----------------------------------------------

	String[] raw_input = sb.toString().split(" ");
	ArrayList<TargetShare> targetShare = new ArrayList<TargetShare>();
	ArrayList<EffectiveShare> effectiveShare = new ArrayList<EffectiveShare>();

	for (String s : raw_input) {
	    // System.out.println("Analizzo:" + s);
	    // System.out.println("primo char:" + s.charAt(0));
	    char c = s.charAt(0);
	    // System.out.println("c:" + c);
	    if (c == 't') {
		TargetShare tar = new TargetShare();
		tar.parse(s);
		targetShare.add(tar);
	    } else if (c == 'e') {
		EffectiveShare eff = new EffectiveShare();
		eff.parse(s);
		effectiveShare.add(eff);
	    } else
		System.out.print("qualcosa e' andato storto");
	}

	// check se ho letto bene
	//for (TargetShare t : targetShare) {
	 //   t.print();
	//}
	// check se ho letto bene
	//for (EffectiveShare e : effectiveShare) {
	 //   e.print();
	//}
	
	// --------------------------------- calcoli statistiche
	// calcolo errore complessivo
	int diff = 0;
	int errorComplessivo = 0 ;
	for (int i = 0; i < targetShare.size(); i++) {
	    diff = Math.abs(targetShare.get(i).TS - effectiveShare.get(i).ES);
	    errorComplessivo+=diff;
	}
	
	System.out.println("Error: " +errorComplessivo);
	System.out.println("Time: "  + realtime);
	
	

    }

}
