package com.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Register;

@Repository
public interface RegisterRepo extends CrudRepository<Register, String> {

	Register findByEmailAndPassword(String email, String password);

	Register findByPassword(String password);

	Register findByEmailAndMob(String email, String mob);

	Register findByEmail(String email);

	Register findByMob(String mob);

}
