package homework_6.util;

import homework_6.domain.Book;

import java.util.List;

public class Utils {

    public static String booksTitlesListToString(List<Book> list){
        StringBuilder srt = new StringBuilder();
        for (Book b : list){
            srt.append(b.getTitle());
            srt.append("; ");
        }
        return srt.toString();
    }
}
