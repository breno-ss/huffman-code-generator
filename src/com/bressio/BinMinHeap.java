package com.bressio;

public class BinMinHeap {
	private int n; /* Numero de elementos no heap */
	private int tam; /* Tamanho do heap */
	private	Arvbin[] vetor; /* Vetor com elementos */
	
	/* Constr�i heap vazio a partir dos elementos (caracteres). */
	public BinMinHeap(int tamanho) {
		n = 0;
		tam = tamanho;
		vetor = new Arvbin[tamanho+1];
	}
	
	/* Testa se a heap est� vazia. */
	public boolean vazia() {
		/* O grupo deve preencher a implementa��o. */
		return false;
	}
	
	/* Refaz a condi��o de heap (heapify). */
	public void refaz(int i) {
		/* O grupo deve preencher a implementa��o. */
	}

	/* Constr�i a heap (build heap). */
	public void constroiHeap() {
		/* O grupo deve preencher a implementa��o. */
	}

	/* L� dados via teclado e insere na heap. */
	public void carregaDados() {
		/* O grupo deve preencher a implementa��o. */
	}
	
	/* Executa o algoritmo de Huffman. */
	public void aplicaHuffman() {
		/* O grupo deve preencher a implementa��o. */
	}
	
	/* Chama o m�todo mostra c�digos da classe Arvbin. */
	public void mostraCodigos() {
		/* O grupo deve preencher a implementa��o. */
	}
	
	/* Insere x na heap. */
	public void insere(Arvbin x) {
		/* O grupo deve preencher a implementa��o. */
	}
	
	/* Remove e retorna o menor item. */
	public Arvbin removeMin() {
		/* O grupo deve preencher a implementa��o. */
		return null;
	}
	
	/* Imprime o conte�do da heap. */
	public void imprime() {
		/* O grupo deve preencher a implementa��o. */
	}
}
