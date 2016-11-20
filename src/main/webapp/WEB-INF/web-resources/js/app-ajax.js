/**
 * author : sumeeth kumar kanojia
 */

$(document).ready(function() {
	$('#searchByFirstName').blur(function() {

		$.ajax({
			url : 'getStudentByFirstName',
			type : "GET",
			data : {
				request : $('#searchByFirstName').val()
			},
			success : function(responseText) {
				ajaxSuccess(responseText);
			},
			error : function() {
				console.log(error);
			}
		});
	});

	$('#searchByLastName').blur(function() {
		var reqData = $('#searchByLastName').val();
		doAjaxRequest(reqData, "getStudentByLastname");
	});

	$('#searchByCollegeId').blur(function() {
		var reqData = $('#searchByCollegeId').val();
		doAjaxRequest(reqData, "getStudentByCollegeId");
	});

	$('#searchByYearLevel').blur(function() {
		var reqData = $('#searchByYearLevel').val();
		doAjaxRequest(reqData, "getStudentByYearLevel");
	});

	$('#searchMusicByName').blur(function() {
		var reqData = $('#searchMusicByName').val();
		getMusicByName(reqData);
	});

});

function doAjaxRequest(requestData, requestUrl) {

	$.ajax({
		url : requestUrl,
		type : "GET",
		data : {
			request : requestData
		},
		success : function(responseText) {
			ajaxSuccess(responseText);
		},
		error : function() {
			console.log(error);
		}
	});
}

function ajaxSuccess(responseText) {
	var obj = JSON.parse(responseText);

	console.log(obj);
	populateJsonData(obj);
}
function ajaxError(responseText) {
	var obj = JSON.parse(responseText);
	console.log(obj);
	populateJsonData(obj);
}

function populateJsonData(obj) {
	var html = '';
	for (var key = 0, size = obj.length; key < size; key++) {

		html += '<tr><td class="data-grid-td">' + obj[key]["studentId"]
				+ '</td><td class="data-grid-td">' + obj[key]["firstname"]
				+ '</td><td class="data-grid-td">' + obj[key]["lastname"]
				+ '</td><td class="data-grid-td">' + obj[key]["yearLevel"]
				+ '</td><td class="data-grid-td">' + obj[key]["collegeId"]
				+ '</td></tr>';
	}
	$('.data-grid tbody').empty();
	$('.data-grid tbody').append(html);
}

function generateRequestData(key, value) {
	return value;
}

function getMusicByLimit(aoffset) {

	$.ajax({
		url : 'getMusicByLimit_ajax.index',
		type : "GET",
		data : {
			offset : aoffset
		},
		success : function(responseText) {
			console.log('responseText' + responseText);
			var html = '';
			var obj = JSON.parse(responseText);
			$.notify(obj.length + " rows fetched", "info");
			for (var key = 0, size = obj.length; key < size; key++) {

				html += populateMusicData(obj[key]);
			}
			$('tbody').empty();
			$('tbody').append(html);

		},
		error : function(error) {
			console.log(error);
		}
	});
}
function getMoviesByLimit(offset, display) {
//alert("Ajax request-> offset"+offset+"limit"+display);

	$.ajax({
		url : 'getMoviesByLimit_ajax.index',
		type : "GET",
		data : {
			limit: display,
			offset: offset
		},
		success : function(responseText) {
			console.log('responseText' + responseText);
			var html = '';
			var jsonObj = JSON.parse(responseText);
			var fileObj = jsonObj.moviesList;
			console.log(fileObj)
			$.notify(fileObj.length + " rows fetched", "info");
			for (var key = 0, size = fileObj.length; key < size; key++) {

				html += populateMusicData(fileObj[key]);
			}
			$('tbody').empty();
			$('tbody').append(html);

		},
		error : function(error) {
			console.log(error);
		}
	});
}


function getMusicByName(aname) {

	$.ajax({
		url : 'getMusicByName_ajax.index',
		type : "GET",
		data : {
			name : aname
		},
		success : function(responseText) {
			console.log('responseText' + responseText);
			var html = '';
			var obj = JSON.parse(responseText);
			$.notify(obj.length + " rows fetched", "info");
			for (var key = 0, size = obj.length; key < size; key++) {

				html += populateMusicData(obj[key]);
			}
			$('tbody').empty();
			$('tbody').append(html);

		},
		error : function() {
			console.log(error);
		}
	});
}

function updateMusicCategory(_id, _category) {
	$.ajax({
		url : 'updateMusicCategory_ajax.index',
		type : "POST",
		data : {
			category : _category,
			id : _id
		},
		success : function(responseText) {
			console.log('responseText' + responseText);
			var obj = JSON.parse(responseText);
			console.log('JSON obj' + obj);
			if (obj.status === true) {
				$.notify("category updated", "success");
			} else {
				$.notify("unable to update category. Please check logs.",
						"error");
			}

		},
		error : function() {
			console.log(error);
		}
	});
}

function getDate(dateString) {
	var currentTime = new Date(parseInt(dateString));
	var month = currentTime.getMonth() + 1;
	var day = currentTime.getDate();
	var year = currentTime.getFullYear();
	var date = day + "/" + month + "/" + year;
	return date;

}

function getFileSize(bytes) {
	var mb = bytes / (1024 * 1024);
	return mb.toFixed(2) + "MB";
}

function getHrefFromAbsolutePath(path) {
	return "file://" + path;
}

function populateMusicData(data) {

	return '<tr>' + '<td class="data-model">' + data["name"]
			+ '<td class="data-model id">' + data["id"]
			+ '</td><td class="data-model editable">' + data["category"]
			+ '</td><td class="data-model">' + getDate(data["modifiedDate"])
			+ '</td><td class="data-model">' + getFileSize(data["size"])
			+ '</td><td class="data-model">' + '<a  href='
			+ getHrefFromAbsolutePath(data["absolutePath"]) + '> View Info</a>'
			+ '</td></tr>';

}
