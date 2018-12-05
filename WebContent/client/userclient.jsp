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
<div class="card h-100 w-100 p-5">
	<div class="row h-100 w-100">
		<div class="col-lg-4 col-xs-12 h-100 w-100">
			<div class="anhdaidien w-75 h-75">
				<img src="${UserName.getImage()}" class="rounded img-fluid">
			</div>
		</div>
		<div class="col-lg-8 col-xs-12">
			<div class="info">
				<form>
					<div class="form-group row">
						<label for="email" class="col-sm-3 form-control-label">Email</label>
						<div class="col-sm-9">
							<input type="email"name="UserName" class="form-control" id="UserName" placeholder="Email" value="${UserName.getUserName()}">
						</div>
					</div>
					<div class="form-group row">
						<label for="name" class="col-sm-3 form-control-label">Tên</label>
						<div class="col-sm-9">
							<input type="text"name="Name" class="form-control" id="Name" placeholder="name" value="${UserName.getName()}">
						</div>
					</div>
					<div class="form-group row">
						<label for="ID" class="col-sm-3 form-control-label">Mã sinh viên</label>
						<div class="col-sm-9">
							<input type="text" name="ID" class="form-control" id="ID" placeholder="ID" value="${UserName.getiD()}" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="DOB" class="col-sm-3 form-control-label">Ngày sinh</label>
						<div class="col-sm-9">
							<input type="date" name="DOB" class="form-control" id="DOB" placeholder="DOB" value="${UserName.getdOB()}">
						</div>
					</div>
					<div class="form-group row">
						<label for="add" class="col-sm-3 form-control-label">Địa chỉ</label>
						<div class="col-sm-9">
							<input type="text" name="Address" class="form-control" id="Address" placeholder="add" value="${UserName.getAddress()}">
						</div>
					</div>
					<div class="form-group row">
						<label for="pass"  name="PassWord"class="col-sm-3 form-control-label">Mật khẩu mới</label>
						<div class="col-sm-9">
							<input type="password" name="PassWord" class="form-control" id="PassWord" placeholder="pass">
						</div>
					</div>
					<input type="button" id="btnUpdateClient" name="" value="Cập nhật thông tin" class="btn btn-danger btn-block">
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('#btnUpdateClient').click(function(){
		$.ajax({
			type : 'POST',
			url : './InfoClient',
			data : {
				ID : $('#ID').val(),
				UserName : $('#UserName').val(),
				Name : $('#Name').val(),
				DOB : $('#DOB').val(),
				Address : $('#Address').val(),
				PassWord : $('#PassWord').val()
			},
			success : function(result) {
				if(result==""){
					alert("Cập nhật thông tin thành công");
				}
				else{
					alert("Cập nhật thông tin thất bại");
				}
			},
			error : function(result) {
				alert("Cập nhật thông tin thất bại");
			}
		});
	});
</script>
</jsp:body>
</t:MainPractise>