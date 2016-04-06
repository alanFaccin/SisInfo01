package br.unoesc.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

import org.hibernate.Session;

import br.unoesc.model.*;
import br.unoesc.conexao.*;
import br.unoesc.dao.ArquivoDAOImpl;

public class Reader {

	public void read() throws ParseException {

		// public void read(BufferedReader b)

		// BufferedReader br = b;
		BufferedReader br = null;

		try {
			try {
				br = new BufferedReader(new InputStreamReader(
						new FileInputStream("/Users/AlanJhones/Documents/workspace_alan/SisInfo01/Dados.txt"), "ISO-8859-1"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// equanto houver mais linhas
		try {
			while (br.ready()) {

				ArquivoDAOImpl f = new ArquivoDAOImpl(); // objeto
															// responsavel
															// pela
															// operaçoes com
															// o banco

				Arquivo dados = new Arquivo();

				// lê a proxima linha
				String linha = br.readLine();
				// int tam = linha.length();
				if ((linha.length() > 8 && linha.length() < 95)) {

					// now create object according to the string
					StringTokenizer st = new StringTokenizer(linha, "\t");

					// int qtdT = st.countTokens();

					String line = st.nextToken();
					String est_civil = st.nextToken();
					String gr_inst = st.nextToken();

					// verifica dado
					int qtdR = st.countTokens(); // qtd restante de tokens
					String salario = null;
					String nFilhos = null;

					if (qtdR == 5) {
						salario = st.nextToken();
					} else {
						nFilhos = st.nextToken();
						salario = st.nextToken();
					}

					String idade_ano = st.nextToken();
					String idade_meses = st.nextToken();
					String dtCompra = st.nextToken();
					String Valor = st.nextToken();

					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					java.sql.Date data = new java.sql.Date(format.parse(dtCompra).getTime());

					String valor_formatado = Valor.replace(',', '.');

					dados.setLine(Integer.parseInt(line));
					dados.setEst_civil(est_civil);
					dados.setEscolaridade(gr_inst);
					if (nFilhos != null) {
						dados.setnFilhos(Integer.parseInt(nFilhos));
					}
					if (salario != null) {
						dados.setSalario(Float.parseFloat(salario));
					}

					dados.setIdade_anos(Integer.parseInt(idade_ano));
					dados.setIdade_meses(Integer.parseInt(idade_meses));
					dados.setDtCompra(data);
					dados.setValor(Float.parseFloat(valor_formatado));

					f.insert(dados); // insere no banco

				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
