<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ page import="java.sql.*, java.util.*"
%><html>
<head>
<title>JSP Oracle, JDBC 예제</title>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
</head>
<body>
<%
	// web server의 socket과 동일하다.
	// db의 session과 동일하다.
    Connection conn = null;
    
    try {     
    	// jdbc 오라클 프로토콜...
        String DB_HOST = "jdbc:oracle:thin:@192.168.0.108:1521:XE"; // 아이피, 포트, 서비스(SID) 정보를 수정
        String DB_USER = "dclub"; // 아이디(유저) - 11g 이상시 대소문자 구분 확인
        String DB_PASS = "dclub"; // 패스워 - 11g 이상시 대소문자 구분 확인
        
        // jar file 클래스 이름이다.
        // jar file을 로딩할 때 사용한다.
        // import와 비슷한 역할... 동적으로 runtime에 class를 메모리 영역에 올린다.    
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // jdbc 오라클 프로토콜을 보낸다.
        conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
        
        out.println("연결성공!");
    } catch (ClassNotFoundException e) {
        out.println("연결 드라이버 없음");
    } catch (SQLException e) {
        out.print("연결실패 : ");
        if(e.getMessage().indexOf("ORA-28009") > -1)
            out.println("허용되지 않는 접속 권한 없음");    
        else if(e.getMessage().indexOf("ORA-01017") > -1)
            out.println("유저/패스워드 확인");    
        else if(e.getMessage().indexOf("IO") > -1)
            out.println("IO - 연결확인!");
        else
            out.println("기본 연결확인!");
        
    } finally {
        if(conn != null) {
            conn.close();
        }
    }
%></body>
</html>