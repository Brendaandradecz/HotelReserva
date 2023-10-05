package br.edu.fescfafic.hotelreserva.Model;

import java.util.UUID;

public abstract class Cliente {
    public String nome;
    public UUID id;
    public String email;
    public Reserva[] reservaDeQuartos = new Reserva[4];
    public int numeroDeReservasFeitas = 0;
    public final int MAXIMO_DE_RESERVAS = 4;
    public boolean desconto;

    public Cliente(String nome, String email, boolean desconto){
        this.nome = nome;
        this.id = UUID.randomUUID();
        this.email = email;
        this.desconto = desconto;
    }
    public void exibirInfo(){
        System.out.println("\nINFORMACOES DO CLIENTE");
        System.out.printf("Nome:\t\t\t\t %s", this.nome);
        System.out.printf("\nid:\t\t\t\t   %s",this.id);
        System.out.printf("\nEmail:\t\t\t\t%s\n", this.email);
    }
    public double percentualDesconto(){
        double descontoCliente = 0;
        return descontoCliente;
    }
    public void adicionarReserva(Reserva reserva) {
        for (int i = 0; i < reservaDeQuartos.length; i++) {
            if (reservaDeQuartos[i] == null) {
                reservaDeQuartos[i] = reserva;
                numeroDeReservasFeitas++;
                return;
            }
        }
    }
    public void removerReserva(Reserva reserva) {
        for (int i = 0; i < reservaDeQuartos.length; i++) {
            if (reservaDeQuartos[i] == reserva) {
                reservaDeQuartos[i] = null;
                numeroDeReservasFeitas--;
                return;
            }
        }
        System.out.println("A reserva nao foi encontrada na lista do cliente.");
    }
    public boolean podeFazerReserva() {
        return numeroDeReservasFeitas < MAXIMO_DE_RESERVAS;
    }
}