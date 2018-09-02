/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type;

import cachetest.type.algoritm.AlgoritmLFU;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Class describing the creation of an LFU cache
 *
 * @author kentyku
 */
public class CasheLFU extends Cache implements Serializable {

    AlgoritmLFU lfu;

    /**
     * Constructor of class CacheLRU
     *
     * @param maxEntries Cashe size
     */
    public CasheLFU(int maxEntries) {
        this.isFileStore = false;
        this.size = maxEntries;
        this.lfu = new AlgoritmLFU(size);
    }

    /**
     * Adding data to the cache
     *
     * @param key unique key
     * @param data value
     */
    @Override
    public void addData(int key, String data) {
        if (this.isFileStore) {
            try {
                FileInputStream fileForRead = new FileInputStream("cache.data");
                ObjectInputStream inStreamObject = new ObjectInputStream(fileForRead);
                if (this.lfu.getCache().isEmpty()) {
                    this.lfu = (AlgoritmLFU) inStreamObject.readObject();
                    inStreamObject.close();
                }
            } catch (Exception e) {
                System.out.println("Ошибка загрузки кэша из файла cache.data");
            }
        }
        this.lfu.addCacheEntry(key, data);
        try {
            FileOutputStream fileForWrite = new FileOutputStream("cache.data");
            ObjectOutputStream outStreamObject = new ObjectOutputStream(fileForWrite);

            outStreamObject.writeObject(this.lfu);
            outStreamObject.close();
        } catch (IOException e) {
            System.out.println("Ошибка выгрузки кэша в файл cache.data");
//            e.printStackTrace();
        }

    }

    /**
     * Getting data from the cache by key
     *
     * @param key unique key
     * @return
     */
    @Override
    public String getData(int key) {
        return lfu.getCacheEntry(key);
    }

    /**
     * Reset cache
     */
    @Override
    public void resetStoreCache() {
        lfu.getCache().clear();
    }

    /**
     * View values ​​in the cache
     *
     * @return
     */
    @Override
    public LinkedHashMap<Integer, String> showCache() {
        return lfu.getCache();
    }

    @Override
    public void setTypeDataStore(boolean isFileStore) {
        this.isFileStore = isFileStore;
    }

}
