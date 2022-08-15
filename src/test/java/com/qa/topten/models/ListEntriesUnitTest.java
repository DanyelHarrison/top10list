package com.qa.topten.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.qa.topten.model.ListEntries;
import com.qa.topten.model.ListModel;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ListEntriesUnitTest {

	@Test
	public void ListEntriesContructorTest() {
		ListEntries entry1 = new ListEntries();
		ListEntries entry2 = new ListEntries(2L, null, null);
		ListEntries entry3 = new ListEntries(null);

		assertTrue(entry1 instanceof ListEntries == true);
		assertTrue(entry2 instanceof ListEntries == true);
		assertTrue(entry3 instanceof ListEntries == true);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(ListEntries.class).withPrefabValues(ListEntries.class,
				new ListEntries("hello"), new ListEntries("goodbye"));
	}

	@Test
	public void testToString() {
		ListEntries entry1 = new ListEntries("hello");
		String expecting = "ListEntries [entryId=" + entry1.getEntryId() + ", listModel=" + entry1.getListModel()
				+ ", list_entry=" + entry1.getList_entry() + "]";
		assertEquals(expecting, entry1.toString());
	}

	@Test
	public void setEntryIdTest() throws NoSuchFieldException, IllegalAccessException {
		ListEntries testEntry = new ListEntries(8L, null, null);
		testEntry.setEntryId(9L);

		Field expected = testEntry.getClass().getDeclaredField("entryId");
		expected.setAccessible(true);
		assertEquals(expected.get(testEntry), 9L);
	}

	@Test
	public void setListEntryTest() throws NoSuchFieldException, IllegalAccessException {
		ListEntries testEntry = new ListEntries(8L, null, "hello");
		testEntry.setList_entry("goodbye");

		Field expected = testEntry.getClass().getDeclaredField("list_entry");
		expected.setAccessible(true);
		assertEquals(expected.get(testEntry), "goodbye");
	}

	@Test
	public void setListModelTest() throws NoSuchFieldException, IllegalAccessException {
		ListModel testModel = new ListModel();
		ListModel testModel2 = new ListModel();

		ListEntries testEntry = new ListEntries(8L, testModel, "hello");
		testEntry.setListModel(testModel2);

		Field expected = testEntry.getClass().getDeclaredField("listModel");
		expected.setAccessible(true);
		assertEquals(expected.get(testEntry), testModel2);
	}
}
