package com.project.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.waterbnb.models.Pool;
import com.project.waterbnb.models.User;

@Repository 												
public interface PoolRepo extends CrudRepository<Pool, Long>{
	
	// Basic retrieval or check
	List<Pool> findAll();
	// List<Pool> findAllBy_Var_(Type var);
	// List<Pool> findAllBy_Var_NotIn(Type var);
	Pool findById(Long id);
	// Pool findBy_Var_(Type var);
	// boolean existsById(Long id);
	// boolean existsBy_Var_(Type var);

	// Custom retrieval
	// Pool findFirstByOrderBy_Var_Asc();
	// List<Pool> findFirst10ByOrderBy_Var_Asc();
	List<Pool> findByLocationContaining(String location);

	// Retrieval by relationship
//	 Pool findBy_One_(One one); // 1t1
	 List<Pool> findByHost(User host); // mt1
	
}
