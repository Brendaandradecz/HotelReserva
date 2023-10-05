package br.edu.fescfafic.hotelreserva.Model;

public class ClienteParceiro extends Cliente{
    public ClienteParceiro(String nome, String email){
        super(nome, email, true);
    }
    @Override
    public double percentualDesconto(){
        double descontoCliente = 0.25;
        return descontoCliente;
    }
}