package com.example.Banking.Exceptions;

import java.time.LocalDate;

public record ErrorDetails(LocalDate timeStamp,
                           String message,
                           String details,
                           String errorCode) {
}
