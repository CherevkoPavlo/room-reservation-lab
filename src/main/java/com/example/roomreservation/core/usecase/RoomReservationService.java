package com.example.roomreservation.core.usecase;

import com.example.roomreservation.core.domain.Reservation;
import com.example.roomreservation.core.ports.in.ReserveRoomUseCase;
import com.example.roomreservation.core.ports.out.ReservationRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;

public class RoomReservationService implements ReserveRoomUseCase {

    private final ReservationRepositoryPort repository;

    // Отримуємо доступ до БД через інтерфейс
    public RoomReservationService(ReservationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Reservation reserveRoom(String roomId, LocalDateTime start, LocalDateTime end, String userName) {
        List<Reservation> existingReservations = repository.findByRoomId(roomId);

        for (Reservation res : existingReservations) {
            if (res.overlapsWith(start, end)) {
                throw new IllegalStateException("Кімната " + roomId + " вже заброньована на цей час!");
            }
        }

        Reservation newReservation = new Reservation(roomId, start, end, userName);
        repository.save(newReservation);

        return newReservation;
    }
}