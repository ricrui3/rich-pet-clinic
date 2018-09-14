package com.ricrui3.bootstrap;

import com.ricrui3.model.*;
import com.ricrui3.services.OwnerService;
import com.ricrui3.services.PetTypeService;
import com.ricrui3.services.SpecialtyService;
import com.ricrui3.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created By ricardo.ruiz
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args){
        Integer count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType axolotl = new PetType();
        axolotl.setName("axolotl");
        PetType savedAxolotlPetType = petTypeService.save(axolotl);

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiologySpecialty = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgerySpecialty = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistrySpecialty = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Richard");
        owner1.setLastName("Ruiz");
        owner1.setAddress("Fogatas #55");
        owner1.setCity("Atizapán de Zaragoza");
        owner1.setTelephone("58870083");
        Pet richardsPet = new Pet();
        richardsPet.setPetType(savedDogPetType);
        richardsPet.setOwner(owner1);
        richardsPet.setBirthDate(LocalDate.now());
        richardsPet.setName("Garlic");
        owner1.getPets().add(richardsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alejandrina");
        owner2.setLastName("Lara");
        owner2.setAddress("Comonfort #2");
        owner2.setCity("Atizapán de Zaragoza");
        owner2.setTelephone("34658692");
        Pet alejandrinasPet = new Pet();
        alejandrinasPet.setName("Goxira");
        alejandrinasPet.setBirthDate(LocalDate.now());
        alejandrinasPet.setOwner(owner2);
        alejandrinasPet.setPetType(savedAxolotlPetType);
        owner2.getPets().add(alejandrinasPet);
        ownerService.save(owner2);

        System.out.println("...Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Liliana");
        vet1.setLastName("Flores");
        vet1.getSpecialties().add(savedRadiologySpecialty);
        vet1.getSpecialties().add(savedDentistrySpecialty);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Maria");
        vet2.setLastName("Aguilar");
        vet2.getSpecialties().add(savedSurgerySpecialty);
        vetService.save(vet2);

        System.out.println("...Loaded Vets");
    }
}
