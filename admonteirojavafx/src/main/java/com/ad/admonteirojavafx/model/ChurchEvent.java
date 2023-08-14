package com.ad.admonteirojavafx.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChurchEvent {

    private String nameEvent;
    private String dateEvent;
    private String hourEvent;
    private String minuteEvent;
    private String locationEvent;
    private String descriptionEvent;


}
