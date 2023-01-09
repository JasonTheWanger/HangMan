public class HangingMan {

  private int numWrongGuesses;
  String[] HangmanImage = {
      "+----+\n" +
          "|\n" +
          "|\n" +
          "|\n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|\n" +
          "|\n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|    +\n" +
          "|\n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|    +-\n" +
          "|\n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|   -+-\n" +
          "|\n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|   -+-\n" +
          "|   / \n" +
          "/\\\n",

      "+----+\n" +
          "|    O\n" +
          "|   -+-\n" +
          "|   / \\\n" +
          "/\\\n",
  };

   //Constructor - initializes numWrongGuesses to zero
  public HangingMan() {
	  numWrongGuesses=0;
  }

  //increments numWrongGuesses by one
  public void dieSomeMore() {
	  	numWrongGuesses++;
  }

  //returns true if numWrongGuesses is 6, false otherwise
  public boolean isntDead() {
	  if(numWrongGuesses==6)
		  return false;
	  else
		  return true;
  }

  //prints to the console the String stored in the HangmanImage array
  //at the index equal to numWrongGuess
  public void show() {
	  System.out.println(HangmanImage[numWrongGuesses]);
  }
  
}