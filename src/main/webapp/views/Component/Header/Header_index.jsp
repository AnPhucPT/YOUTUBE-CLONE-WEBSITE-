<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${not empty sessionScope.currentUser}">
		<%@ include file="/views/Component/Header/Header_Login.jsp"%>
	</c:when>
	<c:otherwise>
		<%@ include file="/views/Component/Header/Login_NoLogin.jsp"%>
	</c:otherwise>
</c:choose>