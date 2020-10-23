package simpleshopapp.week2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import simpleshopapp.week2.Repositories.ShopInitDataRepository;



@Component
@Profile("Plus")
public class ShopPlusService {

    @Value("${shop.info.Vat}")
    double Vat;

    ShopInitDataRepository shopInitDataRepository;

    @Autowired
    public ShopPlusService(ShopInitDataRepository shopInitDataRepository) {
        this.shopInitDataRepository = shopInitDataRepository;
    }


    void showPriceVat(){
        double price = shopInitDataRepository.getProductsPrice() * (100+this.Vat)/100;
        System.out.println("Cena produktów z Vat: " + price);
    };

    @EventListener(ApplicationReadyEvent.class)
    void init(){
        shopInitDataRepository.showProductsPrice();
        showPriceVat();
    }


}
