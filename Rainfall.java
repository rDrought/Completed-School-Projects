
//Alexander Chukwuka
// The "Rainfall" class.
import hsa.*;
import java.util.*;

public class Rainfall {
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		int[] months = new int[12];
		double[] rainfall = new double[12];

		for (int i = 0; i < rainfall.length; i++) {
			System.out.print("Enter the amount of rainfall for month " + (i + 1) + ": ");
			rainfall[i] = c.nextDouble();
		}
		for (int y = 0; y < months.length; y++) {
			months[y] = y + 1;
		}
		double rain = totalrainfall(rainfall);
		Average(rainfall, rain);
		Mostrain(rainfall, months);
		Leastrain(rainfall, months);
	}

	public static double totalrainfall(double[] rainfall) {
		double rain = 0;
		for (int i = 0; i < rainfall.length; i++) {
			rain += rainfall[i];
		}
		System.out.println("\nThe total amount of rainfall is: " + rain);
		return rain;
	}

	public static void Average(double[] rainfall, double rain) {
		double Average = rain / rainfall.length;
		System.out.println("The Average rainfall is: " + Average);
	}

	public static void Mostrain(double[] rainfall, int[] months) {
		double highest = rainfall[0];
		int month = 0;
		for (int i = 0; i < rainfall.length; i++) {
			if (rainfall[i] > highest) {
				highest = rainfall[i];
				month = months[i];
			}
		}
		System.out.println("The month with the highest amont of rainfall is: " + month);
	}

	public static void Leastrain(double[] rainfall, int[] months) {
		double lowest = rainfall[0];
		int month = 0;
		for (int i = 1; i < rainfall.length; i++) {
			if (rainfall[i] < lowest) {
				lowest = rainfall[i];
				month = months[i];
			}
		}
		System.out.println("The month with the lowest amont of rainfall is: " + month);
	}
} // Rainfall class
