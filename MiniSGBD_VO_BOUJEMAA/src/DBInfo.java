


import java.util.ArrayList;

public class DBInfo {
	private static DBInfo dbInfo;
	ArrayList<RelationInfo> relationinfos = new ArrayList<RelationInfo>();
	int counter = 0;
	public static DBInfo getInstance() {
		if(dbInfo == null)
			dbInfo = new DBInfo();
		
		return dbInfo;
	}
 


	void init() {

		
	}
	void finish() {
		
	}
	void addRelation(RelationInfo relationInfo) {
		relationinfos.add(relationInfo);
		counter++;
		
	}
	
	@Override
	public String toString() {
		return "DBInfo [relationinfos=" + relationinfos + ", counter=" + counter + "]";
	}
}
