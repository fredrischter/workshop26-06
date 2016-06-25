package br.com.workshop

import groovy.json.JsonSlurper;
import groovy.sql.*;
import groovy.lang.*;
import java.io.*;
import java.awt.*;
import javax.swing.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths;

public class MensagemAtrasada extends Thread {

	long tempo;
	String texto;

	// Costrutor
	public MensagemAtrasada(long tempo, String texto) {
		this.tempo = tempo;
		this.texto = texto;
	}

	public void run() {
		Thread.sleep(tempo);
		//System.out.println("Mensagem: "+texto);
	}
}

class Main {

    static void main(String[] args) {

		println "Iniciando Aplicação"

		// Executando Thread
		// Executando 100 Threads
		for (long tempo = 1000; tempo<10000; tempo += 100)
			(new MensagemAtrasada(tempo,"Mensagem atrasada em "+tempo)).start();

		// Gravando arquivo
		println "\nGravando arquivo"
		Path file = Paths.get("teste.txt");
		byte[] buf = "conteudo no arquivo".getBytes();
		Files.write(file, buf);

		// SQL
		Sql sql = ConnectionSingleton.getConnection();

	    println "\nSQL"
		def tabelas = [];
		sql.eachRow('SELECT * FROM sqlite_master') { row ->
			tabelas.add(row.toString());
	        println row.toString()
	    }

	    // Groovy syntax sugar
		5.times {
			//System.out.println("Hello");
		}

	    // XML
		println "\nXML"
		def rootNode = new XmlSlurper().parse("exemplo.xml")

		println rootNode.name()
		println rootNode.one[0].@a1
		println rootNode.two.text()

		// JSON
		println "\nJSON"
		def jsonSlurper = new JsonSlurper()
		def object = jsonSlurper.parseText('{ "name": "John Doe" } /* some comment */')

		println object
		println object.name

	    // SWING
	    println "\nSWING"

		JanelaBuilder jb = new JanelaBuilder();
		jb.setSize(500,500);
		jb.setList(tabelas.toArray());
		jb.setList(tabelas.toArray());
		jb.setList(tabelas.toArray());
		Janela janela = jb.build();

		// Outra operação com banco
		sql = ConnectionSingleton.getConnection();

		println "\nSQL"
		tabelas = [];
		sql.eachRow('SELECT * FROM sqlite_master') { row ->
			tabelas.add(row.toString());
			println row.toString()
		}

		println "Finalizando Aplicação"
    }
}