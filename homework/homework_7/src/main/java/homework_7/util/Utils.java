package homework_7.util;

import homework_7.domain.Book;

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
