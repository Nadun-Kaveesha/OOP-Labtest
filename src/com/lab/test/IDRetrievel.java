package com.lab.test;

public class IDRetrievel implements TicketRetrievalStrategy{
    private final TicketPool ticketPool;

    public IDRetrievel(TicketPool ticketPool){
        this.ticketPool = ticketPool;
    }

    @Override
    public String retrieveTicket() {
        return ticketPool.removeTicket();
    }
}
