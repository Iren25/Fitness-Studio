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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setLastName(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId='" + id + '\'' +
                ", date=" + date +
                ", ticketId='" + ticketId + '\'' +
                ", lastName='" + userId + '\'' +
                '}';
    }
}
