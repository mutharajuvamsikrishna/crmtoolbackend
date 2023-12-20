package com.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Addmore;

@Repository
public interface AddmoreRepo extends CrudRepository<Addmore, String> {

	Addmore findByEmail(String email);

}
