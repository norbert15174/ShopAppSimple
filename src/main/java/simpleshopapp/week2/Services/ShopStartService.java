package simpleshopapp.week2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import simpleshopapp.week2.Repositories.ShopInitDataRepository;


@Profile("Basic")
@Component
public class ShopStartService {

    ShopInitDataRepository shopInitDataRepository;

    @Autowired
    public ShopStartService(ShopInitDataRepository shopInitDataRepository) {
        this.shopInitDataRepository = shopInitDataRepository;
    }


    @EventListener(ApplicationReadyEvent.class)
    void init(){
        shopInitDataRepository.showProductsPrice();
    }


}
