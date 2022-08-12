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

import com.qa.topten.model.ListModel;
import com.qa.topten.service.ListModelService;

@RestController
@RequestMapping(path = "/ListModel")
@CrossOrigin
public class ListModelController {

	@Autowired
	private ListModelService listService;

	public ListModelController(ListModelService listService) {
		this.listService = listService;
	}

	@GetMapping
	public ResponseEntity<List<ListModel>> getAllLists() {

		List<ListModel> data = listService.getAllLists();
		return new ResponseEntity<List<ListModel>>(data, HttpStatus.OK);
	}

	@GetMapping("/{list_id}")
	public ResponseEntity<Optional<ListModel>> getEntryById(@PathVariable("list_id") Long id) {
		Optional<ListModel> data = listService.getListById(id);
		return new ResponseEntity<Optional<ListModel>>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ListModel> createEntry(@Valid @RequestBody ListModel listModel) {

		listModel = listService.createList(listModel);
		return new ResponseEntity<ListModel>(listModel, HttpStatus.CREATED);
	}

	@PutMapping("/{entry_id}")
	public ResponseEntity<ListModel> updateEntry(@PathVariable("list_id") Long id, @RequestBody ListModel listModel) {

		ListModel updatedList = listService.updateEntry(id, listModel);

		return new ResponseEntity<ListModel>(updatedList, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{entry_id}")
	public ResponseEntity<Boolean> deleteListById(@PathVariable("list_id") Long id) {
		return new ResponseEntity<Boolean>(listService.deleteList(id), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{entry_id}")
	public ResponseEntity<Boolean> deleteAllLists() {
		return new ResponseEntity<Boolean>(listService.deleteAllLists(), HttpStatus.NO_CONTENT);
	}
}
