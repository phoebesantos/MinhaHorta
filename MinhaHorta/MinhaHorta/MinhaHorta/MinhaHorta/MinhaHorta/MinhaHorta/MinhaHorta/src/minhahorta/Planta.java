package minhahorta;

import java.io.File;

public class Planta {

    private String nome;
    private String categoria;
    private String descricao;

    // --- CAMPOS NOVOS ---
    private int progresso;
    private String anotacoes;

    // --- IMAGEM DO USUÁRIO ---
    private String caminhoImagemPersonalizada;

    public String getCaminhoImagemPersonalizada() {
        return caminhoImagemPersonalizada;
    }

    public void setCaminhoImagemPersonalizada(String caminhoImagemPersonalizada) {
        this.caminhoImagemPersonalizada = caminhoImagemPersonalizada;
    }

    private String caminhoImagem;

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Planta(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.progresso = 0;
        this.anotacoes = "";
        this.caminhoImagemPersonalizada = null;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }

    // --- MÉTODOS NOVOS ---
    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        if (progresso < 0) {
            this.progresso = 0;
        } else if (progresso > 100) {
            this.progresso = 100;
        } else {
            this.progresso = progresso;
        }
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    /**
     * Retorna qual imagem deve ser usada na exibição: 
     * - se o usuário enviou uma imagem → retorna ela 
     * - senão → retorna a imagem padrão da categoria
     */
    public String getImagemFinal() {
        
    if (caminhoImagemPersonalizada != null && !caminhoImagemPersonalizada.isEmpty()) {
        return caminhoImagemPersonalizada; 
    }

    
    switch (categoria.toLowerCase()) {
        case "frutífera":
        case "frutifera":
            return "/minhahorta/icones/frutifera.jpg";

        case "hortaliça":
        case "hortalica":
            return "/minhahorta/icones/hortalica.jpg";

        case "ornamental":
            return "/minhahorta/icones/ornamental.jpg";

        case "medicinal":
            return "/minhahorta/icones/medicinal.jpg";

        case "suculenta":
            return "/minhahorta/icones/suculenta.jpeg";

        default:
            return "/minhahorta/icones/default.png";
    }
    }
}
