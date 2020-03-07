/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

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
    JTextArea area_titulo;
    JScrollBar scrollbar;
    JList<Object> listaArquivos;
    JButton botao;

    public Principal() {
        componentes();
    }

    public void componentes() {
    	
    	super.setLayout(new BorderLayout());    	
    	
        painel_cabecalho = new JPanel();
        painel_cabecalho.setSize(250, 250);

        painel_rodape = new JPanel();
        
        /*
         * setPreferredSize for�a o componente a ter o tamanho especificado
         * mesmo que esteja dentro de um BorderLayout
         */
        
        painel_rodape.setPreferredSize(new Dimension(250, 30));

        painel_centro = new JPanel();
        painel_centro.setSize(250, 250);

        painel_cabecalho.setBackground(Color.GRAY);
        painel_rodape.setBackground(Color.BLACK);
        painel_centro.setBackground(Color.GREEN);

        barra_ferramentas = new JToolBar("Barra de Ferramentas");
        
        barra_ferramentas.setFloatable(false);
        
        painel_cabecalho.add(BorderLayout.CENTER, barra_ferramentas);

        botao = new JButton("Salvar");
        barra_ferramentas.add(botao);
        
        area_texto = new JTextArea();
        area_texto.setColumns(45);
        area_texto.setRows(10);
        area_texto.setLineWrap(true);
        
        area_titulo = new JTextArea();
        area_titulo.setColumns(45);
        area_titulo.setRows(1);
        area_titulo.setLineWrap(true);
        
        scrollbar = new JScrollBar();
       
        painel_centro.add(area_titulo);
        painel_centro.add(area_texto);
        
        
        super.getContentPane().add(BorderLayout.NORTH, painel_cabecalho);
        super.getContentPane().add(BorderLayout.CENTER, painel_centro);
        super.getContentPane().add(BorderLayout.SOUTH, painel_rodape);

        
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(550,300);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
}
