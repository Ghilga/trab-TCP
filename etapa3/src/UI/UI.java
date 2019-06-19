package UI;

import java.util.Map;
import java.util.Scanner;

import domain.Database;

public class UI {
	
	private Map<String, UICommand> commands;
	public static Scanner scanner = new Scanner(System.in);
	
	public String getCommand() {
		return null;
	}
	
	public static void main(String[] args) {
		new Database();
		UICommand teste = new AllocationCommand();
		teste.execute();
	}

}
