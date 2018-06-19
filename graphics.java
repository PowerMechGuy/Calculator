import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class graphics {
//First we are going to declare a public frame, panel, and textfield
	JFrame window = new JFrame("Calculator");
	JPanel design = new JPanel();
	//JTextField inputnumber = new JTextField(20);
	JTextArea outputnumber = new JTextArea(201, 25);
	
	//This function will setup the frame panel and various gui needs.
	
	//These Strings will be used to store pseudo calculations
	String Firstnumber = null;
	String Secondnumber = null;
	
	//Division Memory Variable
	String DividedResult = null;
	
	//Division Variables
	//String DivFirstnumber = null;
	//String DivSecondnumber = null;
	//This String will be used to differentiate between various types of arithmatic
	String function = null;
	
	String tracker = null;
	
	int counter = 0;
 
 	//this char will be used for the switch function
  char funct;
	
	public void setup()
	{
		//Setting the alignment to the right for the text area
		outputnumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//first I'm setting the size of the frame
		window.setSize(245, 250);
		//Now I'm setting the default close operation
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//now we'll configure the text area
		outputnumber.setBounds(15, 10, 201, 25);
		outputnumber.setBackground(Color.white);
		outputnumber.setForeground(Color.black);
		outputnumber.setText(null);
		
		
		//Now I'll declare each button starting with one...
		JButton one = new JButton("1");
		one.setBounds(15,40,45,25);
		one.addActionListener(new ButtonListener());
		//Declaring button two
		JButton two = new JButton("2");
		two.setBounds(65,40,45,25);
		two.addActionListener(new ButtonListener());
		//Declaring button three
		JButton three = new JButton("3");
		three.setBounds(115,40,45,25);
		three.addActionListener(new ButtonListener());
		//Declaring button four
		JButton four = new JButton("4");
		four.setBounds(15,70,45,25);
		four.addActionListener(new ButtonListener());
		//Declaring button five
		JButton five = new JButton("5");
		five.setBounds(65,70,45,25);
		five.addActionListener(new ButtonListener());
		//Declaring button six
		JButton six = new JButton("6");
		six.setBounds(115,70,45,25);
		six.addActionListener(new ButtonListener());
		//Declaring button seven
		JButton seven = new JButton("7");
		seven.setBounds(15,100,45,25);
		seven.addActionListener(new ButtonListener());
		//Declaring button eight
		JButton eight = new JButton("8");
		eight.setBounds(65,100,45,25);
		eight.addActionListener(new ButtonListener());
		//Declaring button nine
		JButton nine = new JButton("9");
		nine.setBounds(115,100,45,25);
		nine.addActionListener(new ButtonListener());
		//Declaring button zero
		JButton zero = new JButton("0");
		zero.setBounds(65,130,45,25);
		zero.addActionListener(new ButtonListener());
		//Declaring button for addition
		JButton add = new JButton("+");
		add.setBounds(170,40,45,25);
		add.addActionListener(new ButtonListener());
		//Declaring button for subtraction
		JButton subtract = new JButton("-");
		subtract.setBounds(170,70,45,25);
		subtract.addActionListener(new ButtonListener());
		//Declaring button for multiplication
		JButton multiply = new JButton("x");
		multiply.setBounds(170,100,45,25);
		multiply.addActionListener(new ButtonListener());
		//Declaring button for division
		JButton divide = new JButton("/");
		divide.setBounds(170,130,45,25);
		divide.addActionListener(new ButtonListener());
		//Declaring button for calculation
		JButton equals = new JButton("=");
		equals.setBounds(115,170,100,25);
		equals.addActionListener(new ButtonListener());
		//Declaring button for clearing of the calculator
		JButton clear = new JButton("C");
		clear.setBounds(15,170,45,25);
		clear.addActionListener(new ButtonListener());
		
		
		//Now declaring the layout for the panel as null
		design.setLayout(null);
		
		//Now we will add all the elements to the panel...
		//First the textarea...
		design.add(outputnumber);
		
		//Now the buttons...
		design.add(one);
		design.add(two);
		design.add(three);
		design.add(four);
		design.add(five);
		design.add(six);
		design.add(seven);
		design.add(eight);
		design.add(nine);
		design.add(zero);
		design.add(add);
		design.add(subtract);
		design.add(multiply);
		design.add(divide);
		design.add(equals);
		design.add(clear);
		
		//Now we will attach the panel to the frame
		window.add(design);
		
		//Now we will set the Frame visible
		window.setVisible(true);
		
		//The gui is now complete!
		outputnumber.setText(null);
	}
	
	//This class will deal with any button presses
	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent calculate)
		{
			
			//We'll use this int to store the result
			int result = 0;
			//this int to store the actual first number
			int first = 0;
			//this int to store the actual second number
			int second = 0;
			//this will store the remainder
			
			//division variables
			//float divresult = 0;
			//float divfirst = 0;
			//float divsecond = 0;
			int remain = 0;
   		
			
			
			//First we'll check what button is being pressed using the following code
			JButton output = (JButton) calculate.getSource();
			String label = output.getText();
			
			//With a string containing the label of the button
			//We can now start entering them into the textarea
			//First we'll see if anything is in there already using a for loop
			//if not we'll just put whatever button number was pressed.
			String num = outputnumber.getText();
			
			
			
			
			if ( counter == 0 && (label == "0" || label == "1" || label == "2" || label == "3" || label == "4" || label == "5" || label == "6" || label == "7" || label == "8" || label == "9" ))
			{
				//tracker = "!";
				counter = 1;
			}
			
			
			
			else if ( counter == 1 && (label == "+" || label == "-" || label == "x" || label == "/"))
			{
				//tracker = "@";
				counter = 2;
			}
			
			else if ( counter == 0 && (label == "+" || label == "-" || label == "x" || label == "/" || label == "="))
			{
				//tracker = "@";
				counter = 3;
			}
			
			else if ( counter == 2 && (label == "0" || label == "1" || label == "2" || label == "3" || label == "4" || label == "5" || label == "6" || label == "7" || label == "8" || label == "9"))
			{
				//tracker = "!";
				counter = 4;
			}
			
			else if (counter == 2 && (label == "+" || label == "-" || label == "x" || label == "/" || label == "="))
			{
				//tracker = "@";
				//counter = 5;
				//tracker = "*";
				//label = ("!Only one operation at a time");
				counter = 0;
				label = ("!Only One Operation at a Time");
			}
			
			//This is the series of if's that do the checking in the textarea
			
			
			
			
				
			
			if (tracker == "^")
			{
				tracker = null;
				outputnumber.setText(null);
				if (label == "C")
				{
					//outputnumber.setText("");
					label = null;
					outputnumber.setText(null);
				}
				outputnumber.setText(DividedResult + label);
			}
			
			else if (tracker == "*")
			{
				tracker = null;
				outputnumber.setText(null);
				if (label == "C")
				{
					label = null;
				}
				outputnumber.setText(label);
			}
			
			
			
			else if (tracker == "#")
			{
				tracker = null;
				outputnumber.setText(null);
				if (label == "C")
				{
					label = null;
				}
				outputnumber.setText(label);
			}
			
			else if (tracker == "+")
			{
				tracker = null;
				outputnumber.setText(null);
				outputnumber.setText(label);
				
			}
			
			else if (tracker == "-")
			{
				tracker = null;
				outputnumber.setText(null);
				outputnumber.setText(label);
				
			}
			
			else if (tracker == "x")
			{
				tracker = null;
				outputnumber.setText(null);
				outputnumber.setText(label);
				
			}
			
			else if (tracker == "/")
			{
				tracker = null;
				outputnumber.setText(null);
				outputnumber.setText(label);
				
			}
			
			else if (label == "C")
			{
				outputnumber.setText(null);
				label = null;
				tracker = null;
				num = null;
				counter = 0;
			}
			else if (label == "+")
			{
				if (counter == 3)
				{
					counter = 0;
					tracker = "*";
					outputnumber.setText("!Please input number first");
				}
				
				/*else if (counter == 5)
				{
					tracker = "*";
					counter = 0;
					outputnumber.setText("!Only one Operation at a time");		
				}*/
				
				else
				{
				function = label;
				tracker = label;
				Firstnumber = outputnumber.getText();
				outputnumber.setText(null);
				outputnumber.setText(" :Plus");
				}
				
			}
			else if (label == "-")
			{
				if (counter == 3)
				{
					counter = 0;
					tracker = "*";
					outputnumber.setText("!Please input number first");
				}
				
				/*else if (counter == 5)
				{
					tracker = "*";
					counter = 0;
					outputnumber.setText("!Only one Operation at a time");		
				}*/
				
				else
				{
				function = label;
				tracker = label;
				Firstnumber = outputnumber.getText();
				outputnumber.setText(null);
				outputnumber.setText(" :Minus");
				}
				
			}
			else if (label == "x")
			{
				if (counter == 3)
				{
					counter = 0;
					tracker = "*";
					outputnumber.setText("!Please input number first");
				}
				
				/*else if (counter == 5)
				{
					tracker = "*";
					counter = 0;
					outputnumber.setText("!Only one Operation at a time");		
				}*/
				
				else
				{
				function = label;
				tracker = label;
				Firstnumber = outputnumber.getText();
				outputnumber.setText(null);
				outputnumber.setText(" :Multiplied by");
				}

			}
			else if (label == "/")
			{
				if (counter == 3)
				{
					counter = 0;
					tracker = "*";
					outputnumber.setText("!Please input number first");
				}
				
				/*else if (counter == 5)
				{
					tracker = "*";
					counter = 0;
					outputnumber.setText("!Only one Operation at a time");
					
				}*/
				
				else
				{
				function = label;
				tracker = label;
				Firstnumber = outputnumber.getText();
				outputnumber.setText(null);
				outputnumber.setText(" :Divided by");
				}
				
			}
			else if (label == "=")
			{
				
				if (counter == 3)
				{
					counter = 0;
					tracker = "*";
					outputnumber.setText("!Please pick operation");
				}
				
				Secondnumber = outputnumber.getText();
				first = Integer.parseInt(Firstnumber);
				second = Integer.parseInt(Secondnumber);
				Firstnumber = null;
				Secondnumber = null;
				/*DivSecondnumber = outputnumber.getText();
				divsecond = Float.parseFloat(DivSecondnumber);
				divfirst = Float.parseFloat(DivFirstnumber);
				DivFirstnumber = null;
				DivSecondnumber = null;*/
				outputnumber.setText(null);
    			funct = function.charAt(0);
    			
				switch(funct)
				{
					
					case'+':
						result = first + second;
						outputnumber.setText(String.valueOf(result));
						break;
					case'-':
						if (first < second)
						{
							tracker = "#";
							outputnumber.setText("Minuend must be > Subtrahend");
							counter = 0;
							break;
						}
						result = first - second;
						outputnumber.setText(String.valueOf(result));
						break;
					case'x':
						result = first * second;
						outputnumber.setText(String.valueOf(result));
						break;
					case'/':
						if (second == 0)
						{
							tracker = "#";
							outputnumber.setText("!Cannot Divide By Zero");
							counter = 0;
							break;
						}
						
						else if (first < second)
						{
							tracker = "#";
							outputnumber.setText("!No Negatives");
							counter = 0;
							break;
						}
						else
						{
						tracker ="^";
						result = first / second;
						//Converting to Integer value
						//Math.round(result);
						remain = first % second;
						DividedResult = String.valueOf(result);
						
						outputnumber.setText( String.valueOf(result) +"r" + String.valueOf(remain));
						counter = 0;
						break;
						}
				}
			}
			else if (num != null)
			{
				outputnumber.setText(num + label);
			}
			
			
			else
			{
				outputnumber.setText(label);
			}
			
			label = null;
			
			
			//outputnumber.setText(Integer.toString(counter));
			
		}
	}
}
