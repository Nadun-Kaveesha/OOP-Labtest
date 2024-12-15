//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lab.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "src/com/lab/test/logs.txt";

    public Logger() {
    }

    public static void log(String message) {
        String var10000 = String.valueOf(LocalDateTime.now());
        String timeStampedMessage = var10000 + ": " + message;
        System.out.println(timeStampedMessage);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true));

            try {
                writer.write(timeStampedMessage);
                writer.newLine();
            } catch (Throwable var6) {
                try {
                    writer.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            writer.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
