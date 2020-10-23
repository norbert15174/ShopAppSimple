package simpleshopapp.week2.Repositories;


import org.springframework.stereotype.Repository;
import simpleshopapp.week2.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ShopInitDataRepository {

    private List<Product> products = new ArrayList<>();

    double randomPrice(){
        Random random = new Random();
        return ((double)(random.nextInt(30000)/100)+50);
    }

    void addProduct(String itemName, double price){
        Product item = new Product(itemName,price);
        this.products.add(item);
    }


    private ShopInitDataRepository() {

        String[] productsNames = {"Spodnie" , "Koszulka" , "Skarpetki" , "Czapka" , "Bluza"};
        for(String name : productsNames) {
            this.addProduct(name,randomPrice());
        }
    }


    public double getProductsPrice(){
        double price = 0;
        for(Product productSum: this.products) price += productSum.getPrice();
        return price;
    }

    public void showProductsPrice(){
        System.out.println("Cena produktów wynosi: " + this.getProductsPrice());
    }

    public void buyNewProduct(String newProductName){
        double price = this.randomPrice();
        this.addProduct(newProductName,price);
    }
    public void buyNewProduct(String newProductName, double price){
        this.addProduct(newProductName,price);
    }

}
