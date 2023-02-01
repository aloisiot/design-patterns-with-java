package br.com.cod3r.iterator.cart;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Cart implements Iterable<Product> {
	List<Product> products;
	
	public Cart(Product... products) {
		this.products = Arrays.asList(products);
	}

	@NotNull
	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
