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
    clear();
  }

  public WordSearch(int rows, int cols, String fileName) {
    this(rows, cols);
    Random rng = new Random();
    seed = rng.nextInt();
    randgen = new Random(seed);  
    wordsAdded = new ArrayList<String>(); 

  }

  public WordSearch(int rows, int cols, String fileName, int randSeed) {
    this(rows, cols, fileName); 
    randgen.setSeed(randSeed);
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
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private void addAllWords(String fileName) {
      File stuff = new File(fileName); 
      try {
        Scanner readWords = new Scanner(stuff);  
        while(readWords.hasNextLine()) {
          for(int i = 0; i < (int)(Math.random() * 5) && readWords.hasNextLine(); i++) {
            readWords.nextLine(); 
          }
          boolean notPlaced = true; 
          String word = readWords.nextLine(); 
          int row = (int)(Math.random() * data.length);  
          int col = (int)(Math.random() * data[row].length); 
          int rowInc = (int)(Math.random() * 3) - 1; 
          int colInc =  (int)(Math.random() * 3) - 1; 
          for(int i = 0; i < 3 && notPlaced;  i++) {
              if(addWord(word, row, col, rowInc, colInc)) {
                notPlaced = false; 
              }
          } 
        }
      } 
      catch (FileNotFoundException e) {
        System.out.println("File not found");  
      } 
  } 

  /**
   * Attempts to add a given word to the specified position of the WordGrid.
   * The word is added from left to right, must fit on the WordGrid, and must
   * have a corresponding letter to match any letters that it overlaps.
   *
   * @param word is any text to be added to the word grid.
   * @param row  is the vertical locaiton of where you want the word to start.
   * @param col  is the horizontal location of where you want the word to start.
   * @return true when the word is added successfully. When the word doesn't fit,
   * or there are overlapping letters that do not match, then false is returned
   * and the board is NOT modified.
   */
  public boolean addWordHorizontal(String word, int row, int col) {
    if (word.length() > data[row].length - col || row > data.length) {
      return false;
    }
    for (int i = 0; i < word.length(); i++) {
      if (!(data[row][col + i] == '_' || data[row][col + i] == word.charAt(i))) {
        return false;
      }
    }
    for (int i = 0; i < word.length(); i++) {
      data[row][col + i] = word.charAt(i);
    }
    return true;
  }

  /**
   * Attempts to add a given word to the specified position of the WordGrid.
   * The word is added from top to bottom, must fit on the WordGrid, and must
   * have a corresponding letter to match any letters that it overlaps.
   *
   * @param word is any text to be added to the word grid.
   * @param row  is the vertical locaiton of where you want the word to start.
   * @param col  is the horizontal location of where you want the word to start.
   * @return true when the word is added successfully. When the word doesn't fit,
   * or there are overlapping letters that do not match, then false is returned.
   * and the board is NOT modified.
   */

  public boolean addWordVertical(String word, int row, int col) {
    if (word.length() > data.length - row && col <= data[row].length) {
      return false;
    }
    for (int i = 0; i < word.length(); i++) {
      if (!(data[row + i][col] == '_' || data[row + i][col] == word.charAt(i))) {
        return false;
      }
    }
    for (int i = 0; i < word.length(); i++) {
      data[row + i][col] = word.charAt(i);
    }
    return true;
  }

  public boolean addWordDiagonal(String word, int row, int col) {
    if (word.length() > data.length || word.length() > data[row].length) {
      return false;
    }
    for (int i = 0; i < word.length(); i++) {
      if (!(data[row + i][col + i] == '_' || data[row + i][col + i] == word.charAt(i))) {
        return false;
      }
    }
    for (int i = 0; i < word.length(); i++) {
      data[row + i][col + i] = word.charAt(i);
    }
    return true;
  }

}
