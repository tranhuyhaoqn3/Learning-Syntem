<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="clientLeft" value='${requestScope["client-left"] }' />
<c:set var="clientRight" value='${requestScope["client-right"] }' />
<t:MainClient>
<jsp:attribute name="clientleft">
<jsp:include page="${clientLeft}" />
</jsp:attribute>
<jsp:attribute name="clientright">
<jsp:include page="${clientRight}" />
</jsp:attribute>


<jsp:attribute name="clientuser">
<c:out value="${UserName.getName()}" />
</jsp:attribute>

<jsp:body>
<h1 class="mt-1 text-center">Các khóa học của tôi</h1>
<div class="container">
<c:if test="${empty ListClass}">
	<h3>Không có khóa học nào</h3>
</c:if>
<c:if test="${not empty ListClass}">
	<c:forEach varStatus="item" begin='0' end="${ListClass.size()-1}" step="2">
	<div class="row">
		<div class="col-xs-12 col-lg-6 mt-4">
			<div class="card" style="height: 21rem;">
				<img class="card-img-top h-75" src="img/soc.jpg" alt="img lớp học">
				<div class="card-body pt-0 pb-0">
					<h4>${ListClass.get(item.index).fullName}</h4>
					<div class="bottom bottom d-flex justify-content-between">
						<p class="card-text text-red">
						<c:if test="${not empty ListClass.get(item.index).classTestDTO}">
						<i class="fa fa-file-alt"></i>! Bạn có bài kiểm tra
						</c:if>
						</p>
						<form action="./ClientTest" method="post">
							<input type="hidden" name="classID" value="${ListClass.get(item.index).iD}">
							<input type="submit" name="" class="btn btn-warning" value="Xem chi tiết">
						</form>
						
					</div>
				</div>
			</div>
		</div>
		<c:if test="${item.index+1<ListClass.size()}">
		<div class="col-xs-12 col-lg-6 mt-4">
			<div class="card" style="height: 21rem;">
				<img class="card-img-top h-75" src="img/soc.jpg" alt="img lớp học">
				<div class="card-body pt-0 pb-0">
					<h4>${ListClass.get(item.index+1).fullName}</h4>
					<div class="bottom bottom d-flex justify-content-between">
						<p class="card-text text-red">
						<c:if test="${not empty ListClass.get(item.index+1).classTestDTO}">
						<i class="fa fa-file-alt"></i>! Bạn có bài kiểm tra
						</c:if>
						</p>
						<form action="./ClientTest" method="post">
							<input type="hidden" name="classID" value="${ListClass.get(item.index+1).iD}">
							<input type="submit" name="" class="btn btn-warning" value="Xem chi tiết">
						</form>
					</div>
				</div>
			</div>
		</div>
		</c:if>
	</div>
</c:forEach>
</c:if>
</jsp:body>
</t:MainClient>