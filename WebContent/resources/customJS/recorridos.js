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
        	 'targets' : [6, 7, 8, 9],
        	 'searchable' : false,
        	 'sortable' : false
         }
         ]
      });
    
	 $('.glyphicon-trash').click(function(){
		 if($(this).parent('recorridosTable')){
			 var row = $(this).parents('tr').children('td');
			 var idRecorrido = $(row[0]).text();
			 if(confirm('¿Seguro que desea eliminar el recorrido seleccionado?')){
				 window.location.href="borrarRecorrido?idRecorrido="+idRecorrido;
			 }
		 }
		 else{

		 }
	 })
	 
	 $('#detalleRecorrido').delegate('.glyphicon-trash', 'click', function(){
		 var idUsuario = $(this).data('id');
		 var idRecorrido = $(this).data('recorrido');
		 if(confirm('¿Seguro que desea eliminar el pasajero seleccionado?')){
			 //window.location.href="borrarRecorrido?idRecorrido="+idRecorrido; TODO
		 }
	 });
    
    $('.glyphicon-plus').click(function(){    	
    	$("#nombre").text('');
    	$("#propietario").text('');
    	$("#destino").text('');
    	$("#lugares").text('');
    	$("#tipo").text('');
    	$("#tramos").text('');
    	$("#fecha").text('');
    	$(".fecha").css('display', 'none');
    	$("#dias").text('');
    	$(".dias").css('display', 'none');
    	$("#horaIda").text('');
    	$(".horaIda").css('display', 'none');
    	$("#horaVuelta").text('');
    	$(".horaVuelta").css('display', 'none');
    	$("#precio").text('');
    	$("#participar").html('');
    	$("#nombre").html('');
    	$('#pasajeros').html('');
    	directionsDisplay.setMap(null);
    	waypoints = [];
    	start = null;
    	end = null;

    	var row = $(this).parents('tr').children('td');
    	var idRecorrido = $(row[0]).text();
    	$.ajax({
    		  type: "GET",
    		  url: "/PulpoPaul/buscarRecorrido",
    		  data: { idRecorrido: idRecorrido }
    	})
    	.fail(function() {
    		alert('Se ha producido un error al traer los datos del servidor');
    	})
    	.success(function(json){
    		console.log(json);
    		$("#nombre").text(json.nombre);
    		$("#propietario").text(json.propietario.nombres);
    		$("#lugares").text(json.lugares);
    		if(json.evento){
    			$("#destino").text(json.evento.nombre);
    		}
    		else{
    			$("#destino").text('FI - UNLP');
    		}
    		$("#tipo").text(json.tipo);
    		$("#tramos").text(json.tramo);
    		if(json.puntual){
    			$("#fecha").text(json.puntual);
    			$(".fecha").css('display', 'inline');
    		}
    		if(json.dias.length > 0){
    			$("#dias").text(json.dias);
    			$(".dias").css('display', 'inline');
    		}
    		if(json.horaSalida){
    			$("#horaIda").text(json.horaSalida);
    			$(".horaIda").css('display', 'inline');
    		}
    		if(json.horaVuelta){
    			$("#horaVuelta").text(json.horaVuelta);
    			$(".horaVuelta").css('display', 'inline');
    		}
    		$("#horaIda").text(json.horaSalida);
    		
    		$("#precio").text('$' + json.precio);
    		var propio = $('#propio').text();
    		if(json.pasajeros.length > 0){
    			var str = '';
    			for(i in json.pasajeros){
    				str += '<p>';
    				str += '<span class="glyphicon glyphicon-warning-sign" data-tipo="pasajero" data-id="' + json.pasajeros[i].id + '"></span>  ';
    				if(propio == 'si'){
    					str += '<span class="glyphicon glyphicon-trash" data-recorrido="' + idRecorrido + '" data-id="' + json.pasajeros[i].id + '"></span>  ';
    				}
    				str += json.pasajeros[i].nombres;
    				str += '</p>';
    			}
    			$('#pasajeros').append(str);
    		}
	  
    		var str = '<a href="/PulpoPaul/participarEnRecorrido?idRecorrido=' + $(row[0]).text() + '" class="btn btn-default col-sm-offset-8 col-sm-3">Participar!</a>';
    		$("#participar").append(str);
    		
    		$('#detalleRecorrido').modal();
    		
    		for(i in json.puntos){
    			var str = json.puntos[i].substring(1, str.length - 1);
    			var latlng = str.split(',');
    			waypoints.push({
    				location: new google.maps.LatLng(parseFloat(latlng[0]), parseFloat(latlng[1])),
    				stopover: true
    			});
    		}
    		start = json.inicio;
    		if(typeof(json.evento) == 'object'){
    			end = json.fin;
    		}
    		else{
    			end = facultad;
    		}
    		calcRoute();
    	})
    });
    
    var idDenunciado;
    var tipoDenunciado;
    $('#pasajeros').delegate('.glyphicon-warning-sign', 'click', function(){
    	iniciarDenuncia(this);
    });
    
    $('.glyphicon-warning-sign').click(function(){
    	iniciarDenuncia(this)
    });
    
    var iniciarDenuncia = function(elemento){
    	idDenunciado = $(elemento).data('id');
    	tipoDenunciado = $(elemento).data('tipo');
    	if(tipoDenunciado == 'pasajero' && idDenunciado == $('#idUsuario').text()){
    		alert('No te podes denunciar a vos mismo');
    	}
    	else{
        	$('#tipoDenuncia').text(tipoDenunciado);
        	$('#denuncia').modal();
    	}
    };
    
    $('#denunciar').click(function(){
    	var motivo = $('#motivo').val();
    	if(motivo != ''){
    		var  string = '/PulpoPaul/nuevaDenuncia?motivo=' + motivo;
    		if(tipoDenunciado == 'recorrido'){
    			string += '&idRecorrido=';
    		}
    		else{
    			string += '&idDenunciado=';
    		}
    		window.location.href = string + idDenunciado;
    	}
    	else{
    		alert('Debe ingresar un motivo para la denuncia');
    	}
    });
});

$("#detalleRecorrido").on("shown.bs.modal", function () {
    google.maps.event.trigger(map, "resize");
});