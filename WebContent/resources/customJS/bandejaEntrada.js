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
        	 'targets' : [6, 7],
        	 'searchable' : false,
        	 'sortables' : false,
        	 'className' : 'invi'
         }
         ]
      });
      
   $('.glyphicon-eye-open').click(function(){
	  var row = $(this).parents('tr').children('td');
	  $('#asunto').text($(row[3]).text());
	  $('#remitente').text($(row[2]).text());
	  $('#fecha').text($(row[1]).text());
	  $('#contenido').text($(row[6]).text());
	  
	  if($(row[7]).text() != '0'){
		  var str = '<br>';
		  str += '<a href="/PulpoPaul/recorrido/aceptarParticipante?idMensaje=' + $(row[0]).text() + '&aceptar=true" class="btn btn-success">Aceptar</a>'
		  str += '<a href="/PulpoPaul/recorrido/aceptarParticipante?idMensaje=' + $(row[0]).text() + '&aceptar=false" class="btn btn-danger">Rechazar</a>';
		  $('#contenido').append(str);
	  }
	  
	  $('#contenidoMensaje').modal();
   });
});