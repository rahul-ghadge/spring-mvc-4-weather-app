

function getWeatherData() {
	
	var city = $("#city").val();
	
	if(city == undefined || city == '') {
		alert("Please enter city(or cities)");
		return;
	}
		
		
	
	var request = $.ajax({
	    url: '../weather-app/city?name=' + city,
	    type: 'GET',
	    contentType: 'application/json; charset=utf-8'
	});

	request.done(function(dataArray) {
		
		console.log(dataArray)
	
	    $("#output").html(			    		
	    `<h4 class="mb-3">Weather details of &nbsp;<span>${dataArray[0].name}</span></h4>
	    <hr style="border: 1px dashed">
	    <div class="row px-4">
	    <p>Id : ${dataArray[0].id}</p>
	    <p class="ml-auto">Code : ${dataArray[0].cod}</p>
	    </div>
	    <div class="row px-4">
	    <p>Latitude : ${dataArray[0].coord.lat}</p>
	    <p  class="ml-auto">Longitude : ${dataArray[0].coord.lon}</p>
	    </div>`);
	    
	});
	
	if($('.output-wrapper li').length > 0){
	    $('.output-wrapper li').css("display","block");
	  }
	
	request.fail(function(error) {
	    $('#error').append('Error: ' + errorMessage);
	    console.log(error);
	});
}