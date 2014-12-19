var mostrarModalNuevoUsuario = function(){
	$('#nuevo-usuario').modal('show');
}

var mostrarModalNuevoEvento = function(){
	$('#nuevo-evento').modal('show');
}

var mostrarModalEliminar= function(){
	$('#eliminar-elemento').modal('show');
}

var mostrarModalMapa = function(latitud,longitud){
	$('#latitudModal').val(latitud);
	$('#longitudModal').val(longitud);
	$('#detalle-mapa').modal('show');
}