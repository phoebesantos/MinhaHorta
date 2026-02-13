package minhahorta;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ImageIcon; // Import adicionado

public class TelaBase extends JFrame {

    private TelaLoginController controller;

    // Construtor que recebe uma planta
    public TelaBase(TelaLoginController controller) {
        this.controller = controller;
        initComponents();
        TemaController.aplicarTema(this);

        initComponent();

        carregarPlantas();
    }

    private void carregarPlantas() {
        // Lista dos labels de NOME
        ArrayList<JLabel> lblNomes = new ArrayList<>();
        lblNomes.add(lblnome_um);
        lblNomes.add(lblnome_dois);
        lblNomes.add(lblnome_tres);
        lblNomes.add(lblnome_quatro);
        lblNomes.add(lblnome_cinco);
        lblNomes.add(lblnome_seis);

        // Lista dos labels de ÍCONE
        ArrayList<JLabel> lblIcones = new ArrayList<>();
        lblIcones.add(lplanta_um);
        lblIcones.add(lplanta_dois);
        lblIcones.add(lplanta_tres);
        lblIcones.add(lplanta_quatro);
        lblIcones.add(lplanta_cinco);
        lblIcones.add(lplanta_seis);

        ArrayList<Planta> plantas = controller.getPlantas();

        // Loop para preencher os 6 espaços
        for (int i = 0; i < Math.min(plantas.size(), 6); i++) {
            Planta planta = plantas.get(i);

            lblNomes.get(i).setText(planta.getNome());

            JLabel iconeLabel = lblIcones.get(i); // Pega o label do ícone (ex: lplanta_um)
            String categoria = planta.getCategoria();
            ImageIcon icone = getIconePorCategoria(categoria); // Pega o ícone certo

            iconeLabel.setText(""); // Apaga o texto "Planta 1"

            if (icone != null) {
                iconeLabel.setIcon(icone); // Define o ícone
                // Centraliza o ícone no quadrado
                iconeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                iconeLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
            }
        }
    }

