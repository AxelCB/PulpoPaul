///////////////////////
// MAPA ///////////////
///////////////////////
var map;
var mapDetalle;
var marker;
var markerDetalle;

function initialize(){
	var laPlata = new google.maps.LatLng(-34.922066, -57.954094);
	var mapOptions = {
		zoom: 13,
		center: laPlata,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		draggable: true
	};
	map = new google.maps.Map(document.getElementById('map'), mapOptions);
	google.maps.event.addListener(map, 'click', function(e){
		addMarker(e.latLng);
	});
	
	mapOptions = {
			zoom: 13,
			mapTypeID: google.maps.MapTypeId.ROADMAP,
			draggable: true
	}
	mapDetalle = new google.maps.Map(document.getElementById('mapDetalle'), mapOptions);
}

function addMarker(location){
	if(marker != undefined){
		marker.setMap(null);
	}
	marker = new google.maps.Marker({
        position: location, 
        map: map
    });
	map.setCenter(location);
	
	$('#puntos').html('');
	var input = '<input type="text" name="latLng"value="' + location + '"/>';
	$('#puntos').append(input);
}

google.maps.event.addDomListener(window, 'load', initialize);

///////////////////////
// MODALS /////////////
///////////////////////

var mostrarModalNuevoEvento = function(){
	$('#nuevo-evento').modal('show');
	marker = undefined;
}

$("#nuevo-evento").on("shown.bs.modal", function () {
    google.maps.event.trigger(map, "resize");
});

$("#detalle-mapa").on("shown.bs.modal", function () {
    google.maps.event.trigger(mapDetalle, "resize");
});

var mostrarModalMapa = function(latLng){
	latLng = latLng.substring(1, latLng.length - 1);
	var stringArray = [];
	stringArray = latLng.split(',');
	
	$('#detalle-mapa').modal('show');
	
	var punto = new google.maps.LatLng(stringArray[0], stringArray[1]);
	if(markerDetalle != undefined){
		markerDetalle.setMap(null);
	}
	markerDetalle = new google.maps.Marker({
		position : punto,
		map: mapDetalle
	})
	mapDetalle.setCenter(punto);
}

///////////////////////
// DATEPICKER /////////
///////////////////////
$(function() {
    $( "#fecha" ).datepicker({
    	format : "dd-mm-yyyy"
    });
});

///////////////////////
// DATATABLE //////////
///////////////////////
$(document).ready(function() {
	$('#eventosTable').DataTable({
    	'language': {
    		'url': '//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json'
        },
        'order' : [[3, "asc"]],
        'searching' : true,
        'processing' : false,
        'columnDefs' : [
        {
        	'targets' : [4, 5, 6, 7, 8,],
        	'sortable' : false,
        	'searchable' : false
        }
        ]
      });
      
});

///////////////////////
// PRESUBMIT //////////
///////////////////////
$('#guardar').click(function(event){
	if(marker == undefined){
		event.preventDefault();
		alert('Haga click en el mapa para seleccionar la ubicación del evento');
	}
	else{
		$(this).unbind('submit').submit();
	}
});  
