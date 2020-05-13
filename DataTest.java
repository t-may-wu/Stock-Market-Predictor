package project2;

import java.awt.Dimension;
import java.io.*;

import javax.swing.JFrame;

public class DataTest 
{

	public static void main(String[] args) throws IOException
	{
		Data dat = new Data("/project2/dow_jones_index.data");
		BasicPredictor stockMan = new Broker(dat);
		stockMan.setPortfolioAmount(10000);
		stockMan.predict();
		System.out.println("type 1 final amount $"+stockMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker1 stockerMan = new Broker1(dat);
		stockerMan.setPortfolioAmount(10000);
		stockerMan.predict();
		System.out.println("type 2 final amount $"+stockerMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker2 stockestMan = new Broker2(dat);
		stockestMan.setPortfolioAmount(10000);
		stockestMan.predict();
		System.out.println("type 3 final amount $"+stockestMan.getPortfolioAmount());
		
//		System.out.println(dat.getStockCount());
//		System.out.println(dat.getWeekCount());
//		System.out.println(dat.getStocksWeek(1, 1));
//		System.out.println(dat.getStockSymbol(2));
//		System.out.println(dat.getStockName(2));
//		System.out.println(dat.getWeekDate(3));		
//		System.out.println(stockMan.rankStocks(3));
		
		//Build the frame 
		JFrame frame=new JFrame("Project2");
		//Set the frame to exit when close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set the size of the frame
		frame.setPreferredSize(new Dimension(600,600));
		//Add the panel
		frame.getContentPane().add(new MainPanel());
		//Makes sure all contents are packed based on their preferred sizes
		frame.pack();
		//Make the frame visible
		frame.setVisible(true);
	}

}
