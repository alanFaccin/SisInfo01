<%@page import="br.unoesc.dao.ArquivoDAO"%>
<%@page import="br.unoesc.model.Arquivo"%>
<%@page import="br.unoesc.dao.ArquivoDAOImpl"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	charset="UTF-8">

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS theme -->
<link href="bootstrap/css/half-slider.css" rel="stylesheet">
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<title>Trabalho Sistemas de Infromação</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<a class="navbar-brand" href="index.jsp"><button type="submit"
					class="btn btn-secondary">Home</button></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a><form role="form" action="Servlet_index">
							<button type="submit" class="btn btn-secondary">Carregar</button>
						</form></a></li>
				<li><a><form role="form" action="EfetuaMineracao">
							<button type="submit" class="btn btn-secondary">Minerar
								Dados</button>
						</form></a></li>

				<!--	<li><a href="#">Gráfico Escolaridade X  Salário</a></li>-->
				<!--	<li><a href="#">Gráfico Num. Filhos X Valor Gasto</a></li>-->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Half Page Image Background Carousel Header -->
	<header id="myCarousel" class="carousel slide"> <!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>

	<!-- Wrapper for Slides -->
	<div class="carousel-inner">
		<div class="item active">
			<!-- Set the first background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=Sistemas de Informação');"></div>
			<div class="carousel-caption">
				<h2>Engenharia de Computação</h2>
			</div>
		</div>
		<div class="item">
			<!-- Set the second background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=Slide Two');"></div>
			<div class="carousel-caption">
				<h2>Caption 2</h2>
			</div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=Slide Three');"></div>
			<div class="carousel-caption">
				<h2>Caption 3</h2>
			</div>
		</div>
	</div>

	<!-- Controls --> <a class="left carousel-control" href="#myCarousel"
		data-slide="prev"> <span class="icon-prev"></span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="icon-next"></span>
	</a> </header>

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-12">
				<h1>Trabalho de Sistemas de Informações</h1>
				<p>Na tabela abaixo podemos ver os dados provenientes do
					Arquivo.</p>
			</div>
		</div>

		<hr>

		<div class="btn-group">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				Gráficos Disponíveis <span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<!-- Links de menu dropdown -->
				<li><a><form role="form" action="PieChartServlet">
							<button type="submit" class="btn btn-primary">Escolaridade
								X Salário</button>
						</form></a></li>
				<li><a><form role="form" action="ChartNfxVg">
							<button type="submit" class="btn btn-primary">Num.
								Filhos X Valor Gasto</button>
						</form></a></li>
				<li><a><form role="form" action="ChartSalEC">
							<button type="submit" class="btn btn-primary">
								Estado Civil X Salário</button>
						</form></a></li>
				<li><a><form role="form" action="ChartDataValor">
							<button type="submit" class="btn btn-primary">
								Data X Valor Gasto</button>
						</form></a></li>
			</ul>
		</div>
		<!-- inicio tabela com os dados do Arquivo -->

		<table class="table table-striped">
			<!-- <caption align="top">Dados do Arquivo</caption> -->
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
						DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
						String text = df.format(f.getDtCompra());
						out.print(text);
							//out.print(f.getDtCompra());
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

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Unoesc 2016</p>
			</div>
		</div>
		<!-- /.row --> </footer>

	</div>
	<!-- /.container -->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>
</body>
</html>