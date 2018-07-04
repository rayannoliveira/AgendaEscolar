
package br.com.agendaescolar.utilitarios;

import java.util.ArrayList;

public class ModeloTabela {
private ArrayList linhas=null;
private String[] colunas=null;
public ModeloTabela(ArrayList lista, String[] colunas){
    setColunas(colunas);
    setLinhas(linhas);
}

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

}
