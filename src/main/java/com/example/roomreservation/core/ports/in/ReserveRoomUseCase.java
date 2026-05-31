package com.example.roomreservation.core.ports.in;

import com.example.roomreservation.core.domain.Reservation;
import java.time.LocalDateTime;

public interface ReserveRoomUseCase {
    Reservation reserveRoom(String roomId, LocalDateTime start, LocalDateTime end, String userName);
}