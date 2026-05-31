package com.example.roomreservation.infrastructure.adapters.in.web;

import com.example.roomreservation.core.domain.Reservation;
import com.example.roomreservation.core.ports.in.ReserveRoomUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationController {

    private final ReserveRoomUseCase reserveRoomUseCase;

    public RoomReservationController(ReserveRoomUseCase reserveRoomUseCase) {
        this.reserveRoomUseCase = reserveRoomUseCase;
    }

    @PostMapping
    public ResponseEntity<?> reserveRoom(@RequestBody ReservationRequest request) {
        try {
            Reservation reservation = reserveRoomUseCase.reserveRoom(
                    request.roomId(),
                    request.startTime(),
                    request.endTime(),
                    request.bookedBy()
            );
            return ResponseEntity.ok(reservation);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public record ReservationRequest(
            String roomId,
            LocalDateTime startTime,
            LocalDateTime endTime,
            String bookedBy
    ) {}
}