package it.mr.zan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import it.mr.zan.model.User;

/**
 * il repository dell'entità User
 */
//public interface UserRepository extends PagingAndSortingRepository<User, Long> {
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastName(@Param("name") String name);

}