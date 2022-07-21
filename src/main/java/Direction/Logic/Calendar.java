package Direction.Logic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calendar {

    public String maxDayReg(String dayStart, int days){
        LocalDate parse = LocalDate.parse(dayStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int i = days;
        if (DayOfWeek.SATURDAY.equals(parse.plusDays(1).getDayOfWeek())){
            i++;
        }
        if (DayOfWeek.SUNDAY.equals(parse.plusDays(1).getDayOfWeek())){
            i++;
        }
        String s = parse.plusDays(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();


        return s;
    }
}
