///////////////////////
// CALENDARIO /////////
///////////////////////
$('#fechaPuntual').datepicker({
	format: 'dd-mm-yyyy',
	language: 'es'
});

///////////////////////
// FUNCIONES //////////
///////////////////////
var cambiarFrecuencia = function(){
	var valorSeleccionado = $('#frecuencia').val();
	if(valorSeleccionado =='diario'){
		$('.periodico').css('display','none');
		$('.puntual').css('display','none');
	}
	else{
		if(valorSeleccionado == 'periodico'){
			$('.periodico').css('display','inline');
			$('.puntual').css('display','none');
		}
		else{ //es puntual
			$('.periodico').css('display','none');
			$('.puntual').css('display','inline');
		}
	}
};

var cambiarIdaOVuelta = function(){
	var valorSeleccionado = $('#idaOVuelta').val();
	if(valorSeleccionado =='ida'){
		$('.ida').css('display','inline');
		$('.vuelta').css('display','none');
	}
	else{
		if(valorSeleccionado=='vuelta'){
			$('.ida').css('display','none');
			$('.vuelta').css('display','inline');
		}
		else{ //es ida y vuelta
			$('.ida').css('display','inline');
			$('.vuelta').css('display','inline');
		}
	}
};

var cambiarDestino = function(){
	if($('#destino').val() == 'evento'){
		$('.evento').css('display', 'inline');
		$('#frecuencia').prop('disabled', true);
		$('#frecuencia').val('puntual');
	}
	else{
		$('.evento').css('display', 'none');
		$('#frecuencia').prop('disabled', false);
		$('#frecuencia').val('diario');
	}
}

var toogleBusqueda = function(){
	if($('#parametros').css('display') == 'none'){
		$('#parametros').css('display','inline');
		$('#viajes').css('display','none');
	}
	else{
		$('#parametros').css('display','none');
		$('#viajes').css('display','inline');
	}
}


///////////////////////
// MAPA ///////////////
///////////////////////
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var facultad = new google.maps.LatLng(-34.90364261359886, -57.93748378753662);
var map;
var geocoder;
var infowindow;
var waypoints = [];
var start = null;

function initialize(){
	directionsDisplay = new google.maps.DirectionsRenderer();
	geocoder = new google.maps.Geocoder();
	var laPlata = new google.maps.LatLng(-34.922066, -57.954094);
	var mapOptions = {
		zoom: 13,
		center: laPlata,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		draggable: true
	};
	map = new google.maps.Map(document.getElementById('map'), mapOptions);
	
	google.maps.event.addListener(map, 'click', function(e){
		addHito(e.latLng)
	});
}
	
function calcRoute(){
	var request = {
		origin: start,
		destination: facultad,
		travelMode: google.maps.TravelMode.DRIVING,
		optimizeWaypoints: true,
		waypoints: waypoints
	}
	
	directionsService.route(request, function(response, status){
		if(status == google.maps.DirectionsStatus.OK){
			directionsDisplay.setMap(map)
			directionsDisplay.setDirections(response);
		}
	})
}

function getAdress(){
	geocoder.geocode({'latLng': start}, function(results, status){
		if(status == google.maps.GeocoderStatus.OK){
			if(results[1]){
				infowindow = new google.maps.InfoWindow({position: start});
				infowindow.setContent(results[1].formatted_address);
				infowindow.open(map);
			}
		}
	})
}
	
function addHito(position){
	if(start == null){
		start = position;
		//getAdress();
	}
	else{
		waypoints.push({
			location: position,
			stopover: true
		})
	}
	calcRoute();
}

function removeHito(position){
	if(waypoints.length === 0){
		start = null;
		directionsDisplay.setMap(null);
		infowindow.open(null);
	}
	else{
		waypoints.pop();
		calcRoute();
	}
}

google.maps.event.addDomListener(window, 'load', initialize);

///////////////////////
// VALIDACIONES ///////
///////////////////////

$('#agregar').click(function(event){
	var input = '';
	input = '<input type="text" name="start" value="' + start +'">';
	$('#puntos').append(input);
	input = '<input type="text" name="end" value="' + facultad +'">';
	$('#puntos').append(input);
	for(var i = 0; i < waypoints.length; i++){
		input = '<input type="text" name="waypoints" value="' + waypoints[i].location +'">';
		$('#puntos').append(input);
	}
})


















