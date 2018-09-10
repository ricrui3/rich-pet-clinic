package com.ricrui3.bootstrap;

import com.ricrui3.model.Owner;
import com.ricrui3.model.PetType;
import com.ricrui3.model.Vet;
import com.ricrui3.services.OwnerService;
import com.ricrui3.services.VetService;
import com.ricrui3.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created By ricardo.ruiz
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args){
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Richard");
        owner1.setLastName("Ruiz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Antony");
        owner2.setLastName("Pared");

        ownerService.save(owner2);

        System.out.println("...Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Liliana");
        vet1.setLastName("Flores");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Maria");
        vet2.setLastName("Aguilar");

        vetService.save(vet2);

        System.out.println("...Loaded Vets");
    }
}
