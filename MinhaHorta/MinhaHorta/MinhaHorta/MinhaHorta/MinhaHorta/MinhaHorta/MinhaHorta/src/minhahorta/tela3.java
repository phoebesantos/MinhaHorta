package minhahorta;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class tela3 extends javax.swing.JFrame {

    // --- VARIÁVEIS DE CLASSE ---
    private TelaLoginController controller;
    private Planta plantaSelecionada;
    
    // --- COMPONENTES DA TELA ---
    private javax.swing.JCheckBox adubar_check;
    private javax.swing.JCheckBox regar_check; 
    private javax.swing.JProgressBar barra_progresso;
    private javax.swing.JButton botao_colher;
    private javax.swing.JButton botao_executar;
    private javax.swing.JButton botao_voltar; // Botão Voltar
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> lista_plantas;
    private javax.swing.JPanel painel_fundo;

    
    /**
     * Construtor principal
     */
    public tela3(TelaLoginController controller) {
        this.controller = controller;
        initComponents(); // Monta a tela
        TemaController.aplicarTema(this);
        configurarTela(); // Configura os extras
    }

    public tela3() {
        initComponents();
        configurarTela();
    }

    private void initComponents() {

        painel_fundo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_plantas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        regar_check = new javax.swing.JCheckBox();
        adubar_check = new javax.swing.JCheckBox();
        botao_executar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        barra_progresso = new javax.swing.JProgressBar();
        botao_colher = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        botao_voltar = new javax.swing.JButton(); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel_fundo.setBackground(new java.awt.Color(204, 255, 204));
        painel_fundo.setLayout(null); // Layout nulo (posicionamento manual)

        // Botão Voltar
        botao_voltar.setText("Voltar");
        painel_fundo.add(botao_voltar);
        botao_voltar.setBounds(10, 10, 75, 23);
        
        // Lista de Plantas
        lista_plantas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista_plantas);
        painel_fundo.add(jScrollPane1);
        jScrollPane1.setBounds(6, 45, 143, 249);

        jLabel1.setText("Tarefas");
        painel_fundo.add(jLabel1);
        jLabel1.setBounds(161, 45, 60, 16); 

        regar_check.setText("Regar");
        painel_fundo.add(regar_check);
        regar_check.setBounds(161, 67, 70, 20); 

        adubar_check.setText("Adubar");
        painel_fundo.add(adubar_check);
        adubar_check.setBounds(235, 67, 70, 20); 

        botao_executar.setText("Executar Tarefa");
        painel_fundo.add(botao_executar);
        botao_executar.setBounds(161, 93, 130, 23); 

        jLabel2.setText("Progresso");
        painel_fundo.add(jLabel2);
        jLabel2.setBounds(161, 128, 70, 16); 

        barra_progresso.setBackground(new java.awt.Color(255, 255, 255));
        barra_progresso.setStringPainted(true);
        painel_fundo.add(barra_progresso);
        barra_progresso.setBounds(161, 150, 222, 22); 

        botao_colher.setText("Colher");
        painel_fundo.add(botao_colher);
        botao_colher.setBounds(161, 178, 75, 23); 

        jLabel3.setText("Anotações:");
        painel_fundo.add(jLabel3);
        jLabel3.setBounds(161, 207, 80, 16); 

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);
        painel_fundo.add(jScrollPane2);
        jScrollPane2.setBounds(161, 229, 223, 65); 

        // --- Configuração do Layout da Janela Principal ---
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }

    private void configurarTela() {
        this.setLocationRelativeTo(null);
        this.setTitle("Minha Horta - Gerenciar");
        limparCamposInfo();
        carregarListaPlantas();
        adicionarListeners();
    }

  
    private void carregarListaPlantas() {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (controller != null) {
            for (Planta p : controller.getPlantas()) {
                model.addElement(p.getNome());
            }
        }
        lista_plantas.setModel(model);
    }

   
    private void adicionarListeners() {
        // Evento de clique no BOTÃO EXECUTAR
        botao_executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_executarActionPerformed(evt);
            }
        });
        
        // Evento de clique na LISTA
        lista_plantas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = lista_plantas.getSelectedIndex();
                    if (index != -1) {
                        plantaSelecionada = controller.getPlantas().get(index);
                        carregarDadosPlanta();
                    } else {
                        plantaSelecionada = null;
                        limparCamposInfo();
                    }
                }
            }
        });

        // Evento de clique no BOTÃO COLHER
        botao_colher.addActionListener(evt -> botaoColherActionPerformed(evt));

        // Evento de "perder o foco" da caixa de ANOTAÇÕES
        jTextArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                salvarAnotacoes();
            }
        });

        // Evento de clique no BOTÃO VOLTAR
        botao_voltar.addActionListener(evt -> botaoVoltarActionPerformed(evt));
    }

    private void carregarDadosPlanta() {
        if (plantaSelecionada == null) return;
        
        regar_check.setEnabled(true);
        adubar_check.setEnabled(true);
        botao_executar.setEnabled(true);
        barra_progresso.setEnabled(true);
        botao_colher.setEnabled(true);
        jTextArea1.setEnabled(true);
        
        barra_progresso.setValue(plantaSelecionada.getProgresso());
        jTextArea1.setText(plantaSelecionada.getAnotacoes());
        regar_check.setSelected(false);
        adubar_check.setSelected(false);
    }

    private void limparCamposInfo() {
        regar_check.setEnabled(false);
        adubar_check.setEnabled(false);
        botao_executar.setEnabled(false);
        barra_progresso.setEnabled(false);
        botao_colher.setEnabled(false);
        jTextArea1.setEnabled(false);
        
        regar_check.setSelected(false);
        adubar_check.setSelected(false);
        barra_progresso.setValue(0);
        jTextArea1.setText("");
        lista_plantas.clearSelection();
    }

    private void salvarAnotacoes() {
        if (plantaSelecionada != null) {
            plantaSelecionada.setAnotacoes(jTextArea1.getText());
        }
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        salvarAnotacoes();
        controller.abrirTelaListarPlantas(this); 
    }

    private void botaoColherActionPerformed(java.awt.event.ActionEvent evt) {
        if (plantaSelecionada == null) return;
        
        if (plantaSelecionada.getProgresso() == 100) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você colheu: " + plantaSelecionada.getNome());
            plantaSelecionada.setProgresso(0);
            barra_progresso.setValue(0);
        } else {
            JOptionPane.showMessageDialog(this, "A planta ainda não está pronta para colher!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void botao_executarActionPerformed(java.awt.event.ActionEvent evt) {
        if (plantaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma planta da lista primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!regar_check.isSelected() && !adubar_check.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa (Regar ou Adubar)!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int progressoAtual = plantaSelecionada.getProgresso();
        String tarefasExecutadas = "";
        
        if (regar_check.isSelected()) {
            progressoAtual += 20;
            tarefasExecutadas += "Planta regada! ";
        }
        
        if (adubar_check.isSelected()) {
            progressoAtual += 30;
            tarefasExecutadas += "Planta adubada! ";
        }
        
        plantaSelecionada.setProgresso(progressoAtual);
        barra_progresso.setValue(plantaSelecionada.getProgresso());
        
        JOptionPane.showMessageDialog(this, tarefasExecutadas);
        regar_check.setSelected(false);
        adubar_check.setSelected(false);
        
        salvarAnotacoes();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(tela3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela3().setVisible(true);
            }
        });
    }
}