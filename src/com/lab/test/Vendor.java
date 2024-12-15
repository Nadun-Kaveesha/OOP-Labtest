//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

public class Vendor extends AbstractTicketHandler implements Runnable {
    private final int ticketReleaseRate;

    public Vendor(TicketPool ticketPool, int ticketReleaseRate) {
        super(ticketPool);
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getTicketReleaseRate(){
        return this.ticketReleaseRate;
    }

    @Override
    public void run() {
        for(int i = 0; i < this.ticketReleaseRate; ++i) {
            String ticket = "Ticket-" + System.nanoTime();
            this.ticketPool.addTickets(ticket);
            Logger.log("com.lab.test.Vendor added: " + ticket);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException var4) {
                Logger.log("com.lab.test.Vendor interrupted.");
            }
        }

    }

    public void handleTickets() {
        this.run();
    }
}
