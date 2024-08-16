import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ApartamentoGUI {
    private JButton botaoEnviar;
    private JTextField input;
    private JPanel panel;
    private JButton botaoVoltar;

    private Main main;

    public ApartamentoGUI(ArrayList<Apartamento> listaAp, Main main) {
        this.main = main;

        panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Número do Apartamento:");
        input = new JTextField();
        botaoEnviar = new JButton("Adicionar Apartamento");

        botaoEnviar.addActionListener(e -> {
            int numeroApartamento = Integer.parseInt(input.getText());
            Apartamento apartamento = new Apartamento();
            apartamento.numero = numeroApartamento;
            listaAp.add(apartamento);
            JOptionPane.showMessageDialog(null, "Você adicionou o apartamento " + numeroApartamento);
            main.atualizarListaApartamentos();
            input.setText("");
            main.mostrarMenuPrincipal();
        });

        inputPanel.add(label);
        inputPanel.add(input);
        inputPanel.add(botaoEnviar);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> main.mostrarMenuPrincipal());

        panel.add(botaoVoltar, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
