package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationIO {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static String readString() {
		String stringInput = null;
		
		while(stringInput == null) {
			try {
				stringInput = scanner.nextLine();
			} catch (InputMismatchException ex) {
				System.out.println("Entrada Invalida! (Deve ser uma palavra)");
				scanner.next();
			}
		}
		
		return stringInput;
	}

	public static int readInteger() {
		Integer integerInput = null;
		while(integerInput == null) {
			try {
				integerInput = scanner.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Entrada Invalida! (Deve ser um numero inteiro)");
				scanner.next();
			}
		}
		
		return integerInput.intValue();
	}
	
	public static void closeScanner() {
		scanner.close();
	}

}
