package com.qa.topten.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.topten.model.ListEntries;
import com.qa.topten.model.ListModel;

@Repository
public interface ListEntriesRepo extends JpaRepository<ListEntries, Long> {

	@Query("SELECT t FROM ListEntries t WHERE t.entryId = ?1")
	public ListEntries getListEntryById(Long entry_id);

	@Query("SELECT t FROM ListEntries t WHERE t.listModel = ?1")
	public ListEntries getAllEntries(ListModel listModel);
}
