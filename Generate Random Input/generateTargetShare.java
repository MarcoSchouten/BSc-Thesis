
public class generateTargetShare {

    private int SP_count;

    public generateTargetShare(int SP_count) {
	this.SP_count = SP_count;

    }

    public int[] generate() {
	int[] targetShare = new int[SP_count];
	int sum = 0;
	for (int i = 0; i < targetShare.length; i++) {
	    targetShare[i] = (int) (getRandomNumber() * 100);
	    sum = sum + targetShare[i];
	    // System.out.println("aggiunto " + targetShare[i]);
	}
	// System.out.println("sum " + sum);
	double doubsum = sum;
	double factor = (100 / doubsum);
	// System.out.println("factor " + factor);
	int rest = 0;
	for (int i = 0; i < targetShare.length - 1; i++) {
	    // System.out.println("sum:" + sum+ " array" + targetShare[i]);
	    targetShare[i] = (int) (targetShare[i] * factor);
	    rest += targetShare[i];
	}
	targetShare[targetShare.length - 1] = (100 - rest);

	return targetShare;
    }

    public static double getRandomNumber() {
	return floor(Math.random());
    }

    public static double floor(double x) {
	return Math.floor(x * 100) / 100;
    }
}
