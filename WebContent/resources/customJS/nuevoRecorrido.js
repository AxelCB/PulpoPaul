///////////////////////
// MAPA ///////////////
///////////////////////
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var geocoder;
var infowindow;
var waypoints;
var start;
var facultad = new google.maps.LatLng(-34.90364261359886, -57.93748378753662);
var end;

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
	
	cambiarFrecuencia();
	cambiarIdaOVuelta();
	cambiarDestino();
	cambiarEvento();

	waypoints = window.waypointsOints || new Array();
	start = window.startPoint || null;
	end = window.endPoint || facultad;
	if(start){
		calcRoute();
	}
}
	
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
			directionsDisplay.setMap(map)
			directionsDisplay.setDirections(response);
		}
	})
}

//No me trae los datos que me interesan
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
		reset();
	}
	else{
		waypoints.pop();
		calcRoute();
	}
}

function reset(){
	start = null;
	directionsDisplay.setMap(null);
	waypoints = [];
	//infowindow.open(null);	
}

google.maps.event.addDomListener(window, 'load', initialize);

///////////////////////
// CALENDARIO /////////
///////////////////////
$('#fechaPuntual').datepicker({
	format: 'dd-mm-yyyy'
});

///////////////////////
// FUNCIONES //////////
///////////////////////
var cambiarFrecuencia = function(){
	var valorSeleccionado = $('#frecuencia').val();
	if(valorSeleccionado =='diario'){
		$('.periodico').css('display','none');
		$('.puntual').css('display','none');
		$('#fechaPuntual').prop('required', false);
	}
	else{
		if(valorSeleccionado == 'periodico'){
			$('.periodico').css('display','inline');
			$('.puntual').css('display','none');
			$('#fechaPuntual').prop('required', false);
		}
		else{ //es puntual
			$('.periodico').css('display','none');
			$('.puntual').css('display','inline');
			$('#fechaPuntual').prop('required', true);
		}
	}
};

var cambiarIdaOVuelta = function(){
	var valorSeleccionado = $('#idaOVuelta').val();
	if(valorSeleccionado =='ida'){
		$('.ida').css('display','inline');
		$('#partida').prop('required', true);
		$('.vuelta').css('display','none');
		$('#regreso').prop('required', false);
	}
	else{
		if(valorSeleccionado=='vuelta'){
			$('.ida').css('display','none');
			$('#partida').prop('required', false);
			$('.vuelta').css('display','inline');
			$('#regreso').prop('required', true);
		}
		else{ //es ida y vuelta
			$('.ida').css('display','inline');
			$('#partida').prop('required', true);
			$('.vuelta').css('display','inline');
			$('#regreso').prop('required', true);
		}
	}
};

var cambiarDestino = function(){
	if($('#destino').val() == 'evento'){
		$('#evento').prop('required', true);
		$('.evento').css('display','inline');
		$('.frecuencia').css('display', 'none');
		$('.periodico').css('display','none');
		$('.puntual').css('display','none');
		cambiarEvento();
	}
	else{
		$('.evento').css('display','none');
		$('#evento').prop('required', false);
		$('.frecuencia').css('display', 'inline');
		cambiarFrecuencia();
		reset();
		end = facultad;
	}
}

var cambiarEvento = function(){
	reset();
	if($('#evento').val() != ''){
		var str = $('#evento').find(':selected').data('latlng');
		str = str.substring(1, str.length - 1);
		var latlng = str.split(',');
		end = new google.maps.LatLng(parseFloat(latlng[0]), parseFloat(latlng[1]));
		if(start != null){
			calcRoute();
		}
	}
	else{
		end = null;
	}
}

var checkHora = function(element){
	var patron=/^(0[1-9]|1\d|2[0-3]):([0-5]\d)(:([0-5]\d))?$/;
	if (!patron.test($(element).val())){
		alert('La hora debe cumplir con el formato HH:MM');
		$(element).val('');
		$(element).focus();
	}	
}

function formatTime(element) {
    var result = false, m;
    var time = element.value;
    var re = /^\s*([01]?\d|2[0-3]):?([0-5]\d)\s*$/;
    if ((m = time.match(re))) {
        result = (m[1].length == 2 ? "" : "0") + m[1] + ":" + m[2];
        element.value=result;
    }
}

//esto es de otro lado, cambiarlo de lugar
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
// PRESUBMIT //////////
///////////////////////

$('#agregar').click(function(event){
	if($('#destino').val() == 'evento' && $('#evento').val() == ''){
		event.preventDefault();
		alert('Debe seleccionar un evento');
	}
	else{
		if(start == null){
			event.preventDefault();
			alert('Haga click en el mapa para armar el recorrido');
		}
		else{
			$(this).unbind('submit').submit();
			
			$('#puntos').html('');
			var input = '';
			input = '<input type="text" name="start" value="' + start +'">';
			$('#puntos').append(input);
			input = '<input type="text" name="end" value="' + end +'">';
			$('#puntos').append(input);
			for(var i = 0; i < waypoints.length; i++){
				input = '<input type="text" name="waypoints" value="' + waypoints[i].location +'">';
				$('#puntos').append(input);
			}
		}
	}
})