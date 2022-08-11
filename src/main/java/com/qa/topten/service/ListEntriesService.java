package com.qa.topten.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.topten.model.ListEntries;
import com.qa.topten.repo.ListEntriesRepo;

@Service
public class ListEntriesService {

	private ListEntriesRepo listEntriesRepo;

	public ListEntriesService() {

	}

	@Autowired
	public ListEntriesService(ListEntriesRepo listEntriesRepo) {
		this.listEntriesRepo = listEntriesRepo;
	}

	public ListEntries addEntry(ListEntries entry) {
		return listEntriesRepo.save(entry);
	}

	public List<ListEntries> readAllEntries() {
		List<ListEntries> entries = listEntriesRepo.findAll();
		return entries;
	}

	public Optional<ListEntries> getPlayer(Long id) {
		return listEntriesRepo.findById(id);
	}

	public List<ListEntries> getAllPlayers() {
		return listEntriesRepo.findAll();
	}

	public ListEntries updateEntry(Long id, ListEntries newEntry) {
		Optional<ListEntries> existingOptional = this.listEntriesRepo.findById(id);
		ListEntries existing = existingOptional.get();

		existing.setList_entry(newEntry.getList_entry());

		return listEntriesRepo.save(existing);
	}

	public Boolean removeEntry(Long id) {
		this.listEntriesRepo.deleteById(id);
		boolean exists = this.listEntriesRepo.existsById(id);
		return !exists;
	}

	public Boolean removeAllEntries() {
		listEntriesRepo.deleteAll();
		return true;

	}
}
