
public class ReservaDeEspacos {
    private String espaco;
    private String inicio;
    private String fim;
    private int numero;

    public String getEspaco() {
        return espaco;
    }

    public void setEspaco(String espaco) {
        this.espaco = espaco;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void reservarEspacos(String espaco, String inicio, String fim, int numero) {
        this.espaco = espaco;
        this.inicio = inicio;
        this.fim = fim;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Reserva de " + espaco + " por " + numero + " de " + inicio + " até " + fim;
    }

}