package liblary_pro;

public class Main {

    public static void main(String[] args) {
	// write your code here
      LibraryManager libraryManager=new LibraryManager();
      libraryManager.addNewBook("Java","Backend",5);
      libraryManager.getBookByTitle("Java");
    }
}
