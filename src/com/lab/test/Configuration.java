//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets() {
        return this.totalTickets;
    }

    public int getTicketReleaseRate() {
        return this.ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return this.customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return this.maxTicketCapacity;
    }


    public static Configuration loadFromFile(String filePath) throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader(filePath);

        Configuration var3;
        try {
            var3 = (Configuration)gson.fromJson(reader, Configuration.class);
        } catch (Throwable var6) {
            try {
                ((Reader)reader).close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        ((Reader)reader).close();
        return var3;
    }

    public void saveToFile(String filePath) throws IOException {
        Gson gson = new Gson();
        Writer writer = new FileWriter(filePath);

        try {
            gson.toJson(this, writer);
        } catch (Throwable var7) {
            try {
                ((Writer)writer).close();
            } catch (Throwable var6) {
                var7.addSuppressed(var6);
            }

            throw var7;
        }

        ((Writer)writer).close();
    }
}
