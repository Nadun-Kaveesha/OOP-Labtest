//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

public class Main {
    public Main() {
    }


    public static void main(String[] args) throws Exception {
        Logger.log("This is a test message");
        Configuration config = CommandLineInterface.configureSystem();
        TicketPool ticketPool = new TicketPool();
        Thread vendor = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate()));
        Thread fastvendor = new Thread(new FastVendor(ticketPool, config.getTicketReleaseRate()));
        Thread slowvendor = new Thread(new SlowVendor(ticketPool, config.getTicketReleaseRate()));
        Thread customer = new Thread(new Customer(ticketPool));
        Thread statisticReporter = new Thread(new StatisticReporter(ticketPool));

        //fastvendor.start();
        //slowvendor.start();

        //statisticReporter.start();
        vendor.start();
        // Wait for 10 seconds before starting the customer thread
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Logger.log("Main thread interrupted during sleep.");
        }
        customer.start();



        try {
            vendor.join();
            customer.join();
        } catch (InterruptedException var6) {
            Logger.log("com.lab.test.Main thread interrupted.");
        }

        Logger.log("System terminated.");
    }
}
