package com.bofa.interview.algo;

import com.bofa.interview.domain.DataSet;
import com.bofa.interview.exception.InvalidDataException;
import com.bofa.interview.util.ChallengeUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ModeBAlgo implements AlgoInterface {
	@SuppressWarnings("rawtypes")
	@Override
	public void calculateAndPrintDistance(String data) throws InvalidDataException {

		// Get the data and convert to right format
		DataSet dataSet = ChallengeUtil.buildDataSet(data);

		System.out.print(dataSet.getStartingIndex() + " ");

		// make sure the loop breaks

		int travelDistance = 0;
		int startingFloor = dataSet.getStartingIndex();
		int i = 0;
		int totalTravel = 0;
		List broutes = (List) dataSet.getRoutes();
		int droppingFloor = (int) broutes.get(0);
		travelDistance = startingFloor - droppingFloor;
		List<Integer> dirList = new ArrayList<>();
		List<Integer> finalList = new ArrayList<>();

		dirList.add(startingFloor);

		while (!(broutes.size() == 0)) {
			if (travelDistance > 0) {
				// Loop through all downward direction consecutive request
				// travel
				while (travelDistance > 0 && !(broutes.size() == 0)) {

					if (broutes.size() > 0)
						travelDistance = (int) broutes.get(i) - (int) broutes.get(i + 1);
					if (travelDistance > 0) {
						dirList.add((int) broutes.get(i));
						dirList.add((int) broutes.get(i + 1));
						broutes.remove(i);
						broutes.remove(i);
					}

				}
				Set<Integer> sorted = new TreeSet<Integer>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});

				sorted.addAll(dirList);
				finalList.addAll(sorted);
				sorted.clear();
				dirList.clear();
			} else if (travelDistance < 0) {
				// Loop through all upward direction consecutive request travel
				while (travelDistance < 0 && !(broutes.size() == 0)) {

					if (broutes.size() > 0)
						travelDistance = (int) broutes.get(i) - (int) broutes.get(i + 1);
					if (travelDistance < 0) {
						dirList.add((int) broutes.get(i));
						dirList.add((int) broutes.get(i + 1));
						broutes.remove(i);
						broutes.remove(i);
					}

				}
				Set<Integer> sorted = new TreeSet<Integer>(dirList);
				finalList.addAll(sorted);
				sorted.clear();
				dirList.clear();

			}
		}

		for (int k = 1; k <= finalList.size() - 1; k++) {
			if ((int) finalList.get(k - 1) == (int) finalList.get(k)) {
				finalList.remove(k);
			}
			totalTravel = totalTravel + Math.abs(finalList.get(k) - finalList.get(k - 1));
			System.out.print(finalList.get(k) + " ");

		}
		System.out.print("(" + totalTravel + ")");
		System.out.println();

	}

}