package guru.sfg.beer.inventory.service.services;

import com.enjoycoding.commons.events.NewInventoryEvent;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){
        BeerInventory beerInventory = BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .upc(event.getBeerDto().getUpc())
                .build();
        beerInventoryRepository.save(beerInventory);
    }
}
