<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="layout/header.jsp" %>

<h1>Index 페이지입니다.</h1>
<div class="container">
  <h2>Striped Rows</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
      <tr>
        <td><a href="/post/${post.id}">${post.id}</a></td>
        <td>${post.title}</td>
        <td><fmt:formatDate value="${post.createDate}" pattern="yyyy-MM-dd" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<%@include file="layout/footer.jsp" %>