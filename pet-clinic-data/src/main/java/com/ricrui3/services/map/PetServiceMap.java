package com.ricrui3.services.map;

import com.ricrui3.model.Pet;
import com.ricrui3.services.CrudService;

import java.util.Set;

/**
 * Created By ricardo.ruiz
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
