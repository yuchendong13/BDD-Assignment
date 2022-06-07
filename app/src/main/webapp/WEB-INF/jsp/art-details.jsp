<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <p id="loginStatus">${loginStatus}</p>
        <button id="loginButton">Log In</button>
        <button id="shareButton">Share</button>
        <p id="generatedLink"></p>
        <p>Age:</p>
        <input id="ageField"></input>
        <p></p>
        <div id="loginNotification"></div>
         <div id="ageNotification"></div>
         <button id="bidButton">Bid</button>
        <button id="buyNowButton">Buy Now</button>


    </body>

    <script>
        $(document).ready(function(){
        $("#bidButton").click(function(){
           if(document.getElementById('loginStatus').innerHTML=="Not logged in") {
               $('#loginNotification').html("Please sign up or log in.");
           } else {
               $('#loginNotification').html("Placeholder - success");
           }
           if(parseInt($("#ageField").val())<16) {
                $('#ageNotification').html("You are too young to purchase art.");
           } else {
                $('#ageNotification').html("Placeholder - old enough");
           }
           if (document.getElementById('loginStatus').innerHTML !="Not logged in" && parseInt($("#ageField").val())>16) {
               location.href = "/shipping"
           }
         });
            $("#shareButton").click(function(){
               $('#generatedLink').html(window.location.href);
           });
            $("#buyNowButton").click(function(){
                if(document.getElementById('loginStatus').innerHTML=="Not logged in") {
                    $('#loginNotification').html("Please sign up or log in.");
                } else {
                    $('#loginNotification').html("Placeholder - success");
                }
                if(parseInt($("#ageField").val())<16) {
                    $('#ageNotification').html("You are too young to purchase art.");
                } else {
                    $('#ageNotification').html("Placeholder - old enough");
                }
                if (document.getElementById('loginStatus').innerHTML !="Not logged in" && parseInt($("#ageField").val())>16) {
                    location.href = "/shipping"
                }
           });
           $('#loginButton').on('click', function(e){
               e.preventDefault();
               var url = this.getAttribute('href');
               $.ajax({
                 url: url,
                 type: 'POST',
                 dataType: "html",
                 success: function(response) {
                   $('#loginStatus').html(response);
                 },
                 error: function(res) {
                   alert("error");
                 }
               });
           });
        });

    </script>

</html>