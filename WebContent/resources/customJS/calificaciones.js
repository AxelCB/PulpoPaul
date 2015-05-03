$(document).ready(function(){
	 var denunciasTable = $('#calificaciones').DataTable({
		'language': {
			'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
	    },
	    'order' : [[1, "asc"]],
	    'searching' : true,
	    'processing' : false
	  });
});