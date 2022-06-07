<html>

<head>
    <title>Add Art</title>
</head>

<body>
<h1>Add Art</h1>

<form method="post">
    <h2>Insert new art details</h2>
    Title : <input type="text" name="title" id="title"/> <br/>
    Description : <input type="text" name="description" id="description"/> <br/>
    <label>
        Select type of art
        <select name="artType" id="artType">
            <option value="0">Painting</option>
            <option value="1">Print</option>
            <option value="2">Sculpture</option>
        </select>
    </label> <br/>
    Dimensions: <input type="text" name="dimensions" id="dimensions"/> <br/>
    Artist Name: <input type="text" name="artistName" id="artistName"/> <br/>
    Image File (e.g. testImage.png, must be found in src/main/images): <input type="text" name="fileOfImage"
                                                                              id="fileOfImage"/> <br/>
    <h2>Insert BuyNow Details (optional)</h2>
    Fixed Price: $<input type="text" name="buyNowPrice" id="buyNowPrice"/><br/>

    <h2>Insert Auction Details (optional)</h2>
    Start Price: $<input type="text" name="auctionStartPrice" id="auctionStartPrice"/><br/>
    Reserve Price: $<input type="text" name="auctionReservePrice" id="auctionReservePrice"/><br/>
    Time Remaining: <input type="text" name="auctionTimeRemaining" id="auctionTimeRemaining"/><br/>

    <input type="submit" id="submitNewArtBtn"/> <br/>
</form>

<label style="color:green" id="message">${message}</label>
<label style="color:red" id="errorMessage">${errorMessage}</label>
</body>

</html>