var mostrarModalNuevoUsuario = function(){
	$('#nuevo-usuario').modal('show');
}

var mostrarModalNuevoEvento = function(){
	$('#nuevo-evento').modal('show');
}

var mostrarModalEliminar= function(){
	$('#eliminar-elemento').modal('show');
}

var mostrarModalMapa = function(latLng){
	var latitud="",longitud="",stringArray=[];
	stringArray = latLng.split(',');
	latitud = stringArray[0].slice(1);
	longitud = stringArray[1].slice(0,stringArray[1].length);
	//TODO parse LatLng into latitud and longitud
	$('#latitudModal').val(latitud);
	$('#longitudModal').val(longitud);
	$('#detalle-mapa').modal('show');
}