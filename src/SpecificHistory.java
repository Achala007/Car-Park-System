import java.util.ArrayList;

public class SpecificHistory {
	ArrayList<String> Line = new ArrayList<String>();

	public void add(String info) {
		Line.add(info);
	}
	
	public void printLine(){
		if(Line.size() > 0){
			for (String iterator : Line){
				System.out.println(iterator);
			}
		}
	}
}
