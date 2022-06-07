<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <p>Address</p>
        <input id="address"></input>
        <button id="submit">Submit</div>
    </body>

    <script>
        $(document).ready(function(){
            $("#submit").click(function(){
                location.href = "/success"
           });
        });
    </script>

</html>