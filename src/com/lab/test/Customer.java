//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

public class Customer extends AbstractTicketHandler implements Runnable {

    public Customer(TicketPool ticketPool) {
        super(ticketPool);
    }

    public void run() {
        while(true) {
            String ticketRemoved = this.ticketPool.removeTicket();
            if (ticketRemoved == null) {
                Logger.log("com.lab.test.Customer found no tickets available.");
                return;
            }

            Logger.log("com.lab.test.Customer retrieved: " + ticketRemoved);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException var3) {
                Logger.log("com.lab.test.Customer interrupted.");
            }
        }
    }

    public void handleTickets() {
        this.run();
    }
}
