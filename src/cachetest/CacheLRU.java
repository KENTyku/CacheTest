/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Class describing the creation of an LRU cache
 *
 * @author kentyku
 */
public class CacheLRU extends Cache implements Serializable {

    AlgoritmLRU lru;

    /**
     * Constructor of class CacheLRU
     *
     * @param maxEntries cache size
     */
    public CacheLRU(int maxEntries) {
        this.size = maxEntries;
        this.lru = new AlgoritmLRU(size);
        this.isFileStore = false;
    }

    /**
     * Set type of Data Store
     *
     * @param isFileStore
     */
    @Override
    void setTypeDataStore(boolean isFileStore) {
        this.isFileStore = isFileStore;
    }

    /**
     * Adding data to the cache
     *
     * @param key unique key
     * @param data value
     */
    @Override
    void addData(String key, String data) {

        if (this.isFileStore) {
            try {
                FileInputStream fileForWrite = new FileInputStream("cache.data");
                ObjectInputStream inStreamObject = new ObjectInputStream(fileForWrite);
                if (this.lru.isEmpty()){
                this.lru=(AlgoritmLRU)inStreamObject.readObject();
                inStreamObject.close();
                }
            } catch (Exception e) {
                System.out.println("Ошибка загрузки кэша из файла cache.data");
            }
        }
        lru.put(key, data);
    }

    /**
     * Getting data from the cache by key
     *
     * @param key unique key
     * @return
     */
    @Override
    String getData(String key) {
        return lru.get(key);
    }

    /**
     * Reset cache
     */
    @Override
    void resetStoreCache() {
        lru.clear();
    }

    /**
     * View values ​​in the cache
     *
     * @return
     */
    @Override
    LinkedHashMap<String, String> showCache() {
        return lru;
    }

}
