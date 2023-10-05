package br.edu.fescfafic.hotelreserva.Model;

import java.time.LocalDate;

public class ReservaSite extends Reserva{
    public ReservaSite(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, boolean acessoPiscina, boolean acessoSpa) {
        super(cliente, quarto, dataCheckIn, dataCheckOut, acessoPiscina, acessoSpa);
    }
    @Override
    public double acesso(){
        double valorAcessos = 0;
        if(acessoPiscina){
            valorAcessos+= 20;
        }
        if(acessoSpa) {
            valorAcessos += 80;
        }
        return valorAcessos;
    }
}