<%@page import="br.unoesc.dao.ArquivoDAO"%>
<%@page import="br.unoesc.model.Arquivo"%>
<%@page import="br.unoesc.dao.ArquivoDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	charset="UTF-8">

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Morris graficos -->
<link rel="stylesheet" href="bootstrap/morrisjs/morris.css">
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script language="JavaScript" src="js/teste.js"></script>


<title>Trabalho Sistemas de Infromação</title>
</head>
<body>
	<div class="container">
		<form role="form" action="Servlet_index">
			<div class="form-group">
				<label for="exampleInputFile">File input</label> <input type="file"
					id="exampleInputFile">
				<p class="help-block">Selecione o arquivo para efetuar a leitura
					dos dodos.</p>
			</div>
			<button type="submit" class="btnbtn-default">Carregar</button>
		</form>
	</div>

<label for="exampleInputFile">Gerador de Gráficos</label> <br /> <br />
	<div class="container">
		<form role="form" action="PieChartServlet">
			<button type="submit" class="btnbtn-default">Escolaridade X
				Salario</button>
		</form>
	</div>

	<div class="container">
		<form role="form" action="ChartNfxVg">
			<button type="submit" class="btnbtn-default">N Filhos X
				Valor Gasto</button>
		</form>
	</div>

	<!-- inicio tabela com os dados do Arquivo -->

	<table class="table table-striped">
		<caption align="top">Dados do Arquivo</caption>
		<thead>
			<tr>
				<th>Linha</th>
				<th>Estado Civil</th>
				<th>Grau de Instrução</th>
				<th>N Filhos</th>
				<th>Salário</th>
				<th>Idade Anos</th>
				<th>Idade Meses</th>
				<th>Data Compra</th>
				<th>Valor Gasto</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArquivoDAO fDao = new ArquivoDAOImpl();
				for (Arquivo f : fDao.getlinhas()) {
			%>
			<tr>
				<td>
					<%
						out.print(f.getLine());
					%>
				</td>
				<td>
					<%
						out.print(f.getEst_civil());
					%>
				</td>
				<td>
					<%
						out.print(f.getEscolaridade());
					%>
				</td>
				<td>
					<%
						out.print(f.getnFilhos());
					%>
				</td>
				<td>
					<%
						out.print(f.getSalario());
					%>
				</td>
				<td>
					<%
						out.print(f.getIdade_anos());
					%>
				</td>
				<td>
					<%
						out.print(f.getIdade_meses());
					%>
				</td>
				<td>
					<%
						out.print(f.getDtCompra());
					%>
				</td>
				<td>
					<%
						out.print(f.getValor());
					%>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<!-- fim tabela com os dados do Arquivo -->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- Morris Graficos-->
	<script src="bootstrap/morrisjs/morris.js"></script>
	<script src="bootstrap/raphael/raphael.js"></script>
	<script src="bootstrap/raphael/raphael-min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</body>
</html>