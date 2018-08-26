/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

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
}
