package simpleshopapp.week2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import simpleshopapp.week2.Repositories.ShopInitDataRepository;


@Component
@Profile("Pro")
public class ShopProService {

    @Value("${shop.info.Vat}")
    double vat;
    @Value("${shop-info.discount}")
    double discount;


    ShopInitDataRepository shopInitDataRepository;

    @Autowired
    public ShopProService(ShopInitDataRepository shopInitDataRepository) {
        this.shopInitDataRepository = shopInitDataRepository;
    }

    void showPriceVat(){
        double price = shopInitDataRepository.getProductsPrice() * (100+this.vat)/100;
        System.out.println("Cena produktów z Vat: " + price);
    };

    void showPriceAfterDiscountVat(){
        double price = shopInitDataRepository.getProductsPrice() * (100+this.vat-this.discount)/100;
        System.out.println("Cena produktów z Vat po obniżce ceny: " + price);
    };

    void showPriceAfterDiscount(){
        double price = shopInitDataRepository.getProductsPrice() * (100-this.discount)/100;
        System.out.println("Cena produktów po obniżce ceny: " + price);
    };

    @EventListener(ApplicationReadyEvent.class)
    void init(){
        shopInitDataRepository.showProductsPrice();
        this.showPriceVat();
        this.showPriceAfterDiscountVat();
        this.showPriceAfterDiscount();
    }


}
