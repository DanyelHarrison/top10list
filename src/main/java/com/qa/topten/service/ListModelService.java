package com.qa.topten.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.topten.model.ListModel;
import com.qa.topten.repo.ListRepo;

@Service
public class ListModelService {

	@Autowired
	private ListRepo listrepo;

	public ListModelService() {

	}

	@Autowired
	public ListModelService(ListRepo listrepo) {
		this.listrepo = listrepo;
	}

	public ListModel createList(ListModel listmodel) {
		return listrepo.save(listmodel);
	}

	public Optional<ListModel> getListById(Long id) {
		return listrepo.findById(id);
	}

	public List<ListModel> getAllLists() {
		return listrepo.findAll();
	}

	public Boolean deleteList(Long id) {
		this.listrepo.deleteById(id);
		boolean exists = this.listrepo.existsById(id);
		return !exists;
	}

	public Boolean deleteAllLists() {
		listrepo.deleteAll();
		return true;
	}

}
