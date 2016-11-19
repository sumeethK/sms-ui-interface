$(document).ready(function() {

      // Initialize the plugin
	 $('.popup').click(function(){
		// var b= $(this).attr( "href");
		// $("#movie_content").attr("src",b);
		 $('#my_popup').popup('show');
		 return false;
	 });
	 $('#my_popup').popup({
		  transition: 'all 0.3s'
		});
	 
	 $('#close').click(function(){
		 $('#my_popup').popup('hide');
		 
	 });
	 

    });