package com.lab.test;

public class SlowVendor extends Vendor{



    public SlowVendor(TicketPool ticketPool, int ticketReleaseRate) {
        super(ticketPool,ticketReleaseRate);
    }

    @Override
    public void run() {
        for(int i = 0; i < this.getTicketReleaseRate(); ++i) {
            String ticket = "Ticket-" + System.nanoTime();
            this.ticketPool.addTickets(ticket);
            Logger.log("com.lab.test.SlowVendor added: " + ticket);

            try {
                Thread.sleep(5000*2);
            } catch (InterruptedException var4) {
                Logger.log("com.lab.test.Vendor interrupted.");
            }
        }

    }
}
