<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistemas de Informação - Relação Número de Filhos X Valor
	Gasto</title>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS theme -->
<link href="bootstrap/css/half-slider.css" rel="stylesheet">
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

        // Create the data table.
        //var data = new google.visualization.DataTable();
        //data.addColumn('string', 'Topping');
        //data.addColumn('number', 'Slices');
        /*data.addRows([
                    <c:forEach items="${pieDataMap}" var="entry">
                        [ '${entry.key}', ${entry.value} ],
                    </c:forEach>
                    ]);*/        
        var data = google.visualization.arrayToDataTable([
                                                              ['Country', 'Area(square km)'],
                                                              <c:forEach items="${pieDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);

        // Set chart options
        var options = {
            'title' : 'Relação N filhos X Valor Gasto', //title which will be shown right above the Google Pie Chart
            is3D : true, //render Google Pie Chart as 3D
            pieSliceText: 'label', //on mouse hover show label or name of the Country
            tooltip :  {showColorCode: true}, // whether to display color code for a Country on mouse hover
            'width' : 900, //width of the Google Pie Chart
            'height' : 500 //height of the Google Pie Chart
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>
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
				<li><a><form role="form" action="Servlet_index">
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
				<h1>Tralahos de Sistemas de Informações</h1>
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
				<li><a><form role="form" action="Servlet_index">
							<button type="submit" class="btn btn-primary">
								Escolaridade X Salário</button>
						</form></a></li>
				<li><a><form role="form" action="Servlet_index">
							<button type="submit" class="btn btn-primary">
								Escolaridade X Salário</button>
						</form></a></li>
			</ul>
		</div>
		
		<!-- Impressão do Gráfico -->
		<div style="width: 600px;">
			<div id="chart_div"></div>
		</div>

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