
package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;


public class MainPanel extends JPanel {
	  //Create the variables
	  private final int WIDTH=400, HEIGHT=400;
	  private JPanel predictorPanel;
	  private JLabel label1;
	  private JLabel label2;
	  private JLabel label3;
	  private JLabel label4;
	  private JLabel label5;
	  private JLabel label6;
	  private JLabel label7;
	  private JLabel type1amount;
	  private JLabel type2amount;
	  private JLabel type3amount;
	  private JLabel info1;
	  private JLabel info2;
	  private JLabel info3;
	  private JLabel info4;
	  private JLabel info5;
	  private JLabel icon1;
	  private JLabel count;
	  private JSlider slider;
	  private JButton buy1;
	  private JButton buy2;
	  private JButton buy3;
	  private JCheckBox name1;
	  private JCheckBox name3;
	  private JRadioButton radio1;
	  private JRadioButton radio2;
	  private JRadioButton radio3;
	  private JTextArea textArea;
	  private JTextArea textArea1;
	  private ImageIcon image1;
	  private JTextField textField;
	  private JTextField textField_1;
	  private JScrollPane scroll1;
	  private JScrollPane scroll2;
	  
	  public MainPanel()
	  {
	  //Includes the data file
	  Data dat = new Data("/project2/dow_jones_index.data");
	  //Run the 3 different predictors
	  BasicPredictor stockMan = new Broker(dat);
	  stockMan.setPortfolioAmount(10000);
      stockMan.predict();
	  Broker1 stockerMan = new Broker1(dat);
	  stockerMan.setPortfolioAmount(10000);
	  stockerMan.predict();
	  Broker2 stockestMan = new Broker2(dat);
	  stockestMan.setPortfolioAmount(10000);
	  stockestMan.predict();
	  //Create the panel
      predictorPanel=new JPanel(null);
      //Set the layout
      setLayout(null);
      //Set a font
      Font font = new Font("Serif",Font.BOLD , 24);
      //Component 1: Label
      count=new JLabel ("Stock Count: ");
      //Set the size of the label
      count.setBounds(150, 30, 80, 60);
      //Add the label
      add(count);
      
      //Dynamic creation of a component: Label
      for(int k=0;k<dat.getStockCount();k++) {
    	  JLabel stock = new JLabel("S"+(k+1));
    	  stock.setBounds(150+30*(k-((int)k/10)*10),60+((int)k/10)*20, 50, 50);
    	  add(stock);
      }
      
      //Label for the title
      label1= new JLabel ("Stock Market Predictor");
      //Set the size of the label
      label1.setSize(249, 60);
      //Set the font of the label
      label1.setFont(font);
      //Add the label
      add(label1);
      //Set the size
      Dimension size1 = label1.getPreferredSize();
      //Set the location of the label
      label1.setLocation(150, 0);
      //Label for the date
      label2= new JLabel("Date: ");
      //Set the size of the label
      label2.setSize(55, 100);
      //Add the label
      add(label2);
      //Set the size
      Dimension size2 = label2.getPreferredSize();
      //Set the location of the label
      label2.setLocation(477,51);
      //Label for showing the open date
      label3=new JLabel("Open Date: ");
      //Set the size of the label
      label3.setSize(68, 36);
      //Add the label
      add(label3);
      //Set the size
      Dimension size3 = label3.getPreferredSize();
      //Set the location of the label
      label3.setLocation(20,241);
      //Set the background of the panel
      setBackground(Color.pink);
      //Set the size of the panel
      setPreferredSize(new Dimension(600,600));
      //Label for the open dates
      label4=new JLabel("<html>"+dat.getWeekDate(0)+"<br>"+dat.getWeekDate(1)+"<br>"+dat.getWeekDate(2)+"<br>"+dat.getWeekDate(3)+"</html>");
      //Set size for the label
      label4.setSize(68, 100);
      //Add the label
      add(label4);
      //Set the size
      Dimension size4 = label4.getPreferredSize();
      //Set the location of the label
      label4.setLocation(145,277);
      //Set it invisible first
      label4.setVisible(false);
      //Label for the open dates
      label5=new JLabel("<html>"+dat.getWeekDate(4)+"<br>"+dat.getWeekDate(5)+"<br>"+dat.getWeekDate(6)+"<br>"+dat.getWeekDate(7)+"</html>");
      //Set size for the label
      label5.setSize(68, 100);
      //Add the label
      add(label5);
      //Set the size
      Dimension size5 = label5.getPreferredSize();
      //Set the location of the label
      label5.setLocation(145,277);
      //Set it invisible first
      label5.setVisible(false);
      //Label for the open dates
      label6=new JLabel("<html>"+dat.getWeekDate(8)+"<br>"+dat.getWeekDate(9)+"<br>"+dat.getWeekDate(10)+"<br>"+dat.getWeekDate(11)+"</html>");
      //Set size for the label
      label6.setSize(68, 100);
      //Add the label
      add(label6);
      //Set the size
      Dimension size6 = label6.getPreferredSize();
      //Set the location of the label
      label6.setLocation(145,277);
      //Set it invisible first
      label6.setVisible(false);
      //Label for the initials
      label7= new JLabel("Your Initials: ");
      //Set size for the label
      label7.setSize(96, 95);
      //Add the label
      add(label7);
      //Set the size
      Dimension size7 = label7.getPreferredSize();
      //Set the location of the label
      label7.setLocation(440,15);
      //Label for information 1
      info1=new JLabel("<html>"+"The stock of a corporation"+"<br>"+"is constituted of the equity"+"<br>"+"stock of its owners.");
      //Set size for the label
      info1.setSize(183,133);
      //Add the label
      add(info1);
      //Set location for the label
      info1.setLocation(91,416);
      //Set it invisible first
      info1.setVisible(false);
      //Label for information 2
      info2=new JLabel("<html>"+"The price of the first trade"+"<br>"+"for any listed stock is its"+"<br>"+"opening price.");
      //Set size for the label
      info2.setSize(183,133);
      //Add the label
      add(info2);
      //Set the location of the label
      info2.setLocation(91,416);
      //Set it invisible first
      info2.setVisible(false);
      //Label for information 3
      info3=new JLabel("<html>"+"Closing price refers to"+"<br>"+ "the last price at which"+"<br>"+ "a stock trades during"+"<br>"+ "a week.");
      //Set size for the label
      info3.setSize(183,133);
      //Add the label
      add(info3);
      //Set the location of the label
      info3.setLocation(91,416);
      //Set it invisible first
      info3.setVisible(false);
      //Label for information 4
      info4=new JLabel("<html>"+"In this Stock Market Predictor,"+"<br>"+ "you always buy at opening price"+"<br>"+ "and sell at closing price.");
      //Set size for the label
      info4.setSize(183,133);
      //Add the label
      add(info4);
      //Set the location of the label
      info4.setLocation(91,416);
      //Set it invisible first
      info4.setVisible(false);
      //Label for information 5
      info5=new JLabel("<html>"+"The buttons at right can tell you"+"<br>"+ "the amount of money you will have if you follow the three predictions.");
      //Set size for the label
      info5.setSize(183,133);
      //Add the label
      add(info5);
      //Set the location of the label
      info5.setLocation(91,416);
      //Set it invisible first
      info5.setVisible(false);
      //Component 2: Slider
      //The slider
      slider = new JSlider();
      //Different attributes of the slider
      //Set the value equal to 1 
      slider.setValue(1);
      //Set tool tip text equal to null
      slider.setToolTipText("");
      //Add paint labels
      slider.setPaintLabels(true);
      //Add paint ticks
      slider.setPaintTicks(true);
      //Set snap to ticks
      slider.setSnapToTicks(true);
      //Add change listener to the slider 
      slider.addChangeListener(new ChangeListener()  {
      	public void stateChanged(ChangeEvent e) {
      		//Create a value variable for the slider 
      		int value = slider.getValue();
      		//Display information 1 when the value is 1
      	   if (value==1) {
      		   info1.setVisible(true);
      		   info2.setVisible(false);
      		   info3.setVisible(false);
      		   info4.setVisible(false);
      		   info5.setVisible(false);
      	   }
      	    //Display information 2 when the value is 2
      	   else if(value==2) {
      		   info2.setVisible(true);
      		   info1.setVisible(false);
      		   info3.setVisible(false);
      		   info4.setVisible(false);
      		   info5.setVisible(false);
      	   }
      	    //Display information 3 when the value is 3
      	   else if(value==3) {
      		   info3.setVisible(true);
      		   info2.setVisible(false);
      		   info1.setVisible(false);
      	   	   info4.setVisible(false);
      	   	   info5.setVisible(false);
      	   }
      	    //Display information 4 when the value is 4
      	   else if(value==4) {
      		   info4.setVisible(true);
      		   info1.setVisible(false);
      		   info2.setVisible(false);
      		   info3.setVisible(false);
      		   info5.setVisible(false);
      	   }
      	    //Display information 5 when the value is 5
      	   else if(value==5) {
      		   info5.setVisible(true);
      		   info1.setVisible(false);
    		   info2.setVisible(false);
    		   info3.setVisible(false);
    		   info4.setVisible(false);
      	   }
      	}
      });
      //Set the minimum and maximum values of the slider
      slider.setMinimum(1);
      slider.setMaximum(5);
      //Make the spacing equal to 1
      slider.setMajorTickSpacing(1);
      //Set the size and the location for the slider
      slider.setBounds(10, 403, 320, 36);
      //Add the slider
      add(slider);
      //Component 3: Picture
      //Create image icon
      image1=new ImageIcon (this.getClass().getResource("/project2/1.jpg"));
      Image image2=image1.getImage();
      Image img1 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
      image1 = new ImageIcon(img1);  
      JLabel icon1=new JLabel(image1);
      //Set the size and the location for the image
      icon1.setBounds(-40, -15, 240, 197);
      //Add the image icon
      add(icon1);
      //Component 4: Radio button
      //Radio button for January
      Action action1 = new CommonAction1("January", false);
      //Set action for the January radio button
      radio1 = new JRadioButton(action1);
      //Set the size and the location
      radio1.setBounds(10, 280, 109, 23);
      //Add the radio button
      add(radio1);
      //Radio button for February 
      Action action2 = new CommonAction2("February", false);
      //Set action for the February radio button
      radio2 = new JRadioButton(action2);
      //Set the size and the location
      radio2.setBounds(10, 320, 109, 23);
      //Add the radio button
      add(radio2);
      //Radio button for March
      Action action3 = new CommonAction3("March", false);
      //Set action for the March radio button
      radio3 = new JRadioButton(action3);
      //Set the size and the location
      radio3.setBounds(10, 360, 109, 23);
      //Add the radio button
      add(radio3);
      //Group the radio buttons
      ButtonGroup group = new ButtonGroup();
      group.add(radio1);
      group.add(radio2);
      group.add(radio3);
      //Component 5: Button
      //Button for type 1
      buy1=new JButton("Type 1 amount: ");
      //Add the action listener for the button
      buy1.addActionListener(new Buy1Listener());
      //Set the size and the location for the button
      buy1.setBounds(353, 401, 127, 23);
      //Add the button
      add(buy1);
      //Label for type 1 amount
      type1amount=new JLabel();
      //Set the text for the label
      type1amount.setText(String.valueOf(stockMan.getPortfolioAmount()));
      //Set the size and the location for the label
      type1amount.setBounds(501, 401, 89, 23);
      //Set it invisible first
      type1amount.setVisible(false);
      //Add the label
      add(type1amount);
      //Button for type 2
      buy2=new JButton("Type 2 amount: ");
      //Add the action listener for the button
      buy2.addActionListener(new Buy2Listener());
      //Set the size and the location for the button
      buy2.setBounds(353, 439, 127, 23);
      //Add the button
      add(buy2);
      //Label for type 2 amount
      type2amount=new JLabel();
      //Set the text for the label
      type2amount.setText(String.valueOf(stockerMan.getPortfolioAmount()));
      //Set the size and the location for the label
      type2amount.setBounds(501, 439, 89, 23);
      //Set it invisible first
      type2amount.setVisible(false);
      //Add the label
      add(type2amount);
      //Button for type 3
      buy3=new JButton("Type 3 amount: ");
      //Add the action listener for the button
      buy3.addActionListener(new Buy3Listener());
      //Set the size and the location for the button
      buy3.setBounds(353, 478, 127, 23);
      //Add the button
      add(buy3);
      //Label for type 3 amount
      type3amount=new JLabel();
      //Set the text for the label
      type3amount.setText(String.valueOf(stockestMan.getPortfolioAmount()));
      //Set the size and the location for the label
      type3amount.setBounds(501, 478, 89, 23);
      //Set it invisible first
      type3amount.setVisible(false);
      //Add the label
      add(type3amount);
      //Component 6: Text area
      //The text area
      JTextArea txtrThisStockMarket = new JTextArea();
      //Add content to the text area
      txtrThisStockMarket.setText("\"An investment in knowledge \r\npays the best interest.\" \r\n- Benjamin Franklin");
      //Make it not editable
      txtrThisStockMarket.setEditable(false);
      //Set the size and the location for the text area
      txtrThisStockMarket.setBounds(10, 170, 173, 60);
      //Add the text area
      add(txtrThisStockMarket);
      //Component 7: Text field
      //The text field
      textField = new JTextField();
      //Set the size and the location for the text field
      textField.setBounds(514, 50, 60, 25);
      //Add the text field
      add(textField);
      //Set columns for the text field
      textField.setColumns(10);
      //The text field
      textField_1 = new JTextField();
      //Set the size and the location for the text field
      textField_1.setBounds(514, 90, 60, 25);
      //Add the text field
      add(textField_1);
      //Set columns for the text field
      textField_1.setColumns(10);
      //Text area with scroll bar
      textArea = new JTextArea();
      //Component 8: Scroll bar
      //The scroll bar
      scroll1 = new JScrollPane(textArea);
      //Set the location of the scroll bar
      scroll1.setLocation(224, 249);
      //Make the scroll bar vertical
      scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //Set the size for the scroll bar
      scroll1.setSize(140,140);
      //Add information into the text area
      String toAdd="";
      for(int i=0;i<dat.getStockCount();i++) {
    	  toAdd+=dat.getStockName(i)+"\r\n";
      }
      textArea.setText(toAdd);
      //Make the text area not editable
      textArea.setEditable(false);
      //Make the text area invisible at first 
      textArea.setVisible(false);
      //Set the size and the location for the text area
      textArea.setBounds(224, 247, 150, 200);
      //Add the scroll bar
      this.add(scroll1);
      //Text area with scroll bar
      textArea1 = new JTextArea();
      //The scroll bar
      scroll2 = new JScrollPane(textArea1);
      //Set the location of the scroll bar
      scroll2.setLocation(392, 249);
      //Make the scroll bar vertical 
      scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //Set the size for the scroll bar
      scroll2.setSize(140,140);
      //Add information into the text area
      String toAdd1="";
      for(int j=0;j<dat.getStockCount();j++) {
    	  toAdd1+=dat.getStockSymbol(j)+"\r\n";
      }
      textArea1.setText(toAdd1);
      //Make the text area not editable 
      textArea1.setEditable(false);
      //Set the text area invisible at first
      textArea1.setVisible(false);
      //Set the size and the location for the text area
      textArea1.setBounds(392, 247, 150, 200);
      //Add the scroll bar
      this.add(scroll2);
      //Component 9: Check box
      //The check box
      name1=new JCheckBox(new CheckboxAction1("Full Name"));
      //Set the size and the location for the check box
      name1.setBounds(244, 182, 100, 48);
      //Add the check box
      add(name1);
      //The check box
      name3=new JCheckBox(new CheckboxAction2("Abbrevated Name"));
      //Set the size and the location for the check box
      name3.setBounds(392, 182, 150, 48);
      //Add the check box
      add(name3);
	  }
	  //Listener for the first button
	  private class Buy1Listener implements ActionListener {
			public void actionPerformed (ActionEvent event){
				type1amount.setVisible(true);
			}
		}
	  //Listener for the second button
	  private class Buy2Listener implements ActionListener {
			public void actionPerformed (ActionEvent event){
				type2amount.setVisible(true);
			}
		}
	  //Listener for the third button
	  private class Buy3Listener implements ActionListener {
			public void actionPerformed (ActionEvent event){
				type3amount.setVisible(true);
			}
		}
	  //Listener for the first radio button
	  private class CommonAction1 extends javax.swing.AbstractAction {
		  
