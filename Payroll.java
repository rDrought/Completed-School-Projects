
// Alexander Chukwuka
// The "Payroll" class.
import hsa.*;
import java.util.*;

public class Payroll {
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		int[] Employeeid = new int[7];
		int[] Hours = new int[7];
		double[] Payrate = new double[7];
		double[] wages = new double[7];

		for (int index = 0; index < Employeeid.length; index++) {
			System.out.print("Enter the employee number for employee " + (index + 1) + ":");
			Employeeid[index] = c.nextInt();
		}
		System.out.println("----------------------------------------------");
		Hoursworked(Employeeid, Hours, c);
		System.out.println("----------------------------------------------");
		Payrate(Employeeid, Payrate, c);
		System.out.println("----------------------------------------------");
		Wagecount(Employeeid, Hours, Payrate, wages, c);
		System.out.println("----------------------------------------------");
		Displayvalues(Employeeid, Hours, Payrate, wages, c);

	}

	public static int[] Hoursworked(int[] Employeeid, int[] Hours, Scanner c) {
		for (int index = 0; index < Employeeid.length; index++) {
			System.out.println("Enter the hours worked by Employee number " + Employeeid[index]);
			Hours[index] = c.nextInt();
		}
		return Hours;
	}

	public static double[] Payrate(int[] Employeeid, double[] Payrate, Scanner c) {
		for (int index = 0; index < Employeeid.length; index++) {
			System.out.println("Enter the Payrate for Employee number " + Employeeid[index]);
			Payrate[index] = c.nextInt();
		}
		return Payrate;
	}

	public static double[] Wagecount(int[] Employeeid, int[] Hours, double[] Payrate, double[] wages, Scanner c) {
		for (int index = 0; index < Employeeid.length; index++) {
			wages[index] = Hours[index] * Payrate[index];
		}
		return wages;
	}

	public static void Displayvalues(int[] Employeeid, int[] Hours, double[] Payrate, double[] wages, Scanner c) {
		System.out.println("ID Number\tWage");
		System.out.println("----------------------------------------------");
		for (int index = 0; index < Employeeid.length; index++) {
			System.out.println(Employeeid[index] + "\t\t" + "$" + wages[index]);
		}
	}
} // Payroll class
