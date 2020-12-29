import java.util.Arrays;

public class generateOperatingRoom {

    private int SP_count;
    private int OR_count;

    public generateOperatingRoom(int orCount, int spCount) {
	this.SP_count = spCount;
	this.OR_count = orCount;
    }

    public boolean[][] generate() {

	boolean[][] operatingRoom = new boolean[OR_count][SP_count];

	boolean[] working_specialties = new boolean[SP_count];
	Arrays.fill(working_specialties, false);
	int counter_tries = 0;
	do {
	for (int i = 0; i < OR_count; i++) {
	    boolean[] type = generateType();
	    for (int j = 0; j < SP_count; j++) {
		if (type[j] == true) {
		    operatingRoom[i][j] = true;
		    working_specialties[j] = true;
		}

	    }
	}
	counter_tries++;
	// System.out.println("try # " + counter_tries);

	} while (not_all_specialties_work(working_specialties));

	
	System.out.println("Found protected input istance at try #" + counter_tries);

	return operatingRoom;
    }

    private boolean not_all_specialties_work(boolean[] working_specialties) {
	for (int i = 0; i < working_specialties.length; i++) {
	    if (working_specialties[i] == false)
		return true;
	}
	return false;
    }

    public static double getRandomNumber() {
	return floor(Math.random());
    }

    public static double floor(double x) {
	return Math.floor(x * 100) / 100;
    }

    public boolean[] generateType() {
	boolean[] res = new boolean[SP_count];
	Arrays.fill(res, false);
	do {
	    for (int i = 0; i < SP_count; i++) {
		double n = getRandomNumber();
		// System.out.print("randomnum:" + n +" ");
		if (n > 0.6)
		    res[i] = true;
		else
		    res[i] = false;
	    }
	    //for (int i = 0; i < SP_count; i++) {
	//	System.out.print(res[i] + " ");
	  //  }
	} while (son_tutte_false(res));
	return res;
    }

    private boolean son_tutte_false(boolean[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == true)
		return false;
	}
	return true;
    }
}
