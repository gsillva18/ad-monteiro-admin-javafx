package com.ad.admonteirojavafx.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ADMonteiroModel {

    private Integer id;
    private List<Cult> cults;
    private List<ChurchEvent> churchEvents;

}
