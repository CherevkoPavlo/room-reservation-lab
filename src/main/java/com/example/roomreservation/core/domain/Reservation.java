package com.example.roomreservation.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final String roomId;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String bookedBy;

    public Reservation(String roomId, LocalDateTime startTime, LocalDateTime endTime, String bookedBy) {
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Час завершення не може бути раніше часу початку.");
        }
        this.id = UUID.randomUUID().toString();
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedBy = bookedBy;
    }

    public boolean overlapsWith(LocalDateTime start, LocalDateTime end) {
        return this.startTime.isBefore(end) && this.endTime.isAfter(start);
    }

    public String getId() { return id; }
    public String getRoomId() { return roomId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getBookedBy() { return bookedBy; }
}