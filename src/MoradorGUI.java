import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MoradorGUI {
    private JTextField textField1;
    private JButton enviarButton;
    private JPanel panel;

    private Main main;

    public MoradorGUI(ArrayList<Morador> listaMoradores, ArrayList<Apartamento> listaAp, Main main) {
        this.main = main;

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Nome do Morador:");
        textField1 = new JTextField();
        enviarButton = new JButton("Adicionar Morador");

        enviarButton.addActionListener(e -> {
            String nomeMorador = textField1.getText();
            Morador morador = new Morador();
            morador.nome = nomeMorador;

            String numeroApartamentoStr = JOptionPane.showInputDialog(null, "Digite o número do apartamento:");
            int numeroApartamento = Integer.parseInt(numeroApartamentoStr);

            Apartamento apartamento = listaAp.stream()
                    .filter(ap -> ap.getNumero() == numeroApartamento)
                    .findFirst()
                    .orElse(null);

            if (apartamento != null) {
                apartamento.adicionarMorador(morador);
                listaMoradores.add(morador);
                JOptionPane.showMessageDialog(null, "Você adicionou o morador " + nomeMorador + " ao apartamento " + numeroApartamento);
                main.atualizarListaApartamentos();
                main.mostrarMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Apartamento não encontrado!");
                main.mostrarMenuPrincipal();
            }
        });

        panel.add(label);
        panel.add(textField1);
        panel.add(enviarButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
