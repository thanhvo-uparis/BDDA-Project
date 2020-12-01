import java.io.File;

public class DiskManager {
       
	
	/**fileIdx un entier correspondant à un identifiant/ indice de ficher.
	 * 
	 * @param fileIdx
	 */
	  public void createFile(int fileIdx) {
		  
	  }

	  
	  /**
	   * 
	   * @param fileIdx
	   * @return
	   */
	  public PageId addpage(int fileIdx) {
		  File file= new File("D:\\Projet_BDDA_VO_BOUJEMAA\\BD\\Data_"+fileIdx);
		  
		  if(file.exists()) {
			  double octets = file.length();
			  System.out.println("La taille du fichier est: "+octets);
			  
			  int compteur = (int)octets/4096;
			  }
		  
	  }
	  
	  /**
	   * 
	   * @param pageId
	   */
	  public void readPage(int pageId, ) {
		  
	  }
	  
	  public void writePage() {
		  
	  }
}
