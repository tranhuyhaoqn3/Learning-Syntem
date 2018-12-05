<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="clientLeft" value='${requestScope["client-left"] }' />
<c:set var="clientRight" value='${requestScope["client-right"] }' />
<t:MainPractise>
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
<div class="p-5 w-100 h-100">
	<h1>${TestDTO.getName()}</h1>
  <c:if test="${empty ListQuest}">
  <h4 class="text-muted">Không có câu hỏi nào</h4>
</c:if>
<c:if test="${not empty ListQuest}">
    <div class="wrap-question-button d-flex justify-content-between flex-column">
      <div class="wrap-question">
          <c:forEach varStatus="item" begin='0' end="${ListQuest.size()-1}" step="1">
             <c:if test="${item.index==0 }">
                <div class="card h-75 w-75 p-5 one-question question-active">
                </c:if>
                <c:if test="${item.index!=0}">
                <div class="card h-75 w-75 p-5 one-question">
                </c:if>
                  
                    <div class="card-block p-3">
                      <h2 class="card-title">Câu ${item.index+1}: <b>${ListQuest.get(item.index).getQuestionText()}</b>         </h2>
                      <c:if test="${empty ListQuest.get(item.index).getAnswerDTOs()}">
                      <h4 class="text-muted">Câu hỏi không có đáp án</h4>
                      </c:if>
                      <c:if test="${not empty ListQuest.get(item.index).getAnswerDTOs()}">
                          <c:forEach items="${ListQuest.get(item.index).getAnswerDTOs()}"
                          var="answer">
                          <div class="radio">
                           <label>
                             <input type="radio" name="cau${item.index+1}"
                             value="${answer.getiD()}" onclick="CheckRadioClick()">
                             ${answer.getName()}
                           </label>
                         </div>
                          </c:forEach>
                          </c:if>
                    </div>
                    
                  
                </div>
      </c:forEach>
      </div>
      <div class="wrap-button">
          <button class="btn btn-primary">Test1</button>
          <button class="btn btn-primary">Test2</button>
      </div>
    </div>
</div>
</c:if>
</script>
</jsp:body>
</t:MainPractise>