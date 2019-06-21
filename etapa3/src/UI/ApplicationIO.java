package UI;

import java.util.InputMismatchException;

public class ApplicationIO {

	public static String readString() {
		return null;
	}

	public static int readInteger() {
		Integer integerInput = null;
		while(integerInput == null) {
			try {
				integerInput = UI.scanner.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Entrada Invalida! (Deve ser um numero inteiro)");
				UI.scanner.next();
			}
		}
		
		return integerInput.intValue();
	}

}
