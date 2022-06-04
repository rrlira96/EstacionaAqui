package br.unicap.engsoftware.EstacionaAqui.Service.Exceptions;

public class FullParkingException extends RuntimeException {
    public FullParkingException(){
        super("Parking spot quantity must be less than total quantity spot");
    }
}
