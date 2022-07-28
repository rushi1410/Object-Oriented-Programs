package com.bridgelabz.StockAccountManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockPortfolio {
	public List<Stock> stockList = new ArrayList<>();
    public double portfolioValue = 0;
    Scanner input = new Scanner(System.in);

    StockPortfolio(){
        System.out.print("Enter number of stocks: ");
        int N = input.nextInt();
        setStockDetails(N);
    }
    void setStockDetails(int N){
        for (int i = 1; i <= N; i++) {
            System.out.println("Stock " + i + ":");
            System.out.print("Enter Stock name: ");
            String stockName = input.next();
            System.out.print("Enter number of shares: ");
            int numberOfShares = input.nextInt();
            System.out.print("Enter price per share: ");
            double pricePerShare = input.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, pricePerShare);
            stockList.add(stock);
            updatePortfolioValue();
        }
    }

    void updatePortfolioValue(){
        double portfolioValue = 0;
        for (Stock stock: stockList) {
            portfolioValue = portfolioValue + stock.getStockValue();
        }
        this.portfolioValue = portfolioValue;
    }

    void printPortfolioReport(){
        System.out.println("-----------Portfolio Report-----------");
        System.out.println();

        for (Stock stock: stockList) {
            System.out.print("Stock Name: " + stock.getStockName());
            System.out.print("\nNumber of Shares: " + stock.getNumberOfShares());
            System.out.print("\nPrice Per Share: " + stock.getPricePerShare());
            System.out.print("\nStock Value: " + stock.getStockValue());
            System.out.println("\n");
        }
        System.out.print("PortFolio Value: " + this.portfolioValue + "\n");
    }

}
