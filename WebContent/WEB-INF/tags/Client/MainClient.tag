<%@tag description="MainClient" pageEncoding="UTF-8"%>
<%@attribute name="clientleft" fragment="true"%>
<%@attribute name="clientright" fragment="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="Head.jsp" />
</head>
<body>
	<div id="client-nav">
		<nav class="navbar navbar-expand-md bg-faded navbar-light">
			<a class="navbar-brand" href="#">Trắc nghiệm online</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div
				class="collapse navbar-collapse justify-content-between mt-3 mt-sm-0"
				id="collapsibleNavbar">
				<form class="form-inline" action="#">
					<div class="input-group">
						<input class="form-control" type="text"
							placeholder="Nhâp nội dung tim kiếm">
						<button class="btn btn-secondary btnFind input-group-append"
							type="button">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</form>
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Trang
							chủ<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Đăng
							nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="wrap-carou">
		<div id="client-carousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#client-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#client-carousel" data-slide-to="1"></li>
				<li data-target="#client-carousel" data-slide-to="2"></li>
			</ul>

			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/panel_1.jpg" class="img-fluid">

				</div>
				<div class="carousel-item">
					<img src="img/panel_2.jpg" class="img-fluid">

				</div>
				<div class="carousel-item">
					<img src="img/panel_3.jpg" class="img-fluid">

				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#client-carousel"
				data-slide="prev"> <i class="fa fa-angle-left colorCarousel"></i>
			</a> <a class="carousel-control-next" href="#client-carousel"
				data-slide="next"> <i class="fa fa-angle-right colorCarousel"></i>
			</a>
		</div>
	</div>
	<div class="row row-wrap">
		<div class="client-left col-lg-2 d-none d-lg-block mt-2">
			<jsp:invoke fragment="clientleft"/>
		</div>
		<div class="client-center col-lg-8 col-xs-12">
			<jsp:doBody />
		</div>
		<div class="client-right col-lg-2 d-none d-lg-block mt-2">
			<jsp:invoke fragment="clientright"/>
		</div>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>
