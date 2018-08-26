/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

/**
 *
 * @author kentyku
 */
public class CasheLFU extends Cache{
    CasheLFU(int maxEntries){
        
    }

    @Override
    void addData(String key,String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getData(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void resetStoreCache() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
