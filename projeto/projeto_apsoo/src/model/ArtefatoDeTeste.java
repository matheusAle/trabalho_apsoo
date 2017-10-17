package model;

import controller.adapters.ArtefatoDeTesteAdapter;

import java.util.LinkedList;

/**
 * Classe que modela um artefato de teste
 */
public class ArtefatoDeTeste implements Comparable<ArtefatoDeTeste>{
    private String pakage;
    private String nomeArquivo;
    private String caminhoAbsoluto;
    private LinkedList<CasoDeTeste> casosDeTeste;

    public ArtefatoDeTeste(String pakage, String nomeArquivo, String caminhoAbsoluto) {
        this.pakage = pakage;
        this.nomeArquivo = nomeArquivo;
        this.caminhoAbsoluto = caminhoAbsoluto;
    }

    /**
     * Retorna o caminh do pacote no qual o artefato de teste encotra-se no diretorio do projeto
     * @return
     */
    public String getPakage() {
        return pakage;
    }

    /**
     * retorna o nome do arquivo do artefato de teste.
     * @return
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * Retorna o caminho absoluto do diretorio do artefato de teste, de acrdo com o sistema operacional.
     * @return
     */
    public String getCaminhoAbsoluto() {
        return caminhoAbsoluto;
    }

    /**
     * Retorna uma lista de casos de teste
     * @return
     */
    public LinkedList<CasoDeTeste> getCasosDeTeste() {
        return casosDeTeste;
    }

    /**
     * Vincula a este artefato de teste o caso de teste passado como paramentro
     * @param casoDeTeste
     */
    public void addCasoDeTeste(CasoDeTeste casoDeTeste){
        casoDeTeste.setArtefatoDeTeste(this);
        casosDeTeste.add(casoDeTeste);

    }

    public void setCasosDeTeste(LinkedList<CasoDeTeste> casosDeTeste) {
        this.casosDeTeste = casosDeTeste;
    }

    @Override
    public int compareTo(ArtefatoDeTeste o) {
        return getPakage().compareTo(o.getPakage());
    }

    /**
     * @return Tetorna uma instancia de ArtefatoDeTesteAdapter com os calores deste ArtefatoDe teste.
     */
    public ArtefatoDeTesteAdapter getAdapter(){
        return new ArtefatoDeTesteAdapter(this.pakage, this.nomeArquivo, this.getCaminhoAbsoluto());
    }
}
