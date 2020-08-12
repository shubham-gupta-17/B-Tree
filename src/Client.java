import oui.*;

public class Client {

	public static void main(String[] args) throws Exception {
		DataManager.basedir = args[0];   // set a static property by name basedirectory where datamanager will store all
						//the data and tree , args[0] -> means through command line we will pass a directory address where it can store 
						
		App app = new App();   // create new app
	}
}
