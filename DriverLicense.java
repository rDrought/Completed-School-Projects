
// Alexander Chukwuka
// The "DriverLicense" class.
import hsa.*;
import java.util.Scanner;

public class DriverLicense {
	public static void main(String[] args) {
		String[] answers = { "b", "d", "a", "a", "c", "a", "b", "a", "c", "d", "b", "c", "d", "a", "d", "c", "c", "b",
				"d", "a" };
		String[] hisansw = new String[20];
		Input(hisansw);
		passed(answers, hisansw);
		totalcorrect(answers, hisansw);
		totalincorrect(answers, hisansw);

	}

	public static void Input(String[] hisansw) {
		Scanner c = new Scanner(System.in);
		System.out.println("Enter the students' answers");
		for (int index = 0; index < hisansw.length; index++) {
			hisansw[index] = c.nextLine();
			if ((!"a".equals(hisansw[index]))) {
				if ((!"b".equals(hisansw[index]))) {
					if ((!"c".equals(hisansw[index]))) {
						if ((!"d".equals(hisansw[index]))) {
							System.out.println("Please enter a valid Answer");
							hisansw[index] = c.nextLine();
							System.out.println(hisansw[index]);
						}
					}
				}
			}
		}
	}

	public static void passed(String[] answers, String[] hisansw) {
		int marks = 0;
		for (int index = 0; index < answers.length; index++) {
			if (hisansw[index].equals(answers[index])) {
				marks++;
			}
		}
		if (marks >= 15) {
			System.out.println("Congratulations you passed");
		} else {
			System.out.println("You have failed this test");
		}
	}

	public static void totalcorrect(String[] answers, String[] hisansw) {
		int marks = 0;
		for (int index = 0; index < answers.length; index++) {
			if (hisansw[index].equals(answers[index])) {
				marks++;
			}
		}
		System.out.println("You correctly answerd " + marks + "/20 questions");
	}

	public static void totalincorrect(String[] answers, String[] hisansw) {
		int marks = 0;
		for (int index = 0; index < answers.length; index++) {
			if (!hisansw[index].equals(answers[index])) {
				marks++;
			}
		}
		System.out.println("You have missed " + marks + " questions");
	}
} // DriverLicense class
