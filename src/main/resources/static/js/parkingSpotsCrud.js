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
        if(id != -1){
        	let originalRow = $('#crud-table').find(`[object-id="${id}"]`);
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
		let enabledValue = editableRow.find('input[name="enabled"]').prop('checked');
		let number = editableRow.find('input[name="number"]').val();
		let sector = editableRow.find('input[name="sector"]').val();
		 
		
		let originalRow = $('#crud-table').find(`[object-id="${id}"]`);
        
		createUpdateObject(id, enabledValue, number, sector, originalRow, editableRow);

    });
  
  //click editar
   crudTable.on('click', '.update-btn', function() {
        let button = $(this);
        let originalRow = button.closest('tr');
        let objectId = originalRow.attr('object-id');
        
        //clonar id a la fila Editable
        let newRow = templateRow.clone().removeClass('template-row').removeAttr('style');
        newRow.find('td:first-child').text(objectId);
        newRow.find('input[name="enabled"]').prop('checked', originalRow.find('input[name="enabled"]').prop('checked'));
        newRow.find('input[name="number"]').val(originalRow.find('td:nth-child(3)').text());
        newRow.find('input[name="sector"]').val(originalRow.find('td:nth-child(4)').text());
        
		newRow.attr('edit-object-id', objectId);
		originalRow.hide();
        originalRow.after(newRow);
        //se reemplaza el id de la fila original a la fila editable
    });
    
    function restoreTable(originalRow, editableRow){
		editableRow.remove();
    	originalRow.show();
	}

	//funcion formHandler
	function createUpdateObject(id, enabledValue, number, sector, originalRow, editableRow){
		
		let data = {id:id, enabled:enabledValue, number:number, sector:sector} 
		
	 	$.ajax({
			  url: 'parkingSpots/crud', 
			  type: 'POST',
			  data: JSON.stringify(data),
			  contentType: 'application/json',
			  beforeSend: function() {
		      	crudTable.find(`[object-id="${id}"]`).find(".spinner-border").show();
		      },
			  success: function(response) {
				originalRow = crudTable.find(`[object-id="${id}"]`);
				originalRow.attr('object-id', response )
				originalRow.find('td:first-child').text(response);
				originalRow.find('input[type="checkbox"]').prop('checked', enabledValue);				
				originalRow.find('td:nth-child(3)').text(number);
			    originalRow.find('td:nth-child(4)').text(sector);
				 
			  },
			  error: function(xhr, status, error) {
		
				console.log(xhr.responseText);
				console.log(status);
				console.log(error);
					
			    alert('Se produjo un error al confirmar los cambios: ' + error);
			  },
			  complete: function(){
				crudTable.find(`[object-id="${id}"]`).find(".spinner-border").hide();
				restoreTable(originalRow, editableRow);
			}
			});
	}
  
  
  
  
});

