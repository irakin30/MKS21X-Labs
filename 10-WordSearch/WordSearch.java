import java.util.*;
import java.io.*;

public class WordSearch {
  private char[][] data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsAdded;

  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    randgen = new Random();
    wordsAdded = new ArrayList<String>();
    clear();
  }

  public WordSearch(int rows, int cols, String fileName, int randSeed) {
    this(rows, cols);
    seed = randSeed; 
    randgen.setSeed(randSeed); 
    addAllWords(fileName);
  }

  public WordSearch(int rows, int cols, String fileName) {
    this(rows, cols, fileName, new Random().nextInt());
  }

  private void clear() {
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        data[row][col] = '_';
      }
    }
  }

  public String toString() {
    String output = "";
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        output += data[row][col];
        if (col < data[row].length - 1) {
          output += " ";
        }
      }
      output += "\n";
    }
    output += "Seed: " + seed + "\n";
    output += "Words Added: " + wordsAdded.toString() + "\n"; 
    return output;
  }

  public boolean addWord(String word, int row, int col, int rowInc, int colInc) {
    //exits if there is no direction
    if (rowInc == 0 && colInc == 0) {
      return false;
    }

    try { 
      //first for loop checks if the word CAN be placed there. if it goes out of bounds, the catch returns false; 
      for (int i = 0; i < word.length(); i++) {
        if (!(data[row + (i * rowInc)][col + (i * colInc)] == '_'
            || data[row + (i * rowInc)][col + (i * colInc)] == word.charAt(i))) {
          return false;
        }
      }

      //since all spaces are valid, add everything from the word.
      for (int i = 0; i < word.length(); i++) {
        data[row + (i * rowInc)][col + (i * colInc)] = word.charAt(i);
      }

      //remember to add the word
      wordsAdded.add(word); 
      return true;

    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private void addAllWords(String fileName) {
      File stuff = new File(fileName);
      try {
        //puts all the words into an ArrayList, and turns the words into UpperCase if not done so already
        Scanner readWords = new Scanner(stuff);
        ArrayList<String> words = new ArrayList<String>(); 
        while(readWords.hasNextLine()) {
            words.add(readWords.nextLine().toUpperCase()); 
        } 

        //forces it to break out of the loop if it tries too much without success
        int tries = 0;
        
        //decrease tries to decrease the amount of words (hypothetically). I know, not a good implementation.
        while(tries < 200 && words.size() > 0) {

            int index = randgen.nextInt(words.size()); 
            String current = words.get(index); 
            words.remove(index); 

            boolean placed = false;  
            for(int j = 0; j < 20 && !placed; j++){
              int row = randgen.nextInt(data.length);
              int col = randgen.nextInt(data[row].length); 
              int rowInc = randgen.nextInt() % 2; 
              int colInc = randgen.nextInt() % 2; 
              tries++; 
              placed = addWord(current, row, col, rowInc, colInc); 
            } 

            if (placed) {
              tries = 0;
            }
        }
        readWords.close(); 
      }

      catch (FileNotFoundException e) {
        System.out.println("File not found");
        System.exit(1);
      }
  } 

  private void fillInRandomLetters() {
      for(int row = 0; row < data.length; row++) {
        for(int col = 0; col < data[row].length; col++) {
          if (data[row][col] == '_') {
          data[row][col] = (char)(randgen.nextInt(26) + 65); 
          }
        }
      }
  }

  public static void main(String[] args) {
    /* 
      I didn't idiot proof this main function, so it just assumes you did this right. 
    */
      WordSearch wordSearch; 
      int rows = Integer.parseInt(args[0]);
      int cols = Integer.parseInt(args[1]); 
      String fileName = args[2]; 
      int mode = Integer.parseInt(args[3]);
      
      if (args.length == 5) {
        int seed = Integer.parseInt(args[4]); 
        wordSearch = new WordSearch(rows, cols, fileName, seed); 
      }
      else {
        wordSearch = new WordSearch(rows, cols, fileName); 
      }  

      if (mode == 0) {
        wordSearch.fillInRandomLetters();
      } 

      System.out.print(wordSearch); 
    }
}
