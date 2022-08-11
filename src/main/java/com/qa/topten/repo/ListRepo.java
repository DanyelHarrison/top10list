package com.qa.topten.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.topten.model.ListModel;

public interface ListRepo extends JpaRepository<ListModel, Long> {

	@Query("SELECT 1 FRON listModel 1 WHERE 1.list_id = ?1")
	public ListModel getListById(Long list_id);
}
