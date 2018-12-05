<%@page import="DTO.Answer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="DTO.Question"%>
<%@page import="java.util.ArrayList"%>
<div>
	<%
		Integer i = 0;
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
		for (Question question : questions) {
			String id = "collapse" + i.toString();
	%>
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="row">
				<div class="col-sm-10">
			<h4 class="panel-title">
				<a data-toggle="collapse" class="text-question"
					data-parent="#accordion" href="#<%=id%>"> <%=question.getQuestionText()%>
				</a> 

			</h4>
				</div>
				<div class="col-sm-2">
				<h4 class="panel-title">
				<a href="#" class="close delete-question" data-dismiss="alert" aria-label="close"
					title="Xóa câu hỏi" id-question="<%=question.getID()%>"> <i class="fa fa-trash" aria-hidden="true"></i></a> <a
					href="#" class="close edit-question" title="Chỉnh sửa câu hỏi"
					id-question="<%=question.getID()%>"> <i class="fa fa-edit"
					aria-hidden="true"> </i>
				</a>
				<input type="hidden" class="text-question" value="<%=question.getQuestionText()%>">

			</h4>
				</div>
			</div>
		</div>
		<div id="<%=id%>" class="panel-collapse collapse in">
			<div class="panel-body">
				<input type="hidden" class="hidden-question"
					value="<%=question.getID()%>">
				<div class="answer-area">
					<%
						for (Answer answer : question.getAnswers()) {
					%>
					<div class="alert alert-info" deleted="false">
						<input type="radio" name='radio3' class="radio-answer"
							answer-data="<%=answer.getName()%>" value="<%=answer.getID()%>"
							<%if (answer.isCorrect()) {
						out.print("checked");
					}%>>
						<a href="#a" class="close delete-answer" aria-label="close"
							title="close"><i class="fa fa-trash" aria-hidden="true"></i></a>
						<a href="#a" class="close edit-answer" title="close"><i class="fa fa-edit"
							aria-hidden="true"></i></a>
						<span><%=answer.getName()%></span>
					</div>
					<%
						}
					%>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-10">
							<input type="text" id="add-answer"
								class="form-control txt-answer" name="add-answer"
								placeholder="Điền câu trả lời">
						</div>
						<div class="col-xs-2">
							<input type="hidden" class="hidden-question-id" value="<%=question.getID()%>" >
							<input type="button" class="btn btn-success add-answer"
								value="Add">
						</div>
					</div>
				</div>
				<input type="button" class="btn btn-success btn-save" value="Lưu">
			</div>
		</div>
	</div>

	<%
		i++;
		}
	%>
</div>