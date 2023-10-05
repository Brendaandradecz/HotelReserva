package br.edu.fescfafic.hotelreserva.Model;

public abstract class Quarto {
    public int numeroDoQuarto;
    public String tipoDeQuarto;
    public double precoDaNoite;
    public boolean disponibilidade;

    public Quarto(int numeroDoQuarto,String tipoDeQuarto,double precoDaNoite, boolean disponibilidade){
        this.numeroDoQuarto = numeroDoQuarto;
        this.tipoDeQuarto = tipoDeQuarto;
        this.precoDaNoite = precoDaNoite;
        this.disponibilidade = disponibilidade;
    }
    public void exibirInfo(){
        System.out.println("\nINFORMACOES DO QUARTO");
        System.out.printf("Numero do Quarto:\t\t\t%d", this.numeroDoQuarto);
        System.out.printf("\nTipo de Quarto:\t\t\t  %s", this.tipoDeQuarto);
        System.out.printf("\nPreco da Noite:\t\t\t  R$ %.2f\n", this.precoDaNoite);
        if (this.disponibilidade){
            System.out.println("QUARTO DISPONIVEL\n");
        } else {
            System.out.println("QUARTO OCUPADO \n");
        }
    }

}