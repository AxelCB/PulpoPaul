$(document).ready(function() {
    var mensajesTable = $('#mensajesTable').DataTable({
    	'language': {
    		'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
        },
        'order' : [[1, "desc"]],
        'searching' : true,
        'processing' : false,
        'columnDefs' : [
         {
            'targets' : 0,
            'className' : "invi",
            'searchable' : false
         },
         {
        	'targets' : [4, 5],
         	'searchable' : false,
         	'sortable' : false
         },
         {
        	 'targets' : [6],
        	 'searchable' : false,
        	 'sortables' : false,
        	 'className' : 'invi'
         }
         ]
      });
      
});