/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

/**
 * Class describing the creation of an LFU cache
 *
 * @author kentyku
 */
public class CasheLFU extends Cache {

    AlgoritmLFU lfu;
    

    /**
     * Constructor of class CacheLRU
     *
     * @param maxEntries Cashe size
     */
    CasheLFU(int maxEntries) {
       
        this.size=maxEntries;        
    }

    /**
     * Adding data to the cache
     *
     * @param key unique key
     * @param data value
     */
    @Override
    void addData(int key, String data) {
        lfu = new AlgoritmLFU(size);
        if (this.isFileStore) {
            try {
                FileInputStream fileForRead = new FileInputStream("cache.data");
                ObjectInputStream inStreamObject = new ObjectInputStream(fileForRead);
                if (lfu.getCache().isEmpty()) {
                    lfu = (AlgoritmLFU) inStreamObject.readObject();
                    inStreamObject.close();
                }
            } catch (Exception e) {
                System.out.println("Ошибка загрузки кэша из файла cache.data");
            }
        }
        lfu.addCacheEntry(key, data);
        try {
            FileOutputStream fileForWrite = new FileOutputStream("cache.data");
            ObjectOutputStream outStreamObject = new ObjectOutputStream(fileForWrite);
            outStreamObject.writeObject(lfu);
            outStreamObject.close();
        } catch (IOException e) {
            System.out.println("Ошибка выгрузки кэша в файл cache.data");
        }

    }

    /**
     * Getting data from the cache by key
     *
     * @param key unique key
     * @return
     */
    @Override
    String getData(int key) {
        return lfu.getCacheEntry(key);
    }

    /**
     * Reset cache
     */
    @Override
    void resetStoreCache() {
//       lfu.get
    }

    /**
     * View values ​​in the cache
     *
     * @return
     */
    @Override
    LinkedHashMap<Integer, String> showCache() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setTypeDataStore(boolean isFileStore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
