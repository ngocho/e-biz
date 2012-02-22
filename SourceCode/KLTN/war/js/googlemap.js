 function initialize() {
        var myOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);
      }
 
 function calcRoute() {
     alert("calcRoute");
     var start = document.getElementById("start").value;
     var end = document.getElementById("end").value;
     alert(start + end);
     var request = {
       origin:start,
       destination:end,
       travelMode: google.maps.TravelMode.DRIVING
     };
     directionsService.route(request, function(result, status) {
       if (status == google.maps.DirectionsStatus.OK) {
         directionsDisplay.setDirections(result);
       }
     });
   }