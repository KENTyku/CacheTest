/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author kentyku
 */
public class CacheLRU extends Cache {

    AlgoritmLRU lru;

    public CacheLRU(int maxEntries) {
        this.size = maxEntries;
        this.lru = new AlgoritmLRU(size);
    }

    @Override
    void addData(String key, String data) {
        lru.put(key, data);
    }

    @Override
    String getData(String key) {
        return lru.get(key);
    }

    @Override
    void resetStoreCache() {
        lru.clear();
    }

    @Override
    LinkedHashMap<String, String> showCache() {
       return lru;
    }

}
