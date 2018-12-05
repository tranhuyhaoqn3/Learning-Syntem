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
<h1 class="mt-1">${TestDTO.getName()}</h1>
<c:if test="${empty ListChildtest}">
<h4 class="text-muted">Không có bài làm nào</h4>
</c:if>
<c:if test="${not empty ListChildtest}">
	<c:forEach varStatus="item" begin='0' end="${ListChildtest.size()-1}"
				step="1">
	<div class="card p-5">
	<div class="card-block">
		<h4 class="card-title">Lần thứ ${item.index+1}</h4>
		<p class="card-text">Điểm số: ${ListChildtest.get(item.index).getScore()}</p>
		<div class="d-flex justify-content-between">
		<c:set var="timeExcute" value="${ListChildtest.get(item.index).getTimeEnd().getTime()-ListChildtest.get(item.index).getTimeStart().getTime()}"/>
		<c:set var="dursec" value="${(timeExcute - (timeExcute mod 1000))/1000}" />
		<c:set var="durhr" value="${(dursec - (dursec mod 3600)) / 3600}" />
		<c:set var="temp" value="${(dursec - (durhr *3600))}" />
		<c:set var="durmin" value="${ (temp - (temp mod 60)) / 60 }" />
		<c:set var="dursec" value="${dursec-durmin*60-durhr*60}" />
		
		

		<p>Thời gian hoàn thành:<fmt:formatNumber value="${durhr}" minFractionDigits="0" maxFractionDigits="0"/>:<fmt:formatNumber value="${durmin}" minFractionDigits="0" maxFractionDigits="0"/>:<fmt:formatNumber value="${dursec}" minFractionDigits="0" maxFractionDigits="0"/> </p>
			<a href="./TestDetail?ID=${ListChildtest.get(item.index).getiDChildTest()}"
							class="btn btn-primary">Xem chi tiết</a>
		</div>
		
	</div>
</div>
	</c:forEach>
</c:if>
<c:forEach items="${ListChildtest}" var="usechild">

</c:forEach>
<script type="text/javascript">
</script>
</jsp:body>

</t:MainClient>