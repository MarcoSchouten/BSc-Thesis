package _MSS_print_to_CSV;

public class TargetShare {
    public int SP;
    public int TS;

    public void parse(String s) {
	String result = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
	String values[] = result.split(",");
	this.SP = Integer.parseInt(values[0]);
	this.TS = Integer.parseInt(values[1]);
    }

    public void print() {
	String str = "[" + SP + " " + TS + "]";
	System.out.println(str);
    }

}
