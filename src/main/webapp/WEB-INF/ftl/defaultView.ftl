<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#include "includes.ftl">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${page_title}</title>

</head>
<body>


<#include "template/navbar.ftl">
	
	
	<table border="1" class="data-grid">
	<thead>
	<th>Name</th>
	<th>Id</th>
	<th>Category</th>
	<th>modifiedDate</th>
	<th>size</th>
	<th>absolutePath</th>
	</thead>
	<tbody>
	<#if moviesList?has_content>
	<#list moviesList as movie>
		<tr class="dynamic">
				<td class="data-model">${movie.name}</td>
				<td class="data-model id">${movie.id?c}</td>
				<td class="data-model editable">${movie.category}</td>
            <td class="data-model">${movie.modifiedDate}</td>
				<td class="data-model">${((movie.size/(1024*1024)))} MB</td>
				<td class="data-model"><a  href="file://${movie.absolutePath}"> View Info</a></td>
		</tr>		
	</#list>
	</tbody>
	<tfoot>
    <tr>
        <td id="paginate">paginate</td>
        <td><input id="total_display" type="text" value="10"></td>
    </tr>
	<#else>
	<tr>
	<td>sorry no data........</td>
	</tr>
	</#if>
	</tfoot>
</table>



<script type="text/javascript">
		$(document).ready(function() {
	<#if rows_affected?has_content>
		$.notify("${rows_affected} rows affected", "info");
	<#else>
		$.notify("0 rows affected", "info");
	</#if>
        $("#paginate").paginate({
				count 		: ${rows_count?c},
				start 		: ${rows_start},
            display: 10,
				border					: false,
				text_color  			: '#888',
				background_color    	: '#EEE',	
				text_hover_color  		: 'black',
				background_hover_color	: '#CFCFCF',
				onChange     			: function(page){
											<#if fileType?has_content>
                                                var limit = $('#total_display').val();
												<#if fileType=="music">
												 getMusicByLimit(page);
												<#elseif fileType=="movies">

                                                    getMoviesByLimit(page, limit);
												 </#if>
											<#else>
											alert("No file type");
											</#if>	  
										  }
			});
				
		});
	</script>		
</body>
</html>