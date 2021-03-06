package com.moonzhou.dateTest;

import java.time.Duration;
import java.time.Instant;

/**
 * <p> java.time.Instant：Instant类是用在机器可读的时间格式上的，它以Unix时间戳的形式存储日期时</p>
 * @author moonzhou
 *
 */
public class InstantExample {
    public static void main(String[] args) {
        // Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = " + timestamp);

        // Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = " + specificTime);

        // Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
    }
}
