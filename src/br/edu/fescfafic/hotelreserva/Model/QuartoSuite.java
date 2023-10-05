package br.edu.fescfafic.hotelreserva.Model;

public class QuartoSuite extends Quarto{
    public QuartoSuite(int numeroDoQuarto, boolean disponibilidade) {
        super(numeroDoQuarto, "Suite", 300, disponibilidade);
    }
}