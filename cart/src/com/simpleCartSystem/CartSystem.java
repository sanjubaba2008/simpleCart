package com.simpleCartSystem;

//purpose : To implement the logic related only to the cart
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CartSystem extends TheSystem {

	// CartSystem() {
	// }
	public CartSystem() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() throws FileNotFoundException {
		// Your code here

		System.out.println("Cart:");
		System.out.println();

		System.out.printf("%-20s %-20s %-10s %-10s %-10s %n", "Name", "Description", "Price", "Quantity", "Sub Total");

		// creating object of AppSystem to access the itemCollection from parent class
		// TheSystem
		// 3
		// CartSystem newObj = new CartSystem();

		// HashMap<String, Item> myCollection = newObj.getItemCollection();

		// getting Set of keys from itemCollection
		Set<Entry<String, Item>> mySet = getItemCollection().entrySet();

		// initializing iterator to iterate through myCollection
		Iterator itr = mySet.iterator();
		double preTax = 0;

		while (itr.hasNext()) {
			Map.Entry<String, Item> m1 = (Entry<String, Item>) itr.next();

			// getting values one by one
			String name = m1.getValue().getItemName();
			String description = m1.getValue().getItemDesc();
			Double price = m1.getValue().getItemPrice();
			String formattedPrice = String.format("%.2f", price);// formatted to meet the requirements
			Integer quantity = m1.getValue().getQuantity();

			Double subtotal = price * quantity;
			String formattedSubtotal = String.format("%.2f", subtotal);
			preTax = preTax + subtotal;

			System.out.printf("%-20s %-20s %-10s %-10d %-10s %n", name, description, formattedPrice, quantity,
					formattedSubtotal);

		} // end of while
		System.out.println();
		String formattedpreTax = String.format("%.2f", preTax);
		double tax = preTax * 0.05;
		String formattedTax = String.format("%.2f", tax);
		double total = preTax + tax;
		String formattedTotal = String.format("%.2f", total);

		System.out.printf("%-20s %-20s %n %-20s %-19s %n %-20s %-20s ", "Pre-tax Total", formattedpreTax, "Tax",
				formattedTax, "Total", formattedTotal);
		System.out.println();
		System.out.println();

	}

}
