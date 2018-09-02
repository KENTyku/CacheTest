/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type;

import java.util.LinkedHashMap;

/**
 * Parent class. Describes how to create a cache
 *
 * @author kentyku
 */
abstract public class Cache {

    String type;
    int key;
    String data;
    int size;
    boolean isFileStore;

    abstract public void setTypeDataStore(boolean isFileStore);

    abstract public void addData(int key, String data);

    abstract public String getData(int key);

    abstract public void resetStoreCache();

    abstract public LinkedHashMap<Integer, String> showCache();

}
