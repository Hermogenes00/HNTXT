/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import br.com.Tratamento.Arquivo;

/**
 *
 * @author ITAUTEC Criando um editor de texto em Java.
 */
public class Principal extends JFrame {

	//Criação dos componentes
	JPanel painel_cabecalho;
	JPanel painel_centro;
	JPanel painel_rodape;
	JToolBar barra_ferramentas;
	JTextArea area_texto;
	JTextArea texto_rodape;
	JTextArea area_titulo;
	JScrollPane scrollPane;

	JList<Object> listaArquivos;
	JButton botaoSalvar;
	JButton botaoAbrirArquivo;
	JButton botaoSair;
	JButton botaoNovo;


	public Principal() {
		super("HNTXT");

		try {
			/*
			 * Utilizando padrão de GUI do estilo Nimbus
			 */
			UIManager.setLookAndFeel(new NimbusLookAndFeel());  
		} catch (Exception e) {
			// TODO: handle exception
		}

		componentes();
	}

	public void componentes() {

		super.setLayout(new BorderLayout());    	

		painel_cabecalho = new JPanel();
		painel_cabecalho.setSize(250, 250);

		painel_rodape = new JPanel();

		/*
		 * setPreferredSize força o componente a ter o tamanho especificado
		 * mesmo que esteja dentro de um BorderLayout
		 */

		painel_rodape.setPreferredSize(new Dimension(250, 10));

		painel_centro = new JPanel();
		painel_centro.setSize(250, 250);

		painel_cabecalho.setBackground(Color.white);
		painel_rodape.setBackground(Color.white);

		painel_centro.setLayout(new BorderLayout());
		painel_centro.setBackground(Color.black);

		barra_ferramentas = new JToolBar("Barra de Ferramentas");

		barra_ferramentas.setFloatable(false);

		painel_cabecalho.add(BorderLayout.CENTER, barra_ferramentas);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/salvar.png")));

		botaoAbrirArquivo = new JButton("Abrir Arquivo");
		botaoAbrirArquivo.setIcon(new ImageIcon(getClass().getResource("/imagens/abrir.png")));

		botaoSair = new JButton("Sair");
		botaoSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
		
		botaoNovo = new JButton("Novo");
		botaoNovo.setIcon(new ImageIcon(getClass().getResource("/imagens/novo.png")));

		barra_ferramentas.add(botaoNovo);
		barra_ferramentas.add(botaoAbrirArquivo);
		barra_ferramentas.add(botaoSalvar);
		barra_ferramentas.add(botaoSair);
		
		
		area_texto = new JTextArea();
		area_texto.setColumns(45);
		area_texto.setRows(10);
		area_texto.setFont((new Font(Font.SANS_SERIF, Font.PLAIN, 11)));
		area_texto.setLineWrap(true);
		area_texto.setWrapStyleWord(true);

		area_titulo = new JTextArea();
		area_titulo.setColumns(45);
		area_titulo.setRows(1);
		area_titulo.setLineWrap(true);

		texto_rodape = new JTextArea();
		texto_rodape.setEnabled(false);

		scrollPane = new JScrollPane(area_texto);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		painel_centro.add(BorderLayout.NORTH,area_titulo);

		painel_centro.add(BorderLayout.CENTER,scrollPane);

		painel_rodape.setPreferredSize(new Dimension(super.getWidth(),25));
		painel_rodape.setLayout(new BorderLayout());;
		painel_rodape.add(BorderLayout.CENTER,texto_rodape);

		super.getContentPane().add(BorderLayout.NORTH, painel_cabecalho);
		super.getContentPane().add(BorderLayout.CENTER, painel_centro);
		super.getContentPane().add(BorderLayout.SOUTH, painel_rodape);


		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setVisible(true);

		botaoNovo.addMouseListener(new botaoNovoMouseListener());
		botaoAbrirArquivo.addMouseListener(new botaoAbrirArquivoMouseListener());
		botaoSair.addMouseListener(new botaoSairArquivoMouseListener());
		botaoSalvar.addMouseListener(new botaoSalvarArquivoMouseListener());
	}

	private class botaoAbrirArquivoMouseListener implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {

			JFileChooser dialogo = new JFileChooser();

			int opcao = dialogo.showOpenDialog(null);

			if (opcao == dialogo.OPEN_DIALOG) {

				String caminho = dialogo.getSelectedFile().getAbsolutePath();
				Arquivo arq = new Arquivo();

				area_titulo.setText("");
				String titulo = dialogo.getSelectedFile().getName().split(".txt")[0];
				area_titulo.append(titulo);

				area_texto.setText("");
				area_texto.append(arq.lerArquivo(caminho));

				texto_rodape.setText("");
				texto_rodape.append(caminho);

			}


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}}

	private class botaoSairArquivoMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			var escolha = JOptionPane.showInternalConfirmDialog(null, "Deseja realmente sair do programa ?");
			if (escolha == JOptionPane.OK_OPTION) {
				System.exit(0);
			}


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}}

	private class botaoSalvarArquivoMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {


			Arquivo arq = new Arquivo();
			
			
			if (verificaArquivoSalvo()) {

				String caminho = texto_rodape.getText().replace("Salvo em:", "");
				arq.gravarArquivo(caminho, area_texto.getText());

			}else {

				JFileChooser dialogo = new JFileChooser();
				System.out.println("Nome do arquivo: "+area_titulo.getText());
				dialogo.setDialogTitle("Salvar em:");

				//String caminho = dialogo.getSelectedFile().getAbsolutePath();

				dialogo.setSelectedFile(new File("c:\\"+area_titulo.getText()));

				int escolha = dialogo.showSaveDialog(null);	
				if (escolha == dialogo.APPROVE_OPTION) {

					/*
					 * Verifica se já existe um arquivo com o nome informado.
					 * Caso existe, pergunta ao usuário se gostaria de sobrescrever o 
					 * arquivo.
					 */
					if (arq.existe(dialogo.getSelectedFile().getAbsolutePath())) {

						int opcaoEscolhida = JOptionPane.showConfirmDialog(null, "Já existe um arquivo com este nome. Gostaria de sobrescrevê-lo?");

						if (opcaoEscolhida == JOptionPane.OK_OPTION) {

							arq.gravarArquivo(dialogo.getSelectedFile().getAbsolutePath(), area_texto.getText());

							texto_rodape.setText("");
							texto_rodape.append("Salvo em:");
							texto_rodape.append(dialogo.getSelectedFile().getPath());
						}

					}else {

						arq.gravarArquivo(dialogo.getSelectedFile().getAbsolutePath(), area_texto.getText());

						texto_rodape.setText("");
						texto_rodape.append("Salvo em:");
						texto_rodape.append(dialogo.getSelectedFile().getPath());

					}


				}
			}


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}}

	private class botaoNovoMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (!area_titulo.getText().equals("")) {
				
				if (!verificaArquivoSalvo()) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Arquivo não salvo, deseja criar um novo arquivo mesmo assim?",
							"Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (opcao == JOptionPane.OK_OPTION) {
						fecharArquivo();
					}
				}
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void fecharArquivo() {
		area_titulo.setText("");
		area_texto.setText("");
		texto_rodape.setText("");
	}

	public boolean verificaArquivoSalvo() {

		if (texto_rodape.getText().equals("")) {

			return false;
		}else {
			return true;
		}

		

	}

}
