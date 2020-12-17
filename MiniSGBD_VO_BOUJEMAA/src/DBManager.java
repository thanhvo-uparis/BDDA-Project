
import java.util.Scanner;

public class DBManager {

	private static DBManager dbmanager = null;
	
	public static DBManager getInstance() {
		if(dbmanager == null)
			dbmanager = new DBManager();
		
		return dbmanager;
	}
	void init() {
		String command;
		Scanner scan = new Scanner(System.in); 
		do
		{
			System.out.println("CREATEREL");
			System.out.println("Exit");
			command = scan.nextLine();
			ProcessCommand(command);
			System.out.println(DBInfo.getInstance());
		}while(!command.equalsIgnoreCase("Exit"));
		scan.close();
	}
	
	void finish() {
		System.exit(0);
	}
	void ProcessCommand(String command)
	{
		if(command.startsWith("CREATEREL"))
		{
			if(command.contains("R"))
			{
				String line[] = command.split(" ");
				for(int i=2;i<line.length;i++)
				{
					String data[] = line[i].split(":");
					DBInfo.getInstance().addRelation(new RelationInfo(line[1].trim(), 0, new CollInfo(data[0], data[1])));
				}
			}
		}
		else if (command == "EXIT")
			finish();
	}
}

