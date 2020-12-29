package _MSS_print_to_CSV;

public class EffectiveShare {
    public int SP;
    public int ES;
    
  
    
    public void parse(String s) {
	String result = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
	String values[] = result.split(",");
	this.SP = Integer.parseInt(values[0]); 
	this.ES = Integer.parseInt(values[1]); 
    }



    public void print() {
	String str = "[" + SP + " " + ES + "]";
	System.out.println(str);
    }

    

}