    //Retorna um ImageIcon baseado no nome da categoria.
    private ImageIcon getIconePorCategoria(String categoria) {
        String caminhoIcone = "";

        switch (categoria) {
            case "Hortaliça":
                caminhoIcone = "/minhahorta/icones/hortalica.jpg";
                break;
            case "Frutífera":
                caminhoIcone = "/minhahorta/icones/frutifera.jpg";
                break;
            case "Ornamental":
                caminhoIcone = "/minhahorta/icones/ornamental.jpg";
                break;
            case "Medicinal":
                caminhoIcone = "/minhahorta/icones/medicinal.jpg";
                break;
            case "Suculenta":
                caminhoIcone = "/minhahorta/icones/suculenta.jpeg";
                break;
            default:
                caminhoIcone = "/minhahorta/icones/default.png";
        }

        java.net.URL imgURL = getClass().getResource(caminhoIcone);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Não foi possível encontrar o ícone: " + caminhoIcone);
            return null;
        }
    }

    private void initComponent() {
        setTitle("Minha Horta - Broto Verde");
        setSize(430, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza a janela na tela

        // --- ADICIONAR OS BOTÕES DEPOIS DO INITCOMPONENTS ---
        painel_fundo.remove(botao_voltar);
        painel_fundo.remove(botao_voltar1);

        botao_voltar.setBounds(20, 10, 80, 30);
        botao_voltar1.setBounds(320, 10, 80, 30);

        // Adiciona diretamente no painel
        painel_fundo.setLayout(null);
        painel_fundo.add(botao_voltar);
        painel_fundo.add(botao_voltar1);

        // Atualiza o painel
        painel_fundo.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        painel_fundo = new javax.swing.JPanel();
        planta_um = new javax.swing.JPanel();
        lplanta_um = new javax.swing.JLabel();
        planta_dois = new javax.swing.JPanel();
        lplanta_dois = new javax.swing.JLabel();
        planta_tres = new javax.swing.JPanel();
        lplanta_tres = new javax.swing.JLabel();
        planta_quatro = new javax.swing.JPanel();
        lplanta_quatro = new javax.swing.JLabel();
        planta_cinco = new javax.swing.JPanel();
        lplanta_cinco = new javax.swing.JLabel();
        planta_seis = new javax.swing.JPanel();
        lplanta_seis = new javax.swing.JLabel();
        lblnome_um = new javax.swing.JLabel();
        lblnome_dois = new javax.swing.JLabel();
        lblnome_tres = new javax.swing.JLabel();
        lblnome_quatro = new javax.swing.JLabel();
        lblnome_cinco = new javax.swing.JLabel();
        lblnome_seis = new javax.swing.JLabel();
        botao_voltar = new javax.swing.JButton();
        botao_voltar1 = new javax.swing.JButton();

        jPanel1.setMaximumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        painel_fundo.setBackground(new java.awt.Color(204, 255, 204));

        planta_um.setBackground(new java.awt.Color(102, 204, 0));
        planta_um.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickUm(evt);
            }
        });

        lplanta_um.setText("Planta 1");

        javax.swing.GroupLayout planta_umLayout = new javax.swing.GroupLayout(planta_um);
        planta_um.setLayout(planta_umLayout);
        planta_umLayout.setHorizontalGroup(
            planta_umLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_umLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lplanta_um)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        planta_umLayout.setVerticalGroup(
            planta_umLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_umLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lplanta_um)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        planta_dois.setBackground(new java.awt.Color(102, 204, 0));
        planta_dois.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickDois(evt);
            }
        });

        lplanta_dois.setText("Planta 2");

        javax.swing.GroupLayout planta_doisLayout = new javax.swing.GroupLayout(planta_dois);
        planta_dois.setLayout(planta_doisLayout);
        planta_doisLayout.setHorizontalGroup(
            planta_doisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_doisLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lplanta_dois)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        planta_doisLayout.setVerticalGroup(
            planta_doisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_doisLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lplanta_dois)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        planta_tres.setBackground(new java.awt.Color(102, 204, 0));
        planta_tres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickedTres(evt);
            }
        });

        lplanta_tres.setText("Planta 3");

        javax.swing.GroupLayout planta_tresLayout = new javax.swing.GroupLayout(planta_tres);
        planta_tres.setLayout(planta_tresLayout);
        planta_tresLayout.setHorizontalGroup(
            planta_tresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_tresLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lplanta_tres)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        planta_tresLayout.setVerticalGroup(
            planta_tresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_tresLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lplanta_tres)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        planta_quatro.setBackground(new java.awt.Color(102, 204, 0));
        planta_quatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickedQuatro(evt);
            }
        });

        lplanta_quatro.setText("Planta 4");

        javax.swing.GroupLayout planta_quatroLayout = new javax.swing.GroupLayout(planta_quatro);
        planta_quatro.setLayout(planta_quatroLayout);
        planta_quatroLayout.setHorizontalGroup(
            planta_quatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_quatroLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lplanta_quatro)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        planta_quatroLayout.setVerticalGroup(
            planta_quatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_quatroLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lplanta_quatro)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        planta_cinco.setBackground(new java.awt.Color(102, 204, 0));
        planta_cinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickedCinco(evt);
            }
        });

        lplanta_cinco.setText("Planta 5");

        javax.swing.GroupLayout planta_cincoLayout = new javax.swing.GroupLayout(planta_cinco);
        planta_cinco.setLayout(planta_cincoLayout);
        planta_cincoLayout.setHorizontalGroup(
            planta_cincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_cincoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lplanta_cinco)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        planta_cincoLayout.setVerticalGroup(
            planta_cincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_cincoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lplanta_cinco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        planta_seis.setBackground(new java.awt.Color(102, 204, 0));
        planta_seis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClickedSeis(evt);
            }
        });

        lplanta_seis.setText("Planta 6");

        javax.swing.GroupLayout planta_seisLayout = new javax.swing.GroupLayout(planta_seis);
        planta_seis.setLayout(planta_seisLayout);
        planta_seisLayout.setHorizontalGroup(
            planta_seisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planta_seisLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lplanta_seis)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        planta_seisLayout.setVerticalGroup(
            planta_seisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planta_seisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lplanta_seis)
                .addGap(37, 37, 37))
        );

        lblnome_um.setText("Nome Planta 1");

        lblnome_dois.setText("Nome Planta 2");

        lblnome_tres.setText("Nome Planta 3");

        lblnome_quatro.setText("Nome Planta 4");

        lblnome_cinco.setText("Nome Planta 5");

        lblnome_seis.setText("Nome Planta 6");

        botao_voltar.setText("Voltar");
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });

        botao_voltar1.setText("Loja");
        botao_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_fundoLayout = new javax.swing.GroupLayout(painel_fundo);
        painel_fundo.setLayout(painel_fundoLayout);
        painel_fundoLayout.setHorizontalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(planta_quatro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(planta_um, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnome_um)
                            .addComponent(lblnome_quatro))))
                .addGap(31, 31, 31)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(planta_dois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(planta_cinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(planta_tres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(planta_seis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_fundoLayout.createSequentialGroup()
                                .addComponent(lblnome_dois)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblnome_tres))
                            .addGroup(painel_fundoLayout.createSequentialGroup()
                                .addComponent(lblnome_cinco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblnome_seis)))
                        .addGap(33, 33, 33))))
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botao_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_voltar1)
                .addContainerGap())
        );
        painel_fundoLayout.setVerticalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_voltar)
                    .addComponent(botao_voltar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(planta_dois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planta_um, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planta_tres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnome_um)
                    .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblnome_dois)
                        .addComponent(lblnome_tres)))
                .addGap(23, 23, 23)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(planta_quatro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(planta_cinco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(planta_seis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnome_quatro)
                    .addComponent(lblnome_cinco)
                    .addComponent(lblnome_seis))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonClickUm(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickUm
        ButtonClickedN(1);
    }//GEN-LAST:event_ButtonClickUm

    private void ButtonClickDois(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickDois
        ButtonClickedN(2);
    }//GEN-LAST:event_ButtonClickDois

    private void ButtonClickedTres(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickedTres
        ButtonClickedN(3);
    }//GEN-LAST:event_ButtonClickedTres

    private void ButtonClickedQuatro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickedQuatro
        ButtonClickedN(4);
    }//GEN-LAST:event_ButtonClickedQuatro

    private void ButtonClickedCinco(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickedCinco
        ButtonClickedN(5);
    }//GEN-LAST:event_ButtonClickedCinco

    private void ButtonClickedSeis(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClickedSeis
        ButtonClickedN(6);
    }//GEN-LAST:event_ButtonClickedSeis

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed
        controller.abrirTelaLogin(this);
    }//GEN-LAST:event_botao_voltarActionPerformed

    private void botao_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltar1ActionPerformed
        controller.abrirTelaLoja(this);
    }//GEN-LAST:event_botao_voltar1ActionPerformed

    private void botao_gerenciarActionPerformed(java.awt.event.ActionEvent evt) {
        controller.abrirTelaGerenciar(this);
    }

    private void ButtonClickedN(int n) {

        System.out.println("Planta " + n + " clicada.");

        controller.abrirTelaGerenciar(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new TelaBase().setVisible(true); // Isso não pode ser executado sem um controller
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_voltar;
    private javax.swing.JButton botao_voltar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblnome_cinco;
    private javax.swing.JLabel lblnome_dois;
    private javax.swing.JLabel lblnome_quatro;
    private javax.swing.JLabel lblnome_seis;
    private javax.swing.JLabel lblnome_tres;
    private javax.swing.JLabel lblnome_um;
    private javax.swing.JLabel lplanta_cinco;
    private javax.swing.JLabel lplanta_dois;
    private javax.swing.JLabel lplanta_quatro;
    private javax.swing.JLabel lplanta_seis;
    private javax.swing.JLabel lplanta_tres;
    private javax.swing.JLabel lplanta_um;
    private javax.swing.JPanel painel_fundo;
    private javax.swing.JPanel planta_cinco;
    private javax.swing.JPanel planta_dois;
    private javax.swing.JPanel planta_quatro;
    private javax.swing.JPanel planta_seis;
    private javax.swing.JPanel planta_tres;
    private javax.swing.JPanel planta_um;
    // End of variables declaration//GEN-END:variables
}
