package com.project.blackbelt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface ModelRepo extends CrudRepository<Model, Long>{
	
	// Basic retrieval or check
	List<Model> findAll();
	List<Model> findAllBy_Var_(Type var);
	List<Model> findAllBy_Var_NotIn(Type var);
	Model findById(id);
	Model findBy_Var_(Type var);
	boolean existsById(Long id);
	boolean existsBy_Var_(Type var);

	// Custom retrieval
	Model findFirstByOrderBy_Var_Asc();
	List<Model> findFirst10ByOrderBy_Var_Asc();
	List<Model> findBy_Var_Containing(String var);

	// Retrieval by relationship
	Model findBy_One_(One one); // 1t1
	List<Model> findBy_One_(One one); // mt1

	// If a join repo, use for both sides
	List<Join> findBy_One_(One one); // mtm
	
}
