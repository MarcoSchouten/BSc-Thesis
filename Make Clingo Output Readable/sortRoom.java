package formatOutput;
import java.util.Comparator;

public class sortRoom implements Comparator<MSS>{

    @Override
    public int compare(MSS o1, MSS o2) {
	if (o1.room < o2.room)
	    return -1;
	else return 
		1;
    }
}

