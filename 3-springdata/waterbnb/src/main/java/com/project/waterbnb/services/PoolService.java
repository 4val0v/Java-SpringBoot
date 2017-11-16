package com.project.waterbnb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.waterbnb.models.Pool;
import com.project.waterbnb.models.User;
import com.project.waterbnb.repositories.PoolRepo;

@Service
public class PoolService {
	
	private PoolRepo repo;
	public PoolService(PoolRepo repo){
		this.repo = repo;
	}
	
	// Basic operations
	public Pool create(Pool x) {return repo.save(x);}
	public Pool update(Pool x) {return repo.save(x);}
//	public void update_Var_(Pool x) {x.set_Var_(var); repo.save(x);}
//	public void delete(Pool x) {repo.delete(x);}
//	public boolean exists(Long id) {return repo.existsById(id);}
//	public boolean existsBy_Var_(Type var) {return existsBy_Var_(var);}

	// Basic retrieval
	public List<Pool> getAll() {return repo.findAll();}
//	public List<Pool> getBy_Var_(Type var) {return repo.findAllBy_Var_(var);}
//	public List<Pool> excludeBy_Var_(Type var) {return repo.findBy_Var_NotIn(var);}
	public Pool get(Long id) {return repo.findById(id);}
//	public Pool getBy_Var_(Type var) {return repo.findBy_Var_(var);}
//	public long count() {return repo.count();}

	// Find or create
//	public Pool getOrCreate(String var) {
//		if (repo.findBy_Var_(var) == null ) {
//			Pool x = new Pool(var);
//			return repo.save(x);}
//		else {return repo.findBy_Var_(var);}}

	// Custom retrieval
//	public Pool getFirst() {return repo.getFirstByOrderBy_Var_Asc();}
//	public List<Pool> getFirst10() {return repo.findFirst10ByOrderBy_Var_Asc();}
	public List<Pool> search(String var) {return repo.findByLocationContaining(var);}
	
	// Retrieval by relationship
//	public Pool getOne(One one) {return repo.findBy_One_(one);} // 1t1
	public List<Pool> getPools(User host) {return repo.findByHost(host);} // 1tm

	// Assigning relationships
//	public void assignOne(Pool p, Review r) {r.set(one); repo.save(x);} // 1t1, 1tm
//	public void assignMany(Pool x, List<Many> many)
//		{x.setMany(many); repo.save(x);} // 1tm

}
