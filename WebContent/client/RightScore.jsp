<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${not empty ListQuest}">
	<div class="card">
		<div class="card-header text-center">
			<b>Điểm số</b>
		</div>
		<div id="score-user" class="text-center">
			<span class="text-red">${ScoreUser}/${ScoreTest}</span>
		</div>
		<div id="numbercorrect">
			
		</div>
	</div>
</c:if>