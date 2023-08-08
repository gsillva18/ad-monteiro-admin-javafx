package com.ad.admonteirojavafx.core.utils;

import com.ad.admonteirojavafx.model.ChurchEvent;
import com.ad.admonteirojavafx.model.Cult;

import java.time.LocalDate;

public class Creator {

    public static Cult createCult(String name,
                                  String dayWeek,
                                  String hour,
                                  String minute){
        Cult cult = new Cult();

        cult.setName(name);
        cult.setDayWeek(dayWeek);
        cult.setHour(hour);
        cult.setMinute(minute);

        return cult;
    }

    public static ChurchEvent createChurchEvent(String name,
                                         LocalDate date,
                                         String hour,
                                         String minute,
                                         String location,
                                         String description){

        ChurchEvent churchEvent = new ChurchEvent();

        churchEvent.setName(name);
        churchEvent.setDate(date);
        churchEvent.setHour(hour);
        churchEvent.setMinute(minute);
        churchEvent.setLocation(location);
        churchEvent.setDescription(description);

        return churchEvent;
    }
}
