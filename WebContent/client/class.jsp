<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:MainClient>
<jsp:attribute name="clientleft">
<jsp:include page="${clientLeft}"/>
</jsp:attribute>
<jsp:attribute name="clientright">
<jsp:include page="${clientRight}"/>
</jsp:attribute>
<jsp:body>
<h1 class="mt-1 text-center">Các khóa học của tôi</h1>
<div class="container">
	<div class="card-deck-wrapper">
		<div class="card-deck">
			<div class="card card-khoahoc p-2">
				<div class="card-block">
					<h4 class="card-title">Lập trình nhúng</h4>
					<p class="card-text text-red"><i class="fa fa-file-alt"></i>! Bạn có bài kiểm tra</p>
					<div class="neo-bottom">
						<p class="card-text"><small class="text-muted">Lần xem cuối 3 phút trước</small></p>
						<a href="" class="btn btn-info ">Xem chi tiết</a>
					</div>
				</div>
			</div>

			<div class="card card-khoahoc p-2">
				<div class="card-block">
					<h4 class="card-title">Lập trình Web</h4>
					<a href=""><p class="card-text text-red"></p></a>
					<div class="neo-bottom">
						<p class="card-text"><small class="text-muted">Lần xem cuối 3 phút trước</small></p>
						<a href="" class="btn btn-info ">Xem chi tiết</a>
					</div>
				</div>
			</div>


			<div class="card card-khoahoc p-2">
				<div class="card-block">
					<h4 class="card-title">Lập trình Windown</h4>
					<p class="card-text text-red"><i class="fa fa-file-alt"></i>! Bạn có bài kiểm tra</p>
					<div class="neo-bottom">
						<p class="card-text"><small class="text-muted">Lần xem cuối 3 phút trước</small></p>
						<a href="" class="btn btn-info ">Xem chi tiết</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</jsp:body>
</t:MainClient>