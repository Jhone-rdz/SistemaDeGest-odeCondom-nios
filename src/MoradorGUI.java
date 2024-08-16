import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MoradorGUI {
    private JTextField textFieldNome;
    private JTextField textFieldNumeroAP;
    private JButton enviarButton;
    private JButton botaoSelecionarApartamento;
    private JPanel panel;
    private JButton botaoVoltar;

    private Main main;
    private ArrayList<Apartamento> listaAp;

    public MoradorGUI(ArrayList<Morador> listaMoradores, ArrayList<Apartamento> listaAp, Main main) {
        this.main = main;
        this.listaAp = listaAp;

        panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelNome = new JLabel("Nome do Morador:");
        textFieldNome = new JTextField();

        JLabel labelNumeroAP = new JLabel("Número do Apartamento:");
        textFieldNumeroAP = new JTextField();

        botaoSelecionarApartamento = new JButton("Selecionar Apartamento");
        botaoSelecionarApartamento.addActionListener(e -> mostrarSelecionarApartamento());

        enviarButton = new JButton("Adicionar Morador");
        enviarButton.addActionListener(e -> adicionarMorador(listaMoradores));

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> main.mostrarMenuPrincipal());

        inputPanel.add(labelNome);
        inputPanel.add(textFieldNome);
        inputPanel.add(labelNumeroAP);
        inputPanel.add(textFieldNumeroAP);
        inputPanel.add(botaoSelecionarApartamento);
        inputPanel.add(enviarButton);

        panel.add(botaoVoltar, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
    }

    private void mostrarSelecionarApartamento() {
        JPanel painelSelecionar = new JPanel(new GridLayout(listaAp.size() + 1, 1, 10, 10));
        JButton botaoConfirmar = new JButton("Confirmar Seleção");

        for (Apartamento ap : listaAp) {
            JButton botaoApartamento = new JButton("Apartamento " + ap.getNumero());
            botaoApartamento.addActionListener(e -> {
                textFieldNumeroAP.setText(String.valueOf(ap.getNumero()));
                JOptionPane.showMessageDialog(null, "Apartamento selecionado: " + ap.getNumero());
                ((JDialog) SwingUtilities.getWindowAncestor(painelSelecionar)).dispose();
            });
            painelSelecionar.add(botaoApartamento);
        }

        painelSelecionar.add(botaoConfirmar);

        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(panel), "Selecionar Apartamento", true);
        dialog.setContentPane(painelSelecionar);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void adicionarMorador(ArrayList<Morador> listaMoradores) {
        String nomeMorador = textFieldNome.getText();
        Morador morador = new Morador();
        morador.nome = nomeMorador;

        int numeroApartamento;
        try {
            numeroApartamento = Integer.parseInt(textFieldNumeroAP.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número do apartamento inválido!");
            return;
        }

        Apartamento apartamento = listaAp.stream()
                .filter(ap -> ap.getNumero() == numeroApartamento)
                .findFirst()
                .orElse(null);

        if (apartamento != null) {
            apartamento.adicionarMorador(morador);
            listaMoradores.add(morador);
            JOptionPane.showMessageDialog(null, "Você adicionou o morador " + nomeMorador + " ao apartamento " + numeroApartamento);
            main.atualizarListaApartamentos();
            textFieldNome.setText("");
            textFieldNumeroAP.setText("");
            main.mostrarMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Apartamento não encontrado!");
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
