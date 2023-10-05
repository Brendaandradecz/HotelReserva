package br.edu.fescfafic.hotelreserva.Model;

import java.time.LocalDate;

public class Hotel {
    public String nome;
    public String endereco;
    public Quarto[] quartosDisponiveis = new Quarto[100];
    public int quantidadeDeQuartos = 0;

    public Hotel(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public void adicionarQuarto(Quarto quarto) {
        for (int i = 0; i < quartosDisponiveis.length; i++) {
            if (quartosDisponiveis[i] == null) {
                quartosDisponiveis[i] = quarto;
                quantidadeDeQuartos++;
                System.out.printf("O quarto %s de numero %d foi adicionado ao %s.\n", quarto.tipoDeQuarto, quarto.numeroDoQuarto, this.nome);
                return;
            }
        }
        System.out.println("A capacidade máxima de quartos foi atingida. Não é possível adicionar mais quartos.\n");
    }

    public void verificarDisponibilidade(){
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto != null && quarto.disponibilidade) {
                System.out.printf("\nO quarto %s de numero %d esta disponivel para reserva.\n", quarto.tipoDeQuarto, quarto.numeroDoQuarto);
                break;
            } else {
                System.out.printf("\nNão há quartos disponíveis para reserva.\n", quarto.tipoDeQuarto, quarto.numeroDoQuarto);
            }
        }
    }

    public void fazerReservaSite(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, boolean acessoPiscina, boolean acessoSpa){
        if (cliente.podeFazerReserva())
            if (quarto != null && quarto.disponibilidade) {
                Reserva reserva = new ReservaSite(cliente, quarto, dataCheckIn, dataCheckOut, acessoPiscina, acessoSpa);
                cliente.adicionarReserva(reserva);
                quarto.disponibilidade = false;
                System.out.printf("\nReserva do cliente %s para o quarto %d realizada com sucesso!", cliente.nome, quarto.numeroDoQuarto);
                reserva.calcularTotal();
                reserva.exibirInfo();
            } else {
                System.out.printf("\nDesculpe, o quarto %d nao esta disponivel para reserva.\n", quarto.numeroDoQuarto);
            }
        else {
            System.out.printf("A capacidade maxima de reservas foi atingida para %s.\n", cliente.nome);
        }
    }

    public void fazerReservaPresencial(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, boolean acessoPiscina, boolean acessoSpa){
        if (cliente.podeFazerReserva())
            if (quarto != null && quarto.disponibilidade) {
                Reserva reserva = new ReservaPresencial(cliente, quarto, dataCheckIn, dataCheckOut, acessoPiscina, acessoSpa);
                cliente.adicionarReserva(reserva);
                quarto.disponibilidade = false;
                System.out.printf("\nReserva do cliente %s para o quarto %d realizada com sucesso!", cliente.nome, quarto.numeroDoQuarto);
                reserva.calcularTotal();
                reserva.exibirInfo();
            } else {
                System.out.printf("\nDesculpe, o quarto %d nao esta disponivel para reserva.\n", quarto.numeroDoQuarto);
            }
        else {
            System.out.printf("A capacidade maxima de reservas foi atingida para %s.\n", cliente.nome);
        }
    }

    public void cancelarReserva(Cliente cliente, Quarto quarto) {
        for (Reserva reserva : cliente.reservaDeQuartos) {
            if (reserva != null && reserva.quarto == quarto) {
                quarto.disponibilidade = true;
                cliente.removerReserva(reserva);
                System.out.printf("\nReserva do cliente %s para o quarto %d cancelada com sucesso!\n", cliente.nome, quarto.numeroDoQuarto);
                return;
            }
        }
        System.out.println("Nao foi encontrada nenhuma reserva correspondente. ");
    }

    public void localizarQuartoPorTipo(String tipoDeQuarto) {
        boolean encontrouQuarto = false;
        for (int i = 0; i < quantidadeDeQuartos; i++) {
            if (quartosDisponiveis[i] != null && quartosDisponiveis[i].disponibilidade && quartosDisponiveis[i].tipoDeQuarto.equalsIgnoreCase(tipoDeQuarto)) {
                System.out.println("\nQuarto encontrado do tipo " + tipoDeQuarto + ":");
                quartosDisponiveis[i].exibirInfo();
                encontrouQuarto = true;
            }
        }
        if (!encontrouQuarto) {
            System.out.println("Nenhum quarto do tipo " + tipoDeQuarto + " encontrado.");
        }
    }

    public void exibirInfo(){
        System.out.println("INFORMACOES DO HOTEL");
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Quartos Disponiveis: ");
        boolean peloMenosUmQuartoDisponivel = false;
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto != null && quarto.disponibilidade) {
                quarto.exibirInfo();
                peloMenosUmQuartoDisponivel = true;
            }
        }
        if (!peloMenosUmQuartoDisponivel) {
            System.out.println("Nenhum quarto disponivel.");
        }
    }
}