package by.epam.training.connectionpool;


import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBResourceManager {
    private static final String BUNDLE_NAME = "db";
    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private static DBResourceManager instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static Lock lock = new ReentrantLock();
    public static DBResourceManager getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new DBResourceManager();
                    instanceCreated.getAndSet(true);
                }
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
