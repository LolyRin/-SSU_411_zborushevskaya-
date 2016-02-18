import java.util.List;

/**
 * Created by Жанна on 27.01.2016.
 */

//interface используется для создания полностью абстрактных классов
public interface Basket {
    void addProduct(String product, int quantity);
    void removeProduct(String product);
    void updateProductQuantity(String product, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String product);
}
