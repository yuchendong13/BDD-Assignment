<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <button id="shareArtistButton">Share Artist</button>
        <p id="generatedArtistLink"></p>
    </body>

    <script>
        $(document).ready(function(){
            $("#shareArtistButton").click(function(){
               $('#generatedArtistLink').html(window.location.href);
           });
        });
    </script>

</html>