/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambdahomework3;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
  private final List<String> sourceWords;

  /**
   * Constructor
   * 
   * @throws IOException If the source words file cannot be read
   */
  public RandomWords() throws IOException {   
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("words"))) {
      sourceWords = reader
              .lines()
              .collect(Collectors.toList());
      System.out.println("Loaded " + sourceWords.size() + " words");
    }
  }

  /**
   * Create a list of a given size containing random words
   *
   * @param listSize The size of the list to create
   * @return The created list
   */
  public List<String> createList(int listSize) {
    Random rand = new Random();
    System.out.println(listSize);
    List<String> wordList;
      wordList = rand
              .ints(0,sourceWords.size())
              .limit(listSize)
              .mapToObj(i -> (sourceWords.get(i)))
              .collect(Collectors.toList());
    return wordList;
  }

  /**
   * Return the list of all source words, which cannot be modified
   *
   * @return The unmodifiable list of all source words
   */
  public List<String> allWords() {
    return Collections.unmodifiableList(sourceWords);
  }
}
