$(document).ready(function(){
	 var usuariosTable = $('#usuarios').DataTable({
		'language': {
			'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
	    },
	    'order' : [[1, "asc"]],
	    'searching' : true,
	    'processing' : false,
	    'columnDefs' : [
	     {
	        'targets' : [0],
	        'className' : "invi",
	        'searchable' : false
	     },
	     {
	    	 'targets' : [3, 4, 5, 6, 7],
	    	 'sortable' : false,
	    	 'searchable' : false
	     }
	     ]
	  });
	 
	 $('.glyphicon-trash').click(function(){
		 var row = $(this).parents('tr').children('td');
		 var usuarioId = $(row[0]).text();
		 if(confirm('¿Seguro que desea eliminar el usuario seleccionado?')){
			 window.location.href="borrarUsuario?usuarioId="+usuarioId;
		 }
	 })
	 
	 $('.glyphicon-warning-sign').click(function(){
		 var row = $(this).parents('tr').children('td');
		 var usuarioId = $(row[0]).text();
		 window.location.href="listarDenuncias?idDenunciado="+usuarioId;
	 })
	 
	 $('.glyphicon-envelope').click(function(){
		 var row = $(this).parents('tr').children('td');
		 $('#idDestinatario').val($(row[0]).text());
		 $('#nombreDestinatario').text($(row[1]).text()+', '+$(row[2]).text());
		 
		 $('#mensajeEnviar').modal();
	 })
	 
	 
});