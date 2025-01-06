package com.lab.test;
import com.lab.test.TicketPool;
import com.lab.test.Logger;

public class StatisticReporter implements Runnable {
    private final TicketPool ticketPool;

    public StatisticReporter(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run(){
        while (true) {
            try {
                Logger.log("Total Tickets Added: "+ ticketPool.getAddedTicketCount());
                Logger.log("Total Tickets Removed: "+ ticketPool.getRemovedTicketcount());
                Logger.log("Current Tickets in Pool: " + ticketPool.getTicketCount());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Logger.log("Statistics reporting interrupted"+ e);
                break;
            }
        }
    }
}
