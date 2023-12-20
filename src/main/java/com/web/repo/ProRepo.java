package com.web.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.web.model.Pro;

public interface ProRepo extends CrudRepository<Pro, Long> {
	@Query("SELECT p FROM Pro p WHERE " + "p.bdmname LIKE CONCAT('%', :query, '%') "
			+ "OR p.firstres LIKE CONCAT('%', :query, '%')" + "OR p.coun LIKE CONCAT('%', :query, '%')"
			+ "OR p.lastres LIKE CONCAT('%', :query, '%')" + "OR p.linkprof LIKE CONCAT('%', :query, '%')"
			+ "OR p.pocstatus LIKE CONCAT('%', :query, '%')" + "OR p.maincontact LIKE CONCAT('%', :query, '%')"
			+ "OR p.intrestserv LIKE CONCAT('%', :query, '%')" + "OR p.lfstatus LIKE CONCAT('%', :query, '%')"
			+ "OR p.mainemail LIKE CONCAT('%', :query, '%')" + "OR p.id LIKE CONCAT('%', :query, '%')")
	List<Pro> searchPro(@Param("query") String query);

	@Query("SELECT p FROM Pro p WHERE DATEDIFF(p.followup, :currentDate) = -1")
	List<Pro> findByFollowupOneDayBefore(@Param("currentDate") Date currentDate);

	@Query("SELECT p FROM Pro p WHERE DATEDIFF(p.followup, :date) = 0")
	List<Pro> findByFollowup(@Param("date") Date date);

	List<Pro> findAll();

}
