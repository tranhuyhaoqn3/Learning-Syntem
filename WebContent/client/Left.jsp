<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="card">
	<div class="card-header">
		<b>Thanh điều hướng</b>
	</div>
	<ul class="list-group list-group-flush">
		<li class="list-group-item itemChuyenMuc"><a class="a-collapse"
			data-toggle="collapse" href="#collapInfo" role="button"
			aria-expanded="false" aria-controls="collapseExample"> Thông tin
				cá nhân</a>
			<div class="collapse" id="collapInfo">
				<ul>
					<li><a href="./InfoClient?ID=${UserName.getiD() }" class="wrap-dieuhuong pl-3"><i
							class="fa fa-user"></i>	${UserName.getName()}</a></li>
					<li><a href="./LogoutClient"class="pl-3 wrap-dieuhuong"><i class="fa fa-sign-out-alt"></i>Đăng
							Xuất</a></li>
				</ul>
			</div></li>
		<li class="list-group-item itemChuyenMuc">
			<a class="a-collapse"
			data-toggle="collapse" href="#collapCourse" role="button"
			aria-expanded="false" aria-controls="collapseExample">Khóa học</a>
			<div class="collapse" id="collapCourse">
				<ul>
					<li><a href="./MyClass?ID=${UserName.getiD()}" class="wrap-dieuhuong pl-3"><i
							class="fa fa-school"></i>	Đang tham gia</a></li>
				</ul>
			</div>
		</li>
	</ul>
</div>