package com.project.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.waterbnb.models.Pool;
import com.project.waterbnb.models.Review;

@Repository 												
public interface ReviewRepo extends CrudRepository<Review, Long>{
	
	// Basic retrieval or check
	List<Review> findAll();
	 List<Review> findAllByPool(Pool p);
	// List<Review> findAllBy_Var_NotIn(Type var);
	 Review findById(Long id);
	// Review findBy_Var_(Type var);
	// boolean existsById(Long id);
	// boolean existsBy_Var_(Type var);

	// Custom retrieval
	// Review findFirstByOrderBy_Var_Asc();
	// List<Review> findFirst10ByOrderBy_Var_Asc();
	// List<Review> findBy_Var_Containing(String var);

	// Retrieval by relationship
	// Review findBy_One_(One one); // 1t1
	// List<Review> findBy_One_(One one); // mt1

	// If a join repo, use for both sides
	// List<Join> findBy_One_(One one); // mtm
	
}
