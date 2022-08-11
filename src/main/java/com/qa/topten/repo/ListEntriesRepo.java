package com.qa.topten.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.topten.model.ListEntries;

public interface ListEntriesRepo extends JpaRepository<ListEntries, Long> {

	@Query("SELECT t FROM ListEntries t WHERE t.entry_id = ?1")
	public ListEntries getListEntryById(Long entry_id);
}
