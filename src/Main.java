import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Apartamento> apartamentos = new ArrayList<>();
        ArrayList<ReservaDeEspacos> reservas = new ArrayList<>();


        Apartamento ap1 = new Apartamento();
        ap1.cadastrarApartamento(101);
        apartamentos.add(ap1);

        Morador moradorAp1 = new Morador();
        moradorAp1.nome = "cesar";
        ap1.adicionarMorador(moradorAp1);


        ReservaDeEspacos reserva1 = new ReservaDeEspacos();
        reserva1.reservarEspacos("Salão de Festas", LocalDateTime.of(2023, 8, 20, 18, 0), LocalDateTime.of(2023, 8, 20, 23, 0), ap1);
        reservas.add(reserva1);

        for (Apartamento apartamento : apartamentos) {
            System.out.println(apartamento);
            for (Morador morador : apartamento.getMoradores()) {
                System.out.println(" - " + morador);
            }
        }

        for (ReservaDeEspacos reserva : reservas) {
            System.out.println(reserva);
        }
    }
}
