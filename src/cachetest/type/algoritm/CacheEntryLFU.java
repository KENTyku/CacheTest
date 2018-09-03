/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type.algoritm;

import java.io.Serializable;

/**
 * Describes the cache entry
 *
 * @author kentyku
 */
public class CacheEntryLFU implements Serializable {

    private String data;
    private int frequency;

    /**
     * Defaul constructor
     */
    CacheEntryLFU() {
    }

    /**
     * Get value for etem cache
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * Set value for etem cache
     *
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get frequency etem cache
     *
     * @return
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Set frequency etem cache
     *
     * @param frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
