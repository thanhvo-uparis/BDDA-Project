
import java.util.ArrayList;

public class RelationInfo {

	String relation;
	int number; 
	ArrayList<CollInfo> columns = new ArrayList<>();
	
	RelationInfo(String rel,int num, CollInfo col){
		relation = rel;
		number = num;
		columns.add(col);
	}

	@Override
	public String toString() {
		return "RelationInfo [relation=" + relation + ", number=" + number + ", columns=" + columns + "]";
	}
}
