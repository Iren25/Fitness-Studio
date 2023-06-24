package de.ait.models;


import java.time.LocalDate;


public class Contract {

    private String id;
    private LocalDate date;
    private String ticketId;
    private String userId;

    public Contract(String id, LocalDate date, String ticketId, String userId) {
        this.id = id;
        this.date = date;
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Договор номер: " +
                id  + ", заключён: " + date +
                ", номер абонемента: " + ticketId +
                ", номер паспорта: " + userId;
    }
}
