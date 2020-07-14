package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {


}
