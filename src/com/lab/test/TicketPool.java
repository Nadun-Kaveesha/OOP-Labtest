//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool implements TicketOperation {
    private final List<String> tickets = Collections.synchronizedList(new LinkedList());
    private int addedTicketCount =0;
    private int removedTicketcount =0;
    private Lock lock;

    public TicketPool() {
        lock = new ReentrantLock();
    }

    public void addTickets(String ticket) {
        lock.lock();
        try{
            this.tickets.add(ticket);
            addedTicketCount ++;
        }finally {
            lock.unlock();
        }
    }

    public String removeTicket() {
        lock.lock();
        try {
            removedTicketcount ++;
            return this.tickets.isEmpty() ? null : (String)this.tickets.remove(0);
        }finally {
            lock.unlock();
        }
    }


    public int getTicketCount() {
        return this.tickets.size();
    }
    public int getAddedTicketCount(){
        return this.addedTicketCount;
    }
    public int getRemovedTicketcount(){
        return this.removedTicketcount;
    }
}
