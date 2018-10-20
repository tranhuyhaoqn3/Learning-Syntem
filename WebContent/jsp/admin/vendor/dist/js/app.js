var STATUS = Object.freeze({
    'STATUS_START': 'Start',
    'STATUS_PAUSED': 'Paused',
    'STATUS_RESUME': 'Resume',
    'STATUS_COMPLETED': 'Completed'
});
var STATUS_TEXT = {
    0: 'Not Started',
    1: 'Executing',
    2: 'Paused',
    3: 'Completed'
}


$(document).ready(function () {
    $('#login').submit(() => {
        if ($("#username").val() == "") {
            alert("Please enter your user name");
            $("#username").focus();
            return false;
        }
        if ($("#password").val() == "") {
            alert("Please enter your password");
            $("#password").focus();
            return false;
        }
        $.post(
            '../api.php', {
                username: document.getElementById('username').value,
                password: document.getElementById('password').value
            },
            function (res) {
                //location = location;
                if (res == "ok") {
                    $("#main-section").show();
                    $("#login-modal").modal("toggle");
                    loadParentTable();
                    refreshParentData();
                } else {
                    alert("Your user name and/or password does not match");
                    $("#username").focus();
                    return false;
                }
            }
        );
        return false;
    })


    $(window).ready(function () {
        $.get("../api.php", function (data, status) {
            if (data != 'error') {
                $("#main-section").hide();
            //    showLoginForm();
            } else {
                $("#main-section").show();
                loadParentTable();
                refreshParentData();
                setInterval(() => {
                    refreshParentData();
                }, 5000);
            }
        });
    });



    function loadParentTable() {
        //$("#parenttable").DataTable().destroy();
        var table = $('#parenttable').DataTable({
            iDisplayLength: 50,
            "order": [
                [0, "desc"]
            ],
            "columnDefs": [{
                    "targets": [0],
                    "data": "uploaded_date"
                },
                {
                    "targets": [1],
                    "data": "file_path"
                },
                {
                    "targets": [2],
                    "data": "total"
                },
                {
                    "targets": [3],
                    "data": "successful"
                },
                {
                    "targets": [4],
                    "data": "failed"
                },
                {
                    "targets": [5],
                    "data": "queue"
                },
                {
                    "targets": [6],
                    "data": "status_code"
                },
                {
                    "targets": [7],
                    "data": null,
                    "defaultContent": "<button class='btn btn-sm btn-info btn-flat pull-left'>Detail</button>"
                },
                {
                    "targets": [8],
                    "data": null,
                    "defaultContent": "<button class='btn btn-sm btn-primary btn-flat pull-left btn-control' id ='btn-control'>Start</button>"
                },
                {
                    "targets": [9],
                    "data": null,
                    "defaultContent": "<button class='btn btn-sm btn-danger btn-flat pull-left' id = 'btn-delete'>Delete</button>"
                },
            ]
        });

        $('#parenttable tbody').on('click', 'button', function () {
            var data = table.row($(this).parents('tr')).data();
            var btn = $(this);
            var id = btn[0].id;
            if (id === 'btn-control') {
                setStatus(data.batch_id, refreshParentData);
            } else if (id === 'btn-delete') {
                if (confirm("Are you sure ? ")) {
                    deleteBatch(data.batch_id);
                }
            } else {
                getDetailTable(data.batch_id);
            }
        });
    }

    function deleteBatch(batch_id) {
        $.get(`../api.php?deleteBatch=${batch_id}`, (data, status) => {
            refreshParentData();
        });
    }

    function refreshParentData() {
        refreshTable('#parenttable', '../api.php?getparent');
    }

    function setStatus(batch_id, changeBtn) {
        $.get(`../api.php?setStatus=${batch_id}`, changeBtn);
    }

    function getDetailTable(batch_id) {
        //$(".tablepop").css('display', 'block');
        $("#detail-modal").modal({
            width: 800
        });

        $("#maintable").DataTable().destroy();
        var table = $('#maintable').DataTable({
            ajax: {
                url: `../api.php?getDetailData=${batch_id}`,
                dataSrc: ''
            },
            "columnDefs": [{
                    "targets": [0],
                    "data": null
                },
                {
                    "targets": [1],
                    "data": "phone_number"
                },
                {
                    "targets": [2],
                    "data": "phone_name"
                },
                {
                    "targets": [3],
                    "data": "sent_time"
                },
                {
                    "targets": [4],
                    "data": "message"
                },
                {
                    "targets": [5],
                    "data": "unicode"
                },
                {
                    "targets": [6],
                    "data": "error_message"
                }
            ]
        });

        table.on('order.dt search.dt', function () {
            table.column(0, {
                search: 'applied',
                order: 'applied'
            }).nodes().each(function (cell, i) {
                cell.innerHTML = (i + 1);
            });
        }).draw();
        $("#maintable").width("100%");
    }


    // Change this to the location of your server-side upload handler:

    $(document).ready(() => {
        $('#fileupload').fileupload({
                url: '../api.php?upload',
                dataType: 'json',
                autoUpload:true,
                done: function (e, data) {
                    $.each(data.result.files, function (index, file) {
                        $('<p/>').text(file.name).appendTo('#files');
                    });
                    if(data.result.error){
                        alert("The file already exists in the database, try another file");
                        return;
                    }
                    refreshParentData();
                    $("#number_failed").text('Failed Number  : ' +  `${data.result.failed}`);
                    $("#number_success").text('Success Number : ' +  `${data.result.success}`);
                    $("#number-modal").modal({width:300});
                },
                progressall: function (e, data) {
                    var progress = parseInt(data.loaded / data.total * 100, 10);
                    $('#progress .progress-bar').css(
                        'width',
                        progress + '%'
                    );
                }
            }).prop('disabled', !$.support.fileInput)
            .parent().addClass($.support.fileInput ? undefined : 'disabled');
    });
});

// 2018-06-04 VCS add start
/**
 * purpose : Show/hide/change text button
 * define status_code :
 * status_code = 0 => send message not start => button hide
 * status_code = 1 => send message excuting => button show for user click paused (change text into Paused)
 * status_code = 2 => send message paused => button show for user click Resume (change text into Resume)
 * @param {*} data : The data returned by the server {status_code : {0 or 1 or 2 or 3}}
 */
function changeBtn(data) {
    var status = data.status_code;
    if (status === "3") {
        $(this).css('display', 'none');
        return;
    }
    if (status === "0") {
        $(this).css('display', 'none');
    } else if (status === "1") {
        $(this).text(STATUS.STATUS_PAUSED);
        $(this).css('display', 'block');
    } else if (status === "2") {
        $(this).text(STATUS.STATUS_RESUME);
        $(this).css('display', 'block');
    }
}

function setBtnControl() {
    var table = $("#parenttable").DataTable();
    table.rows().every(function (rowIdx, tableLoop, rowLoop) {
        var listBtn = $('.btn-control');
        var btn = $(listBtn[rowIdx]);
        changeBtn.call(btn, this.data());
    });
}
// 2018-06-04 VCS add end
function refreshTable(tableId, urlData) {
    $.getJSON(urlData, null, function (json) {
        table = $(tableId).dataTable();
        oSettings = table.fnSettings();

        table.fnClearTable(this);
        for (var i = 0; i < json.length; i++) {
            var temp = json[i].status_code;
            json[i].status_code = STATUS_TEXT[json[i].status_code];
            table.oApi._fnAddData(oSettings, json[i]);
            json[i].status_code = temp;

        }
        oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
        table.fnDraw();
        setBtnControl();
    });
}