package com.example.roomreservation.infrastructure.adapters.infrastructure.config;

import com.example.roomreservation.core.ports.in.ReserveRoomUseCase;
import com.example.roomreservation.core.ports.out.ReservationRepositoryPort;
import com.example.roomreservation.core.usecase.RoomReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public ReserveRoomUseCase reserveRoomUseCase(ReservationRepositoryPort repository) {
        return new RoomReservationService(repository);
    }
}
