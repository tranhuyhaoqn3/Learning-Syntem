<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DTO.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Ngân hàng câu hỏi</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
			<li class="active">Here</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content container-fluid">
		<div class="row">
			<div class="col-xs-6"></div>
			<div class="col-xs-6">
				<form action="#" method="get">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Nhập loại câu hỏi..."> <span
							class="input-group-btn">
							<button type="submit" name="search-question" id="search-question"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</div>
		</div>
		<div class="container-fluid">
			<br>
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Danh sách loại câu hỏi</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="row">
						<div class="col-lg-4">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Loại câu hỏi</h3>
								</div>
								<div>
									<div class="row">
										<div class="col-xs-12">
											<select class="form-control" id="sl-subject"
												name="sl-subject">
												<%
													ArrayList<Subject> listSubject = (ArrayList<Subject>) request.getAttribute("listSubject");
													for (int i = 0; i < listSubject.size(); i++) {
												%>
												<option value="<%=listSubject.get(i).getID()%>"><%=listSubject.get(i).getName()%></option>
												<%
													}
												%>

											</select>
										</div>
									</div>
									<p class="badge badge-pill badge-danger col-12">Tổng số câu
										khó : 10</p>
									<p class="badge badge-pill badge-danger">Tổng số câu khó :
										10</p>
								</div>

								<input type="button" id="create-type" class="btn btn-success"
									value="Tạo mới" style="margin: 10px 0;">
								<%
									String rs = request.getParameter("success");
									if (rs != null) {
										int result = Integer.parseInt(request.getParameter("success"));

										if (result <= 0) {
								%>
								<div class="bg-danger" id="message">
									<p>Tạo loại câu hỏi không thành công</p>
								</div>
								<%
									} else {
								%>
								<div class="bg-success" id="message">
									<p>Tạo loại câu hỏi thành công</p>
								</div>
								<%
									}
									}
								%>
								<form action="SubjectServlet?type=addNew" id="form-type"
									style="display:none;" method="post">
									<div>
										<div class="form-group">
											<label for="txt-question-type">Tên loại câu hỏi</label> <input
												type="text" id="txt-question-type" name="txt-question-type"
												class="form-control">
										</div>
										<input type="submit" class="btn btn-primary" value="Lưu">
									</div>
								</form>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Danh sách câu hỏi</h3>
								</div>
								<input type="button" id="create-question" name="create-question"
									class="btn btn-success" value="Tạo câu hỏi mới"
									style="margin: 10px 0;">
								<div class="panel-group" id="accordion-question"></div>
							</div>
							<ul class="pagination">
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>

						</div>
					</div>

					<form id="form-file" action="questionBank?type=saveFile" enctype='multipart/form-data' method="post">
						<input type="file" id="file-question" name="file-question" class="btn btn-success"
						value="Import file">
					</form>
				</div>
				<br>
			</div>
		</div>
	</section>
			<jsp:include page="../sub/addEditQuestion.jsp"></jsp:include>