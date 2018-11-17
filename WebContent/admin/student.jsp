<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div class="row">
	<div class="col-xs-6">
		<input type="button" id="create" name="create" class="btn btn-success"
			data-toggle="modal" data-target="#myModal"
			value="Thêm sinh viên"">
	</div>
	<div class="col-xs-6">
		<form action="#" method="get">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Nhập mã số sinh viên..."> <span
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
			<h3 class="box-title">Danh sách sinh viên</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<table class="table table-bordered table-hover">
				<tr>
					 <th>Mã số sinh viên</th>
                                        <th>Họ tên</th>
                                        <th>Giới tính</th>
                                        <th>Ngày sinh</th>
                                        <th>Quê quán</th>
                                        <th>Lớp</th>
                                        <th>Tình trạng</th>
                                        <th>Hành động</th>
				</tr>
				<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
								name="delete" class="btn btn-danger" value="Xóa">
						</div>

					</td>

				</tr>
		<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
								name="delete" class="btn btn-danger" value="Xóa">
						</div>

					</td>

				</tr>
				<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
								name="delete" class="btn btn-danger" value="Xóa">
						</div>

					</td>

				</tr>
				<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
								name="delete" class="btn btn-danger" value="Xóa">
						</div>

					</td>

				</tr>
				<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
								name="delete" class="btn btn-danger" value="Xóa">
						</div>

					</td>

				</tr>
				<tr>
					<td>16110054</td>
					<td>Nguyễn Văn Dinh </a></td>
					<td>Nam</td>
					<td>10/22/1998</td>
					<td>Gia Lai</a></td>
					<td>16110CL6</a></td>
					<td>Đang học</a></td>
					<td>
						<div>
							<input type="button" id="edit" data-toggle="modal"
								data-target="#myModal" name="edit" class="btn btn-primary"
								value="Sửa"> <input type="button" id="delete"
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


<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Thông tin sinh viên</h4>
			</div>
			<div class="modal-body">
			<div class="content">
			<form class="form-add">
			<div id="line-mssv" class="line"> <label >Mã số sinh viên</label><input id="ipmssvl" type="input" placeholder="Mã số sinh viên"> </div>
			<div id="line-ten" class="line"> <label >Họ và tên</label><input id="iptenl" type="input" placeholder="Họ và tên"> </div>
			<div id="line-gt" class="line"> <label >Giới tính</label><input id="ipgtl" type="input" placeholder="Giới tính"> </div>
			<div id="line-ns" class="line"> <label >Ngày sinh</label><input id="ipnsl" type="input" placeholder="Ngày sinh"> </div>
			<div class="line-qq"> <label for="fname">Quê quán</label>
									<select class="form-control" >
										<option >Vũng tàu</option>
										<option >Sài gòn</option>
										<option >Hà Nội</option>
									</select>
			</div>
			<div id="line-l" class="line"> <label >Lớp học</label><input id="ipmssvl" type="input" placeholder="Lớp học"> </div>
			<div id="line-btn" class="btnLine"><input type="button" id="btnsave" class="btn btn-success" value="Lưu"></div>
			</form>
			</div>
			</div>
		</div>
		</div></div>
			