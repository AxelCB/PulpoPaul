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

function formatTime(element) {
    var result = false, m;
    var time = element.value;
    var re = /^\s*([01]?\d|2[0-3]):?([0-5]\d)\s*$/;
    if ((m = time.match(re))) {
        result = (m[1].length == 2 ? "" : "0") + m[1] + ":" + m[2];
        element.value=result;
    }
    //return result;
}
function validateTime(time) {
    var re = /^\s*([01]?\d|2[0-3]):?([0-5]\d)\s*$/;
    if (time.match(re)) {
    	return true;
    }
    return false;
}