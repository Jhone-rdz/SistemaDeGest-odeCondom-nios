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

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Número do Apartamento:");
        input = new JTextField();
        botaoEnviar = new JButton("Adicionar Apartamento");

        botaoEnviar.addActionListener(e -> {
            try {
                int numeroApartamento = Integer.parseInt(input.getText());
                Apartamento apartamento = new Apartamento();
                apartamento.setNumero(numeroApartamento);
                listaAp.add(apartamento);
                JOptionPane.showMessageDialog(null, "Você adicionou o apartamento " + numeroApartamento);
                main.atualizarListaApartamentos();
                input.setText(""); 
                main.mostrarMenuPrincipal();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Número do apartamento inválido!");
            }
        });

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> main.mostrarMenuPrincipal());

        panel.add(label);
        panel.add(input);
        panel.add(botaoEnviar);
        panel.add(botaoVoltar, BorderLayout.NORTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
