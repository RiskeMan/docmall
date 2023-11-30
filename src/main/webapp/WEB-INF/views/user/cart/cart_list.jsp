<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
              <p class="display-4">장바구니</p>
            </div>

            <div class="container">
              <!-- <input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum}" />
              <input type="hidden" name="amount" id="amount" value="${pageMaker.cri.amount}" />
              <input type="hidden" name="type" id="type" value="${pageMaker.cri.type}" />
              <input type="hidden" name="keyword" id="keyword" value="${pageMaker.cri.keyword}" />

              <input type="hidden" name="cg_code" id="cg_code" value="${cg_code}" />
              <input type="hidden" name="cg_name" id="cg_name" value="${cg_name}" /> -->

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
                    <th scope="col">비고</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${cart_list }" var="cartDTO">
                  <tr>
                    <td><input type="checkbox" name="cart_code" value="${cartDTO.cart_code}"></td>
                    <td><img src="/user/cart/imageDisplay?dateFolderName=${cartDTO.pro_up_folder }&fileName=s_${cartDTO.pro_img }" height="100" width="100"></td>
                    
                    <td>${cartDTO.pro_name }</td>
                    <td><span id="unitPrice">${cartDTO.pro_price }</span></td>
                    <td><input type="number" name="cart_amount" value="${cartDTO.cart_amount }" style="width: 50px;"><button type="button" name="btn_cart_amount_change" class="btn btn-outline-secondary">변경</button></td>
                    <td><span id="unitDiscount">${cartDTO.pro_discount }</span></td>
                    <td><span class="unitTotalPrice" id="unitTotalPrice">${Math.floor((cartDTO.pro_price - ((cartDTO.pro_price * cartDTO.pro_discount) / 100)) * cartDTO.cart_amount)}</span></td>
                    <td>
                      <button type="button" name="btn_cart_ajax_del" class="btn btn-outline-secondary">삭제(ajax)</button>
                      <button type="button" name="btn_cart_nonajax_del" class="btn btn-outline-secondary">삭제(non-ajax)</button>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <td colspan="8"><button type="button" class="btn btn-outline-secondary">선택삭제</button></td><br>
                  </tr>
                  <tr>
                    <td colspan="8" style="text-align: right;">
                      <span>최종결제금액 : </span>
                      <span id="cart_total_price">${cart_total_price}</span>
                    </td>
                  </tr><br>
                  <tr>
                    <td colspan="8" style="text-align: center;">
                      <button type="button" name="btn_order" id="" class="btn btn-outline-secondary">돌아가기</button>
                      <button type="button" name="btn_order" id="" class="btn btn-outline-secondary">장바구니 비우기</button>
                      <button type="button" name="btn_order" id="btn_order" class="btn btn-outline-secondary">주문</button>
                    </td>
                  </tr>
                </tfoot>
              </table>


              <%@include file="/WEB-INF/views/comm/footer.jsp" %>
            </div>

            <%@include file="/WEB-INF/views/comm/plugIn.jsp" %>
              <!-- 카테고리 메뉴 자바스크립트 작업소스 -->
              <script src="/js/category_menu.js"></script>


              <script>
                $(document).ready(function () {



                  // 장바구니 목록에서 수량 변경클릭시
                  $("button[name='btn_cart_amount_change']").on("click", function() {

                    let cur_btn_change = $(this)

                    // name="cart_amount"
                    let cart_amount = $(this).parent().find("input[name='cart_amount']").val();
                    // console.log("수량", cart_amount); // 인식 확인 완료

                    let cart_code = $(this).parent().parent().find("input[name='cart_code']").val();
                    // console.log("장바구니 코드", cart_code); // 장바구니 코드 확인 완료.

                    // let cart_amount_success = $(this).parent().find("td[name='cart_amount_success']");

                    $.ajax({
                      url: '/user/cart/cart_amount_change',
                      type: 'post',
                      data: {cart_code : cart_code, cart_amount : cart_amount},
                      dataType: 'text',
                      beforeSend : function(xhr) {
                        xhr.setRequestHeader("AJAX", "true");
                      },
                      success: function(result) {
                        if(result == 'success') {

                          // 합계금액 계산작업
                          let unitPrice = cur_btn_change.parent().parent().find("span#unitPrice").text();
                          let unitDiscount = cur_btn_change.parent().parent().find("span#unitDiscount").text();
                          
                          // 상품 별 단위 주문금액
                          let unitTotalPrice = cur_btn_change.parent().parent().find("span#unitTotalPrice");
                          unitTotalPrice.text(Math.floor((unitPrice - ((unitPrice * unitDiscount) / 100)) * cart_amount));
                          alert("수량변경이 되었습니다.")
                          
                          // 전체 주문금액
                          fn_cart_sum_proce()
                          

                        }
                      },
                      error : function(xhr, status, error) {
                        alert(status);
                        alert("로그인 페이지로 이동합니다.");
                        location.href = "/member/login";
                      }
                    });
                  });

                  // 장바구니 삭제 (ajax사용 구문)
                  $("button[name='btn_cart_ajax_del']").on("click", function() {
                    
                    if(!confirm("장바구니 상품을 삭제하시겠습니까?")) return;

                    let btn_cart_del = $(this); // 선택된 버튼태그의 위치를 참조. ajax시 버튼의 위치가 휘발되기에 그 전에 변수에 담는다.
                    let cart_code = $(this).parent().parent().find("input[name='cart_code']").val();
                    // console.log("상품 삭제 버튼 클릭. cart_code 출력", cart_code); // 확인 완료.

                    $.ajax({
                      url: '/user/cart/cart_list_del',
                      type: 'post',
                      data: {cart_code : cart_code},
                      dataType: 'text',
                      success: function(result) {
                        if(result == 'success') {

                          alert("장바구니 상품이 삭제되었습니다.");

                          btn_cart_del.parent().parent().remove();

                          // 전체 주문금액
                          fn_cart_sum_proce();

                        }
                      }
                    });
                  });

                  // 장바구니 삭제 (ajax 미사용 구문)
                  $("button[name='btn_cart_nonajax_del']").on("click", function() {

                    if(!confirm("장바구니 상품을 삭제하시겠습니까?")) return;

                    let cart_code = $(this).parent().parent().find("input[name='cart_code']").val();
                    // console.log("상품 삭제 버튼 클릭. cart_code 출력", cart_code); // 확인 완료.

                    alert("장바구니 상품이 삭제되었습니다.");
                    location.href = "/user/cart/cart_list_del?cart_code=" + cart_code; //장바구니 삭제주소

                  });

                  // 주문하기
                  $("#btn_order").on("click",function() {
                    location.href = "/user/order/order_Info";
                  });

                }); // jquery ready-end

                // 장바구니 전체 주문금액
                function fn_cart_sum_proce() {
                  let sumPrice = 0;
                  $(".unitTotalPrice").each(function() {
                    sumPrice += Number($(this).text());
                  });
                  
                  $("#cart_total_price").text(sumPrice);
                }

              </script>

      </body>



      </html>