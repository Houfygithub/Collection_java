package example.enumeration.codes;

import com.sun.javafx.collections.MappingChange;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by root on 17-1-10.
 */
public class EnumExample {
    public static void main(String[] args) {

        // EnumSet.range
        for(WeekDayEnum day : EnumSet.range(WeekDayEnum.Mon, WeekDayEnum.Fri)) {
            System.out.println(day);
        }

        //EnumSet.of
        EnumSet<WeekDayEnum> subset = EnumSet.of(WeekDayEnum.Mon,WeekDayEnum.Wed);
        for (WeekDayEnum day:subset){
            System.out.println(day);
        }

        //EnumMap
        Map<WeekDayEnum,RainbowColor>schema = new EnumMap<WeekDayEnum,RainbowColor>(WeekDayEnum.class);


        for (int i=0; i<WeekDayEnum.values().length;i++){
            schema.put(WeekDayEnum.values()[i],RainbowColor.values()[i]);
        }

        System.out.println("What is the lucky color today?");
        System.out.println("It's " + schema.get(WeekDayEnum.Sat));
    }
}
