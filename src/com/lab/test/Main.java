//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

public class Main {
    public Main() {
    }


    public static void main(String[] args) throws Exception {
        Logger.log("THis is a test message");
        Configuration config = CommandLineInterface.configureSystem();
        TicketPool ticketPool = new TicketPool();
        Thread vendor = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate()));
        Thread fastvendor = new Thread(new FastVendor(ticketPool, config.getTicketReleaseRate()));
        Thread slowvendor = new Thread(new SlowVendor(ticketPool, config.getTicketReleaseRate()));
        Thread customer = new Thread(new Customer(ticketPool));
        //vendor.start();
        //fastvendor.start();
        slowvendor.start();
        customer.start();



        try {
            slowvendor.join();
            customer.join();
        } catch (InterruptedException var6) {
            Logger.log("com.lab.test.Main thread interrupted.");
        }

        Logger.log("System terminated.");
    }
}
