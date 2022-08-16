package com.qa.topten.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Lists")
public class ListModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_id")
	private long ListId;

	@Column(name = "list_name")
	private String listName;

	@OneToMany(mappedBy = "listModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ListEntries> listEntries;

	public ListModel() {

	}

	public ListModel(String listName) {
		super();
		this.listName = listName;
	}

	public ListModel(long listId, String listName) {
		super();
		ListId = listId;
		this.listName = listName;
	}

	public ListModel(long listId, String listName, List<ListEntries> listEntries) {
		super();
		ListId = listId;
		this.listName = listName;
		this.listEntries = listEntries;
	}

	public long getListId() {
		return ListId;
	}

	public void setListId(long listId) {
		ListId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@JsonIgnore
	public List<ListEntries> getListEntries() {
		return listEntries;
	}

	@JsonIgnore
	public void setListEntries(List<ListEntries> listEntries) {
		this.listEntries = listEntries;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listEntries, listName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListModel other = (ListModel) obj;
		return Objects.equals(listEntries, other.listEntries) && Objects.equals(listName, other.listName);
	}

	@Override
	public String toString() {
		return "ListModel [ListId=" + ListId + ", listName=" + listName + ", listEntries=" + listEntries + "]";
	}

}
