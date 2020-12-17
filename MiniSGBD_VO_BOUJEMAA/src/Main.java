
import java.io.File;

public class Main {

	public static void main(String[] args) {
 
		String path = "";
		if (args.length>0)
			path = args[0];
		DBParams.DBPath = path + File.separator;
		DBParams.frameCount = 2;
		DBManager.getInstance().init();
//		DiskManager obj = new DiskManager();
//		obj.CreateFile(0);
//		System.out.println(obj.AddPage(0));
	}

}