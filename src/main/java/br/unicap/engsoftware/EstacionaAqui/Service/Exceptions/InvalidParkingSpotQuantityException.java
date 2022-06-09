package br.unicap.engsoftware.EstacionaAqui.Service.Exceptions;

public class InvalidParkingSpotQuantityException extends RuntimeException {
    public InvalidParkingSpotQuantityException(){
        super("Parking spot quantity must be less than total quantity spot");
    }
}
