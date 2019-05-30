/**
 * 
 */
 /**
 * 
 */
 
$(document).on("click", "#btnSave", function(){
	 
	var validity = isValidFormItem(); 
	if (validity == "true"){ 
		
		var method = "post";
		if ($("#id").val() != "0"){
		 
			method = "create";
		}
	 	$("#divStsMsgItem").html("Saving...");
		$.ajax({
		 
			type : method,
		 	url : "ItemDAO",
		 	data : $("#formItems").serialize(),
		 	complete : function(response, status){
		 
		 		onSaveUpdateComplete(response.responseText, status);
		 	}
		});
	}else{
		$("#divStsMsgItem").html(validity); 
	}
});

 function isValidFormItem()
{
	if ($.trim($("#name").val()) == "") {
		 return "Enter Item Name";
		 
	}
	if ($.trim($("#brand").val()) == "") {
		 return "Enter Brand";	 
	}
	if ($.trim($("#qty").val()) == "") {
		 return "Enter Quantity";	 
	}
	if ($.trim($("#color").val()) == "") {
		 return "Enter Color";	 
	}
	
	
	return "true";
} 

function onSaveUpdateComplete(response, status){
		
	if (status == "success"){
	 
		$("#formItems")[0].reset();
	 	$("#divItemsTable").html(response);
	 	$("#divStsMsgItem").html("Saved successfully");
	 	$("#id").val("0");
	}
	else if (status == "error"){
	 
		$("#divStsMsgItem").html("Error while saving");
	}
	else{
	 
		$("#divStsMsgItem").html("Unknown error while saving");
	}
}
 
$(document).on("click", "#btnEdit", function(){
			 
		$("#id").val($(this).data("id"));
		$("#name").val($(this).closest("tr").find("td:eq(1)").text());
		$("#brand").val($(this).closest("tr").find("td:eq(2)").text());
		$("#qty").val($(this).closest("tr").find("td:eq(3)").text());
		$("#color").val($(this).closest("tr").find("td:eq(4)").text());
	}); 
	$(document).on("click", "#btnRemove", function(){
			 
		$("#divStsMsgItem").html("Removing...");
		$.ajax({
			 
			type : "delete",
			url : "ItemDAO",
			data : "id=" + $(this).data("id"),
			complete : function(response, status){
			 
				onItemDeleteComplete(response.responseText, status);
			}
		});
});
 
function onItemDeleteComplete(response, status){
			
	if (status == "success"){
		 
		$("#divItemsTable").html(response);
		$("#divStsMsgItem").html("Removed successfully");
	}
	else if (status == "error"){
		 
		$("#divStsMsgItem").html("Error while removing");
	}
	else{
		 
		$("#divStsMsgItem").html("Unknown error while removing");
	}
} 
 