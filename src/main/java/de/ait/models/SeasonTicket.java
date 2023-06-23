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

    public void setTypeOfTicket(TypeOfTicket typeOfTicket) {
        this.typeOfTicket = typeOfTicket;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SeasonTicket{" +
                "id='" + id + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", typeOfTicket=" + typeOfTicket +
                '}';
    }
}
