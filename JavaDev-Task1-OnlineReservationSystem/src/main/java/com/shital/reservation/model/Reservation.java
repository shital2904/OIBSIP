package com.shital.reservation.model;

import java.time.LocalDate;

public class Reservation {
    private final String pnr;
    private final String passengerName;
    private final int trainNumber;
    private final String trainName;
    private final String classType;
    private final LocalDate journeyDate;
    private final String sourceStation;
    private final String destinationStation;

    public Reservation(String pnr, String passengerName, int trainNumber,
                       String trainName, String classType, LocalDate journeyDate,
                       String sourceStation, String destinationStation) {
        this.pnr = pnr;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public String getPnr() { return pnr; }
    public String getPassengerName() { return passengerName; }
    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getClassType() { return classType; }
    public LocalDate getJourneyDate() { return journeyDate; }
    public String getSourceStation() { return sourceStation; }
    public String getDestinationStation() { return destinationStation; }
}
