package com.bridgelabz.StockAccountManagement;

public class Stock {
	  private String stockName;
	    private int numberOfShares;
	    private double pricePerShare;
	    private double stockValue;

	    Stock(String stockName, int numberOfShares, double pricePerShare){
	        this.stockName = stockName;
	        this.numberOfShares = numberOfShares;
	        this.pricePerShare = pricePerShare;
	        this.stockValue = numberOfShares * pricePerShare;
	    }

	    public String getStockName() {
	        return stockName;
	    }

	    public void setStockName(String stockName) {
	        this.stockName = stockName;
	    }

	    public int getNumberOfShares() {
	        return numberOfShares;
	    }

	    public void setNumberOfShares(int numberOfShares) {
	        this.numberOfShares = numberOfShares;
	        setStockValue(this.numberOfShares * this.pricePerShare);
	    }

	    public double getPricePerShare() {
	        return pricePerShare;
	    }

	    public void setPricePerShare(double pricePerShare) {
	        this.pricePerShare = pricePerShare;
	    }

	    public double getStockValue() {
	        return stockValue;
	    }

	    public void setStockValue(double stockValue) {
	        this.stockValue = stockValue;
	    }

}
