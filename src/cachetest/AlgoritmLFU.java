/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author kentyku
 */
public class AlgoritmLFU {
  private int maxEntries;
    
    /**
     * 
     */
    class CacheEntry {

        private String data;
        private int frequency;

        // default constructor
        private CacheEntry() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }

    

    private static LinkedHashMap<Integer, CacheEntry> cache = new LinkedHashMap<Integer, CacheEntry>();

    /* LinkedHashMap is used because it has features of both HashMap and LinkedList. 
     * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
     * */
    public AlgoritmLFU(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public void addCacheEntry(int key, String data) {
        if (!isFull()) {
            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            getCache().put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            getCache().remove(entryKeyToBeRemoved);

            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            getCache().put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, CacheEntry> entry : getCache().entrySet()) {
            if (minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public String getCacheEntry(int key) {
        if (getCache().containsKey(key)) // cache hit
        {
            CacheEntry temp = getCache().get(key);
            temp.frequency++;
            getCache().put(key, temp);
            return temp.data;
        }
        return null; // cache miss
    }

    public  boolean isFull() {
        if (getCache().size() == maxEntries) {
            return true;
        }

        return false;
    }

    /**
     * @return the cache
     */
    public static LinkedHashMap<Integer, CacheEntry> getCache() {
        return cache;
    }

    /**
     * @param aCache the cache to set
     */
    public static void setCache(LinkedHashMap<Integer, CacheEntry> aCache) {
        cache = aCache;
    }
}
