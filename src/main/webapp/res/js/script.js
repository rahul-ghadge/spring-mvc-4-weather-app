var query = $("#searchItem").value;


$("button").click(function(){
var request = $.ajax({
    url: '/assets/data.json',
    type: 'GET',
    data: { field1: "query"} ,
    contentType: 'application/json; charset=utf-8'
});

request.done(function(data) {
    $("#output").html(
    `<h3>${data.clouds}</h3>
    <p><span class="logo">${data.loc}</span> ${data.main} mi</p>
    <p class="stores-desc">Testing</p>
    <p class="stores-timing"><strong> Test &nbsp;</strong>  
      0:00 am - 0:00 pm &nbsp; <strong>tst</strong>  ${data.main} pm  &nbsp;
      <strong> tst&nbsp;</strong>  0:00 am - 0:00 pm</p>
    <div class="store-checkin">Click here</div>
    </div>`);
    


    console.log(data)
});
request.fail(function(error) {
    $('#error').append('Error: ' + errorMessage);
    console.log(error);
});

});
// $("button").click(function(){
//     $.ajax({url: "/assets/data.json", success: function(result){
//       $("#output").html(result);
//     }, Error: function(error){
//        $('#error').append('Error: ' + errorMessage);  
//     },
//     type: "get",
//     dataType: 'json',
//     timeout: 500
// });
//   });


// var subtext = 'uk&appid=b6907d289e10d714a6e88b30761fae22';
//   $.ajax({
//     url: "https://samples.openweathermap.org/data/2.5/weather?q=London,+subtext",
//     type: "get", //send it through get method
//     data: { 
//       ajaxid: 4, 
//       UserID: UserID, 
//       EmailAddress: EmailAddress
//     },
//     success: function(response) {
//       //Do Something
//     },
//     error: function(xhr) {
//       //Do Something to handle error
//     }
//   });


// var ajaxReq = $.ajax('api.openweathermap.org/data/2.5/weather?q=London', {
//     dataType: 'json',
//     timeout: 500
// });

// ajaxReq.success(function (data, status, jqXhr) {
// $('#output').append(data.coord + ' ' + data.weather);
// })

// ajaxReq.error(function (jqXhr, textStatus, errorMessage) {
// $('#error').append('Error: ' + errorMessage);
// })
