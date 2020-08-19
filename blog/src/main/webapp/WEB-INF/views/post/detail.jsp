<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../layout/header.jsp" %>

<h1>Index 페이지입니다.</h1>
<div class="container">
  <h2>Striped Rows</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
     <tr>
      <td><input type="text" id="id" value="${PostDetailRespDto.id }" readonly></td>
      <td><input type="text" id="title" value="${PostDetailRespDto.title }" readonly></td>
      <td><input type="text" id="content" value="${PostDetailRespDto.content }" readonly></td>
      <td><input type="text" id="username"value="${PostDetailRespDto.username }" readonly></td>

     </tr>
    </tbody>
  </table>
  <button id ="btn-update" class = "btn btn-primary">수정하기</button>
  <button id ="btn-update-mode" class="btn btb-warming">수정</button>
  <button id ="btn-delete" class="btn btb-danger">삭제</button>
</div>
<script src="/js/post.js"></script>
<%@include file="../layout/footer.jsp" %>