package com.ad.admonteirojavafx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChurchEvent {

    private String name;
    private LocalDate date;
    private String hour;
    private String minute;
    private String location;
    private String description;
}
