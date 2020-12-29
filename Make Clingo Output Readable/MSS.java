package formatOutput;

public class MSS {
    public int room;
    public int session;
    public int specialty;
    public int day;
    
    public MSS() {
	this.room = -1;
	this.session = -1;
	this.specialty = -1;
	this.day = -1;
    }
    public void parse(String s) {
	
	String result = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
	String values[] = result.split(",");
	this.room = Integer.parseInt(values[0]); 
	this.session = Integer.parseInt(values[1]); 
	this.specialty = Integer.parseInt(values[2]); 
	this.day = Integer.parseInt(values[3]); 
    }
    public String toString() {
	String str = "[" + room + " " + session + " " + specialty + " " + day + "]" ;
	return str;
    }
    
   

}

//mss(5,1,1,1)
