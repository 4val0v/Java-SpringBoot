package com.project.waterbnb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.waterbnb.models.Pool;
import com.project.waterbnb.models.Review;
import com.project.waterbnb.repositories.ReviewRepo;

@Service
public class ReviewService {
	
	private ReviewRepo repo;
	public ReviewService(ReviewRepo repo){ // JoinRepo jrepo
		this.repo = repo;
	}
	
	// Basic operations
	public Review create(Review re) {return repo.save(re);}
//	public Review update(Review re) {return repo.save(re);}
//	public void update_Var_(Review re) {re.set_Var_(var); repo.save(re);}
//	public void delete(Review re) {repo.delete(re);}
//	public boolean exists(Long id) {return repo.existsById(id);}
//	public boolean existsBy_Var_(Type var) {return existsBy_Var_(var);}

	// Basic retrieval
	public List<Review> getAll() {return repo.findAll();}
//	public List<Review> getAllBy_Var_(Type var) {return repo.findAllBy_Var_(var);}
//	public List<Review> excludeBy_Var_(Type var) {return repo.findBy_Var_NotIn(var);}
	public Review get(Long id) {return repo.findById(id);}
//	public Review getBy_Var_(Type var) {return repo.findBy_Var_(var);}
	public long count() {return repo.count();}

	// Find or create
//	public Review getOrCreate(String var) {
//		if (repo.findBy_Var_(var) == null ) {
//			Review re = new Review(var);
//			return repo.save(re);}
//		else {return repo.findBy_Var_(var);}}

	// Custom retrieval
//	public Review getFirst() {return repo.findFirstByOrderBy_Var_Asc();}
//	public List<Review> getFirst10() {return repo.findFirst10ByOrderBy_Var_Asc();}
//	public List<Review> searchBy_Var_(String var) {return repo.findBy_Var_Containing(var);}
	
	// Retrieval by relationship
//	public Review getOne(One one) {return repo.findBy_One_(one);} // 1t1
	public List<Review> getReviews(Pool p) {return repo.findAllByPool(p);} // 1tm
//	public List<Review> getJoins(One one) {return jrepo.findBy_One_(one);} // mtm

	// Assigning relationships
//	public void assignOne(Review re, One one) {re.setOne(one); repo.save(re);} // 1t1
//	public void assignMany(Review re, List<Many> many)
//		{re.setMany(many); repo.save(re);} // 1tm
//	public void assignJoin(Review re, One one)
//		{ Join join = new Join(re, one); jrepo.save(join); } // mtm

}
