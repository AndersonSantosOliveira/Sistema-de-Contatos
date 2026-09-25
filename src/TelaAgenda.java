import javax.swing.*;
import java.awt.*;

public class TelaAgenda extends JFrame {

    private Agenda agenda = new Agenda();

    private JTextField txtCpf = new JTextField();
    private JTextField txtNome = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTelefone = new JTextField();

    public TelaAgenda() {
        setTitle("Agenda Eletrônica");
        setSize(600, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        criarMenu();
        criarFormulario();

        setVisible(true);
    }

    // ================= MENU =================
    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuContato = new JMenu("Contato");
        JMenuItem itemNovo = new JMenuItem("Novo");
        JMenuItem itemListar = new JMenuItem("Listar contatos");
        JMenuItem itemSair = new JMenuItem("Sair");

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");

        itemNovo.addActionListener(e -> limparCampos());
        itemListar.addActionListener(e -> new TelaListaContatos(this, agenda));
        itemSair.addActionListener(e -> System.exit(0));

        itemSobre.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Agenda Eletrônica\nVersão 1.0\nJava Swing",
                        "Sobre", JOptionPane.INFORMATION_MESSAGE)
        );

        menuContato.add(itemNovo);
        menuContato.add(itemListar);
        menuContato.addSeparator();
        menuContato.add(itemSair);

        menuAjuda.add(itemSobre);

        menuBar.add(menuContato);
        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);
    }

    // ================= FORMULÁRIO =================
    private void criarFormulario() {
        Font fonte = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 20);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(63, 135, 193, 152));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel titulo = new JLabel("Cadastro de Contatos", SwingConstants.CENTER);
        titulo.setFont(fonteTitulo);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        painel.add(criarLabel("CPF:"), gbc);
        gbc.gridx = 1;
        painel.add(configurarCampo(txtCpf, fonte), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Nome:"), gbc);
        gbc.gridx = 1;
        painel.add(configurarCampo(txtNome, fonte), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("E-mail:"), gbc);
        gbc.gridx = 1;
        painel.add(configurarCampo(txtEmail, fonte), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        painel.add(configurarCampo(txtTelefone, fonte), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        JPanel botoes = new JPanel();
        botoes.setBackground(new Color(63, 115, 193, 86));

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnExcluir = new JButton("Excluir");

        botoes.add(btnCadastrar);
        botoes.add(btnBuscar);
        botoes.add(btnExcluir);

        painel.add(botoes, gbc);

        btnCadastrar.addActionListener(e -> cadastrar());
        btnBuscar.addActionListener(e -> buscar());
        btnExcluir.addActionListener(e -> excluir());

        add(painel);
    }

    // ================= AÇÕES =================
    private void cadastrar() {
        try {
            Contato c = new Contato(
                    txtCpf.getText(),
                    txtNome.getText(),
                    txtEmail.getText(),
                    txtTelefone.getText()
            );

            if (agenda.cadastrar(c)) {
                JOptionPane.showMessageDialog(this, "Contato cadastrado!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
            }

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void buscar() {
        Contato c = agenda.buscarContato(txtCpf.getText());

        if (c == null) {
            JOptionPane.showMessageDialog(this, "CPF não encontrado!");
        } else {
            txtNome.setText(c.getNome());
            txtEmail.setText(c.getEmail());
            txtTelefone.setText(c.getTelefone());
        }
    }

    private void excluir() {
        if (agenda.excluirContato(txtCpf.getText())) {
            JOptionPane.showMessageDialog(this, "Contato excluído!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "CPF não encontrado!");
        }
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        return label;
    }

    private JTextField configurarCampo(JTextField campo, Font fonte) {
        campo.setFont(fonte);
        campo.setPreferredSize(new Dimension(260, 30));
        return campo;
    }

    private void limparCampos() {
        txtCpf.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
    }

}
