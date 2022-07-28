package com.bridgelabz.StockAccountManagement;

import java.util.Scanner;

public class StockAccount {
	 String userName;
	    double accountBalance;
	    StockPortfolio stockPortfolio;
	    Scanner input = new Scanner(System.in);

	    StockAccount(String userName, double accountBalance){
	        this.userName = userName;
	        this.accountBalance = accountBalance;
	        this.stockPortfolio = new StockPortfolio();
	        System.out.println("Stock Account successfully created and user Portfolio updated.");
	    }

	    void buyStock(){
	        System.out.print("Enter Stock name: ");
	        String stockName = input.next();
	        System.out.print("Enter number of shares: ");
	        int numberOfShares = input.nextInt();
	        System.out.print("Enter price per share: ");
	        double pricePerShare = input.nextDouble();

	        if(numberOfShares * pricePerShare < accountBalance) {
	            Stock stock = new Stock(stockName, numberOfShares, pricePerShare);
	            stockPortfolio.stockList.add(stock);
	            this.accountBalance = this.accountBalance - (numberOfShares * pricePerShare);
	            System.out.println("Stock added to your Portfolio successfully.\n");
	            stockPortfolio.updatePortfolioValue();
	        } else {
	            System.out.println("Your account balance is less than the stock value you're trying to buy. Press 1 to add account balance..");
	            if(input.nextInt() == 1) {
	                addAccountBalance();
	            }
	        }
	    }

	    void sellStock(){
	        System.out.print("Enter Stock name: ");
	        String stockName = input.next();
	        System.out.print("Enter number of shares: ");
	        int numberOfShares = input.nextInt();

	        for(Stock stock : stockPortfolio.stockList){
	            if(stockName.equalsIgnoreCase(stock.getStockName())){
	                if(numberOfShares <= stock.getNumberOfShares()){
	                    this.accountBalance = this.accountBalance + (numberOfShares * stock.getPricePerShare());
	                    stock.setNumberOfShares(stock.getNumberOfShares() - numberOfShares);
	                    stockPortfolio.updatePortfolioValue();
	                    System.out.println("Stock sold from your Portfolio successfully.\n");
	                } else {
	                    System.out.println("The entered stock quantity is more than the quantity in Portfolio.");
	                }
	            }
	        }
	    }

	    void showAccountBalance(){
	        System.out.println("Account holder Name: " + this.userName);
	        System.out.println("Account balance: " + this.accountBalance);
	    }


	    void addAccountBalance(){
	        System.out.print("Enter the amount to add: ");
	        double amount = input.nextDouble();
	        this.accountBalance = accountBalance + amount;
	    }

	    public int showMainMenu() {
	        System.out.println("\nMain Menu:\n 1.Buy Stock \n 2.Sell Stock \n 3.Add account balance \n 4.Show Account Balance \n 5.Show Portfolio details \n 0.Exit\n");
	        System.out.print("Enter your choice: ");
	        return input.nextInt();
	    }

	}

