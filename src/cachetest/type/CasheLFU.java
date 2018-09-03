/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type;

import cachetest.type.algoritm.AlgoritmLFU;
import cachetest.type.algoritm.CacheEntryLFU;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

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
                    LinkedHashMap<Integer, CacheEntryLFU> cache = (LinkedHashMap<Integer, CacheEntryLFU>) inStreamObject.readObject();
                    this.lfu.setCache(cache);
                    inStreamObject.close();
                }
            } catch (Exception e) {
                System.out.println("Ошибка загрузки кэша из файла cacheLfu.data");
            }

            this.lfu.addCacheEntry(key, data);
            try {
                FileOutputStream fileForWrite = new FileOutputStream("cacheLfu.data");
                ObjectOutputStream outStreamObject = new ObjectOutputStream(fileForWrite);
                outStreamObject.writeObject(this.lfu.getCache());
                outStreamObject.close();
            } catch (IOException e) {
                System.out.println("Ошибка выгрузки кэша в файл cacheLfu.data");
//            e.printStackTrace();
            }
        } else {
            this.lfu.addCacheEntry(key, data);
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
        LinkedHashMap<Integer, String> cacheTemp = new LinkedHashMap<Integer, String>();       
        for (Map.Entry<Integer, CacheEntryLFU> entry : lfu.getCache().entrySet()) {
            cacheTemp.put(entry.getKey(), entry.getValue().getData());
        }
        return cacheTemp;        
    }

    @Override
    public void setTypeDataStore(boolean isFileStore) {
        this.isFileStore = isFileStore;
    }

}
