import java.util.*;
import java.io.*;

public class WordSearch {
  private char[][] data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsAdded;

  /**
   * Initialize the grid to the size specified
   * and fill all of the positions with '_'
   *
   * @param rows is the starting height of the WordSearch
   * @param cols is the starting width of the WordSearch
   */
  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    Random rng = new Random();
    seed = rng.nextInt();
    randgen = new Random(seed);
    wordsAdded = new ArrayList<String>();
    clear();
  }

  public WordSearch(int rows, int cols, String fileName) {
    this(rows, cols);
    addAllWords(fileName);
  }

  public WordSearch(int rows, int cols, String fileName, int randSeed) {
    this(rows, cols);
    seed = randSeed; 
    randgen.setSeed(randSeed); 
    addAllWords(fileName);
  }

  /** Set all values in the WordSearch to underscores'_' */
  private void clear() {
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        data[row][col] = '_';
      }
    }
  }

  /**
   * Each row is a new line, there is a space between each letter
   *
   * @return a String with each character separated by spaces, and rows
   * separated by newlines.
   */
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
    output += "Seed:" + seed;
    return output;
  }

  /**
   * Attempts to add a given word to the specified position of the WordGrid.
   * The word is added in the direction rowIncrement,colIncrement
   * Words must have a corresponding letter to match any letters that it overlaps.
   *
   * @param word   is any text to be added to the word grid.
   * @param row    is the vertical locaiton of where you want the word to start.
   * @param col    is the horizontal location of where you want the word to start.
   * @param rowInc is -1,0, or 1 and represents the displacement of each letter in
   *               the row direction
   * @param colInc is -1,0, or 1 and represents the displacement of each letter in
   *               the col direction
   * @return true when: the word is added successfully.
   *         false (and do not change the board at all) when any of the following
   *         happen:
   *         a) rowInc and colInc are both 0,
   *         b) the word doesn't fit,
   *         c) there are overlapping letters that do not match
   */

  public boolean addWord(String word, int row, int col, int rowInc, int colInc) {
    if (rowInc == 0 && colInc == 0) {
      return false;
    }
    try {
      for (int i = 0; i < word.length(); i++) {
        if (!(data[row + (i * rowInc)][col + (i * colInc)] == '_'
            || data[row + (i * rowInc)][col + (i * colInc)] == word.charAt(i))) {
          return false;
        }
      }
      for (int i = 0; i < word.length(); i++) {
        data[row + (i * rowInc)][col + (i * colInc)] = word.charAt(i);
      }
      wordsAdded.add(word); 
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private void addAllWords(String fileName) {
      File stuff = new File(fileName);
      try {
        
        Scanner readWords = new Scanner(stuff);
        ArrayList<String> words = new ArrayList<String>(); 
        while(readWords.hasNextLine()) {
            words.add(readWords.nextLine()); 
        } 

        for(int i = 0; i < words.size(); i += (int)(randgen.nextInt(5))) { 
            String current = words.get(i); 
            boolean placed = false; 
            for(int j = 0; j < 5 && !placed; j++){
              int row = randgen.nextInt(data.length);
              int col = randgen.nextInt(data[row].length); 
              int rowInc = randgen.nextInt(3) - 1; 
              int colInc = randgen.nextInt(3) - 1; 
              placed = addWord(current, row, col, rowInc, colInc); 
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
  }

}
