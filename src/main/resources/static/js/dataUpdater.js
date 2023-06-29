$(document).ready(function() {
  	let dataDiv = $('#content');
	

	//click simular
	dataDiv.on('click', '.sim-btn', function() {
		let clickedRow = $(this).closest('tr')
		let parkingSpotId = clickedRow.attr('spot-id');
		let availableValue = clickedRow.find('input[name="available"]').prop('checked');
		let sensorid = clickedRow.find('input[name="available"]').attr("sensor-id");
		simulateParking(parkingSpotId, sensorid, availableValue, clickedRow);
    });
  
	//funcion formHandler
	function simulateParking(spotId, sensorId, availableValue, clickedRow){
		
		let data = {id:sensorId,  available:availableValue}
		
	 	$.ajax({
			  url: '/simulateParking', 
			  type: 'POST',
			  data: JSON.stringify(data),
			  contentType: 'application/json',
			  beforeSend: function() {
		      	clickedRow.find(".spinner-border").show();
		      },
			  success: function(response) {
				
				let similarRows = $("#content").find(`[spot-id="${spotId}"]`);
				similarRows.find('input[name="available"]').prop('checked', response == 'true');
			  },
			  error: function(xhr, status, error) {
		
				console.log(xhr.responseText);
				console.log(status);
				console.log(error);
					
			    alert('Se produjo un error al confirmar los cambios: ' + error);
			  },
			  complete: function(){
				$(".spinner-border").hide();
				if(availableValue){
					clickedRow.find('a .sim-btn.btn-warning').hide();
					clickedRow.find('a .sim-btn.btn-danger').show();
				}
				else{
					clickedRow.find('a .sim-btn.btn-warning').show();
					clickedRow.find('a .sim-btn.btn-danger').hide();
				}
			}
		});
	}
});