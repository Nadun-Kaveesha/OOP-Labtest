package com.lab.test;

public class PriorityRetrievel implements TicketRetrievalStrategy {
    private final TicketPool ticketPool;

    public PriorityRetrievel(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public String retrieveTicket() {
        return "";
    }
}
