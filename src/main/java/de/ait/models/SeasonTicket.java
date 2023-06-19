package de.ait.models;

import java.time.LocalDate;

public class SeasonTicket  {
    private TypeOfTicket seasonTicket;
    private LocalDate begin;
    private LocalDate end;
    private int id;

    public SeasonTicket(TypeOfTicket seasonTicket, LocalDate begin, LocalDate end, int id) {
        this.seasonTicket = seasonTicket;
        this.begin = begin;
        this.end = end;
        this.id = id;
    }

    public TypeOfTicket getSeasonTicket() {
        return seasonTicket;
    }

    public void setSeasonTicket(TypeOfTicket seasonTicket) {
        this.seasonTicket = seasonTicket;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SeasonTicket{" +
                "seasonTicket=" + seasonTicket +
                ", begin=" + begin +
                ", end=" + end +
                ", numberId=" + id +
                '}';
    }
}
