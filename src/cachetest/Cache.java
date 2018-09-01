/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

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

    abstract void setTypeDataStore(boolean isFileStore);

    abstract void addData(int key, String data);

    abstract String getData(int key);

    abstract void resetStoreCache();

    abstract LinkedHashMap<Integer, String> showCache();

}
