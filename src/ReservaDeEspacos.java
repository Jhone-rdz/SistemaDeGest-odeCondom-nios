import java.time.LocalDateTime;

public class ReservaDeEspacos {
    private String espaco;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Apartamento apartamento;

    public void reservarEspacos(String espaco, LocalDateTime inicio, LocalDateTime fim, Apartamento apartamento) {
        this.espaco = espaco;
        this.inicio = inicio;
        this.fim = fim;
        this.apartamento = apartamento;
    }

    @Override
    public String toString() {
        return "Reserva de " + espaco + " por " + apartamento.getNumero() + " de " + inicio + " até " + fim;
    }

}
