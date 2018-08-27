/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.util.LinkedHashMap;

/**
 * Class describing the creation of an LRU cache
 *
 * @author kentyku
 */
public class CacheLRU extends Cache {

    AlgoritmLRU lru;

    /**
     * Constructor of class CacheLRU
     *
     * @param maxEntries cache size
     */
    public CacheLRU(int maxEntries) {
        this.size = maxEntries;
        this.lru = new AlgoritmLRU(size);
    }

    /**
     * Adding data to the cache
     *
     * @param key unique key
     * @param data value
     */
    @Override
    void addData(String key, String data) {
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
