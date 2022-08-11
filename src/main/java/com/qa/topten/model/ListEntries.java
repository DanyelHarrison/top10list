package com.qa.topten.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ListEntries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entry_id")
	private long entryId;

	@ManyToOne(targetEntity = ListModel.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_list_id")
	private ListModel listModel;

	@Column(name = "list_entry", nullable = false)
	private String list_entry;

	public ListEntries() {

	}

	public ListEntries(long entryId, ListModel listModel, String list_entry) {
		super();
		this.entryId = entryId;
		this.listModel = listModel;
		this.list_entry = list_entry;
	}

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}

	public ListModel getListModel() {
		return listModel;
	}

	public void setListModel(ListModel listModel) {
		this.listModel = listModel;
	}

	public String getList_entry() {
		return list_entry;
	}

	public void setList_entry(String list_entry) {
		this.list_entry = list_entry;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listModel, list_entry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListEntries other = (ListEntries) obj;
		return Objects.equals(listModel, other.listModel) && Objects.equals(list_entry, other.list_entry);
	}

}
