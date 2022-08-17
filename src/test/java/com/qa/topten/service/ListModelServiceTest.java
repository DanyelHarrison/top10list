package com.qa.topten.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.topten.model.ListModel;
import com.qa.topten.repo.ListRepo;

@SpringBootTest
public class ListModelServiceTest {

	@Autowired
	@Mock
	private ListModelService service;

	@MockBean
	private ListRepo repo;

	@Test
	public void createListTest() {
		ListModel list1 = new ListModel("name");
		ListModel list2 = new ListModel(1L, "name");

		Mockito.when(this.service.createList(list1)).thenReturn(list2);
		assertEquals(list2, this.service.createList(list1));

		Mockito.verify(this.repo, Mockito.times(1)).save(list1);
	}

	@Test
	public void readListByIdTest() {
		Long id = 1L;
		ListModel testList = new ListModel(1L, "hello", null);
		Optional<ListModel> testOpt = Optional.of(testList);
		ListModel testModel = testOpt.get();

		Mockito.when(repo.findById(id)).thenReturn(testOpt);
		assertEquals(testModel, this.service.getListById(id).get());
		Mockito.verify(repo, Mockito.times(1)).findById(id);
	}
}
