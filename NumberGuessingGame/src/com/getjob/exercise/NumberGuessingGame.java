package com.getjob.exercise;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NumberGuessingGame {

	public static void main(String[] args) {
		
		// Initialize a frame - optional
	    JFrame frame = new JFrame("InputDialog");

	    // prompt the user to enter number between 1 and 100 (for example - could be any range)
	    String readyForGame = JOptionPane.showInputDialog(frame, "Think of number"
	    		                                               + " between 1 and 100."
	    		                                               + " Are you Ready?");

	    // get the user's response. Can add more validation to response here
	    System.out.printf("User Resonse '%s'.\n", readyForGame);
	    
	    if (readyForGame !=null && readyForGame.toLowerCase().equals("ready") ) 
	    {
	    	//First guess by computer
	    	Random randomGenerator = new Random();
	    	int guess = randomGenerator.nextInt(100);
	    	System.out.printf("Generated first guess: " + guess + "\n");
	    	
	    	//can add option dialogue. This is just to keep it simple for this example
	    	String guessReply = JOptionPane.showInputDialog(frame, "Is the number " + guess 
	    			                                         + " Answer higher, lower or yes");
	    	int prevHigher = 100;
	    	int prevLower = 1;
	    	while (true) {	 //can add more logic to keep count of tries
	    		switch(guessReply.toLowerCase()) {
	    			case "higher":
	    				//if higher, then adjust lower range and guess again
	    				if (prevLower == 1 || prevLower < guess) 
		    				prevLower = guess;		    			
		    			Random randomHigher = new Random();
		    			guess = randomHigher.nextInt((prevHigher - guess)) + guess;
		    			System.out.printf("Generated Higher: " + guess + ":" + prevLower + ":" + prevHigher + "\n");
		    			break;
	    			case "lower":		
	    				//if lower, adjust higher range and guess again
	    				if (prevHigher == 100 || prevHigher > guess)
		    				prevHigher = guess;	    				
	    				Random randomLower = new Random();
	    				guess = randomLower.nextInt((guess - prevLower)) + prevLower;
	    				System.out.printf("Generated Lower: " + guess + ":" + prevLower + ":" + prevHigher + "\n");
		    			break;
	    			case "yes": 
	    				JOptionPane.showMessageDialog(frame, "HOORAY!!!");
	    				System.exit(0);
	    				break;
	    			default: //Can add validation checks
	    		}	//end switch
	    		
	    		guessReply = JOptionPane.showInputDialog(frame, "Is the number " + guess 
		                                                  + " Answer higher, lower or yes");
	    	} //end while
	    }
	}

}
