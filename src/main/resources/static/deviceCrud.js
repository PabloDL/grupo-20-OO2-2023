$(document).ready(function() {
  	const addBtn = $('#add-btn');
  	const crudTable = $('#crud-table');
	const templateRow = crudTable.find('.template-row');	
	
	//click agregar
  	addBtn.on('click', function() {
		/*se clona la fila plantilla, 
		se quita la etiqueta de plantilla a la nueva fila editable
		se quita el hidden
		se agrega la fila editable al principio de tabla 
		*/
    	const newRow = templateRow.clone().removeClass('template-row').show();
    	crudTable.find('tbody').prepend(newRow);
	});
	
	//click cancelar
  	crudTable.on('click', '.cancel-btn', function() {
		/*se elimina la fila editable*/
        const newRow = $(this).closest('tr').remove();
    });

	//click guardar
    crudTable.on('click', '.save-btn', function() {
        const newRow = $(this).closest('tr');
        const enabledValue = newRow.find('input[name="enabled"]').prop('checked');
        const nameValue = newRow.find('input[name="name"]').val();
		

        createUpdateObject(-1, enabledValue, nameValue, newRow);

        newRow.remove();
    });
  
  //click editar
   crudTable.on('click', '.update-btn', function() {
        const button = $(this);
        const deviceId = button.data('device-id');
        const row = button.closest('tr');
        row.attr("object-id", deviceId);
        row.hide();
        //clonar id a la newRow

        const newRow = templateRow.clone().removeClass('template-row').removeAttr('style');
        newRow.find('input[name="enabled"]').prop('checked', row.find('input[name="enabled"]').prop('checked'));
        newRow.find('input[name="name"]').val(row.find('td:nth-child(2)').text());
		newRow.find('.save-btn').attr('id', deviceId);
        row.after(newRow);
	
		//click cancelar en fila editada
        newRow.find('.cancel-btn').on('click', function() {
            newRow.remove();
            row.show();
        });

		//click guardar en fila editada
        newRow.find('.save-btn').on('click', function() {
            const enabledValue = newRow.find('input[name="enabled"]').val();
            const nameValue = newRow.find('input[name="name"]').val();
            const id = newRow.find('.save-btn').attr('id');
	
           createUpdateObject(id, enabledValue, nameValue, row);

            newRow.remove();
            row.show();
        });
    });

	//funcion envio de formulario
	function createUpdateObject(id, enabledValue, nameValue,row){
		
		let data = {id:id, enabled:enabledValue === "on" ? true : false, name:nameValue} 
		row.find(".spinner-border").show();
		
		$.ajaxSetup({
		  headers: {
		    'Content-Type': 'application/json'
		  }
		});
		
	 	$.ajax({
			  url: 'devices/crud', 
			  type: 'POST',
			  data: JSON.stringify(data),
			  contentType: 'application/json',
			  success: function(response) {
				
				row.find('input[name="enabled"]').val(data.enabled);
				row.find('input[name="name"]').val(data.name);
			    alert('Cambios confirmados correctamente');
			  },
			  error: function(xhr, status, error) {
		
				console.log(xhr.responseText);
				console.log(status);
				console.log(error);
		
			
			    alert('Se produjo un error al confirmar los cambios: ' + error);
			  },
			  complete: function(){
				$(".spinner-border").hide();
			}
			});
	}
  
  
  
  
});
