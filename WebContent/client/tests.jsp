<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<c:set var="clientLeft" value='${requestScope["client-left"] }' />
<c:set var="clientRight" value='${requestScope["client-right"] }' />
<c:set var="now" value="<%=new Date()%>" />

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
<h1 class="mt-1">Lớp: ${ClassDTO.fullName}</h1>
<h3 class="mt-1">Danh sách đề thi</h3>
<c:if test="${empty ListTest}">
<h4 class="text-muted">Không có bài kiểm tra nào</h4>
</c:if>
<c:forEach items="${ListTest}" var="test">
<div class="row one-de mt-3">
	<div class="card container p-3">
		<div class="card-block one-de">
			<div class="de-header d-flex justify-content-between">
				<div class="time">Thời gian làm bài: ${test.time}</div>
				<div class="excuteTime">Số lần làm bài: 
					<c:if test="${test.numberUserExcuteTest==test.numberExamTest}">
						<span class="text-red"> 
					</c:if>
					<c:if test="${test.numberUserExcuteTest==test.numberExamTest}">
						<span> 
					</c:if>
					${test.numberUserExcuteTest}/${test.numberExamTest}</span>

				</div>
			</div>
			<div class="de-body2">
				<h4 class="card-title title-color">${test.name}</h4>
				<c:if test="${now>test.timeEnd||now<test.timeStart }">
				<p>
					<span class="title-color">Thời gian mở đề: </span>
					<span class="text-red">
						<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss"
						value="${test.timeStart}" /> đến <fmt:formatDate
						pattern="dd-MM-yyyy HH:mm:ss" value="${test.timeEnd}" />
					</span>
				</p>
			</c:if>
			<c:if test="${now<=test.timeEnd && now>=test.timeStart}">
			<p>
				<span class="title-color">Thời gian mở đề: </span>
				<span class="">
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss"
					value="${test.timeStart}" /> đến <fmt:formatDate
					pattern="dd-MM-yyyy HH:mm:ss" value="${test.timeEnd}" />
				</span>
			</p>
		</c:if>
	</div>
	<div class="de-footer d-flex justify-content-between">
		<div class="socauhoi">
			<i class="fa fa-question-circle"></i>${test.numberQuestion} câu hỏi
		</div>
		<div class="btnDetail d-flex">
			<c:if test="${test.numberUserExcuteTest==0}">
				<button class="btn btn-secondary mr-2" disabled>Xem chi tiết</button>
			</c:if>
			<c:if test="${test.numberUserExcuteTest!=0}">
				<form action="./ChildtestDetail" method="post" class="mr-2">
					<input type="hidden" name="IDTest" value="${test.iD}">
					<input type="submit" class="btn btn-outline-info" name="btnDetail" value="Xem chi tiết">
				</form>
			</c:if>
			<c:if test="${now>test.timeEnd||now<test.timeStart }">
				<button class="btn btn-secondary" disabled>Bắt đầu thi</button>
			</c:if>
			<c:if test="${now<=test.timeEnd && now>=test.timeStart&&test.numberUserExcuteTest==test.numberExamTest}">
				<button class="btn btn-secondary" disabled>Bắt đầu thi</button>
			</c:if>
			<c:if test="${now<=test.timeEnd && now>=test.timeStart&&test.numberUserExcuteTest!=test.numberExamTest}">
				<form action="./ClientQuestion" method="post">
					<input type="hidden" name="IDTest" value="${test.iD }">
					<input type="submit" class="btn btn-warning" name="btnExcute" value="Bắt đầu thi">
				</form>
			</c:if>
		</div>

	</div>
</div>
</div>
</div>
</c:forEach>


</jsp:body>

</t:MainClient>