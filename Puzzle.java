import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle {
  private String word; //represents the random word the user is supposed to guess
                       //stored as all uppercase letters
  
  private String guesses; //represents all the letters that the user has guessed.
                          //If the user has guessed the letters r, s, t and e, then
                          //guesses would refer to the String "RSTE"
  
  private int MAX_WORDS = 45402; //represents how many words are in words.txt
  
  private boolean [] index;
  
  private String toBeGuessed;
  
  private boolean flag;

  public Puzzle() {
    //loading text from a file using the Scanner (not on AP exam)
    word = pickRandomWord("/Users/junran.wang/eclipse-workspace/APCS/src/words.txt");
    guesses = "";
    toBeGuessed="";
    flag=false;;
    index= new boolean[word.length()];
    for(int i=0; i<index.length; i++)
    	index[i]=false;
  }

  private String pickRandomWord(String filename) {
    try {
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
      int i = 0;
      int n = (int) (Math.random() * MAX_WORDS);
      String line = "";
      while (i < n) {
        line = scanner.next();
        i++;
      }
      scanner.close();
      return line.toUpperCase();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  //If the guess String is length one, add it to the list of to guesses and return
  //true or false if that letter is in our word to be guessed.
  //If the guess String is longer than length one, check to see if it is the word
  //to be guessed. If it is, add guess to guesses and return true, else return false
  public boolean makeGuess(String guess) {
	  guesses+=(guess+", ");
	  char [] list = word.toCharArray();
	  if(word.indexOf(guess)>=0) {
		  for(int i=0; i<word.length(); i++) {
			  if(list[i]==guess.charAt(0))
			  index[i]=true;
		  }
		  return true;
	  }
	  else 
		  return false;
  }

  //Display the word to be guessed letter by letter using a loop. If the letter has
  //been guessed, print that letter. If not, print and underscore character (_) instead.
  //On a different line, show all the letters that have been guessed so far. 
  public void show() {
	  toBeGuessed="";
	  for(int i=0; i<index.length; i++) {
		  if(index[i]==true)
			  toBeGuessed+=word.substring(i,i+1);
		  else
			  toBeGuessed+=" _ ";
	  }
	  System.out.println(toBeGuessed);
	  System.out.println(guesses);
  }

  //Return true or false if the word has been guessed or not (ie: all of the letters in 
  //word are also in guesses.
  public boolean isUnsolved() {
	  flag=false;
	  for(int i=0; i<index.length; i++)
		  if(index[i]==false)
			  flag=true;
    return flag;
  }
  
  //returns word;
  public String getWord() {
    return word;
  }
}