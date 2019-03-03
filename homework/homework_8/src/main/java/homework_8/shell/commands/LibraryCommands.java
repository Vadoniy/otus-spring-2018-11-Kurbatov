package homework_8.shell.commands;

import homework_8.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class LibraryCommands {

    private LibraryServiceShell libraryServiceShell;

    @Autowired
    public LibraryCommands(LibraryServiceShell libraryServiceShell){
        this.libraryServiceShell = libraryServiceShell;
    }

    //------------------get list-----------------------
    @ShellMethod("Get books list")
    public List<String> gbl(){
        return libraryServiceShell.getBooksList();
    }

    /*@ShellMethod("Get authors list")
    public List<String> gal(){
        return libraryServiceShell.getAuthorsList();
    }*/

    /*@ShellMethod("Get genres list")
    public List<String> ggl(){
        return libraryServiceShell.getGenresList();
    }*/

    @ShellMethod("Get reviews list")
    public List<String> grl(){
        return libraryServiceShell.getReviewsList();
    }

    //------------------get entity---------------------
   /* @ShellMethod("Get author by pen name Use \"--penName\" as an option")
    public String gan(@ShellOption String penName){
        return libraryServiceShell.getAuthorByName(penName);
    }

    @ShellMethod("Get author by id. Use \"--id\" as an option")
    public String gai(@ShellOption long id){
        return libraryServiceShell.getAuthorById(id);
    }

    @ShellMethod("Get genre by id. Use \"--genre\" as an option")
    public String ggn(@ShellOption String genre){
        return libraryServiceShell.getGenre(genre);
    }

    @ShellMethod("Get genre by id. Use \"--genre\" as an option")
    public String ggi(@ShellOption long genreId){
        return libraryServiceShell.getGenreById(genreId);
    }*/

    @ShellMethod("Get book by id. Use \"--bookId\" as an option")
    public String gbi(@ShellOption String bookId){
        return libraryServiceShell.getBookById(bookId);
    }

    @ShellMethod("Get book by title. Use \"--title\" as an option")
    public String gbt(@ShellOption String title){
        return libraryServiceShell.getBookByTitle(title);
    }

    @ShellMethod("Get book by genre. Use \"--genre\" as an option")
    public List<String> gbg(@ShellOption String genre){
        return libraryServiceShell.getBookByGenre(genre);
    }

    @ShellMethod("Get review by book title. Use \"--title\" as an option")
    public String grt(@ShellOption String title){
        return libraryServiceShell.getReviewByBookTitle(title);
    }

    @ShellMethod("Get review by review id. Use \"--id\" as an option")
    public String gri(@ShellOption String reviewId){
        return libraryServiceShell.getReviewById(reviewId);
    }

    @ShellMethod("Get review by book id. Use \"--id\" as an option")
    public String grb(@ShellOption String bookId){
        return libraryServiceShell.getReviewByBookId(bookId);
    }

    @ShellMethod("Get review by review owner. Use \"--owner\" as an option")
    public List<String> gro(@ShellOption String owner){
        return libraryServiceShell.getReviewByReviewOwner(owner);
    }

    //------------------add entity---------------------
   /* @ShellMethod("Add author by pen name. Use \"--penName\" as an option")
    public void addA(@ShellOption String penName){
        libraryServiceShell.addAuthor(penName);
    }
    @ShellMethod("Add genre. Use \"--penName\" as an option")
    public void addG(@ShellOption String genre){
        libraryServiceShell.addGenre(genre);
    }*/

    @ShellMethod("Add book by . Use \"--title\", \"--author\" and \"--genre\" as an option")
    public void addB(@ShellOption String title, @ShellOption String author, @ShellOption String genre){
        libraryServiceShell.addBook(title, author, genre);
    }

    @ShellMethod("Add review. Use \"--title\", \"--review\" and \"--reviewOwner\" as an option")
    public void addR(@ShellOption String title, @ShellOption String review, @ShellOption String reviewOwner){
        libraryServiceShell.addReview(title, review, reviewOwner);
    }

    //---------------remove entity---------------------
    /*@ShellMethod("Delete author by id. Use \"--id\" as an option")
    public void dai(@ShellOption long authorId){
        libraryServiceShell.deleteAuthor(authorId);
    }

    @ShellMethod("Delete genre by id. Use \"--id\" as an option")
    public void dgi(@ShellOption long authorId){
        libraryServiceShell.deleteGenre(authorId);
    }*/

    @ShellMethod("Delete book by id. Use \"--id\" as an option")
    public void dbi(@ShellOption String id){
        libraryServiceShell.deleteBook(id);
    }

    @ShellMethod("Delete review by id. Use \"--id\" as an option")
    public void dri(@ShellOption String authorId){
        libraryServiceShell.deleteReview(authorId);
    }


    //---------------update entity---------------------
    @ShellMethod("Update book. Use \"--bookId\", \"--title\", \"--author\" and \"--genre\" as an option")
    public void ubi(@ShellOption String bookId, String title, String author, String genre){
        libraryServiceShell.updateBook(bookId, title, author, genre);
    }

    @ShellMethod("Update review. Use \"--reviewId\", \"--reviewOwner\" and \"--review\" as an option")
    public void uri(@ShellOption String reviewId, @ShellOption String reviewOwner, @ShellOption String review){
        libraryServiceShell.updateReview(reviewId, reviewOwner, review);
    }

    @ShellMethod("Exit program")
    public void exitLib(){
        System.exit(0);
    }
}
