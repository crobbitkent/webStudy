<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.keroro.domain.Store"%>
<%@ page import="org.keroro.dao.StoreDAO"%>

<%@ page import="java.sql.*" %>    
<%@ page import="java.util.*" %>    
<%
	Long sno = Long.parseLong(request.getParameter("sno"));

	StoreDAO dao = StoreDAO.getInstance();
	
	Store store = dao.selectOne(sno);
%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
    <h1>view.jsp</h1>
        <div><label>번호</label>
            <input name="name" type="text" placeholder="가게 번호" value="<%=store.getStoreCode()%>" readonly="readonly"  />
        </div>
         <div>
            <input name="name" type="text" placeholder="가게 이름" value="<%=store.getName()%>" readonly="readonly"  />
        </div>
        <div>
            <input name="lat" type="number" step=".012" placeholder="가게 경도" value="<%=store.getLat()%>" readonly="readonly"/>
        </div>
        <div>
            <input name="lng" type="number" step=".012" placeholder="가게 위도" value="<%=store.getLng()%>" readonly="readonly"/>
        </div>
        <input name="menu" type="text" placeholder="가게 메뉴"value="<%=store.getMenu()%>" readonly="readonly"/>

        <div>
            <button>등록</button>
        </div>

</body>
</html>
