package br.edu.fescfafic.hotelreserva.Model;

import java.time.LocalDate;

public class ReservaPresencial extends Reserva{
    public ReservaPresencial(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, boolean acessoPiscina, boolean acessoSpa) {
        super(cliente, quarto, dataCheckIn, dataCheckOut, acessoPiscina, acessoSpa);
    }
}