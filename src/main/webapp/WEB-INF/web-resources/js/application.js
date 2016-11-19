/**
 * This contains commonly used methods definition
 * 
 */

$(document).ready(
		function() {

			// $(".editable").dblclick(function(e){
			// $(this).addClass("updateCategory");
			// $(this).attr("contenteditable","true");
			// event.stopPropagation();
			// console.log(e);
			// });

			$(document).on("dblclick", ".editable", function() {
				$(this).addClass("updateCategory");
				$(this).attr("contenteditable", "true");
				event.stopPropagation();
			});

			$(document).click(
					function(event) {
						if (!$(event.target).closest('.editable').length
								&& $(".editable").hasClass("updateCategory")) {
							persistUpdateCategory();
						}
					});

		});

function persistUpdateCategory() {
	var id = $(".updateCategory").siblings(".id").text();
	var category = $(".updateCategory").text();
	alert("ID=" +id + " cat"+ category);
	$(".updateCategory").attr("contenteditable", "false");
	updateMusicCategory(id,category);
	$(".updateCategory").removeClass("updateCategory");

}
