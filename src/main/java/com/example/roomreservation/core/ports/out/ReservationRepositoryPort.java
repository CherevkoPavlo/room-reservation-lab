package com.example.roomreservation.core.ports.out;

import com.example.roomreservation.core.domain.Reservation;
import java.util.List;

public interface ReservationRepositoryPort {
    List<Reservation> findByRoomId(String roomId);
    void save(Reservation reservation);
}