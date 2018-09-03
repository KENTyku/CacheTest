/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type.algoritm;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author kentyku
 */
public class AlgoritmLFU {

    public CacheEntryLFU temp;
    private final int maxEntries;
    private LinkedHashMap<Integer, CacheEntryLFU> cache = new LinkedHashMap<Integer, CacheEntryLFU>();

    public AlgoritmLFU(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public void addCacheEntry(int key, String data) {
        if (!isFull()) {
            CacheEntryLFU temp = new CacheEntryLFU();
            temp.setData(data);
            temp.setFrequency(0);

            cache.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            cache.remove(entryKeyToBeRemoved);

            CacheEntryLFU temp = new CacheEntryLFU();
            temp.setData(data);
            temp.setFrequency(0);

            cache.put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, CacheEntryLFU> entry : cache.entrySet()) {
            if (minFreq > entry.getValue().getFrequency()) {
                key = entry.getKey();
                minFreq = entry.getValue().getFrequency();
            }
        }

        return key;
    }

    public String getCacheEntry(int key) {
        if (cache.containsKey(key)) // cache hit
        {
            CacheEntryLFU temp = cache.get(key);
            temp.setFrequency(temp.getFrequency() + 1);
            cache.put(key, temp);
            return temp.getData();
        }
        return null; // cache miss
    }

    public boolean isFull() {
        if (cache.size() == maxEntries) {
            return true;
        }

        return false;
    }

    /**
     * @return the cache
     */
    public LinkedHashMap<Integer, CacheEntryLFU> getCache() {
        return cache;
    }

    /**
     * @param aCache the cache to set
     */
    public void setCache(LinkedHashMap<Integer, CacheEntryLFU> aCache) {
        cache = aCache;
    }
}
