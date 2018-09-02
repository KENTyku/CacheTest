/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest.type.algoritm;

/**
 *
 * @author kentyku
 */
public class  CacheEntryLFU {

        private String data;
        private int frequency;

        // default constructor
        CacheEntryLFU() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }
