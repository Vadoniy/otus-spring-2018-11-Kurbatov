package homework_5.shell.commands;

import homework_5.services.LibraryService;
import homework_5.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class LibraryCommands {

    private final LibraryServiceShell libraryServiceShell;

    @Autowired
    public LibraryCommands(LibraryServiceShell libraryService) {
        this.libraryServiceShell = libraryService;
    }
//------------------get list-----------------------
    @ShellMethod("Get books list")
    public List<String> bookList(){
        return libraryServiceShell.getBooksList();
    }

    @ShellMethod("Get authors list")
    public List<String> getAuthors(){
        return libraryServiceShell.getAuthorsList();
    }

    @ShellMethod("Get genres list")
    public List<String> getGenres(){
        return libraryServiceShell.getGenresList();
    }

//------------------get by id----------------------
    @ShellMethod("Get book by id. Use \"--id_book\" as an option")
    public String getBook(@ShellOption long id_book){
        return libraryServiceShell.getBook(id_book);
    }

//------------------add row------------------------
    @ShellMethod("Add an author. Use \"--id_author\" and \"--pen_name\" as an options")
    public void addAuthor(@ShellOption long id_author, @ShellOption String pen_name){
        libraryServiceShell.addAuthor(id_author, pen_name);
    }

    @ShellMethod("Add a genre. Use \"--id_genre\" and \"--genre\" as an options")
    public void addGenre(@ShellOption long id_genre, @ShellOption String genre){
        libraryServiceShell.addGenre(id_genre, genre);
    }

    @ShellMethod("Add a book. Use \"--id_book\" and \"--title\" and \"--id_author\" and \"--id_genre\" as an options")
    public void addBook(@ShellOption long id_book, @ShellOption String title, @ShellOption long id_author, @ShellOption long id_genre){
        libraryServiceShell.addBook(id_book, title, id_author, id_genre);
    }
}
