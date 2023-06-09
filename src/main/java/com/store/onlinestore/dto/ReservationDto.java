package com.store.onlinestore.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	
	@NotNull
    private LocalDate reservationDate;
	@NotNull
    private LocalTime reservationTime;
}
