var mostrarModalNuevoUsuario = function(){
	$('#nuevo-usuario').modal('show');
}

var mostrarModalEliminar= function(){
	$('#eliminar-elemento').modal('show');
}

///////////////////////
// FUNCIONES //////////
///////////////////////

function formatTime(element) {
    var result = false, m;
    var time = element.value;
    var re = /^\s*([01]?\d|2[0-3]):?([0-5]\d)\s*$/;
    if ((m = time.match(re))) {
        result = (m[1].length == 2 ? "" : "0") + m[1] + ":" + m[2];
        element.value=result;
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