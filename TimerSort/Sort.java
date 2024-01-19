import java.util.Random;

public class Sort {

	// swap the ith element with the jth elements.
	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// initialize the array a with elements from 0 to size-1.
	public void initializeArray(int[] a, int size) {
		for (int i = 0; i < size; i++) {
			a[i] = i;
		}
	}

	// display the elements in the array a, rowSize elements per row.
	public void displayArray(int[] a, int size) {
		int rowSize = 100;
		for (int i = 0; i < size; i++) {
			if (i % rowSize == 0) {
				System.out.println();
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// randomly swap two elements in a for SWAPTIMES times.
	public void randomizeArray(int[] a, int size) {
		final int SWAPTIMES = 10000;
		Random r = new Random();
		int j, k;
		for (int i = 0; i < SWAPTIMES; i++) {
			j = r.nextInt(size);
			k = r.nextInt(size);
			this.swap(a, j, k);
		}
	}

	// selectionSort
	public void selectionSort(int a[], int size) {
		int i, j, min, minIndex;
		for (j = 0; j < size - 1; j++) {// select jth element.
			minIndex = j;
			min = a[j];
			for (i = j + 1; i < size; i++) {
				if (a[i] < min) {
					minIndex = i;
					min = a[i];
				}
			}
			this.swap(a, j, minIndex);
		}
	}

	/* method to sort array using insertion sort */
	public void insertionSort(int a[], int size) {
		int n = a.length;
		for (int i = 1; i < n; ++i) {
			int key = a[i];
			int j = i - 1;

			/*
			 * Move elements of a[0..i-1], that are
			 * greater than key, to one position ahead
			 * of their current position
			 */
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		}
	}

	// method heapSort
	public void heapSort(int a[]) {
		int n = a.length;

		// build maxHeap
		buildMaxHeap(a);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			swap(a, 0, i);

			// call max maxHeapify on the reduced heap
			maxHeapify(a, 0, i);
		}
	}

	// method to buildMaxHeap
	public void buildMaxHeap(int a[]) {
		// Build heap (re arrange array)
		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(a, i, n);
	}

	// To maxHeapify a subtree rooted with node i which is
	// an index in a[]. n is size of heap
	void maxHeapify(int a[], int i, int n) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && a[l] > a[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && a[r] > a[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			swap(a, i, largest);

			// Recursively maxHeapify the affected sub-tree
			maxHeapify(a, largest, n);
		}
	}
	// accepts a single array and calls the overloaded method for performing
	// Randomized QuickSort

	public void randQuickSort(int arr[]) {

		randQuickSort(arr, 0, arr.length - 1);

	}

	// accepts a single array and calls the overloaded method for performing
	// QuickSort

	public void quickSort(int arr[]) {

		quickSort(arr, 0, arr.length - 1);

	}

	public void randQuickSort(int arr[], int left, int right) {

		if (left >= right)

			return;

		Random rand = new Random();

		// pick a random pivot in the range [left,right]

		// if rand.nextInt() = 0, you get left as the index, If it returns (right -
		// left),

		// you will get (right - left + left) = right as the index

		int index = rand.nextInt(right - left) + left;

		// set pivot

		int pivot = arr[index];

		// partition on the pivot

		int partition_index = partition(arr, left, right, pivot);

		// call quicksort on both sides of the partition index

		randQuickSort(arr, left, partition_index - 1);

		randQuickSort(arr, partition_index, right);

	}

	public void quickSort(int arr[], int left, int right) {

		if (left >= right)

			return;

		// pick the first element in the subarray as the pivot

		int pivot = arr[left];

		// partition around the pivot

		int partition_index = partition(arr, left, right, pivot);

		// call quicksort on both sides of the partition index

		quickSort(arr, left, partition_index - 1);

		quickSort(arr, partition_index, right);

	}

	// this method partitions a subarray in [left,right] such that all elements less
	// than pivot are on one the left side

	// and all elements greater than pivot are on the right side of an index called
	// the partition index

	public int partition(int arr[], int left, int right, int pivot) {

		// repeat while left is less than or at most equal to right

		while (left <= right) {

			// find the first element greater than pivot on the left side

			while (arr[left] < pivot)

				left++;

			// find the first element less than pivot on the right side

			while (arr[right] > pivot)

				right--;

			// if indices are still valid, swap the values

			if (left <= right) {

				swap(arr, left, right);

				left++;

				right--;

			}

		}

		// value of the left pointer is the partition_index

		return left;

	}

}
