package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiResponse {

	private String status;
	private String message;
	private LocalDateTime timeStamp;
	public ApiResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	
	}
}
