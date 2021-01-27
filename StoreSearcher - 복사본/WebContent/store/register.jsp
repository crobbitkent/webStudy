<%--
  Created by IntelliJ IDEA.
  User: crobbitkent
  Date: 21. 1. 20.
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>register.jsp</h1>
    <form action="/store/registerAction.jsp" method="post">
        <div>
            <input name="name" type="text" placeholder="가게 이름" value="Burger King"/>
        </div>
        <div>
            <input name="lat" type="number" step=".012" placeholder="가게 경도" value="37.543563"/>
        </div>
        <div>
            <input name="lng" type="number" step=".012" placeholder="가게 위도" value="127.19753"/>
        </div>
        <input name="menu" type="text" placeholder="가게 메뉴" value="와퍼, 불고기와퍼"/>

        <div>
            <button>등록</button>
        </div>
    </form>

    <video oncontextmenu="return false;" id="myVideo" width="100%" muted controls autoplay>

        <source src = "/mp4/movie.mp4" type="video/mp4">
    </video>
</body>
</html>
