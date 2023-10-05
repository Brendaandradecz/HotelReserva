package br.edu.fescfafic.hotelreserva.Main;
import br.edu.fescfafic.hotelreserva.Model.Cliente;
import br.edu.fescfafic.hotelreserva.Model.ClienteNormal;
import br.edu.fescfafic.hotelreserva.Model.ClienteIndicado;
import br.edu.fescfafic.hotelreserva.Model.ClienteParceiro;
import br.edu.fescfafic.hotelreserva.Model.Quarto;
import br.edu.fescfafic.hotelreserva.Model.QuartoSimples;
import br.edu.fescfafic.hotelreserva.Model.QuartoDuplo;
import br.edu.fescfafic.hotelreserva.Model.QuartoSuite;
import br.edu.fescfafic.hotelreserva.Model.Hotel;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Hotel hotel = new Hotel(
                "Hotel Pampas House",
                "Avenida Rubens Miguel, 890, Imperador"
        );
        hotel.exibirInfo();

        Cliente cliente1 = new ClienteNormal(
                "Milena Graziella",
                "milena@gmail.com"
        );
        cliente1.exibirInfo();

        Cliente cliente2 = new ClienteIndicado(
                "Simara Formiga",
                "simara@gmail.com"
        );
        cliente2.exibirInfo();

        Cliente cliente3 = new ClienteParceiro(
                "Brenda Andrade",
                "brenda@gmail.com"
        );
        cliente3.exibirInfo();

        Cliente cliente4 = new ClienteParceiro(
                "Samuel Seny",
                "samuel@gmail.com"
        );
        cliente4.exibirInfo();

        Quarto quarto1 = new QuartoSimples(
                101,
                true
        );
        quarto1.exibirInfo();
        hotel.adicionarQuarto(quarto1);

        Quarto quarto2 = new QuartoDuplo(
                102,
                true
        );
        quarto2.exibirInfo();
        hotel.adicionarQuarto(quarto2);

        Quarto quarto3 = new QuartoSimples(
                103,
                true
        );
        quarto3.exibirInfo();
        hotel.adicionarQuarto(quarto3);

        Quarto quarto4 = new QuartoSimples(
                104,
                true
        );
        quarto4.exibirInfo();
        hotel.adicionarQuarto(quarto4);

        Quarto quarto5 = new QuartoSuite(
                105,
                true
        );
        quarto5.exibirInfo();
        hotel.adicionarQuarto(quarto5);

        Quarto quarto6 = new QuartoSuite(
                106,
                true
        );
        quarto6.exibirInfo();
        hotel.adicionarQuarto(quarto6);

        hotel.verificarDisponibilidade();

        hotel.localizarQuartoPorTipo("Duplo");
        hotel.localizarQuartoPorTipo("Suite");
        hotel.localizarQuartoPorTipo("Presidencial");

        hotel.fazerReservaSite(cliente1, quarto1, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 25), true, false);

        hotel.fazerReservaPresencial(cliente2, quarto1, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 25), true, true);

        hotel.fazerReservaSite(cliente2, quarto2, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 25), false, false);
        hotel.cancelarReserva(cliente1, quarto1);

        hotel.fazerReservaPresencial(cliente3, quarto3, LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 28), false, true);

        hotel.fazerReservaSite(cliente4, quarto4, LocalDate.of(2023, 10, 14), LocalDate.of(2023, 10, 28), true, true);
        hotel.cancelarReserva(cliente4, quarto4);

        hotel.fazerReservaPresencial(cliente3, quarto5, LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 28), true, true);

        hotel.fazerReservaSite(cliente3, quarto6, LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 28), true, true);

        hotel.fazerReservaPresencial(cliente3, quarto4, LocalDate.of(2023, 12, 15), LocalDate.of(2024, 3, 10), true, true);

        hotel.fazerReservaSite(cliente3, quarto1, LocalDate.of(2023, 10, 16), LocalDate.of(2023, 10, 26), true, true);

        hotel.localizarQuartoPorTipo("Simples");
    }
}