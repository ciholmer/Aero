$(document).ready(function() {
    $.ajax({
        url: "http://dataservicetest.elasticbeanstalk.com/api/city/1"
    }).then(function(data) {
       $('.greeting-id').append(city.id);
       $('.greeting-content').append(cityName.content);
    });
    alert('done with function').append(city.id);
});