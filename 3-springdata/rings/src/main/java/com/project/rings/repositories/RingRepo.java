package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Ring;
import com.project.rings.models.User;

@Repository
public interface RingRepo extends CrudRepository<Ring, Long>{
	
	List<Ring> findByUser(User user);
	Ring findById(Long id);

}
