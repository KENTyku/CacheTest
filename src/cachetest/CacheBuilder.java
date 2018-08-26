/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

import java.util.Map;

/**
 *
 * @author kentyku
 */
public class CacheBuilder {
    Cache cache;
    private String type;
    private int size;

    CacheBuilder(String typeCache, int sizeCache) {
        this.type = typeCache;
        this.size = sizeCache;        
        if (type.equals("LRU")) {
            this.cache = new CacheLRU(size);
        }        
        else {
            this.cache=new CasheLFU(size);
        }
    }

    void addData(String key,String data) {        
        cache.addData(key,data);        
    }
    
    String getData(String key){
        return cache.getData(key);
    }
    void resetCash(){
        cache.resetStoreCache();
    }
    void showData(){
        
        for (Map.Entry<String, String> entry: cache.showCache().entrySet())
    System.out.println(entry.getKey() + " = " + entry.getValue());

    }
}
