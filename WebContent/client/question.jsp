<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/Client" %>
<t:MainPractise>
<h1> Nội dung chương 5</h1>
 <div class="card">
    <div class="card-block p-3">
      <h4 class="card-title">Câu 1: <b> 1+1=?</b></h4>
      <div class="radio">
        <label>
          <input type="radio" name="cau1" id="cau1A" value="option1" checked>
         1
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="cau1" id="Cau1B" value="option1">
          2
        </label>
      </div>
     
    </div>
  </div>
   <div class="card mt-3">
    <div class="card-block p-3">
      <h4 class="card-title">Câu 2: <b> 3+1=?</b></h4>
      <div class="radio">
        <label>
          <input type="radio" name="cau2" id="cau21" value="option1" checked>
         4
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="cau2" id="cau21" value="option1">
          5
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="cau2" id="cau21" value="option1">
          6
        </label>
      </div>
       <div class="radio">
        <label>
          <input type="radio" name="cau2" id="cau21" value="option1">
          7
        </label>
      </div>
    </div>
  </div>
<div id="time-excute">
  <p>Thời gian còn lại:
    <b><span id="h"></span> :</b>
    <b><span id="m"></span> :</b>
    <b><span id="s"></span></b>
  </p>
</div>
  <a href="" class="btn btn-danger btn-block">Nộp bài</a>
  <script>
  	var h=0;
  	var m=30;
  	var s=0;
  	start();
  	function start()
	{

		

		if (s === -1){
			m -= 1;
			s = 59;
		}

	    // Nếu số phút = -1 tức là đã chạy ngược hết số phút, lúc này:
	    //  - giảm số giờ xuống 1 đơn vị
	    //  - thiết lập số phút lại 59
	    if (m === -1){
	    	h -= 1;
	    	m = 59;
	    }

	    // Nếu số giờ = -1 tức là đã hết giờ, lúc này:
	    //  - Dừng chương trình
	    if (h == -1){
	    	clearTimeout(timeout);
	    	alert('Hết giờ');
	    	return false;
	    }

	    /*BƯỚC 1: HIỂN THỊ ĐỒNG HỒ*/
	    document.getElementById('h').innerText = h.toString();
	    document.getElementById('m').innerText = m.toString();
	    document.getElementById('s').innerText = s.toString();

	    /*BƯỚC 1: GIẢM PHÚT XUỐNG 1 GIÂY VÀ GỌI LẠI SAU 1 GIÂY */
	    timeout = setTimeout(function(){
	    	s--;
	    	start();
	    }, 1000);
	}
	function stop(){
		clearTimeout(timeout);
	}
  </script>
</t:MainPractise>>