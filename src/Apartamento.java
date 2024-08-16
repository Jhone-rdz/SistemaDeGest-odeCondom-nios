import java.util.ArrayList;

public class Apartamento {
    int numero;
    ArrayList<Morador> moradores = new ArrayList<>();

    public void cadastrarApartamento(Integer numero) {
        this.numero = numero;
    }
    public ArrayList<Morador> getMoradores() {
        return moradores;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMoradores(ArrayList<Morador> moradores) {
        this.moradores = moradores;
    }

    public void adicionarMorador(Morador morador) {
        moradores.add(morador);
    }

    @Override
    public String toString() {
        return "Apartamento " + numero + " com " + moradores.size() + " moradores.";
    }

    public int getNumero() {
        return numero;
    }
}
