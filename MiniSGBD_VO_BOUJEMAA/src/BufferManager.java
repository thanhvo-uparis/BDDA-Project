
public class BufferManager {
	private static BufferManager buffermanager;
	
	public static BufferManager getInstance() {
		if(buffermanager == null)
			buffermanager = new BufferManager(); 
		return buffermanager;
	}
	
}