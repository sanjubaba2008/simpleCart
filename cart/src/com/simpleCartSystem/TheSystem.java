package com.simpleCartSystem;

/*purpose: To maintain the list of items and the main logic of the system that is
 *         similar in the app and cart classes. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

//	 properties

	private HashMap<String, Item> itemCollection;// provides the list of items in the system or the
	// cart depending on which class initiates it

	TheSystem() throws FileNotFoundException {
		// Your code here
		this.itemCollection = new HashMap<String, Item>();// empty HashMap

		// checking if the AppSystem is invoking the constructor
		if (getClass().getSimpleName().equals("AppSystem")) {
			final File myFile = new File("sample.txt");
			final Scanner scan = new Scanner(myFile);

			while (scan.hasNextLine()) {
				final String line = scan.nextLine();
				// System.out.println(line);
				final String[] itemInfo = line.split("\s ");

				final String itemName = itemInfo[0];
				final String itemDesc = itemInfo[1];
				final Double itemPrice = Double.parseDouble(itemInfo[2]);
				final Integer availableQuantity = Integer.parseInt(itemInfo[3]);

				// calling Item constructor
				final Item item = new Item(itemName, itemDesc, itemPrice, availableQuantity);

				// adding item to the HashMap
				itemCollection.put(itemName, item);

			} // end while
		} // end if
	}// end TheSystem constructor

	// Getter and Setter

	public HashMap<String, Item> getItemCollection() {
		return itemCollection;
	}

	public void setItemCollection(final HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

	public Boolean checkAvailability(final Item item) {
		// Your code here
		if (item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.println("System is unable to add " + item.getItemName() + "to the cart. System only has "
					+ item.getAvailableQuantity() + " " + item.getItemName() + "s.");
			return false;

		} // end if
		else
			return true;
	}// end checkAvailability(Item item)

	public Boolean add(final Item item) throws FileNotFoundException {
		// Your code here
		// HashMap<String, Item> myCollection = getItemCollection();
		if (item == null)
			return false;
		else if (itemCollection.containsKey(item.getItemName()) && (item.getAvailableQuantity() != 0)) {
			int a = item.getQuantity();
			++a;
			item.setQuantity(a);
			return true;
		} else if (!(getItemCollection().containsKey(item.getItemName()))) {
			getItemCollection().put(item.getItemName(), item);
			return true;

		} else
			return false;
	}// end add method

	public Item remove(final String itemName) {
		// Your code here
		Item item = null;
		if (getItemCollection().containsKey(itemName)) {
			item = itemCollection.remove(itemName);
			return item;
		}
		return item;
	}// end remove method

	public abstract void display() throws FileNotFoundException;

}
