package com.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.SuperAdminLogin;

@Repository
public interface SuperAdminRepo extends CrudRepository<SuperAdminLogin, String> {

	SuperAdminLogin findByEmailAndPassword(String email, String password);

	SuperAdminLogin findByEmail(String email);

}
