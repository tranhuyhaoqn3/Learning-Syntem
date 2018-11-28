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
								<form>
									<fieldset>
										<div class="row">
											<div class="col-xs-2">
												<input type="button" class="btn btn-success" value="Tạo mới">
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-xs-12">
													<select class="form-control">
														<option value="math1">Toán cao cấp 1</option>
														<option value="oop">Lập trình hướng đối tượng</option>
														<option value="nmlt">Nhập môn lập trình</option>
													</select>
												</div>
											</div>
										</div>
									</fieldset>

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
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse1"> Câu 1. Một trong những nội dung quan
													trọng của Hội nghị Ianta là:</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="alert alert-info">
													<input type="radio" name='radio3'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													A. Đàm phán, kí kết các hiệp ước với các nước phát xít bại
													trận.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio3'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													B. Các nước thắng trận thoả thuận viêc phân chia Đức thành
													haỉ nước Đông Đức và Tây Đức.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio3'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													C. Ba nước phe Đồng minh bàn bạc, thoả thuận khu vực đóng
													quân tại các nước nhằm giải giáp quân đội phát xít; phân
													chia phạm vi ảnh hưởng ở châu Âu và châu Á.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio3'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													D. Các nước phát xít Đức, Italia kí văn kiện đầu hàng phe
													Đồng minh vô điều kiện.
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-xs-10">
															<input type="text" id="add-answer" class="form-control"
																name="add-answer" placeholder="Điền câu trả lời">
														</div>
														<div class="col-xs-2">
															<input type="button" class="btn btn-success" value="Add">
														</div>
													</div>
												</div>
												<input type="button" class="btn btn-success" value="Lưu">

											</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse2"> Câu 2. Những nước nào tham gia Hội
													nghị Ianta ?</a>
											</h4>
										</div>
										<div id="collapse2" class="panel-collapse collapse">
											<div class="panel-body">
												<div class="alert alert-info">
													<input type="radio" name='radio2'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													A. Anh - Pháp - Mĩ.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio2'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													B. Anh - Mĩ - Liẽn Xô.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio2'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													C. Anh - Pháp - Đức.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio2'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													D. Mĩ - Liên Xô - Trung Quốc.
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-xs-10">
															<input type="text" id="add-answer" class="form-control"
																name="add-answer" placeholder="Điền câu trả lời">
														</div>
														<div class="col-xs-2">
															<input type="button" class="btn btn-success" value="Add">
														</div>
													</div>
												</div>
												<input type="button" class="btn btn-success" value="Lưu">
											</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse3"> Câu 3. Hội nghị Ianta có ảnh hưởng
													như thế nào đối với thế giới sau chiến tranh ? </a>
											</h4>
										</div>
										<div id="collapse3" class="panel-collapse collapse">
											<div class="panel-body">
												<div class="alert alert-info">
													<input type="radio" name='radio1'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													A. Làm nảy sinh những mâu thuẫn mới giữa các nước đế quốc
													với các nước đế quốc.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio1'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													B. Đánh dấu sự hình thành một trật tự thế giới mới sau
													chiến tranh.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio1'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													C. Trở thành khuôn khổ của một trật tự thế giới, từng bước
													được thiết lập trong những năm 1945 - 1947.
												</div>
												<div class="alert alert-info">
													<input type="radio" name='radio1'> <a href="#"
														class="close" data-dismiss="alert" aria-label="close"
														title="close"><i class="fa fa-trash"
														aria-hidden="true"></i></a> <a href="#" class="close"
														title="close"><i class="fa fa-edit" aria-hidden="true"></i></a>
													D. Là sự kiện đánh dấu sự xác lập vai trò thống trị thế
													giới của chủ nghĩa đế quốc Mĩ.
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-xs-10">
															<input type="text" id="add-answer" class="form-control"
																name="add-answer" placeholder="Điền câu trả lời">
														</div>
														<div class="col-xs-2">
															<input type="button" class="btn btn-success" value="Add">
														</div>
													</div>
												</div>
												<input type="button" class="btn btn-success" value="Lưu">

											</div>
										</div>
									</div>
								</div>
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


					<input type="file" id="file" name="file" class="btn btn-success"
						value="Import file">
				</div>
				<br>
			</div>
		</div>
	</section>