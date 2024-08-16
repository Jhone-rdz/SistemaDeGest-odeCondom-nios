import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReservaGUI {
    private JButton enviarButton;
    private JTextField localTextField;
    private JTextField dataInicioTextField;
    private JTextField dataFimTextField;
    private JTextField numeroAPTextField;
    private JPanel panel;

    private Main main;

    public ReservaGUI(ArrayList<Apartamento> listaAp, Main main) {
        this.main = main;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel labelEspaco = new JLabel("Espaço:");
        localTextField = new JTextField();

        JLabel labelDataInicio = new JLabel("Data de Início:");
        dataInicioTextField = new JTextField();

        JLabel labelDataFim = new JLabel("Data de Fim:");
        dataFimTextField = new JTextField();

        JLabel labelNumeroAP = new JLabel("Número do Apartamento:");
        numeroAPTextField = new JTextField();

        enviarButton = new JButton("Reservar Espaço");

        enviarButton.addActionListener(e -> {
            String espaco = localTextField.getText();
            String dataInicio = dataInicioTextField.getText();
            String dataFim = dataFimTextField.getText();
            int numero = Integer.parseInt(numeroAPTextField.getText());

            Apartamento apartamento = listaAp.stream()
                    .filter(ap -> ap.getNumero() == numero)
                    .findFirst()
                    .orElse(null);

            if (apartamento != null) {
                ReservaDeEspacos reserva = new ReservaDeEspacos();
                reserva.setEspaco(espaco);
                reserva.setInicio(dataInicio);
                reserva.setFim(dataFim);
                reserva.setNumero(numero);
                JOptionPane.showMessageDialog(null, reserva.toString());
                main.mostrarMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Apartamento não encontrado!");
            }
        });

        panel.add(labelEspaco);
        panel.add(localTextField);
        panel.add(labelDataInicio);
        panel.add(dataInicioTextField);
        panel.add(labelDataFim);
        panel.add(dataFimTextField);
        panel.add(labelNumeroAP);
        panel.add(numeroAPTextField);
        panel.add(enviarButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
