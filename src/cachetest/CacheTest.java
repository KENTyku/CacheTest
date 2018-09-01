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
        CacheBuilder cache = new CacheBuilder("LRU", 5);
        cache.setTypeDataStore(true);
        cache.addData(1, "Ижевск");
        cache.addData(2, "Лондон");
        cache.addData(3, "Венеция");
        cache.addData(4, "Берлин");
        cache.addData(5, "Вашингтон");
        cache.getData(3);
        cache.addData(6, "Токио");
        cache.addData(7, "Париж");
        cache.showData();
//        System.out.println("Очистка");
//        cache.resetCash();
//        cache.addData("Украина", "Киев");
//        cache.showData();
        System.out.println("Очистка");
        cache.resetCash();
        cache.addData(8, "Киев");
        cache.showData();
    }

}
