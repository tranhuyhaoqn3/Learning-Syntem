$(document).ready(()=>{
	let subjectId = $("#sl-subject").val(); 
	getQuestionBySubject(subjectId);
	$("#file-question").change(function(){
		$("#form-file").submit();
	})
	$("#sl-subject").change(function(){
		let subjectId = $(this).val();
		getQuestionBySubject(subjectId);
	})
	$("#create-type").click(function(){
		$("#form-type").css("display",'block');
		$("#message").css("display",'none');
		$("#txt-question-type").focus();
	})
	$("#create-question").click(()=>{
		$("#type-edit").val("add-question");
		$('#myModal').modal('show');
	})
	$("#btn-save-modal").click(function(){
		let type = $("#type-edit").val();
		switch (type) {
		case "edit-question":
			saveQuestion();
			break;
		case "add-question":
			addQuestion();
		default:
			break;
		}
	})
	function addQuestion(){
		let data = {
			questionText:$("iframe").contents().find('.cke_editable').html(),
			subjectID:$("#sl-subject").val(),
		};
		$.ajax({
		    url : "questionBank?type=saveQuestion&typeAction=add",
		    type: 'POST',
		    dataType: 'json',
		    data: {"data":JSON.stringify(data)},
		    cache : false
		}).done(function(response)  {
			$('#myModal').modal('hide');
			getQuestionBySubject($("#sl-subject").val());
			alert(response);
			
		}).fail(function(response)  {
			$('#myModal').modal('hide');
			getQuestionBySubject($("#sl-subject").val());
			alert(response);
		}); 
	}
	function saveQuestion(){
		let questionID = $("#value");
		let data = {
			questionText:$("iframe").contents().find('.cke_editable').html(),
			subjectID:$("#sl-subject").val(),
			id:$("#value").val()
		};
		$.ajax({
		    url : "questionBank?type=saveQuestion&typeAction=edit",
		    type: 'POST',
		    data: {"data":JSON.stringify(data)},
		    cache : false,
		    contentType: "application/x-www-form-urlencoded;charset=utf8"
		}).done(function(response)  {
			$('#myModal').modal('hide');
			getQuestionBySubject($("#sl-subject").val());
			alert(response);
			
		}).fail(function(response)  {
			$('#myModal').modal('hide');
			getQuestionBySubject($("#sl-subject").val());
			alert(response);
		}); 
	}
	function getQuestionBySubject(subjectId){
		$.get(`questionBank?type=getQuestionBySubjectId&subjectId=${subjectId}`,(data,success)=>{
			if(success){
				if(data === ""){
					$("#accordion-question").html("<p class='text-warning'>Không có câu hỏi nào!</p>");
				} else{
					$("#accordion-question").html(data);	
				}
				setSaveQuestionActive();
			}
		})
	}
	function setSaveQuestionActive(){
		$(".btn-save").click(function(){
			let parent = $(this).parent();
			let data = {
					questionID : $(parent).find(".hidden-question").val(),
					answer : $(parent).find(".radio-answer").map(
							function(){
								let obj = {};
								obj.answerID = $(this).val();
								obj.answerText = $(this).attr("answer-data");
								obj.questionID = $(parent).find(".hidden-question").val();
								obj.deleted = $(this).parent().attr('deleted');
								if($(this).is(':checked')){
									obj.isCorrect = true;
								} else{
									obj.isCorrect = false;
								}
								return obj;
								}
							).toArray()
			};
			$.ajax({
			    url : "questionBank?type=saveQuestionDetail",
			    type: 'POST',
			    data: {"data":JSON.stringify(data)},
			    cache : false
			}).done(function(response) {
			    alert(response);
			});
		})	
			$(".edit-question").click(function(){
		let questionText = $(this).siblings('.text-question').val();
		console.log(questionText);
		$("iframe").contents().find('.cke_editable').html(questionText);
		$("#type-edit").val("edit-question");
		$("#value").val($(this).attr('id-question'));
		$('#myModal').modal('show');
	})
	$(".delete-answer").click(function(){
		$(this).parent().attr('deleted',true);
		$(this).parent().css('display','none');
	})
	
	$(".delete-question").click(function(){
		let questionId = $(this).attr('id-question');
		let rs = confirm("Bạn có chắc chắn muốn xóa câu hỏi này ?");
		if(rs === true){
			$.ajax({
			    url : `questionBank?type=deleteQuestion&id=${questionId}`,
			    type: 'GET',
			    cache : false
			}).done(function(response)  {
				getQuestionBySubject($("#sl-subject").val());
				alert(response);
				
			}).fail(function(response)  {
				getQuestionBySubject($("#sl-subject").val());
				alert(response);
			}); 	
		}
	})
	$(".edit-answer").click(function(){
		
	})
	$(".add-answer").click(function(){
		console.log($(this).parent().siblings(".col-xs-10").find(".txt-answer"));
		let answer = $(this).parent().siblings(".col-xs-10").find(".txt-answer").val();
		let html = `
		<div class="alert alert-info">
				<input type="radio" name='radio3' class="radio-answer"
						answer-data="${answer}" value="">
					<a href="#" class="close" data-dismiss="alert" aria-label="close"
						title="close"><i class="fa fa-trash" aria-hidden="true"></i></a> <a
						href="#" class="close" title="close"><i class="fa fa-edit"
						aria-hidden="true"></i></a>
						${answer}
				</div>`;
		$(this).parent().parent().parent().siblings(".answer-area").append(html);
	})
	}
})