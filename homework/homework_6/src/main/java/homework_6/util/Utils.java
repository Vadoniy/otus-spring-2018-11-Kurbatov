package homework_6.util;

import java.util.List;

public class Utils {

    public static String listToString(List list){
        StringBuilder srt = new StringBuilder();
        for (Object o : list){
            srt.append(o.toString());
        }
        return srt.toString();
    }
}
