package com.qa.topten.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.topten.model.ListModel;

@Repository
public interface ListRepo extends JpaRepository<ListModel, Long> {

	@Query(value = "SELECT l FROM Lists l WHERE l.list_id = ?1", nativeQuery = true)
	public ListModel getListById(Long list_id);
}
