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

        cult.setNameCult(name);
        cult.setDayWeekCult(dayWeek);
        cult.setHourCult(hour);
        cult.setMinuteCult(minute);

        return cult;
    }

    public static ChurchEvent createChurchEvent(String name,
                                         LocalDate date,
                                         String hour,
                                         String minute,
                                         String location,
                                         String description){

        ChurchEvent churchEvent = new ChurchEvent();

        churchEvent.setNameEvent(name);
        churchEvent.setDateEvent(date.toString());
        churchEvent.setHourEvent(hour);
        churchEvent.setMinuteEvent(minute);
        churchEvent.setLocationEvent(location);
        churchEvent.setDescriptionEvent(description);

        return churchEvent;
    }
}
