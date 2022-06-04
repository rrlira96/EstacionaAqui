package br.unicap.engsoftware.EstacionaAqui.Service.Exceptions;

public class FullParkingLotException extends RuntimeException {
    public FullParkingLotException(){
        super("The parking lot is full");
    }
}
