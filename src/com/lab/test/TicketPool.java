//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TicketPool implements TicketOperation {
    private final List<String> tickets = Collections.synchronizedList(new LinkedList());

    public TicketPool() {
    }

    public synchronized void addTickets(String ticket) {
        this.tickets.add(ticket);
    }

    public synchronized String removeTicket() {
        return this.tickets.isEmpty() ? null : (String)this.tickets.remove(0);
    }

    public int getTicketCount() {
        return this.tickets.size();
    }
}
