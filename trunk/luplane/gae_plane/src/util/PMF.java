package util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");
	private static final ThreadLocal<PersistenceManager> threadLocal = new ThreadLocal<PersistenceManager>();
	private PMF(){}
	
	public static PersistenceManagerFactory get() {
        return pmfInstance;
    }

	public static PersistenceManager getManager(){
		PersistenceManager manager = threadLocal.get();
		if(manager== null){
			manager = pmfInstance.getPersistenceManager();
			threadLocal.set(manager);
		}
		return manager;
	}
	
	public static void closeCurrentPM(){
		PersistenceManager manager = threadLocal.get();
		if(manager != null && !manager.isClosed()){
			threadLocal.remove();
			manager.close();
		}
	}
}
