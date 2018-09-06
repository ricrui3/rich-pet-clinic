package com.ricrui3.bootstrap;

import com.ricrui3.model.Owner;
import com.ricrui3.model.Vet;
import com.ricrui3.services.OwnerService;
import com.ricrui3.services.VetService;
import com.ricrui3.services.map.OwnerServiceMap;
import com.ricrui3.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created By ricardo.ruiz
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args){
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Richard");
        owner1.setLastName("Ruiz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Antony");
        owner2.setLastName("Pared");

        ownerService.save(owner2);

        System.out.println("...Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Liliana");
        vet1.setLastName("Flores");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Maria");
        vet2.setLastName("Aguilar");

        vetService.save(vet2);

        System.out.println("...Loaded Vets");
    }
}
