/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Tratamento;


import br.com.Modelo.Documento;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.*;
/**
 *
 * @author Neto_Santos
 */
public class Arquivo extends JFrame {

	private Documento documento;
	private File file;
	private String caminho;

	public String getCaminho()
	{
		return this.caminho;
	}

	public Arquivo(String nome, String conteudo) {

		this.file = new File(nome);

		documento = new Documento();

	}

	public Arquivo(){}

	public void gravarArquivo(String local,String conteudo) {

		try {

			String nome = local.replace(".txt", "");
			FileWriter escritor = new FileWriter(nome+".txt");

			escritor.write(conteudo);

			escritor.flush();
			escritor.close();


		} catch (IOException e) {

		}
	}

	public String lerArquivo(String caminho) {

		try {

			/*
			 * Obtém o caminho da pasta + o nome do arquivo com a sua extensão.
			 * Ex: c:/user/desktop/teste.txt
			 */
			FileReader file = new FileReader(caminho);

			BufferedReader bf = new BufferedReader(file);

			StringBuilder sb = new StringBuilder();


			if (bf.ready()) {

				while (bf.ready()) {

					sb.append(bf.readLine());
				}
			}


			return sb.toString();

		}
		catch (IOException e) {
			e.printStackTrace();

		}


		return null;
	}

	public boolean existe(String caminhoArquivo) {
		
		File arquivo = new File(caminhoArquivo+".txt");
		
		return arquivo.exists();

	}
}


