package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double total;

// link to customer	
	@ToString.Exclude
	@OneToOne(mappedBy = "cart")
	private Customer customer;

// Needs to have temp list of albums linked to album	
	@ToString.Exclude
	@ManyToMany
	@JoinTable(name = "cart_album", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
	private List<Album> albums;

	public Cart(double total, Customer customer, List<Album> albums) {
		super();
		this.total = total;
		this.customer = customer;
		this.albums = albums;
	}



	

}
