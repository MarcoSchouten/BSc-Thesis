package formatOutput;
import java.util.Comparator;

public class sortSession implements Comparator<MSS>{

    @Override
    public int compare(MSS o1, MSS o2) {
	if (o1.session < o2.session)
	    return -1;
	else return 
		1;
    }
}

