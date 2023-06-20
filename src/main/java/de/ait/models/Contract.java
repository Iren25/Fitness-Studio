package de.ait.models;


import java.time.LocalDate;


public class Contract {

    private String contractId;
    private LocalDate date;
    private String ticketId;
    private String userId;

    public Contract(String contractId, LocalDate date, String ticketId, String userId) {
        this.contractId = contractId;
        this.date = date;
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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
                "contractId='" + contractId + '\'' +
                ", date=" + date +
                ", ticketId='" + ticketId + '\'' +
                ", lastName='" + userId + '\'' +
                '}';
    }
}
