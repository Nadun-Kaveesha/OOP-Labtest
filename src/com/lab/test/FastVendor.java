package com.lab.test;

public class FastVendor extends Vendor {

    public FastVendor(TicketPool ticketPool, int ticketReleaseRate) {
        super(ticketPool,ticketReleaseRate);
    }

    @Override
    public void run() {
        for(int i = 0; i < this.getTicketReleaseRate(); ++i) {
            String ticket = "Ticket-" + System.nanoTime();
            this.ticketPool.addTickets(ticket);
            Logger.log("com.lab.test.FastVendor added: " + ticket);

            try {
                Thread.sleep(5000/2);
            } catch (InterruptedException var4) {
                Logger.log("com.lab.test.Vendor interrupted.");
            }
        }

    }
}
