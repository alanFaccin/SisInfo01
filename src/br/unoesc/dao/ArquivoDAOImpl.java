package br.unoesc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import br.unoesc.model.Arquivo;
import br.unoesc.model.GenericObject;
import br.unoesc.conexao.*;

public class ArquivoDAOImpl implements ArquivoDAO {

	@Override
	public String insert(Arquivo file) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(file);
			transacao.commit();
			return "Insert Realizado com sucesso!";
		} catch (HibernateException e) {
			System.out.println("Não foi possivel realizar o Insert -> Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				return ("Erro ao fechar a operaçao de insersão. Mensagem: " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String remove(int codigo) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(this.getLinha(codigo));
			transacao.commit();
			return "Remove Realizado com Sucesso";
		} catch (HibernateException e) {
			return ("Não foi possivel remover a linha desejada -> Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				return ("Erro ao fechar operação de exclusão. Mensagem: " + e.getMessage());
			}
		}

	}

	@Override
	public String update(Arquivo file) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(file);
			transacao.commit();
			return "Update Realizado com Sucesso!";
		} catch (HibernateException e) {
			return ("Não foi possível alterar o registro desejado -> Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				return ("Erro ao fechar a operação de Update -> Mensagem: " + e.getMessage());
			}
		}
	}

	@Override
	public List<Arquivo> getlinhas() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Arquivo> resultado = null;

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("FROM Arquivo file order by file.line");
			resultado = consulta.list();
			transacao.commit();

		} catch (HibernateException e) {
			System.out.println("Não foi possivel selecionar as linhas do arquivo -> Erro: " + e);
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println(
						"Erro ao fechar operação de listar as linhas do arquivo -> Mensagem: " + e.getMessage());
			}
		}
		return resultado;

	}

	@Override
	public Arquivo getLinha(int codigo) {
		Arquivo file = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("FROM Arquivo where id = :parametro");
			consulta.setInteger("parametro", codigo);
			file = (Arquivo) consulta.uniqueResult();
			transacao.commit();
			return file;
		} catch (HibernateException e) {
			System.out.println("Não foi possivel buscar a linha -> Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de busca. Mensagem: " + e.getMessage());
			}
		}
		return file;

	}

	@Override
	public JSONObject getJsonObject(Arquivo line) {

		// instancia um novo JSONObjec t
		JSONObject my_obj = new JSONObject();
		// preenche o objeto com os campos lidos do arquivo
		try {
			my_obj.put("linha", line.getLine()); // Integer.toString(line.getLine())
			my_obj.put("est_civil", line.getEst_civil());
			my_obj.put("escolaridade", line.getEscolaridade());
			my_obj.put("salario", line.getSalario());
			my_obj.put("idade_a", line.getIdade_anos());
			my_obj.put("idade_m", line.getIdade_meses());
			my_obj.put("dt_compra", line.getDtCompra());
			my_obj.put("valor", line.getValor());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return my_obj;

		// return null;
	}

	@Override
	public List<GenericObject> getSalariosEscolaridade() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<GenericObject> resultado = new ArrayList<GenericObject>();

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			// consulta = sessao.createQuery("SELECT escolaridade, AVG(Salario)
			// as Salario FROM Arquivo file group by escolaridade");
			// resultado = consulta.list();
			Iterator obj = sessao
					.createQuery("SELECT escolaridade, AVG(Salario) as Salario FROM Arquivo file group by escolaridade")
					.list().iterator();

			while (obj.hasNext()) {
				GenericObject go = new GenericObject();
				Object[] tuple = (Object[]) obj.next();
				System.out.println(tuple[0]);
				System.out.println(tuple[1]);
				go.setKey((String) tuple[0]);
				go.setValor(Double.toString((double) tuple[1]));
				resultado.add(go);
			}

			transacao.commit();

		} catch (HibernateException e) {
			System.out.println("Não foi possivel selecionar as linhas do arquivo -> Erro: " + e);
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println(
						"Erro ao fechar operação de listar as linhas do arquivo -> Mensagem: " + e.getMessage());
			}
		}
		return resultado;
	}

	@Override
	public List<GenericObject> getNfilhosValorGasto() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<GenericObject> resultado = new ArrayList<GenericObject>();

		try {
			sessao = Hibernate4Util.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			// consulta = sessao.createQuery("SELECT escolaridade, AVG(Salario)
			// as Salario FROM Arquivo file group by escolaridade");
			// resultado = consulta.list();
			Iterator obj = sessao
					.createQuery("SELECT nFilhos, AVG(file.Valor) as vg FROM Arquivo file group by nFilhos")
					.list().iterator();

			while (obj.hasNext()) {
				GenericObject go = new GenericObject();
				Object[] tuple = (Object[]) obj.next();
				System.out.println(tuple[0]);
				System.out.println(tuple[1]);
				go.setKey(Integer.toString((int) tuple[0]));
				go.setValor(Double.toString((double) tuple[1]));
				resultado.add(go);
			}

			transacao.commit();

		} catch (HibernateException e) {
			System.out.println("Não foi possivel selecionar as linhas do arquivo -> Erro: " + e);
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println(
						"Erro ao fechar operação de listar as linhas do arquivo -> Mensagem: " + e.getMessage());
			}
		}
		return resultado;
	}

	@Override
	public String efetuaMinercao() {
		
		for (Arquivo f : getlinhas()) {
			// ajuste Salario
			f.setSalario(f.getSalario()*1000.00f);
			f.setValor(f.getValor()*10.00f);
			update(f);
		}
		
		return "Mineraçao Completa";
	}

}
