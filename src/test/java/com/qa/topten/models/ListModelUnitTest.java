package com.qa.topten.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.topten.model.ListModel;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ListModelUnitTest {

	static ListModel listy;

	@BeforeAll
	public static void buildList() {
		System.out.println("Creating List");
		listy = new ListModel(1L, "Test List", null);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(ListModel.class)
				.withPrefabValues(ListModel.class, new ListModel("list 1"), new ListModel("list 2")).verify();

	}

	@Test
	public void testToString() {
		String expecting = "ListModel [ListId=" + listy.getListId() + ", listName=" + listy.getListName()
				+ ", listEntries=" + listy.getListEntries() + "]";
		assertEquals(expecting, listy.toString());
	}

	@Test
	public void constructorTest() {
		ListModel list0 = new ListModel();
		ListModel list1 = new ListModel("test list 1");
		ListModel list2 = new ListModel(2L, "test list 2");
		ListModel list3 = new ListModel(3L, "test list 3", null);

		assertTrue(list0 instanceof ListModel == true);
		assertTrue(list1 instanceof ListModel == true);
		assertTrue(list2 instanceof ListModel == true);
		assertTrue(list3 instanceof ListModel == true);
	}

	@Test
	public void setListNameTest() throws NoSuchFieldException, IllegalAccessException {
		ListModel testList = new ListModel(8L, "testList");
		testList.setListName("success");

		Field expected = testList.getClass().getDeclaredField("listName");
		expected.setAccessible(true);
		assertEquals(expected.get(testList), "success");
	}

	@Test
	public void setListIdTest() throws NoSuchFieldException, IllegalAccessException {
		ListModel testList = new ListModel();
		testList.setListId(5L);

		Field expected = testList.getClass().getDeclaredField("ListId");
		expected.setAccessible(true);
		assertEquals(expected.get(testList), 5L);
	}

	@Test
	public void setListEntryTest() throws NoSuchFieldException, IllegalAccessException {
		ListModel testList = new ListModel();
		testList.setListEntries(null);

		Field expected = testList.getClass().getDeclaredField("listEntries");
		expected.setAccessible(true);
		assertEquals(expected.get(testList), null);
	}
}
