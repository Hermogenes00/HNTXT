/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Tratamento;


import br.com.Modelo.Documento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.*;
/**
 *
 * @author Neto_Santos
 */
public class Arquivos extends JFrame {

	private Documento documento;
	private File file;
	private ObjectOutputStream escritor;

	public Arquivos(String nome, String conteudo) {

		this.file = new File(nome);

		documento = new Documento();

	}

	public Arquivos(){}

	public void gravarArquivo() {

		if (!file.exists()) {

			try {

				FileOutputStream arquivo = new FileOutputStream(documento.getNome() + ".txt");

				escritor = new ObjectOutputStream(arquivo);

				escritor.writeUTF(documento.getArquivo().toString());
				escritor.flush();

			} catch (IOException e) {

			}

		}
	}

	public String lerArquivo() {

		if (JOptionPane.showConfirmDialog(this, "Deseja realizar esta operação?") == JOptionPane.OK_OPTION) {
			System.out.println("Clickou em ok");
		}
		try {
			
			JFileChooser escolherArquivo = new JFileChooser();
			
			escolherArquivo.setDialogTitle("Escolha o arquivo");
			escolherArquivo.showOpenDialog(null);
			
			String dados = escolherArquivo.getSelectedFile().getName().isEmpty()?"Vazio":"Contém algo";

			if (!dados.isEmpty() && !dados.isBlank()) {
				FileInputStream file_Entrada = new FileInputStream(dados);
				ObjectInputStream entrada = new ObjectInputStream(file_Entrada);
				dados =  entrada.readUTF();            
				return dados;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
