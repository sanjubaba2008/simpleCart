package com.simpleCartSystem;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//purpose: To implement the logic related only to the App System.

public class AppSystem extends TheSystem {

	public AppSystem() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() throws FileNotFoundException {
		// Your code here
		System.out.println("AppSystem Inventory");
		System.out.println();

		System.out.printf("%-20s %-20s %-10s %-10s %n", "Name", "Description", "Price", "Available Quantity");

		// getting Set of keys from itemCollection
		Set<Entry<String, Item>> mySet = getItemCollection().entrySet();

		// initializing iterator to iterate through myCollection
		Iterator itr = mySet.iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Item> m1 = (Entry<String, Item>) itr.next();

			// getting values one by one
			String name = m1.getValue().getItemName();
			String description = m1.getValue().getItemDesc();
			Double price = m1.getValue().getItemPrice();
			String formattedPrice = String.format("%.2f", price);// formatted to meet the requirements
			Integer quantity = m1.getValue().getAvailableQuantity();

			System.out.printf("%-20s %-20s %-10s %-10d %n", name, description, formattedPrice, quantity);

		} // end of while

	}// end of display method

	@Override // this overwrites the parents class add method
	public Boolean add(Item item) throws FileNotFoundException {
		// Your code here
		// AppSystem newObj = new AppSystem();
		// HashMap<String, Item> myCollection = newObj.getItemCollection();

		if (item == null)
			return false;
		else if (getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item.getItemName() + " is already in the App System");
			return false;

		} else

			getItemCollection().put(item.getItemName(), item);
		return true;

	}// end add

	public Item reduceAvailableQuantity(String item_name) throws FileNotFoundException {
		// Your code here
		// AppSystem newObj = new AppSystem();
		// HashMap<String, Item> myCollection = newObj.getItemCollection();
		if (getItemCollection().containsKey(item_name)) {
			Item item = getItemCollection().get(item_name);
			int a = item.getAvailableQuantity();
			--a;
			if (a == 0) {
				getItemCollection().remove(item_name);
			}
			item.setAvailableQuantity(a);
			return item;

		}

		return null;
	}// end reduceAvailableQuantity

}
