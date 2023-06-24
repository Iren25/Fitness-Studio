package de.ait.models;

import java.time.LocalDate;

public class SeasonTicket  {
    private String id;

    private LocalDate begin;
    private LocalDate end;
    private TypeOfTicket typeOfTicket;


    public SeasonTicket(String id, LocalDate begin, LocalDate end, TypeOfTicket typeOfTicket) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.typeOfTicket = typeOfTicket;
    }


    public TypeOfTicket getTypeOfTicket() {
        return typeOfTicket;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Абонемент номер  : " + id +
                ", начало действия абонемента: " + begin +
                ", конец действия абонемента: " + end +
                ", название абонемента: " + typeOfTicket;

    }
}
