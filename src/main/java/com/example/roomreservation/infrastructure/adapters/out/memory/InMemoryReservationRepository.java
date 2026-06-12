package com.example.roomreservation.infrastructure.adapters.out.memory;

import com.example.roomreservation.core.domain.Reservation;
import com.example.roomreservation.core.ports.out.ReservationRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryReservationRepository implements ReservationRepositoryPort {

    private final List<Reservation> database = new ArrayList<>();

    @Override
    public List<Reservation> findByRoomId(String roomId) {
        return database.stream()
                .filter(r -> r.getRoomId().equals(roomId))
                .toList();
    }

    @Override
    public void save(Reservation reservation) {
        database.add(reservation);
    }
}
