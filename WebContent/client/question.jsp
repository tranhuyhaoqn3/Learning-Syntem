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
<span id="time-excute" data-time="${TestDTO.getTime()}"></span>
    <div
					class="wrap-question-button d-flex justify-content-between flex-column h-75 w-100 p-5 rounded"
					style="background-color: white;">
      <div class="wrap-question h-100 w-100">
          <c:forEach varStatus="item" begin='0'
							end="${ListQuest.size()-1}" step="1">
             <c:if test="${item.index==0 }">
                <div
									class="card h-100 w-100 p-5 one-question question-active"
									data-idquetion="${ListQuest.get(item.index).getiD()}">
			
							
							
							</c:if>
                <c:if test="${item.index!=0}">
                <div class="card h-100 w-100 p-5 one-question"
									data-idquetion="${ListQuest.get(item.index).getiD()}">
                
							
							
							
							
							</c:if>
                  
                    <div class="card-block">
                      <h2 class="card-title">Câu ${item.index+1}: <b>${ListQuest.get(item.index).getQuestionText()}</b>         </h2>
                      <c:if
									test="${empty ListQuest.get(item.index).getAnswerDTOs()}">
                      <h4 class="text-muted">Câu hỏi không có đáp án</h4>
                      </c:if>
                      <c:if
									test="${not empty ListQuest.get(item.index).getAnswerDTOs()}">
                          <c:forEach
										items="${ListQuest.get(item.index).getAnswerDTOs()}"
										var="answer">
                          <div class="radio">
                           <label>
                             <input type="radio"
												name="cau${item.index+1}" value="${answer.getiD()}"
												onclick="CheckRadioClick(this)">
                             ${answer.getName()}
                           </label>
                         </div>
                          </c:forEach>
                          </c:if>
                    </div>
                    
                  
                
					
					
					
					
					</div>
      </c:forEach>
      </div>
      <div class="wrap-button d-flex justify-content-around">
		<c:if test="${ ListQuest.size()!=1}">
			<button class="btn btn-primary btnPre" onclick="GoPre()">Trước</button>
			<button class="btn btn-primary btnNext btn-active" onclick="GoNext()">Sau</button>
		</c:if>          
      </div>
    
		
		
		
		
		</div>
</div>
</c:if>
<script type="text/javascript">
	function SendFinish() {
		$.ajax({
			type : 'POST',
			async : false,
			url : 'FinishedTest',
			data : {
				IDChildtest : $('#IDChildtest').val()
			},
			success : function(result) {

			},
			error : function(result) {

			}
		});
	}
	$(window).unload(function() {
		SendFinish();
	});
	function CheckRadioClick(e) {

		$.ajax({
			url : 'SaveAnswerClient',
			type : 'POST',
			data : {
				IDQuestion : $('.question-active').attr('data-idquetion'),
				IDChiltest : $('#IDChildtest').val(),
				IDAnswer : e.value
			},
			success : function(result) {
				if (result == "Error") {
					alert("Server bị sập vui lòng thử lại");
					e.checked = false;
					$('.stt-question').eq($('.question-active').index())
					.removeClass('stt-question-active');
				} else {
					$('.stt-question').eq($('.question-active').index())
							.addClass('stt-question-active');
				}
			},
			error : function(result) {
				alert("Mạng không ổn định vui lòng kiểm tra lại");
				e.checked = false;
			}
		});
	}
	function GoPre() {
		var present = $('.question-active');
		var prev = present.prev();
		if (prev != null) {
			present.removeClass('question-active');
			prev.addClass('question-active');
			$('.btnPre').addClass('btn-active');
			$('.btnNext').addClass('btn-active');
			if (prev.prev().length == 0) {
				$('.btnPre').removeClass('btn-active');
			}
		}

	}
	function GoNext() {

		var present = $('.question-active');
		var next = present.next();
		if (next != null) {
			present.removeClass('question-active');
			next.addClass('question-active');
			$('.btnPre').addClass('btn-active');
			$('.btnNext').addClass('btn-active');
			if (next.next().length == 0) {
				$('.btnNext').removeClass('btn-active');
			}
		}
	}
</script>
</jsp:body>
</t:MainPractise>