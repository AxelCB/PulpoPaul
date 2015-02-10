///////////////////////
// MAPA ///////////////
///////////////////////
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var waypoints = [];
var start = null;
var facultad = new google.maps.LatLng(-34.90364261359886, -57.93748378753662);
var end;

function initialize(){
	directionsDisplay = new google.maps.DirectionsRenderer();
	var laPlata = new google.maps.LatLng(-34.922066, -57.954094);
	var mapOptions = {
		zoom: 13,
		center: laPlata,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		draggable: true
	};
	map = new google.maps.Map(document.getElementById('map'), mapOptions);
}

google.maps.event.addDomListener(window, 'load', initialize);

function calcRoute(){
	var request = {
		origin: start,
		destination: end,
		travelMode: google.maps.TravelMode.DRIVING,
		optimizeWaypoints: true,
		waypoints: waypoints
	}
	
	directionsService.route(request, function(response, status){
		if(status == google.maps.DirectionsStatus.OK){
			directionsDisplay.setMap(map);
			directionsDisplay.setDirections(response);
		}
	})
}

///////////////////////
// ACCIONES ///////////
///////////////////////
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
        	 'targets' : 6,
        	 'searchable' : false,
        	 'sortable' : false
         }
         ]
      });
    
//    $('.glyphicon-plus').click(function(){    	
//    	$("nombre").text('');
//    	$("propietario").text('');
//    	$("destino").text('');
//    	$("tipo").text('');
//    	$("fecha").text('');
//    	$("dias").text('');
//    	$("horaIda").text('');
//    	$("horaVuelta").text('');
//    	$("precio").text('');
//    	$("participar").html('');
//    	directionsDisplay.setMap(null);
//    	waypoints = [];
//    	start = null;
//    	end = null;
//
//    	var row = $(this).parents('tr').children('td');
//    	$.ajax({
//    		  type: "GET",
//    		  url: "/recorrido/buscar",
//    		  data: { idRecorrido: $(row[0]).text() }
//    	})
//    	.fail(function() {
//    		alert('Se ha producido un error al traer los datos del servidor');
//    	})
//    	.success(function(json){
//    		$("nombre").text();
//    		$("propietario").text();
//    		$("destino").text();
//    		$("tipo").text();
//    		$("fecha").text();
//    		$("dias").text();
//    		$("horaIda").text();
//    		$("horaVuelta").text();
//    		$("precio").text('$');
//	  
//    		var str = '<a href="/recorrido/agregarViajero?idViajero=' + $('#idUsuario').text() + '&idRecorrido=' + $(row[0]).text() + '" class="btn btn-default col-sm-offset-8 col-sm-3">Participar!</a>';
//    		$("participar").append(str);
//	  
//    		waypoints = 'los waypoints que devuelve';
//    		start = 'el punto de partida que devuelve';
//    		if(true){
//    			end = facultad;
//    		}
//    		else{
//    			end = 'la location del evento';
//    		}
//    		calcRoute();
//	  
//    		$('#detalleRecorrido').modal();
//    	})
//    });
});

$("#detalleRecorrido").on("shown.bs.modal", function () {
    google.maps.event.trigger(map, "resize");
});