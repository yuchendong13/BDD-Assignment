<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
    <h1>Art gallery</h1>
    <form method="post" action="art-gallery/sale-type">
        <i>Filter by Sale type:</i>
        <input type="radio" name="saleTypeOption" id="buynow" value="Buy now" checked="checked">Buy now
        <input type="radio" name="saleTypeOption" id="auction" value="Auction">Auction
        <input type="submit" id="filterBySaleBtn">
    </form>
    <form method="post" action="art-gallery/art-type">
        <i>Filter by Art type:</i>
        <input type="radio" name="artTypeOption" id="painting" value="Painting" checked="checked">Painting
        <input type="radio" name="artTypeOption" id="print" value="Print">Print
        <input type="radio" name="artTypeOption" id="Sculpture" value="Sculpture">Sculpture
        <input type="submit" id="filterByArtBtn">
    </form>
    Art currently displayed in the gallery : <br/>
    <div id="arts">
        <c:forEach items="${lists}" var="entry">
            ------------------------------------------------------------------------
            <h5>Image: "src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
            <h5>Title: ${entry.title}</h5>
            <h5>Art type: ${entry.getArtType()}</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

    Art currently displayed on sale : <br/>
    <div id="sales">
        <c:forEach items="${saleLists}" var="entry">
            ------------------------------------------------------------------------
            <h5>"src/test/java/A4/G2/model/artwork/testImage${entry.artPiece.title.split(" ")[1]}.png"</h5>
            <h5>Title: ${entry.artPiece.title}</h5>
            <h5>Sale type: ${entry.getSaleType()}</h5>
            <h5>Price: $${entry.price}</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

    Display section : <br/>
    <div id="display">
        <c:forEach items="${imageLists}" var="entry">
            ------------------------------------------------------------------------
            <h5>Image: "src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

</body>

</html>