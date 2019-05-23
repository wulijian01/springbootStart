public class SingletonTest {

	private SingletonTest() {};
	
	public static class singletonGet {
		
		public static final SingletonTest instance = new SingletonTest();
	}
	
	   public static final SingletonTest getInstance() {
	        return singletonGet.instance;
	    }
	
}
