<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="category_menu">
  <ul class="nav justify-content-center" id="first_Category">
    <c:forEach items="${firstCategoryList }" var="category">
      <li class="nav-item">
        <a class="nav-link active" href="#" data-cg_code="${category.cg_code }">${category.cg_name }</a>
      </li>
    </c:forEach>
  </ul>
</div>
<!-- 
<script>

$(document).ready(function() {

// 1차 카테고리 오버
$("#category_menu li a").on("mouseover", function(e) {
  e.preventDefault(); // a태그의 링크 기능 제거
  // console.log("1차 카테고리 마우스 오버");

  let sel_first_category = $(this);
  let cg_code = $(this).data("cg_code");

  // console.log("1차 카테고리 코드", cg_code);
  // return;

  let url = "/category/secondCategory/" + cg_code;
  $.getJSON(url, function(category) {
    // console.log(category);
    let str = '<ul class="nav">';
    for(let i=0; i<category.length; i++) {
      str += '<li class = "nav-item">'
      str += '<a class="nav-link active" href="#" data-cg_code="' + category[i].cg_code + '">' + category[i].cg_name + '</a>'
      str += '</li>'
    }

    str += '</ul>'

    console.log(str);
    // HTML DOM을 이용한 작업 패턴. 이후 str을 참조시켜 하단에 작업시키면 된다.

    sel_first_category.parent().parent().after(str);

  });
});

});


</script> -->