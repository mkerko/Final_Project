package by.epam.training.dao.impl.connectionpool;

import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBResourceManager {
    private static final String BUNDLE_NAME = "db";

    static Logger logger = Logger.getLogger(String.valueOf(DBResourceManager.class));
    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private static DBResourceManager instance = null;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    public static DBResourceManager getInstance() {
        Lock lock = new ReentrantLock();
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (!instanceCreated.get()) {
                    instance = new DBResourceManager();
                    instanceCreated.set(true);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING,"initialization error handling");
            } finally {
                lock.unlock();
            }

        }
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
