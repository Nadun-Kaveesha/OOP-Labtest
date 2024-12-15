//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

public abstract class AbstractTicketHandler {
    protected TicketPool ticketPool;

    public AbstractTicketHandler(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public abstract void handleTickets();
}
