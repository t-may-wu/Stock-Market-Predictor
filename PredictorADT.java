package project2;

import java.util.ArrayList;

public interface PredictorADT 
{
	public void setPortfolioAmount(double amount);
	public double getPortfolioAmount();
	public void setDataSet(StockDataADT data);
	public void predict();
	
	public ArrayList<String> rankStocks(int weekIndex);
}
