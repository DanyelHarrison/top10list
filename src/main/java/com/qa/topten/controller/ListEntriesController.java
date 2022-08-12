package com.qa.topten.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.topten.model.ListEntries;
import com.qa.topten.service.ListEntriesService;

@RestController
@RequestMapping(path = "/ListEntries")
@CrossOrigin
public class ListEntriesController {

	@Autowired
	private ListEntriesService listEntriesService;

	public ListEntriesController(ListEntriesService listEntriesService) {
		this.listEntriesService = listEntriesService;
	}

	@GetMapping
	public ResponseEntity<List<ListEntries>> getAllListEntries() {

		List<ListEntries> data = listEntriesService.readAllEntries();
		return new ResponseEntity<List<ListEntries>>(data, HttpStatus.OK);
	}

	@GetMapping("/{entry_id}")
	public ResponseEntity<Optional<ListEntries>> getEntryById(@PathVariable("entry_id") Long id) {
		Optional<ListEntries> data = listEntriesService.getEntryById(id);
		return new ResponseEntity<Optional<ListEntries>>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ListEntries> createEntry(@Valid @RequestBody ListEntries listEntries) {

		listEntries = listEntriesService.addEntry(listEntries);
		return new ResponseEntity<ListEntries>(listEntries, HttpStatus.CREATED);
	}

	@PutMapping("/{entry_id}")
	public ResponseEntity<ListEntries> updateEntry(@PathVariable("entry_id") Long id,
			@RequestBody ListEntries listEntries) {

		ListEntries updatedEntry = listEntriesService.updateEntry(id, listEntries);

		return new ResponseEntity<ListEntries>(updatedEntry, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{entry_id}")
	public ResponseEntity<Boolean> deleteEntryById(@PathVariable("entry_id") Long id) {
		return new ResponseEntity<Boolean>(listEntriesService.removeEntry(id), HttpStatus.NO_CONTENT);
	}

}
