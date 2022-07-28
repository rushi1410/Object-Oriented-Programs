package com.bridgelabz.StockAccountManagement;

public class Main {
	  public static void main(String[] args) {
	        System.out.println("Creating new stock account. Add stocks to User Portfolio");
	        StockAccount stockAccount = new StockAccount("Rushi", 100000);

	        loop : do {
	            int choice = stockAccount.showMainMenu();
	            switch (choice) {
	                case 1 -> stockAccount.buyStock();
	                case 2 -> stockAccount.sellStock();
	                case 3 -> stockAccount.addAccountBalance();
	                case 4 -> stockAccount.showAccountBalance();
	                case 5 -> stockAccount.stockPortfolio.printPortfolioReport();
	                default -> {
	                    break loop;
	                }
	            }
	        } while (true);

	    }
}
