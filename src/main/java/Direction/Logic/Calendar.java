package Direction.Logic;

import Direction.DataBase.DirectionUpdateDb;
import Direction.Models.DirectionErrorModel;
import com.beust.ah.A;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.IllegalFormatCodePointException;

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


    public void CalDayRecord(DirectionErrorModel model){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (model.getNumber()!="null"){
            LocalDate maxDay = LocalDate.parse(model.getMaxDayRecord(), pattern);
            LocalDate start = LocalDate.parse(model.getDayStart(), pattern);
            LocalDate And = LocalDate.parse(model.getDayRecord(), pattern);
            Period period = Period.between(And, maxDay);
            Period period1 = Period.between(start , And);
            DirectionUpdateDb directionUpdateDb = new DirectionUpdateDb();
            boolean b = true;
            while (b) {
                b = directionUpdateDb.daysRecord(model.getHref(),  String.valueOf(period1.getDays()));
            }
            if (period.getDays()>0){
                boolean c = true;
                while (c) {
                    c = directionUpdateDb.updateError(model.getHref());
                }
            }
        }
    }

    public void CalDayReg(DirectionErrorModel model){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate And = LocalDate.now();
        LocalDate start = LocalDate.parse(model.getDayStart(), pattern);
        LocalDate maxDay = LocalDate.parse(model.getMaxDayReg(), pattern);
        if (model.getDayEnd()!="null"|model.getDayReg()!="null"){
            System.out.println(1);
            if (model.getDayEnd().equals("null")){
                System.out.println(11);
                And = LocalDate.parse(model.getDayReg(), pattern);
            } else {
                System.out.println(111);
                And = LocalDate.parse(model.getDayEnd(), pattern);
            }
            Period period = Period.between(And, maxDay);
            Period period1 = Period.between(start , And);
            DirectionUpdateDb directionUpdateDb = new DirectionUpdateDb();
            boolean b = true;
            while (b) {
                System.out.println(1111);
                b = directionUpdateDb.daysRecord(model.getHref(), String.valueOf(period1.getDays()));
            }
            System.out.println(period.getDays());
            if (period.getDays()>0){

                System.out.println(11111);
                boolean c = true;
                while (c) {
                    c = directionUpdateDb.updateError(model.getHref());
                }
            }

        }

    }

}
