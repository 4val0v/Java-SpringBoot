package com.project.waterbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface ReviewRepo extends CrudRepository<Template, Long>{
	
	// Basic retrieval or check
	List<Template> findAll();
	List<Template> findAllBy_Var_(Type var);
	List<Template> findAllBy_Var_NotIn(Type var);
	Template findById(id);
	Template findBy_Var_(Type var);
	boolean existsById(Long id);
	boolean existsBy_Var_(Type var);

	// Custom retrieval
	Template findFirstByOrderBy_Var_Asc();
	List<Template> findFirst10ByOrderBy_Var_Asc();
	List<Template> findBy_Var_Containing(String var);

	// Retrieval by relationship
	Template findBy_One_(One one); // 1t1
	List<Template> findBy_One_(One one); // mt1

	// If a join repo, use for both sides
	List<Join> findBy_One_(One one); // mtm
	
}
