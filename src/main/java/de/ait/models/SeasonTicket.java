package de.ait.models;

import java.time.LocalDate;

public class SeasonTicket  {
    private TypeOfTicket typeOfTicket;
    private LocalDate begin;
    private LocalDate end;
    private String id;

    public SeasonTicket(TypeOfTicket typeOfTicket, LocalDate begin, LocalDate end, String id) {
        this.typeOfTicket = typeOfTicket;
        this.begin = begin;
        this.end = end;
        this.id = id;
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
                "seasonTicket=" + typeOfTicket +
                ", begin=" + begin +
                ", end=" + end +
                ", numberId=" + id +
                '}';
    }
}
