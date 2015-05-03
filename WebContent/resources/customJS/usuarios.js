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
	    	 'targets' : [5, 6, 7, 8],
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
	 
	 $('.glyphicon-star').click(function(){
		 var row = $(this).parents('tr').children('td');
		 var calificadoId = $(row[0]).text();		 
		 window.location.href = "listarCalificaciones?calificadoId=" + calificadoId;
	 })
	 
});