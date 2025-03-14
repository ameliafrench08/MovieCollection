import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MovieCollection {
  private ArrayList<Movie> movies;
  private Scanner scanner;

  public MovieCollection(String fileName) {
    importMovieList(fileName);
    scanner = new Scanner(System.in);
  }

  public ArrayList<Movie> getMovies() {
    return movies;
  }

  public void menu() {
    String menuOption = "";

    System.out.println("Welcome to the movie collection!");
    System.out.println("Total: " + movies.size() + " movies");

    while (!menuOption.equals("q")) {
      System.out.println("------------ Main Menu ----------");
      System.out.println("- search (t)itles");
      System.out.println("- search (k)eywords");
      System.out.println("- search (c)ast");
      System.out.println("- see all movies of a (g)enre");
      System.out.println("- list top 50 (r)ated movies");
      System.out.println("- list top 50 (h)igest revenue movies");
      System.out.println("- (q)uit");
      System.out.print("Enter choice: ");
      menuOption = scanner.nextLine();

      if (!menuOption.equals("q")) {
        processOption(menuOption);
      }
    }
  }

  private void processOption(String option) {
    if (option.equals("t")) {
      searchTitles();
    } else if (option.equals("c")) {
      searchCast();
    } else if (option.equals("k")) {
      searchKeywords();
    } else if (option.equals("g")) {
      listGenres();
    } else if (option.equals("r")) {
      listHighestRated();
    } else if (option.equals("h")) {
      listHighestRevenue();
    } else {
      System.out.println("Invalid choice!");
    }
  }

  private void searchTitles() {
    System.out.print("Enter a title search term: ");
    String searchTerm = scanner.nextLine();

    // prevent case sensitivity
    searchTerm = searchTerm.toLowerCase();

    // arraylist to hold search results
    ArrayList<Movie> results = new ArrayList<Movie>();

    // search through ALL movies in collection
    for (int i = 0; i < movies.size(); i++) {
      String movieTitle = movies.get(i).getTitle();
      movieTitle = movieTitle.toLowerCase();

      if (movieTitle.indexOf(searchTerm) != -1) {
        //add the Movie objest to the results list
        results.add(movies.get(i));
      }
    }

    // sort the results by title
    sortResults(results);

    // now, display them all to the user    
    for (int i = 0; i < results.size(); i++) {
      String title = results.get(i).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = i + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = results.get(choice - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();
  }

  private void sortResults(ArrayList<Movie> listToSort) {
    for (int j = 1; j < listToSort.size(); j++) {
      Movie temp = listToSort.get(j);
      String tempTitle = temp.getTitle();

      int possibleIndex = j;
      while (possibleIndex > 0 && tempTitle.compareTo(listToSort.get(possibleIndex - 1).getTitle()) < 0) {
        listToSort.set(possibleIndex, listToSort.get(possibleIndex - 1));
        possibleIndex--;
      }
      listToSort.set(possibleIndex, temp);
    }
  }

  private void displayMovieInfo(Movie movie) {
    System.out.println();
    System.out.println("Title: " + movie.getTitle());
    System.out.println("Tagline: " + movie.getTagline());
    System.out.println("Runtime: " + movie.getRuntime() + " minutes");
    System.out.println("Year: " + movie.getYear());
    System.out.println("Directed by: " + movie.getDirector());
    System.out.println("Cast: " + movie.getCast());
    System.out.println("Overview: " + movie.getOverview());
    System.out.println("User rating: " + movie.getUserRating());
    System.out.println("Box office revenue: " + movie.getRevenue());
  }

  private void searchCast() {
    System.out.print("Enter a cast member name: ");
    String searchTerm = scanner.nextLine();

    // prevent case sensitivity
    searchTerm = searchTerm.toLowerCase();

    // arraylist to hold search results
    ArrayList<Movie> results = new ArrayList<Movie>();

    // search through ALL movies in collection
    for (int i = 0; i < movies.size(); i++) {
      String actorName = movies.get(i).getCast();
      actorName = actorName.toLowerCase();

      if (actorName.indexOf(searchTerm) != -1) {
        //add the Movie objest to the results list
        results.add(movies.get(i));
      }
    }

    // sort the results by title
    sortResults(results);

    // now, display them all to the user
    for (int i = 0; i < results.size(); i++) {
      String title = results.get(i).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = i + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = results.get(choice - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();

  }

  private void searchKeywords() {
    System.out.print("Enter a keyword: ");
    String searchTerm = scanner.nextLine();

    // prevent case sensitivity
    searchTerm = searchTerm.toLowerCase();

    // arraylist to hold search results
    ArrayList<Movie> results = new ArrayList<Movie>();

    // search through ALL movies in collection
    for (int i = 0; i < movies.size(); i++) {
      String keyWords = movies.get(i).getKeywords();
      keyWords = keyWords.toLowerCase();

      if (keyWords.contains(searchTerm)) {
        //add the Movie objest to the results list
        results.add(movies.get(i));
      }
    }

    // sort the results by title
    sortResults(results);

    // now, display them all to the user
    for (int i = 0; i < results.size(); i++) {
      String title = results.get(i).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = i + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = results.get(choice - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();

  }


  private void listGenres() {
    ArrayList<String> genres = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++) {
      ArrayList<String> genresInMovie = new ArrayList<>(List.of(movies.get(i).getGenres().split("\\|")));
      for (String genre : genresInMovie) {
        if (!genres.contains(genre)) {
          genres.add(genre);
        }
      }

    }

    for (int j = 1; j < genres.size(); j++) {
      String temp = genres.get(j);


      int possibleIndex = j;
      while (possibleIndex > 0 && temp.compareTo(genres.get(possibleIndex - 1)) < 0) {
        genres.set(possibleIndex, genres.get(possibleIndex - 1));
        possibleIndex--;
      }
      genres.set(possibleIndex, temp);
    }



    for (int m = 0; m < genres.size(); m++) {
      String genre = genres.get(m);

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = m + 1;

      System.out.println("" + choiceNum + ". " + genre);
    }

    System.out.println("Which genre would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    // prevent case sensitivity
    String searchTerm = genres.get(choice - 1);
    searchTerm = searchTerm.toLowerCase();

    // arraylist to hold search results
    ArrayList<Movie> results = new ArrayList<Movie>();

    // search through ALL movies in collection
    for (int k = 0; k < movies.size(); k++) {
      String movieGenres = movies.get(k).getGenres();
      movieGenres = movieGenres.toLowerCase();

      if (movieGenres.contains(searchTerm)) {
        //add the Movie objest to the results list
        results.add(movies.get(k));
      }
    }

    // sort the results by title
    sortResults(results);

    // now, display them all to the user
    for (int p = 0; p < results.size(); p++) {
      String title = results.get(p).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = p + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice2 = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = results.get(choice2 - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();
  }
  
  private void listHighestRated()
  {
    ArrayList<Movie> tempMovies = movies;

    for (int j = 1; j < tempMovies.size(); j++) {
      Movie temp = tempMovies.get(j);
      double tempTitle = temp.getUserRating();

      int possibleIndex = j;

      // tempTitle.compareTo(tempMovies.get(possibleIndex - 1).getTitle()) < 0
      while (possibleIndex > 0 && tempTitle - (tempMovies.get(possibleIndex - 1).getUserRating()) > 0) {
        tempMovies.set(possibleIndex, tempMovies.get(possibleIndex - 1));
        possibleIndex--;
      }
      tempMovies.set(possibleIndex, temp);
    }

    for (int i = 0; i < 50; i++) {
      String title = tempMovies.get(i).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = i + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = tempMovies.get(choice - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();

  
  }
  
  private void listHighestRevenue()
  {

    ArrayList<Movie> tempMovies = new ArrayList<>(movies);
    ArrayList<Movie> topFifty = new ArrayList<>();
    int index = 50;
    while (index > 0){
      int max = tempMovies.getFirst().getRevenue();
      int maxIndex = 0;
      for (int i = 0; i < tempMovies.size(); i++){
        if (tempMovies.get(i).getRevenue() > max){
          maxIndex = i;
        }
      }
      topFifty.add(tempMovies.get(maxIndex));
      tempMovies.remove(maxIndex);
      index--;

    }


    for (int i = 0; i < 50; i++) {
      String title = topFifty.get(i).getTitle();

      // this will print index 0 as choice 1 in the results list; better for user!
      int choiceNum = i + 1;

      System.out.println("" + choiceNum + ". " + title);
    }

    System.out.println("Which movie would you like to learn more about?");
    System.out.print("Enter number: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    Movie selectedMovie = topFifty.get(choice - 1);

    displayMovieInfo(selectedMovie);

    System.out.println("\n ** Press Enter to Return to Main Menu **");
    scanner.nextLine();
  
  }
  
  private void importMovieList(String fileName)
  {
    try
    {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line = bufferedReader.readLine();
      
      movies = new ArrayList<Movie>();
      
      while ((line = bufferedReader.readLine()) != null) 
      {
        String[] movieFromCSV = line.split(",");
     
        String title = movieFromCSV[0];
        String cast = movieFromCSV[1];
        String director = movieFromCSV[2];
        String tagline = movieFromCSV[3];
        String keywords = movieFromCSV[4];
        String overview = movieFromCSV[5];
        int runtime = Integer.parseInt(movieFromCSV[6]);
        String genres = movieFromCSV[7];
        double userRating = Double.parseDouble(movieFromCSV[8]);
        int year = Integer.parseInt(movieFromCSV[9]);
        int revenue = Integer.parseInt(movieFromCSV[10]);
        
        Movie nextMovie = new Movie(title, cast, director, tagline, keywords, overview, runtime, genres, userRating, year, revenue);
        movies.add(nextMovie);  
      }
      bufferedReader.close();
    }
    catch(IOException exception)
    {
      // Print out the exception that occurred
      System.out.println("Unable to access " + exception.getMessage());              
    }
  }
}