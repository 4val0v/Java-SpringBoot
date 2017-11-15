package com.project.waterbnb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	
	private TemplateRepo repo;
	// private JoinRepo jrepo;
	public ReviewService(TemplateRepo repo){ // JoinRepo jrepo
		this.repo = repo;
		// this.jrepo = jrepo;
	}
	
	// Basic operations
	public Template create(Template x) {return repo.save(x);}
	public Template update(Template x) {return repo.save(x);}
	public void update_Var_(Template x) {x.set_Var_(var); repo.save(x);}
	public void delete(Template x) {repo.delete(x);}
	public boolean exists(Long id) {return repo.existsById(id);}
	public boolean existsBy_Var_(Type var) {return existsBy_Var_(var);}

	// Basic retrieval
	public List<Template> getAll() {return repo.findAll();}
	public List<Template> getAllBy_Var_(Type var) {return repo.findAllBy_Var_(var);}
	public List<Template> excludeBy_Var_(Type var) {return repo.findBy_Var_NotIn(var);}
	public Template get(Long id) {return repo.findById(id);}
	public Template getBy_Var_(Type var) {return repo.findBy_Var_(var);}
	public long count() {return repo.count();}

	// Find or create
	public Template findOrCreate(String var) {
		if (repo.findBy_Var_(var) == null ) {
			Template x = new Template(var);
			return repo.save(x);}
		else {return repo.findBy_Var_(var);}}

	// Custom retrieval
	public Template findFirst() {return repo.findFirstByOrderBy_Var_Asc();}
	public List<Template> findFirst10() {return repo.findFirst10ByOrderBy_Var_Asc();}
	public List<Template> searchBy_Var_(String var) {return repo.findBy_Var_Containing(var);}
	
	// Retrieval by relationship
	public Template getOne(One one) {return repo.findBy_One_(one);} // 1t1
	public List<Template> getMany(One one) {return repo.findBy_One_(one);} // 1tm
	public List<Template> getJoins(One one) {return jrepo.findBy_One_(one);} // mtm

	// Assigning relationships
	public void assignOne(Template x, One one) {x.setOne(one); repo.save(x);} // 1t1
	public void assignMany(Template x, List<Many> many)
		{x.setMany(many); repo.save(x);} // 1tm
	public void assignJoin(Template x, One one)
		{ Join join = new Join(x, one); jrepo.save(join); } // mtm

}
