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
              <h3>주문정보</h3>
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col"><input type="checkbox"></th>
                    <th scope="col">상품</th>
                    <th scope="col">상품명</th>
                    <th scope="col">판매가</th>
                    <th scope="col">수량</th>
                    <th scope="col">할인</th>
                    <th scope="col">합계</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${order_info }" var="cartDTO" varStatus="상태변수">
                    <tr>
                      <td><input type="checkbox" name="cart_code" value="${cartDTO.cart_code}"></td>
                      <td><img
                          src="/user/cart/imageDisplay?dateFolderName=${cartDTO.pro_up_folder }&fileName=s_${cartDTO.pro_img }"
                          height="100" width="100"></td>

                      <td>${cartDTO.pro_name }</td>
                      <td><span id="unitPrice">${cartDTO.pro_price }</span></td>
                      <td><span name="cart_amount">${cartDTO.cart_amount }</span></td>
                      <td><span id="unitDiscount">${cartDTO.pro_discount }</span></td>
                      <td><span class="unitTotalPrice" id="unitTotalPrice">${((cartDTO.pro_price - ((cartDTO.pro_price * cartDTO.pro_discount) / 100)) * cartDTO.cart_amount)}</span></td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <td colspan="8" style="text-align: right;">
                      <span id="cart_price_count">${fn:length(order_info)-1 }</span>
                      <span>최종결제금액 : </span>
                      <span id="cart_total_price">${order_price}</span>
                    </td>
                  </tr><br>
                </tfoot>
              </table>

              <div class="box box-primary">

                <form role="form" id="" method="post" action="">
                  <fieldset class="form-group border p-3">
                    <legend class="w-auto px-2">주문하시는 분</legend>
                    <div class="box-body">
                      <div class="form-group row">
                        <label for="mbsp_name" class="col-2">주문자</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_id" value="${loginStatus.mbsp_id }"
                            readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="mbsp_name" class="col-2">이름</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_name" value="${loginStatus.mbsp_name }"
                            readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="mbsp_email" class="col-2">전자우편</label>
                        <div class="col-10">
                          <input type="email" class="form-control" id="b_mbsp_email" value="${loginStatus.mbsp_email }"
                            readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_postcode" class="col-2">우편번호</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_zipcode"
                            value="${loginStatus.mbsp_zipcode }" readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_address" class="col-2">기본주소</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_addr" value="${loginStatus.mbsp_addr }"
                            readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_detailAddress" class="col-2">상세주소</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_deaddr" value="${loginStatus.mbsp_deaddr }"
                            readonly>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="mbsp_phone" class="col-2">전화번호</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="b_mbsp_phone" value="${loginStatus.mbsp_phone }"
                            readonly>
                        </div>
                      </div>
                    </div>
                  </fieldset>
                  <hr>
                  <fieldset class="form-group border p-3">
                    <legend class="w-auto px-2">받으시는 분</legend>
                    <div class="box-body">
                      <div class="form-group row">
                        <label for="mbsp_name" class="col-2">수령인</label>
                        <div class="col-8">
                          <input type="text" class="form-control" id="mbsp_name" placeholder="성명">
                        </div>
                        <div class="col-2">
                          <input type="checkbox" id="same"><span>수령인과 동일</span>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_postcode" class="col-2">우편번호</label>
                        <div class="col-8">
                          <input type="text" class="form-control" name='mbsp_zipcode' id="mbsp_zipcode" placeholder="우편번호">
                        </div>
                        <div class="col-2">
                          <button type="button" onclick="sample2_execDaumPostcode()"
                            class="btn btn-outline-info">우편번호찾기</button>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_address" class="col-2">기본주소</label>
                        <div class="col-10">
                          <input type="text" class="form-control" name='mbsp_addr' id="mbsp_addr" placeholder="주소">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sample2_detailAddress" class="col-2">상세주소</label>
                        <div class="col-10">
                          <input type="text" class="form-control" name='mbsp_deaddr' id="mbsp_deaddr" placeholder="상세주소">
                          <input type="hidden" id="sample2_extraAddress">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="mbsp_phone" class="col-2">전화번호</label>
                        <div class="col-10">
                          <input type="text" class="form-control" id="mbsp_phone" placeholder="전화번호">
                        </div>
                      </div>
                    </div>
                  </fieldset>

                  <fieldset class="form-group border p-3">
                    <legend class="w-auto px-2">결제방법 선택</legend>
                    <div class="form-group row">
                      <label for="mbsp_name" class="col-2">결제방법</label>
                      <div class="col-10">
                        <input type="radio" name="paymethod" id="paymethod" value="nobank"><span>무통장입금</span><br>
                        <input type="radio" name="paymethod" id="paymethod" value="kakaopay"><img src="/image/payment.png">
                      </div>
                    </div>

                  </fieldset>

                  <div class="form-group row text-center">
                    <div class="col-12">
                      <button type="button" name="btn_order" id="btn_order">결제</button>
                    </div>
                  </div>
                </form>
              </div>
              <%@include file="/WEB-INF/views/comm/footer.jsp" %>
            </div>

            <%@include file="/WEB-INF/views/comm/plugIn.jsp" %>
              <!-- 카테고리 메뉴 자바스크립트 작업소스 -->
              <script src="/js/category_menu.js"></script>


              <script>
                $(document).ready(function () {

                  // 수령인과 동일 id="seme"
                  $("#same").on("click", function () {

                    if ($("#same").is(":checked")) {
                      // console.log("same 체크"); // 확인 완료

                      $("#mbsp_name").val($("#b_mbsp_name").val());
                      $("#mbsp_zipcode").val($("#b_mbsp_zipcode").val());
                      $("#mbsp_addr").val($("#b_mbsp_addr").val());
                      $("#mbsp_deaddr").val($("#b_mbsp_deaddr").val());
                      $("#mbsp_phone").val($("#b_mbsp_phone").val());

                    } else {

                      $("#mbsp_name").val("");
                      $("#mbsp_zipcode").val("");
                      $("#mbsp_addr").val("");
                      $("#mbsp_deaddr").val("");
                      $("#mbsp_phone").val("");

                    }

                  })

                });


                $("#btn_order").on("click", function () {

                  // 1)주문테이블 , 주문상세테이블 , 결제테이블에 저장이 필요한 정보구성
                  // 2) 카카오페이 결제에 필요한 정보구성
                  // 스프링에서 처리 할수 있는 부분

                  console.log("paymethod", $("input[name='paymethod']:checked").val());
                  console.log("ord_name",$("#mbsp_name").val());
                  console.log("ord_zipcode",$("input[name='mbsp_zipcode']").val());
                  console.log("ord_addr_basic", $("input[name='mbsp_addr']").val());
                  console.log("ord_addr_detail", $("input[name='mbsp_deaddr']").val());
                  console.log("ord_tel",$("#mbsp_phone").val());
                  console.log("ord_price", $("#cart_total_price").text());
                  console.log("totalprice",  $("#cart_total_price").text());


                  $.ajax({
                    url: "/user/order/orderPay",
                    type: 'get',
                    data: {
                      paymethod: $("input[name='paymethod']:checked").val(),
                      ord_name: $("#mbsp_name").val(),
                      ord_zipcode: $("input[name='mbsp_zipcode']").val(),
                      ord_addr_basic: $("input[name='mbsp_addr']").val(),
                      ord_addr_detail: $("input[name='mbsp_deaddr']").val(),
                      ord_tel: $("#mbsp_phone").val(),
                      ord_price: parseFloat($("#cart_total_price").text(), 10),
                      totalprice: parseFloat($("#cart_total_price").text(), 10),
                    },
                    dataType: 'json',
                    success: function (response) {
                      console.log("응답 : " + response);

                      alert(response.next_redirect_pc_url);
                      location.href = response.next_redirect_pc_url;

                    }

                    // 1)주문테이블 , 주문상세테이블 , 결제테이블에 저장이 필요한 정보구성
                    // 2) 카카오페이 결제에 필요한 정보구성
                    // 스프링에서 처리 할수 있는 부분
                  });
                });

              </script>

        </body>



        </html>