package formatOutput;
import java.util.Comparator;

public class sortDay implements Comparator<MSS>{

    @Override
    public int compare(MSS o1, MSS o2) {
	if (o1.day < o2.day)
	    return -1;
	else return 
		1;
    }
}

