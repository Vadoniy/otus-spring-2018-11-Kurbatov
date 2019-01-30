package homework_6.shell.commands;

import homework_6.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class LibraryCommands {

    private final LibraryServiceShell libraryServiceShell;

    @Autowired
    public LibraryCommands(LibraryServiceShell libraryServiceShell) {
        this.libraryServiceShell = libraryServiceShell;
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

}