		    public CommonAction1(String text, boolean selected) {
		        super(text);
		        super.putValue(SELECTED_KEY, selected);
		    }
		 
		    @Override
		    public void actionPerformed(ActionEvent event) {
		       label4.setVisible(true);
		       label5.setVisible(false);
		       label6.setVisible(false);
		    }
		 
		}
	  //Listener for the second radio button
	  private class CommonAction2 extends javax.swing.AbstractAction {
		  
		    public CommonAction2(String text, boolean selected) {
		        super(text);
		        super.putValue(SELECTED_KEY, selected);
		    }
		 
		    @Override
		    public void actionPerformed(ActionEvent event) {
		       label5.setVisible(true);
		       label4.setVisible(false);
		       label6.setVisible(false);
		    }
		 
		}
	  //Listener for the third radio button
	  private class CommonAction3 extends javax.swing.AbstractAction {
		  
		    public CommonAction3(String text, boolean selected) {
		        super(text);
		        super.putValue(SELECTED_KEY, selected);
		    }
		 
		    @Override
		    public void actionPerformed(ActionEvent event) {
		       label6.setVisible(true);
		       label4.setVisible(false);
		       label5.setVisible(false);
		    }
		 
		}
	  //Listener for the first check box
	 private class CheckboxAction1 extends AbstractAction {
		    public CheckboxAction1(String text) {
		        super(text);
		    }
		 
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JCheckBox name2 = (JCheckBox) e.getSource();
		        if (name2.isSelected()) {
		           textArea.setVisible(true);
		        } else {
		           textArea.setVisible(false);
		        }
		    }
		}
	  //Listener for the second check box
	  class CheckboxAction2 extends AbstractAction {
		    public CheckboxAction2(String text) {
		        super(text);
		    }
		 
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JCheckBox name4 = (JCheckBox) e.getSource();
		        if (name4.isSelected()) {
		        	textArea1.setVisible(true);
		        } else {
		        	textArea1.setVisible(false);
		        }
		    }
		}
    	}
	  
	  

