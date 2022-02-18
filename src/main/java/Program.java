import java.util.List;
import java.util.Scanner;

import controller.CoinHelper;
import model.Coin;

/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 1, 2022
 */

public class Program {
	static Scanner in = new Scanner(System.in);
	static CoinHelper ch = new CoinHelper();
	
	public static void main(String[] args) {
		runMenu();
	}
	
	private static void runMenu() {
		System.out.println("Welcome to the coin collection management system.");
		boolean cont = true;
		while(cont) {
			System.out.println("Availiable options:");
			System.out.println("- 1 - Add a coin");
			System.out.println("- 2 - Edit a coin");
			System.out.println("- 3 - Remove a coin");
			System.out.println("- 4 - View your collection");
			System.out.println("- 5 - Quit");
			System.out.print("Enter an option: ");
			String chosenOption = in.nextLine();
			if(chosenOption.equals("1")) {
				addCoin();
			} else if(chosenOption.equals("2")) {
				editCoin();
			} else if(chosenOption.equals("3")) {
				removeCoin();
			} else if(chosenOption.equals("4")) {
				viewCoins();
			} else if(chosenOption.equals("5")) {
				System.out.println("Bye!");
				ch.cleanUp();
				cont = false;
			}
			
		}
	}
	
	private static void addCoin() {
		System.out.print("Enter the country: ");
		String country = in.nextLine();
		System.out.print("Enter the year: ");
		int year = Integer.parseInt(in.nextLine());
		System.out.print("Enter the denomination: ");
		String denomination = in.nextLine();
		Coin toAdd = new Coin(country, year, denomination);
		ch.addCoin(toAdd);
		System.out.println("Coin added.");
	}
	
	private static void editCoin() {
		System.out.print("Enter the ID of the coin to edit: ");
		try {
		int id = Integer.parseInt(in.nextLine());
		Coin toEdit = ch.getCoinById(id);
		System.out.println("You are editing the coin '" + toEdit.getCoinInfo() + "'. Do you want to:");
		System.out.println("- 1 - Edit country");
		System.out.println("- 2 - Edit year");
		System.out.println("- 3 - Edit denomination");
		String chosenOption = in.nextLine();
		if(chosenOption.equals("1")) {
			System.out.print("Enter the country: ");
			String country = in.nextLine();
			toEdit.setCountry(country);
		} else if(chosenOption.equals("2")) {
			System.out.print("Enter the year: ");
			int year = Integer.parseInt(in.nextLine());
			toEdit.setYear(year);
		} else if(chosenOption.equals("3")) {
			System.out.print("Enter the denomination: ");
			String denomination = in.nextLine();
			toEdit.setDenomination(denomination);
		}
		ch.editCoin(toEdit);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, returning to the menu.");
			return;
		}	
	}
	
	private static void removeCoin() {
		System.out.print("Enter the ID of the coin to remove: ");
		try {
		int id = Integer.parseInt(in.nextLine());
		Coin toRemove = ch.getCoinById(id);
		ch.removeCoin(toRemove);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, returning to the menu.");
		}
	}
	
	private static void viewCoins() {
		List<Coin> allCoins = ch.getAllCoins();
		for(Coin singleCoin : allCoins){
			System.out.println(singleCoin.getFullCoinInfo());
			}
	}
	
}
