
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class DiskManager {
	
	void CreateFile (int fileIdx ) {
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(DBParams.DBPath + "Data_"+fileIdx+".rf","rw");
			
		  } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		  }
	}
	 
	
	int AddPage(int fileIdx)
	{
		RandomAccessFile file; 
		try {	
			file = new RandomAccessFile(DBParams.DBPath + "Data_"+fileIdx+".rf","rw");
			long len = file.length();
			file.seek(len);
			file.write(new byte[DBParams.pageSize]); 
			len = file.length();
			return (int) (len/DBParams.pageSize);
		  } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		  }catch (IOException e) { 
			e.printStackTrace();
		  }
		
		return 0;
		
	}
	
	byte[] ReadPage(String pageId, byte[] buff)
	{
		String div[] = pageId.split(",");
		String fileIdx = div[0];
		int pageid = Integer.valueOf(div[1]);
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(DBParams.DBPath + "Data_"+fileIdx+".rf","r");
			buff = new byte[(int) DBParams.pageSize];
			pageid *= DBParams.pageSize; 
			file.read(buff, pageid, DBParams.pageSize);
			return buff;
		  } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		  }catch (IOException e) { 
			e.printStackTrace();
		  }
		return null;
		
	}
	
	void WritePage(String pageid, byte[] buff)
	{
		String div[] = pageid.split(",");
		String fileIdx = div[0];
		int pageId = Integer.valueOf(div[1]);
		
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(DBParams.DBPath + "Data_"+fileIdx+".rf","rw");
			pageId *= DBParams.pageSize; 
			file.write(buff, pageId, DBParams.pageSize);
		  } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		  }catch (IOException e) { 
			e.printStackTrace();
		  }
		
	}
}
