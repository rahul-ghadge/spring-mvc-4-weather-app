



function simpleCall() {
	
	var city = $("#city").val();
	
	var request = $.ajax({
	    url: '../weather-app/city?name=' + city,
	    type: 'GET',
	    contentType: 'application/json; charset=utf-8'
	});

	request.done(function(dataArray) {
		
		console.log(dataArray)
		
		
	    for(var i =0;i < dataArray.length-1;i++)
	    	{
	    	//var data = dataArray[i];  
			    $("#output").html(
			    `<h4 class="mb-3">Weather details of &nbsp;<span>${dataArray[i].name}</span></h4>
			    <hr style="border: 1px dashed">
			    <div class="row px-4">
			    <p>Id : ${dataArray[i].id}</p>
			    <p class="ml-auto">Code : ${dataArray[i].cod}</p>
			    </div>
			    <div class="row px-4">
			    <p>Latitude : ${dataArray[i].coord.lat}</p>
			    <p  class="ml-auto">Longitude : ${dataArray[i].coord.lon}</p>
			    </div>`);
	    	}

	    
	});
	
	if($('.output-wrapper li').length > 0){
	    $('.output-wrapper li').css("display","block");
	  }
	
	request.fail(function(error) {
	    $('#error').append('Error: ' + errorMessage);
	    console.log(error);
	});
}


/*
 * $("button").click(function(){
 * 
 * 
 * });
 */
// $("button").click(function(){
// $.ajax({url: "/assets/data.json", success: function(result){
// $("#output").html(result);
// }, Error: function(error){
// $('#error').append('Error: ' + errorMessage);
// },
// type: "get",
// dataType: 'json',
// timeout: 500
// });
// });


// var subtext = 'uk&appid=b6907d289e10d714a6e88b30761fae22';
// $.ajax({
// url: "https://samples.openweathermap.org/data/2.5/weather?q=London,+subtext",
// type: "get", //send it through get method
// data: {
// ajaxid: 4,
// UserID: UserID,
// EmailAddress: EmailAddress
// },
// success: function(response) {
// //Do Something
// },
// error: function(xhr) {
// //Do Something to handle error
// }
// });


// var ajaxReq = $.ajax('api.openweathermap.org/data/2.5/weather?q=London', {
// dataType: 'json',
// timeout: 500
// });

// ajaxReq.success(function (data, status, jqXhr) {
// $('#output').append(data.coord + ' ' + data.weather);
// })

// ajaxReq.error(function (jqXhr, textStatus, errorMessage) {
// $('#error').append('Error: ' + errorMessage);
// })
