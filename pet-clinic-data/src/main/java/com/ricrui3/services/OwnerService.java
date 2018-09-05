package com.ricrui3.services;

import com.ricrui3.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
