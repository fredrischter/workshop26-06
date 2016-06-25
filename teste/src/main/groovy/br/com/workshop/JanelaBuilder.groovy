package br.com.workshop

/**
 * Created by dummy on 18/06/2016.
 */
class JanelaBuilder {

    Janela janela;

    JanelaBuilder() {
        janela = new Janela();
    }

    def setSize(int i, int j) {
        janela.setSize(i, j)
    }

    def setList(Object[] objects) {
        janela.setList(objects);
    }

    Janela build() {
        janela.exibir();
    }
}
