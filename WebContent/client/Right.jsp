<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${not empty ListQuest}">
	<div class="card">
		<div class="card-header">
			<b>Thời gian còn lại</b>
		</div>
		<div id="time-excute" class="text-center">
			<b><span id="h"></span> :</b> <b><span id="m"></span> :</b> <b><span
				id="s"></span></b>
		</div>
		<div id="number-question">
			<c:forEach varStatus="item" begin='0' end="${ListQuest.size()-1}"
				step="1">
				<div class="stt-question p-1 m-2" onclick="GoQuestion(this)">${item.index+1}</div>
			</c:forEach>
		</div>
		<form action="./FinishedTest" method="post" id="formFinish">
			<input type="hidden" name="IDChildtest" id="IDChildtest" value="${ChildTestDTO.getiD()}">
			<input type="button" class="btn btn-danger btn-block btnNopBai" name="btnFinish" value="Nộp bài">
		</form>
	</div>

	<script type="text/javascript">

	$('.btnNopBai').click(function(){
		stop();
		$('#formFinish').submit();
	});
	function GoQuestion(e) {
		var present = $('.question-active');
		present.removeClass('question-active');
		var oClick = $('.one-question').eq(parseInt(e.innerHTML)-1);
		oClick.addClass('question-active');
		$('.btnPre').addClass('btn-active');
		$('.btnNext').addClass('btn-active');
		if(oClick.next().length==0){
			$('.btnNext').removeClass('btn-active');
		}
		if(oClick.prev().length==0){
			 $('.btnPre').removeClass('btn-active');
		}
	
}
		document.addEventListener('DOMContentLoaded', function(e) {
			var time=$('#time-excute').attr('data-time');
			var mTime=time.split(':');
		  	var h=mTime[0];
		  	var m=mTime[1];
		  	var s=mTime[2];
		  	start();
		  	function start()
			{

				if (s === -1){
					m -= 1;
					s = 59;
				}
			    if (m === -1){
			    	h -= 1;
			    	m = 59;
			    }

			    if (h == -1){
			    	clearTimeout(timeout);
			    	$('#formFinish').submit();
			    	return;
			    }

			    $('#h').html(h.toString());
			    $('#m').html(m.toString());
			    $('#s').html(s.toString());
			    timeout = setTimeout(function(){
			    	s--;
			    	start();
			    }, 1000);
			}
			function stop(){
				clearTimeout(timeout);
			}
			$('.btnNopBai').click(function(){
				stop();
				$('#formFinish').submit();
			});
			
		});
	</script>
</c:if>