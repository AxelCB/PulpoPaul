var mostrarModalNuevoUsuario = function(){
	$('#nuevo-usuario').modal('show');
}

var mostrarModalEliminar= function(){
	$('#eliminar-elemento').modal('show');
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