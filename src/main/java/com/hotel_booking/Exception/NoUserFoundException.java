package com.hotel_booking.Exception;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException(String mesage)
    {
        super(mesage);
    }
}
