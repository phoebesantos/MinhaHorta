package minhahorta;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;

public class TelaLoginController {

    private TelaLogin tela;
    private ArrayList<Planta> plantas = new ArrayList<>();

    private File imagemSelecionada;

    public TelaLoginController(TelaLogin tela) {
        this.tela = tela;
    }
    public void setImagemSelecionada(File imagem) {
        this.imagemSelecionada = imagem;
    }

    public File getImagemSelecionada() {
        return imagemSelecionada;
    }

    // ----------------------------------------------------
    //            FUNÇÃO CADASTRAR PLANTA
    // ----------------------------------------------------
    public void cadastrarPlanta() {

        String nome = tela.getNomePlanta().trim();
        String categoria = tela.getCategoriaSelecionada();
        String descricao = tela.getDescricaoPlanta().trim();

        if (nome.isEmpty() || nome.equalsIgnoreCase("Nome")) {
            JOptionPane.showMessageDialog(tela, "Digite o nome da planta!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Planta registro = new Planta(nome, categoria);
        registro.setDescricao(descricao);
        registro.setAnotacoes(descricao);

        if (imagemSelecionada != null) {
            registro.setCaminhoImagemPersonalizada(imagemSelecionada.getAbsolutePath());
        }

        imagemSelecionada = null;

        plantas.add(registro);

        JOptionPane.showMessageDialog(tela, "Planta cadastrada com sucesso!");
        tela.limparCampos();
    }

    // ----------------------------------------------------
    //            CONTROLE DE TROCA DE TELAS
    // ----------------------------------------------------
    // Abre TelaBase
    public void abrirTelaListarPlantas(JFrame telaAtual) {
        TelaBase tb = new TelaBase(this);
        tb.setVisible(true);
        telaAtual.setVisible(false);
    }

    // TelaBase → tela3
    public void abrirTelaGerenciar(JFrame telaAtual) {
        tela3 t3 = new tela3(this);
        t3.setVisible(true);
        telaAtual.setVisible(false);
    }

    // Voltar ← TelaLogin
    public void abrirTelaLogin(JFrame telaAtual) {
        tela.setVisible(true);
        telaAtual.dispose();
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public void abrirTelaLoja(JFrame telaAtual) {
        TelaLoja telaLoja = new TelaLoja();
        telaLoja.setVisible(true);
        telaAtual.dispose(); // fecha a tela atual
    }

}
