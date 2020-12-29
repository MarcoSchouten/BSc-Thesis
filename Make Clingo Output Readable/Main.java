package formatOutput;



import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Main {
    /**
     * FORMAT MSS_OUTPUT
     */

    private static final int OR_count = 10;
    private static final int D_count = 5;
    private static final int S_per_day_count = 2;
    private static final int S_count = D_count * S_per_day_count;


    public static void main(String[] args) throws IOException {
	
	// ---------------------------------parse JSON FILE-----------------------------------------
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
	// System.out.println("\n\n\n" + sb.toString() + "\n\n\n"); // stampa

	
	
	// --------------------------------- FORMAT  -----------------------------------------------
	//String test = sc.nextLine();
	//System.out.println("\n\n\n" + test + "\n\n\n"); // stampa
	FileReader f = new FileReader("input.txt");
	Scanner sc = new Scanner(f);
	String[] raw_input = sb.toString().split(" "); //FROM JSON
	//String[] raw_input = sc.nextLine().split(" "); //FROM TEXT
	ArrayList<MSS> input = new ArrayList<MSS>();

	for (String s : raw_input) {
	    MSS data = new MSS();
	    data.parse(s);
	    input.add(data);
	}
	// Collections.sort(input, new sortDay());
	// Collections.sort(input, new sortRoom());
	// check input letto correttamente
	// System.out.println("OR, S, SP, Day");
	// for (MSS d : input)
	// System.out.println(d.toString());

	int[][] mat = new int[OR_count][S_count];

	// riempio la matrice
	for (int i = 0; i < input.size(); i++)
	    mat[input.get(i).room - 1][input.get(i).session - 1] = input.get(i).specialty;

	// formatto output
	System.out.print("    Session\n    ");
	for (int i = 0; i < S_count; i++)
	    System.out.print((i + 1) + " ");
	System.out.print("\nOR ");
	for (int i = 0; i < S_count; i++)
	    System.out.print("__");
	System.out.print("\n");
	for (int i = 0; i < OR_count; i++) {
	    System.out.print((i + 1) + " | ");
	    for (int j = 0; j < S_count; j++)
		System.out.print(mat[i][j] + " ");
	    System.out.print("\n");
	}

	sc.close();
    }
}
