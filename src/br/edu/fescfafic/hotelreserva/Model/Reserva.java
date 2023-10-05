package br.edu.fescfafic.hotelreserva.Model;

import java.time.LocalDate;

public abstract class Reserva {
    public Cliente cliente;
    public Quarto quarto;
    public LocalDate dataCheckIn;
    public LocalDate dataCheckOut;
    public boolean acessoPiscina;
    public boolean acessoSpa;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, boolean acessoPiscina, boolean acessoSpa) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.acessoPiscina = acessoPiscina;
        this.acessoSpa = acessoSpa;
    }
    public double acesso(){
        double valorAcessos = 0;
        if(acessoPiscina){
            valorAcessos+= 30;
        }
        if(acessoSpa) {
            valorAcessos += 100;
        }
        return valorAcessos;
    }
    public void calcularTotal(){
        int diasPorMes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean anoBissextoCheckIn = this.dataCheckIn.isLeapYear();
        boolean anoBissextoCheckOut = this.dataCheckOut.isLeapYear();

        if (anoBissextoCheckIn) {
            diasPorMes[2] = 29;
        }

        int totalDias = 0;

        for (int ano = this.dataCheckIn.getYear(); ano < this.dataCheckOut.getYear(); ano++) {
            totalDias += 365;
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                totalDias++;
            }
        }

        if (anoBissextoCheckOut) {
            totalDias++;
        }

        for (int mes = 1; this.dataCheckIn.getMonthValue() > mes; mes++) {
            totalDias -= diasPorMes[mes];
        }

        for (int mes = 1; mes < this.dataCheckOut.getMonthValue(); mes++) {
            totalDias += diasPorMes[mes];
        }

        totalDias += this.dataCheckOut.getDayOfMonth() - this.dataCheckIn.getDayOfMonth();
        double valor = totalDias * quarto.precoDaNoite + acesso();

        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf("Total de Dias da Reserva:\t %d\n", totalDias);
        System.out.printf("Valor do Quarto:\t      R$ %.2f\n", quarto.precoDaNoite);
        System.out.printf("Valor dos acessos:\t      R$ %.2f\n", acesso());
        System.out.printf("Valor total da Reserva:\t  R$ %.2f\n", valor);

        if(cliente.desconto){
            double valorComDesconto = valor - (valor * cliente.percentualDesconto());
            System.out.println("Desconto:\t                " + cliente.percentualDesconto()*100 + "%");
            System.out.printf("Valor com desconto:\t      R$ %.2f\n", valorComDesconto);
        }
    }
    public void exibirInfo(){
        this.cliente.exibirInfo();
        this.quarto.exibirInfo();
        String entrada = String.format("%d", this.dataCheckIn.getDayOfMonth()) + "/" + String.format("%d", this.dataCheckIn.getMonthValue()) + "/" + String.format("%d", this.dataCheckIn.getYear());
        String saida = String.format("%d", this.dataCheckOut.getDayOfMonth()) + "/" + String.format("%d", this.dataCheckOut.getMonthValue()) + "/" + String.format("%d", this.dataCheckOut.getYear());
        System.out.printf("Data de CheckIn:\t\t%s\n", entrada);
        System.out.printf("Data de CheckOut:\t\t%s\n",  saida);
        System.out.println("--------------------------------------------------------------------");
    }
}