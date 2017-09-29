package compareDataTypes;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CompareLinkedList_HashTable {
	private ArrayList<String> listOfWords = new ArrayList<String>();
	private ArrayList<String> listOfRandomWordsToFind = new ArrayList<String>();
	private ArrayList<String> listOfRandomWordsToAdd = new ArrayList<String>();
	private ArrayList<Records> record = new ArrayList<Records>();

	private long startTime;
	private long endTime;
	private long runtime;

	private final double GROWTH_FACTOR = 1.02;
	private final int NUMBER_OF_TESTRUNS = 200;
	private final int RANDOM_LIMIT = 10000;

	public CompareLinkedList_HashTable() {
		// creates the dataset for filling the structure
		WordList words = new WordList();
		// brings the data over
		listOfWords = words.getList();
		// generates second dataset for find testing...
		for (int i = 0; i < RANDOM_LIMIT; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt(listOfWords.size() - 1);
			listOfRandomWordsToFind.add(listOfWords.get(randomNumber));
		}
		
		for (int i = 0; i < RANDOM_LIMIT; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt(listOfWords.size() - 1);
			listOfRandomWordsToAdd.add(listOfWords.get(randomNumber));
		}

	}

	public void runComparisons() {
		runOpsTest();
		runPerformanceTest();
		printRecords();
	}

	public void runOpsTest() {
		 DumbList findTestList = new DumbList();
		 findNumberOfOpsOneSecond(findTestList);

		HashStructure findTestTable = new HashStructure();
		findNumberOfOpsOneSecond(findTestTable);
	}

	public void findNumberOfOpsOneSecond(DataType test) {
		int counter = 0;
		startTime = System.currentTimeMillis();
		endTime = startTime + 1000;
		while (System.currentTimeMillis() < endTime) {
			test.addElement(listOfWords.get(counter));
			counter++;
		}
		endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
		System.out.println(test.getSize());
		writeLog("# added in 1 second", test.getType(), runtime, test.getSize());
	}

	public void writeLog(String id, String type, long time, int size) {
		Records newRecord = new Records(id, type, time, size);
		record.add(newRecord);

	}

	public void runPerformanceTest() {
		int size = 200;
		for (int i = 0; i < NUMBER_OF_TESTRUNS; i++) {
			 DumbList testList = new DumbList();
			 trackPerformanceAtSize(testList, size);

			HashStructure testHash = new HashStructure();
			trackPerformanceAtSize(testHash, size);

			size = (int) ((int) size * GROWTH_FACTOR);

		}

	}

	public void trackPerformanceAtSize(DataType test, int size) {


		for (int j = 0; j < size; j++) {
			test.addElement(listOfWords.get(j));
		}

		startTime = System.currentTimeMillis();
		for (int k = 0; k < RANDOM_LIMIT; k++) {
			test.addElement(listOfRandomWordsToAdd.get(k));
		}
		endTime = System.currentTimeMillis();
		runtime = endTime - startTime;

		writeLog("add 10k random words", test.getType(), runtime, test.getSize());

		startTime = System.currentTimeMillis();
		for (int k = 0; k < RANDOM_LIMIT; k++) {
			test.findElement(listOfRandomWordsToFind.get(k));
		}
		endTime = System.currentTimeMillis();
		runtime = endTime - startTime;

		writeLog("Find 10k random words", test.getType(), runtime, test.getSize());

	}

	public void printRecords() {

		for (Records in : record) {
			System.out.println(in.toString());
		}
	}

}
