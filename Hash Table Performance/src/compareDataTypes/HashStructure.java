package compareDataTypes;

import compareDataTypes.DumbList.Node;
import compareDataTypes.DumbList;

public class HashStructure implements DataType {

	private int numberOfElements;
	private DumbList[] hashArrary = new DumbList[20];
	private String type = "HashTable";

	public HashStructure() {
		hashArrary = activateArray(hashArrary);
	}

	private DumbList[] activateArray(DumbList[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = new DumbList();
		}

		return array;
	}

	private int findIndex(String data) {
		Integer index = data.hashCode();
		index = index % hashArrary.length;
		return index;
	}

	public boolean addElement(String newValue) {
		// TODO Auto-generated method stub
		// is found?
		// not found, add
		boolean added = false;
		if (!findElement(newValue)) {
			hashArrary[findIndex(newValue)].addElement(newValue);
//			System.out.println(newValue + " added at " + findIndex(newValue));
			numberOfElements++;
			resizeTable();
			added = true;

		}
		return added;
	}

	public boolean removeElement(String value) {
		// TODO Auto-generated method stub
		boolean removed = false;
		if (findElement(value)) {
			hashArrary[findIndex(value)].removeElement(value);
//			System.out.println(value + " removed at " + findIndex(value));
			numberOfElements--;
			removed = true;
		}
		return removed;
	}

	public boolean findElement(String query) {
		// TODO Auto-generated method stub
		// find index, search list
		// boolean found = hashArrary[findIndex(query)].findElement(query);
		// debug
		boolean found = false;
		if (hashArrary[findIndex(query)].getHead() != null) {
			if (hashArrary[findIndex(query)].findElement(query)) {
				found = true;
			}
		}

		return found;
	}

	private void resizeTable() {
		// what are the things i need to do?
		// query # of elements, if # > size*.7 then
		// create a larger array
		// re add everything to that array
		if (numberOfElements >= (hashArrary.length * .69)) {

//			System.out.println("Resizing because there are " + numberOfElements + " elements in the list.");
			numberOfElements = 0;
			// create a temp array and activate it
			DumbList[] temp = new DumbList[hashArrary.length];
			temp = activateArray(temp);

			// copy all the data from the array into temp
			for (int i = 0; i < temp.length; i++) {
				temp[i] = hashArrary[i];
			}

			// create a bigger array and activate it
			DumbList[] biggerHashArray = new DumbList[(hashArrary.length * 2)];
			biggerHashArray = activateArray(biggerHashArray);

			// change the reference of hA to the address of bHA
			hashArrary = biggerHashArray;

			// add all the previous elements to the new Table
			for (DumbList dumbList : temp) {
				if (dumbList.getHead() != null) {
					Node node = dumbList.getHead();
					addElement(node.getData());
					while (node.getNext() != null) {
						node = node.getNext();
						addElement(node.getData());
					}

				}
			}
		}

	}

	public void printList() {
		for (DumbList newDumbList : hashArrary) {
			if (newDumbList.getHead() != null) {
				newDumbList.printList();
			}
		}
	}

	public void printVerbose() {
//		System.out.println("The table now has " + hashArrary.length + " buckets");
		for (int i = 0; i < hashArrary.length; i++) {
			DumbList newDumbList = hashArrary[i];
			System.out.println("bucket " + i);
			if (newDumbList != null) {
				newDumbList.printList();
			}
		}

	}

	public int getSize() {
		// TODO Auto-generated method stub
		return hashArrary.length;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
