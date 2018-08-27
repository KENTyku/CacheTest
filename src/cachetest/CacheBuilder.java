/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.util.Map;

/**
 * The class implements the creation of a specific type of cache
 *
 * @author kentyku
 */
public class CacheBuilder {

    Cache cache;
    private final String type;
    private final int size;

    /**
     * Сonstructor of class CacheBuilder
     *
     * @param typeCache type Cache
     * @param sizeCache size Cache
     */
    CacheBuilder(String typeCache, int sizeCache) {
        this.type = typeCache;
        this.size = sizeCache;
        if (type.equals("LRU")) {
            this.cache = new CacheLRU(size);
        } else {
            this.cache = new CasheLFU(size);
        }
    }

    /**
     * Adding data to the cache
     *
     * @param key unique key
     * @param data value
     */
    void addData(String key, String data) {
        cache.addData(key, data);
    }

    /**
     * Getting data from the cache by key
     *
     * @param key unique key
     * @return
     */
    String getData(String key) {
        return cache.getData(key);
    }

    /**
     * Reset cache
     */
    void resetCash() {
        cache.resetStoreCache();
    }

    /**
     * View values ​​in the cache
     */
    void showData() {

        for (Map.Entry<String, String> entry : cache.showCache().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
