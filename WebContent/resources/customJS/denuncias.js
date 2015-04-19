$(document).ready(function(){
	 var denunciasTable = $('#denuncias').DataTable({
		'language': {
			'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
	    },
	    'order' : [[1, "asc"]],
	    'searching' : true,
	    'processing' : false,
	    'columnDefs' : [
	     {
	        'targets' : [0, 2],
	        'className' : "invi",
	        'searchable' : false
	     },
	     {
	    	 'targets' : [3],
	    	 'sortable' : false,
	    	 'searchable' : false
	     }
	     ]
	  });
	 
	 $('.glyphicon-eye-open').click(function(){
		 var row = $(this).parents('tr').children('td');
		 $('#asunto').text($(row[1]).text());
		 $('#motivo').text($(row[2]).text());
		 
		 $('#denuncia').modal();
	 })
});