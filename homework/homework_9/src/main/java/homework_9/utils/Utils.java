package homework_9.utils;

import java.time.LocalDate;
import java.time.Period;

public class Utils {

    public static LocalDate updateBirthday(int day, int month, int year){
        if (day == 0 || month == 0 || year == 0){
            return null;
        }
        return LocalDate.of(year, month, day);
    }

    public static int getAge(LocalDate birthDate){
        if (birthDate == null){
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
