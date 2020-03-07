/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import java.util.Calendar;

/**
 *
 * @author ITAUTEC
 */
public class Documento {

	private String nome;
    private Calendar data;
    private StringBuilder arquivo;
    
	public Documento(String nome,String arquivo)
	{
		this.nome = nome;
		this.arquivo = new StringBuilder(arquivo);
		this.data = Calendar.getInstance();
	}
	
	public Documento() {}
    
    
	
	
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
        
    }

    /**
     * @return the arquivo
     */
    public StringBuilder getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(StringBuilder arquivo) {
        this.arquivo = arquivo;
    }
    
    
}
