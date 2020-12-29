
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    /**
     * GENERATE RANDOM INPUT
     */

    // parametri "regolabili"
    private static final int OR_count = 10;
    private static final int SP_count = 5;
    private static final int D_count = 5;
    private static final int S_per_day_count = 2;
    private static final int S_count = D_count * S_per_day_count;
    private static final int ERROR = 10;


    public static void main(String[] args) {

	String windowsPath = "C:\\Users\\marco\\Google Drive\\Università degli Studi di Genova\\MS-TesiTriennale-MSSP\\Encoding\\input_MSS.lp";
	String javaPath = windowsPath.replace("\\", "/"); // Create a new variable
	FileWriter fileWriter;
	try {
	    fileWriter = new FileWriter(javaPath);
	    // System.out.print("file trovato");

	    StringBuilder sb = new StringBuilder();
	    // costanti
	    sb.append("#const or_count = " + OR_count + ".\n");
	    sb.append("#const sp_count = " + SP_count + ".\n");
	    sb.append("#const d_count = " + D_count + ".\n");
	    sb.append("#const s_count = " + S_count + ".\n\n");

	    sb.append("specialty(1.." + SP_count + ").\n\n");
	    sb.append("sessionID(1.." + S_count + ").\n\n");
	    sb.append("planningDay(1.." + D_count + ").\n\n");
	    sb.append("hours(6).\n\n");

	    generateTargetShare myTS = new generateTargetShare(SP_count);
	    int[] targetShare = myTS.generate();
	    for (int i = 1; i <= SP_count; i++) {
		sb.append("targetShare(" + i + ", " + targetShare[i - 1] + ", " + ERROR +  ").\n");
	    }

	    sb.append("\n");
	    generateOperatingRoom myOR = new generateOperatingRoom(OR_count, SP_count);
	    boolean[][] operatingRoom = myOR.generate();
	    for (int i = 0; i < OR_count; i++) {
		for (int j = 0; j < SP_count; j++) {
		    if (operatingRoom[i][j] == true)
			sb.append("operatingRoom(" + (i + 1) + ", " + (j + 1) + ").\n");
		}
	    }

	    fileWriter.write(sb.toString());
	    fileWriter.close();
	} catch (IOException e) {
	    System.out.print("file non trovato");
	    e.printStackTrace();
	}
    }

}