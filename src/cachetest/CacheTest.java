/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package cachetest;

/**
 *
 * @author kentyku
 */
public class CacheTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CacheBuilder cache=new CacheBuilder("LRU",5);
        cache.addData("Россия", "Ижевск");
        cache.addData("Англия", "Лондон");
        cache.addData("Италия", "Венеция");
        cache.addData("Германия", "Берлин");
        cache.addData("США", "Вашингтон");
        cache.getData("Италия");
        cache.addData("Япония", "Токио");
//        System.out.println(cache.getData("США"));
        cache.showData();
    }
    
}
