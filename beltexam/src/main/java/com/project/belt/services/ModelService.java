package com.project.blackbelt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
	
	private ModelRepo repo;
	// private JoinRepo jrepo;
	public ModelService(ModelRepo repo){ // JoinRepo jrepo if needed
		this.repo = repo;
		// this.jrepo = jrepo;
	}
	
	// Basic operations
	public Model create(Model x) {return repo.save(x);}
	public Model update(Model x) {return repo.save(x);}
	public void update_Var_(Model x) {x.set_Var_(var); repo.save(x);}
	public void delete(Model x) {repo.delete(x);}
	public boolean exists(Long id) {return repo.existsById(id);}
	public boolean existsBy_Var_(Type var) {return existsBy_Var_(var);}

	// Basic retrieval
	public List<Model> getAll() {return repo.findAll();}
	public List<Model> getBy_Var_(Type var) {return repo.findAllBy_Var_(var);}
	public List<Model> excludeBy_Var_(Type var) {return repo.findBy_Var_NotIn(var);}
	public Model get(Long id) {return repo.findById(id);}
	public Model getBy_Var_(Type var) {return repo.findBy_Var_(var);}
	public long count() {return repo.count();}

	// Find or create
	public Model getOrCreate(String var) {
		if (repo.findBy_Var_(var) == null ) {
			Model x = new Model(var);
			return repo.save(x);}
		else {return repo.findBy_Var_(var);}}

	// Custom retrieval
	public Model getFirst() {return repo.getFirstByOrderBy_Var_Asc();}
	public List<Model> getFirst10() {return repo.findFirst10ByOrderBy_Var_Asc();}
	public List<Model> searchBy_Var_(String var) {return repo.findBy_Var_Containing(var);}
	
	// Retrieval by relationship
	public Model getOne(One one) {return repo.findBy_One_(one);} // 1t1
	public List<Model> getMany(One one) {return repo.findBy_One_(one);} // 1tm
	public List<Model> getJoins(One one) {return jrepo.findBy_One_(one);} // mtm

	// Assigning relationships
	public void assignOne(Model x, One one) {x.setOne(one); repo.save(x);} // 1t1
	public void assignMany(Model x, List<Many> many)
		{x.setMany(many); repo.save(x);} // 1tm
	public void assignJoin(Model x, One one)
		{ Join join = new Join(x, one); jrepo.save(join); } // mtm

}
