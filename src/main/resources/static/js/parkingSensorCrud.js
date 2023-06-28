$(document).ready(function() {
  	let addBtn = $('#add-btn');
  	let crudTable = $('#crud-table');
	let templateRow = crudTable.find('.template-row');	
	
	
	//click agregar
  	addBtn.on('click', function() {
		/*se clona la fila plantilla, 
		se agrega la fila editable al principio de tabla 
		*/
    	let editableRow = templateRow.clone().removeClass('template-row').attr('edit-object-id', -1).show();
    	let newRow =  crudTable.find(".blank-row").clone().removeClass('blank-row').attr('object-id', -1);
    	crudTable.find('tbody').prepend(editableRow);
    	crudTable.find('.blank-row').before(newRow);
	});
	
	//click cancelar
  	crudTable.on('click', '.cancel-btn', function() {
		/*se elimina la fila editable*/
        let editableRow = $(this).closest('tr')
        let id = editableRow.attr('edit-object-id')
        let originalRow;
        if(id != -1){
        	originalRow = $('#crud-table').find(`[object-id="${id}"]`);
        	restoreTable(originalRow, editableRow)
    	}
    	else{
					editableRow.remove();
		}
    });

	//click guardar
	crudTable.on('click', '.save-btn', function() {
		//recopila info editada y la envia al formHandler
		let editableRow = $(this).closest('tr');
		let id = editableRow.attr('edit-object-id');
		let originalRow = $('#crud-table').find(`[object-id="${id}"]`);
		
		let enabledValue = editableRow.find('input[name="enabled"]').prop('checked');		
		let number = editableRow.find('td:nth-child(4) select').val() ?? '';
		number = number.slice(0, number.indexOf("-"));
		let sector = editableRow.find('td:nth-child(4) select').val() ?? '';
		sector = sector.trim().slice(sector.indexOf("-")+1);		
		let deviceId = originalRow.find("td:last-child").attr("device-id");
		  
		createUpdateObject(id, enabledValue, number, sector, deviceId, /*spotId,*/ originalRow, editableRow);
    });
  
  //click editar
   crudTable.on('click', '.update-btn', function() {
        let button = $(this);
        let originalRow = button.closest('tr');
        let objectId = originalRow.attr('object-id');
        
        originalRow.hide();
                
		//se clonan los datos de la fila original a la editable
        let newRow = templateRow.clone().removeClass('template-row').removeAttr('style');
    	  newRow.find('td:nth-child(1)').text(originalRow.find('td:nth-child(1)').text());
    	  newRow.find('input[name="enabled"]').prop('checked', originalRow.find('input[name="enabled"]').prop('checked'));
	      newRow.find('input[name="available"]').prop('checked', originalRow.find('input[name="available"]').prop('checked')).prop('disabled', true);
		  newRow.find('td:nth-child(4) select').val(originalRow.find('td:nth-child(4)').text());
		  newRow.find('td:nth-child(5) select').val(originalRow.find('td:nth-child(5)').text());
		  
		newRow.attr('edit-object-id', objectId);
        originalRow.after(newRow);
        //se reemplaza el id de la fila original a la fila editableS
    });
    
    function restoreTable(originalRow, editableRow){
		editableRow.remove();
    	originalRow.show();
	}

	//funcion formHandler
	function createUpdateObject(id, enabledValue, number, sector,deviceId,/* spotId,*/ originalRow, editableRow){
		
		let data = {/*id: spotId,*/ sector: sector, number: number, parkingSensor: {id : id, enabled : enabledValue, device:{id:deviceId}} } 
		
		$.ajax({
			  url: '/devices/parkingSensor/crud', 
			  type: 'POST',
			  data: JSON.stringify(data),
			  contentType: 'application/json',
			  beforeSend: function() {
			  	crudTable.find(`[object-id="${id}"]`).find(".spinner-border").show();
			  },
			  success: function(response) {
				//se reemplazan los datos editados
				originalRow.attr('object-id', response )
				originalRow.find('td:nth-child(1)').text(response);
			    originalRow.find('input[name="enabled"]').prop('checked', enabledValue).prop('disabled', true);
			  	originalRow.find('td:nth-child(4)').text(number != ""? number : "no asignada");
			  	originalRow.find('td:nth-child(5)').text(sector != ""? sector : "no asignado")
								
			  },
			  error: function(xhr, status, error) {
			
				console.log(xhr.responseText);
				console.log(status);
				console.log(error);
					
			    alert('Se produjo un error al confirmar los cambios: ' + error);
			  },
			  complete: function(){
				$(".spinner-border").hide();
				restoreTable(originalRow, editableRow);
			  }
		});
	}
  
  
  
  
});

