package com.azurian.technical.test;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface PersonRepository.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	/**
	 * Find by last name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Person> findByLastName(@Param("name") String name);

}
