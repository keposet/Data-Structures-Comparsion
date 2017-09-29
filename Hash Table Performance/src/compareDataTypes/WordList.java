package compareDataTypes;

import java.util.ArrayList;

public class WordList {
	
	ArrayList<String> elementList = new ArrayList<String>();
	String letters[] = { "q", "a", "z", "w", "s", "x", "e", "d", "c", "r", "f", "v", "t", "g", "b", "y", "h", "n",
			"u", "j", "m", "i", "k", "o", "l", "p" };

	public WordList() {
		// Creates a 12 million element arraylist of strings which can be used for
		// working with the data types

		// adds all single char to the list
		for (int i = 0; i < 13; i++) {
			elementList.add(letters[i]);
			// double char
			for (int j = 0; j < letters.length; j++) {
				elementList.add((letters[i] + letters[j]));
				// triple
				for (int k = 0; k < letters.length; k++) {
					elementList.add((letters[i] + letters[j] + letters[k]));
					// quad
					for (int l = 0; l < letters.length; l++) {
						elementList.add((letters[i] + letters[j] + letters[k] + letters[l]));
						// pent
						for (int m = 0; m < letters.length; m++) {
							elementList.add((letters[i] + letters[j] + letters[k] + letters[l] + letters[m]));

						}
					}
				}
			}
		}

	}
	
	public ArrayList<String> getList(){
		
		return elementList;
	}

}
