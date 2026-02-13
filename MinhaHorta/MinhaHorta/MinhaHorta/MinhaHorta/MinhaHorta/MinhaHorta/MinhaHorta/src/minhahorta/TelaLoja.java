package minhahorta;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TelaLoja extends javax.swing.JFrame {

    public TelaLoja() {
        initComponents();

        btn_visitar3.addActionListener(e -> abrirLoja("https://www.plantei.com.br/?utm_source=&utm_medium=&utm_campaign=&utm_content=&gad_source=1&gad_campaignid=22478850867&gbraid=0AAAAADbG2QgqDH5KW3fVW6d7vAb9ZJGWV&gclid=EAIaIQobChMIwejl6tOikQMVDTtECB3GIwZUEAAYASAAEgJrjfD_BwE"));
        btn_visitar2.addActionListener(e -> abrirLoja("https://www.holambelo.com/pt/product/index/index/WPA_ID/7/"));
        btn_visitar1.addActionListener(e -> abrirLoja("https://loja.spagnhol.com.br/?gad_source=1&gad_campaignid=21019151227&gbraid=0AAAAACemfm9uAwKH1U1HF0m6NQNEvewvD&gclid=EAIaIQobChMIzeyItNOikQMVEGFIAB3Pcxu6EAAYASAAEgJgmvD_BwE"));
    }

    // --- Método para abrir links no navegador ---
    private void abrirLoja(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível abrir o navegador.\nURL: " + url, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | URISyntaxException e) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar abrir o link: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        painel_fundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_img1 = new javax.swing.JLabel();
        lbl_loja1 = new javax.swing.JLabel();
        lbl_img2 = new javax.swing.JLabel();
        lbl_loja2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_loja3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_visitar1 = new javax.swing.JButton();
        btn_visitar2 = new javax.swing.JButton();
        btn_visitar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel_fundo.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Display", 0, 24));
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Lojas Parceiras do Broto Verde");

        lbl_img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minhahorta/icones/logo_plantei.png")));

        lbl_loja1.setFont(new java.awt.Font("Sitka Display", 0, 14));
        lbl_loja1.setText("Plantei Garden Center");

        lbl_img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minhahorta/icones/logo_holambelo.png")));

        lbl_loja2.setFont(new java.awt.Font("Sitka Display", 0, 14));
        lbl_loja2.setText("Spagnhol");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minhahorta/icones/logo_spagnhol.png")));

        lbl_loja3.setFont(new java.awt.Font("Sitka Display", 0, 14));
        lbl_loja3.setText("Holambelo");

        jLabel3.setText("Use o nosso cupom BROTOVERDE25 e ganhe descontos incríveis!");

        btn_visitar1.setText("Visitar loja");
        btn_visitar2.setText("Visitar loja");
        btn_visitar3.setText("Visitar loja");

        // --- Layout do painel ---
        GroupLayout painel_fundoLayout = new GroupLayout(painel_fundo);
        painel_fundo.setLayout(painel_fundoLayout);
        painel_fundoLayout.setHorizontalGroup(
            painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, painel_fundoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btn_visitar3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_visitar2)
                .addGap(86, 86, 86)
                .addComponent(btn_visitar1)
                .addGap(55, 55, 55))
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_loja1)
                .addGap(82, 82, 82)
                .addComponent(lbl_loja3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_loja2)
                .addGap(70, 70, 70))
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel3)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, painel_fundoLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(GroupLayout.Alignment.TRAILING, painel_fundoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_img1)
                .addGroup(painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, painel_fundoLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(47, 47, 47))
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lbl_img2)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painel_fundoLayout.setVerticalGroup(
            painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_img2, GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_img1, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_loja1)
                    .addComponent(lbl_loja3)
                    .addComponent(lbl_loja2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fundoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_visitar1)
                    .addComponent(btn_visitar2)
                    .addComponent(btn_visitar3))
                .addGap(23, 23, 23))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null); // Centraliza na tela
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new TelaLoja().setVisible(true));
    }
    
    private JButton btn_visitar1;
    private JButton btn_visitar2;
    private JButton btn_visitar3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel lbl_img1;
    private JLabel lbl_img2;
    private JLabel lbl_loja1;
    private JLabel lbl_loja2;
    private JLabel lbl_loja3;
    private JPanel painel_fundo;
}
