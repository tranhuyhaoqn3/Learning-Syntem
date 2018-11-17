<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "clientLeft" value ='${requestScope["client-left"] }'/>
<c:set var = "clientRight" value ='${requestScope["client-right"] }'/>

<t:MainClient>
<jsp:attribute name="clientleft">
<jsp:include page="${clientLeft}"/>
</jsp:attribute>
<jsp:attribute name="clientright">
<jsp:include page="${clientRight}"/>
</jsp:attribute>



<jsp:body>
<h1>Đề thi hiện có</h1>
<div class="find-de">
</div>
<div class="row one-de">
	<div class="card container p-3">
		<div class="card-block one-de">
			<div class="de-header d-flex justify-content-start">
				<div class="chude">Hóa học|</div>
				<div class="time">50 phút</div>
			</div>
			<div class="de-body">
				<h4 class="card-title">Đề thi THPT QG năm 2018 môn Hóa học - Mã đề 223</h4>
			</div>
			<div class="de-footer d-flex justify-content-between">
				<div class="socauhoi"><i class="fa fa-question-circle"></i> 40 câu hỏi</div>
				<button class="btn btn-warning"><a href="/Learning_Demo/Question">Bắt đầu thi</a></button>
			</div>
		</div>
	</div>
</div>
<div class="row one-de mt-3">
	<div class="card container p-3">
		<div class="card-block one-de">
			<div class="de-header d-flex justify-content-start">
				<div class="chude">Hóa học|</div>
				<div class="time">50 phút</div>
			</div>
			<div class="de-body">
				<h4 class="card-title">Đề thi THPT QG năm 2018 môn Hóa học - Mã đề 223</h4>
			</div>
			<div class="de-footer d-flex justify-content-between">
				<div class="socauhoi"><i class="fa fa-question-circle"></i> 40 câu hỏi</div>
				<button class="btn btn-warning"><a href="/Learning_Demo/Question">Bắt đầu thi</a></button>
			</div>
		</div>
	</div>
</div>
<div class="row one-de mt-3">
	<div class="card container p-3">
		<div class="card-block one-de">
			<div class="de-header d-flex justify-content-start">
				<div class="chude">Hóa học|</div>
				<div class="time">50 phút</div>
			</div>
			<div class="de-body">
				<h4 class="card-title">Đề thi THPT QG năm 2018 môn Hóa học - Mã đề 223</h4>
			</div>
			<div class="de-footer d-flex justify-content-between">
				<div class="socauhoi"><i class="fa fa-question-circle"></i> 40 câu hỏi</div>
				<button class="btn btn-warning"><a href="/Learning_Demo/Question">Bắt đầu thi</a></button>
			</div>
		</div>
	</div>
</div>


</jsp:body>

</t:MainClient>
