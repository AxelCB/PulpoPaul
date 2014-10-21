var cambiarFrecuencia=function(){
	var valorSeleccionado = $('#frecuenciaViaje').val();
	if(valorSeleccionado =='diario'){
		$('.periodico').css('display','none');
		$('.puntual').css('display','none');
	}else{
		if(valorSeleccionado=='periodico'){
			$('.periodico').css('display','inline');
			$('.puntual').css('display','none');
		}else{ //es puntual
			$('.periodico').css('display','none');
			$('.puntual').css('display','inline');
			$(function(){
				$('#fechaPuntual').datepicker({
					format: 'dd-mm-yyyy'
				});	
			});
		}
	}
};
var cambiarIdaOVuelta=function(){
	var valorSeleccionado = $('#idaOVuelta').val();
	if(valorSeleccionado =='ida'){
		$('.ida').css('display','inline');
		$('.vuelta').css('display','none');
	}else{
		if(valorSeleccionado=='vuelta'){
			$('.ida').css('display','none');
			$('.vuelta').css('display','inline');
		}else{ //es ida y vuelta
			$('.ida').css('display','inline');
			$('.vuelta').css('display','inline');
		}
	}
};
var cambiarRolViaje=function(){
	var valorSeleccionado = $('#rolViaje').val();
	if(valorSeleccionado =='pasajero'){
		$('.asientos').css('display','none');
	}else{
		$('.asientos').css('display','inline');
	}
};