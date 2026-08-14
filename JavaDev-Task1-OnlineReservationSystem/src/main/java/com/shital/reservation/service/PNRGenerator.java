package com.shital.reservation.service;

import java.util.UUID;

public class PNRGenerator {

    private PNRGenerator() {
    }

    public static String generate() {
        return "PNR" + UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10)
                .toUpperCase();
    }
}
