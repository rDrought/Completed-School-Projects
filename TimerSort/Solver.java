public class Solver {
    public static void main(String[] args) {
        final int SIZE = 1000000; // 1 million
        final int Instances = 20;
        int[][] TwoDimArray = new int[Instances][SIZE];

        Sort s = new Sort();

        for (int i = 0; i < Instances; i++) {
            s.initializeArray(TwoDimArray[i], SIZE);
            s.randomizeArray(TwoDimArray[i], SIZE);
        }

        System.out.println("For Insertion Sort: ");

        long startTime = System.nanoTime();

        for (int i = 0; i < Instances; i++) {

            System.out.println("Array " + (i + 1));

            s.insertionSort(TwoDimArray[i], SIZE);

        }

        long duration = (System.nanoTime() - startTime) / 1000000;

        System.out.println("Duration in seconds:" + (duration / 1000.0));

        for (int i = 0; i < Instances; i++) {

            s.initializeArray(TwoDimArray[i], SIZE);

        }

        System.out.println("For Quick Sort: ");

        startTime = System.nanoTime();

        for (int i = 0; i < Instances; i++) {

            System.out.println("Array " + (i + 1));

            s.quickSort(TwoDimArray[i], 0, 100);

        }

        duration = (System.nanoTime() - startTime) / 1000000;

        System.out.println("Duration in seconds:" + (duration / 1000.0));

        for (int i = 0; i < Instances; i++) {

            s.initializeArray(TwoDimArray[i], SIZE);

        }

        System.out.println("For Randomized Quick Sort: ");

        startTime = System.nanoTime();

        for (int i = 0; i < Instances; i++) {

            System.out.println("Array " + (i + 1));

            s.randQuickSort(TwoDimArray[i], 0, 100);

        }

        duration = (System.nanoTime() - startTime) / 1000000;

        System.out.println("Duration in seconds:" + (duration / 1000.0));

    }

}
