<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div id="myModal" class="modal fade" role="dialog">
	<input type="hidden" id="type-edit">
	<input type="hidden" id="value">
		<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Cập nhật câu hỏi</h4>
			</div>
			<div class="modal-body">
				<!-- /. tools -->
				<div class="box-body pad">
					<form>
						<textarea id="editor1" name="editor1" rows="10" cols="80">
                    </textarea>
					</form>
				</div>
			</div>
			<div class="modal-footer">
			<button type="button" id="btn-save-modal" class="btn btn-primary">Lưu</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Quay lại</button>
			</div>
		</div>

	</div>
</div>