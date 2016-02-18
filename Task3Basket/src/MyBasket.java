

import java.util.*;


/**
 * Created by Жанна on 27.01.2016.
 */
public class MyBasket implements Basket {

    private HashMap<String, Integer> basket;

    MyBasket() {
        basket = new HashMap<String, Integer>();
    }


    @Override //этот метод переопределен
    public void addProduct(String product, int quantity) {
        basket.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        basket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        int value = basket.get(product);
        basket.put(product, value + quantity);
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<String>(basket.keySet());
    }


    @Override
    public int getProductQuantity(String product) {
        return basket.get(product);
    }

};
