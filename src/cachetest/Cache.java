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
    String key;
    String data;
    int size;

    abstract void addData(String key, String data);

    abstract String getData(String key);

    abstract void resetStoreCache();

    abstract LinkedHashMap<String, String> showCache();

}
