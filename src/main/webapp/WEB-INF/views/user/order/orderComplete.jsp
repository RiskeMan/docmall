<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <!doctype html>
        <html lang="en">

        <head>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
          <meta name="description" content="">
          <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
          <meta name="generator" content="Hugo 0.101.0">
          <title>Pricing example · Bootstrap v4.6</title>

          <!-- Bootstrap core CSS -->
          <%@include file="/WEB-INF/views/comm/plugIn2.jsp" %>



            <!-- Favicons -->


            <style>
              .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
              }

              @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                  font-size: 3.5rem;
                }
              }
            </style>

        </head>

        <body>

          <%@include file="/WEB-INF/views/comm/header.jsp" %>

            <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
              <p></p>
            </div>

            <div class="container">
              <h3>결제완료</h3>
              <table class="table table-striped">
                <thead>
                  <p>카카오 결제 및 주문처리가 완료되었습니다.</p>
              </table>

              <div class="box box-primary">


              </div>
              <%@include file="/WEB-INF/views/comm/footer.jsp" %>
            </div>

            <%@include file="/WEB-INF/views/comm/plugIn.jsp" %>
              <!-- 카테고리 메뉴 자바스크립트 작업소스 -->
              <script src="/js/category_menu.js"></script>


              <script>
                $(document).ready(function () {

                });
              </script>

        </body>



        </html>