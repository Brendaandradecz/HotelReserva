package br.edu.fescfafic.hotelreserva.Model;

public class ClienteIndicado extends Cliente {
    public ClienteIndicado(String nome, String email){
        super(nome, email, true);
    }
    @Override
    public double percentualDesconto(){
        double descontoCliente = 0.1;
        return descontoCliente;
    }
}