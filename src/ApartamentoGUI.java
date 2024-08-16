import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ApartamentoGUI {
    private JButton BotaoEnviar;
    private JTextField Input;
    private JPanel panel;

    private Main main;

    public ApartamentoGUI(ArrayList<Apartamento> listaAp, Main main) {
        this.main = main;

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Número do Apartamento:");
        Input = new JTextField();
        BotaoEnviar = new JButton("Adicionar Apartamento");

        BotaoEnviar.addActionListener(e -> {
            int numeroApartamento = Integer.parseInt(Input.getText());
            Apartamento apartamento = new Apartamento();
            apartamento.numero = numeroApartamento;
            listaAp.add(apartamento);
            JOptionPane.showMessageDialog(null, "Você adicionou o apartamento " + numeroApartamento);
            main.atualizarListaApartamentos();
            main.mostrarMenuPrincipal(); // Volta para o menu principal
        });

        panel.add(label);
        panel.add(Input);
        panel.add(BotaoEnviar);
    }

    public JPanel getPanel() {
        return panel;
    }
}
