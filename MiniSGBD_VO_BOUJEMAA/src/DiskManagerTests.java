


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class DiskManagerTest {

	DiskManager diskmanager = new DiskManager();
	
	@Test
	@Order(1)
	void createfiletest() {
		System.out.println("Create File test");
		DBParams.DBPath = "Project_BDDA"+File.separator;
		DBParams.pageSize = 4096;
		diskmanager.CreateFile(0);
		File file = new File("Project_BDDA"+File.separator+"Data_0.rf");
		assertEquals(true,file.exists());
	}
	
	@Test
	@Order(2)
	void addpagetest()
	{
		System.out.println("add page test");
		DBParams.pageSize = 4096;
		DBParams.DBPath = "Project_BDDA" + File.separator; 
		assertEquals(1, diskmanager.AddPage(0) );
	}

	
	@Test
	@Order(3)
	void writepagetest() {
		System.out.println("write page test and read");
		DBParams.pageSize = 4096;
		DBParams.DBPath = "Project_BDDA"+File.separator; 
		byte []buff = new byte[DBParams.pageSize];
		for(int i=0;i<DBParams.pageSize;i++)
			buff[i] = 1;
		byte []buffreader= null;
		diskmanager.WritePage("0,0", buff);
		buffreader = diskmanager.ReadPage("0,0", buffreader); 
		assertArrayEquals(buff, buffreader);
	}


}
