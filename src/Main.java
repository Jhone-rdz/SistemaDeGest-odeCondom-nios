import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultListModel<String> listModel;
    private JList<String> listaApartamentos;

    private ApartamentoGUI apartamentoGUI;
    private MoradorGUI moradorGUI;
    private ReservaGUI reservaGUI;

    private ArrayList<Apartamento> listaAp = new ArrayList<>();
    private ArrayList<Morador> listaMoradores = new ArrayList<>();

    public Main() {
        frame = new JFrame("Gestão de Condomínios");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Instanciar GUIs e passar a instância de Main atual
        apartamentoGUI = new ApartamentoGUI(listaAp, this);
        moradorGUI = new MoradorGUI(listaMoradores, listaAp, this);
        reservaGUI = new ReservaGUI(listaAp, this);

        mainPanel.add(criarMenuPrincipal(), "MenuPrincipal");
        mainPanel.add(apartamentoGUI.getPanel(), "AdicionarApartamento");
        mainPanel.add(moradorGUI.getPanel(), "AdicionarMorador");
        mainPanel.add(reservaGUI.getPanel(), "ReservarEspaco");

        frame.add(mainPanel);
        frame.setVisible(true);

        mostrarMenuPrincipal();
    }

    private JPanel criarMenuPrincipal() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAdicionarApartamento = new JButton("Adicionar Apartamento");
        JButton btnAdicionarMorador = new JButton("Adicionar Morador");
        JButton btnReservarEspaco = new JButton("Reservar Espaço");

        btnAdicionarApartamento.addActionListener(e -> mostrarAdicionarApartamento());
        btnAdicionarMorador.addActionListener(e -> mostrarAdicionarMorador());
        btnReservarEspaco.addActionListener(e -> mostrarReservarEspaco());

        botoesPanel.add(btnAdicionarApartamento);
        botoesPanel.add(btnAdicionarMorador);
        botoesPanel.add(btnReservarEspaco);

        listModel = new DefaultListModel<>();
        listaApartamentos = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaApartamentos);

        menuPanel.add(botoesPanel, BorderLayout.NORTH);
        menuPanel.add(scrollPane, BorderLayout.CENTER);

        return menuPanel;
    }

    public void atualizarListaApartamentos() {
        listModel.clear();
        for (Apartamento apartamento : listaAp) {
            listModel.addElement(apartamento.toString());
            for (Morador morador : apartamento.getMoradores()) {
                listModel.addElement("   - " + morador.toString());
            }
        }
    }

    public void mostrarMenuPrincipal() {
        atualizarListaApartamentos();
        cardLayout.show(mainPanel, "MenuPrincipal");
    }

    private void mostrarAdicionarApartamento() {
        cardLayout.show(mainPanel, "AdicionarApartamento");
    }

    private void mostrarAdicionarMorador() {
        cardLayout.show(mainPanel, "AdicionarMorador");
    }

    private void mostrarReservarEspaco() {
        cardLayout.show(mainPanel, "ReservarEspaco");
    }

    public static void main(String[] args) {
        new Main();
    }
}
