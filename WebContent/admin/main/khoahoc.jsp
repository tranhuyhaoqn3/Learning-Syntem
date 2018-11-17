<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Danh sách khóa học
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
			<li class="active">Here</li>
		</ol>
	</section>
	
	<!-- Main content -->
	<section class="content container-fluid">
		<div class="row">
			<div class="col-xs-6">
				<input type="button" id="create" name="create" class="btn btn-success"
				data-toggle="modal" data-target="#myModal"
				value="Tạo khóa học mới"">
			</div>
			<div class="col-xs-6">
				<form action="#" method="get">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
						placeholder="Nhập tên khóa học..."> <span
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
			<h3 class="box-title">Danh sách khóa học</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<table class="table table-bordered table-hover">
				<tr>
					<th>STT</th>
					<th>Tên khóa học</th>
					<th>Số sinh viên</th>
					<th>Ngày bắt đầu</th>
					<th>Ngày kết thúc</th>
					<th>Giáo viên</th>
					<th>Tùy chọn</th>
				</tr>
				<tr>
					<td>1</td>
					<td><a href="#">Lập trình web</a></td>
					<td>10</td>
					<td>10/22/2018</td>
					<td>13/22/2018</td>
					<td><a href="#">Mr. Cao Son</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
							data-target="#myModal" name="edit" class="btn btn-primary"
							value="Chi tiết"> <input type="button" id="delete"
							name="delete" class="btn btn-danger" value="Xóa">
						</div>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td><a href="#">Lập trình nhúng</a></td>
					<td>13</td>
					<td>10/22/2018</td>
					<td>13/22/2018</td>
					<td><a href="#">Mr. Cao Son</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
							data-target="#myModal" name="edit" class="btn btn-primary"
							value="Chi tiết"> <input type="button" id="delete"
							name="delete" class="btn btn-danger" value="Xóa">
						</div>
					</td>
				</tr>
				
			</table>
			<ul class="pagination">
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
<br>
<div>
	<input type="file" id="file" name="file" class="btn btn-success"
	value="Import file">
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Chi tiết khóa học</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-3 form-control-label">Tên khóa học</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputEmail3" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-3 form-control-label">Giảng viên phụ trách</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputEmail3" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-3 form-control-label">Số lượng sinh viên</label>
						<div class="col-sm-9">
							<input type="number" class="form-control" id="inputPassword3" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-3 form-control-label">Ngày bắt đầu</label>
						<div class="col-sm-9">
							<input type="date" class="form-control" id="inputPassword3" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-3 form-control-label">Ngày kết thúc</label>
						<div class="col-sm-9">
							<input type="date" class="form-control" id="inputPassword3" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary btn-block">Lưu thông tin</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>