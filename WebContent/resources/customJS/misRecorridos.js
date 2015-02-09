$(document).ready(function() {
    var recorridosTable = $('#recorridosTable').DataTable({
    	'language': {
    		'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
        },
        'order' : [[1, "asc"]],
        'searching' : true,
        'processing' : false,
        'columnDefs' : [
         {
            'targets' : 0,
            'className' : "invi",
            'searchable' : false
         },
         {
        	'targets' : [6, 7],
         	'searchable' : false,
         	'sortable' : false
         },
         {
        	'targets' : [3, 4],
         	'sortable' : false 
         },
         {
        	 'targets' : [5],
        	 'searchable' : false
         }
         ]
      });
      
});