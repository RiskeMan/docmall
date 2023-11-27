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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
        <script id="reviewTemplate" type="text/x-handlebars-template">

<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">상품평</th>
      <th scope="col">평점</th>
      <th scope="col">날짜</th>
      <th scope="col">비고</th>
    </tr>
  </thead>
  <tbody>

    {{#each .}}
    <tr>
      <th scope="row" class="rew_num">{{rew_num}}</th>
      <td class="rew_content">{{rew_content}}</td>
      <td class="rew_score">{{displayStar rew_score}}</td>
      <td class="rew_regdate">{{converDate rew_regdate}}</td>
      <td>{{authControlView mbsp_id rew_num rew_score}}</td>
    </tr>
    {{/each}}

  </tbody>
</table>

        </script>


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

            /* 별 모양 평점 기본선택자. */
            p#star_rv_score a.rv_score {
              font-size: 22px;
              text-decoration: none;
              color: lightblue;
            }

            /* 별점에 마우스 오버했을 경우 사용되는 CSS선택자. */
            p#star_rv_score a.rv_score.on {
              color: gold;
            }
          </style>

      </head>

      <body>

        <%@include file="/WEB-INF/views/comm/header.jsp" %>

          <%@include file="/WEB-INF/views/comm/categoey_manu.jsp" %>

            <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
              <!-- 2차 상품코드 -->
              <h3 class="display-4">${cg_name }</h3>
            </div>

            <div class="container">
              <div class="card-deck mb-3 text-center row">

                <!-- 상품 이미지 -->
                <div class="col-6">
                  <img class="btn_pro_img" data-pro_num="${productVO.pro_num}"
                    src="/user/product/imageDisplay?dateFolderName=${productVO.pro_up_folder }&fileName=${productVO.pro_img }"
                    height="200" width="200">
                </div>

                <div class="col-6">
                  <div class="text-left">
                    <div class="row">
                      <div class="col">
                        상품이름 : ${productVO.pro_name}
                      </div>
                    </div>
                    <div class="row">
                      <div class="col">
                        가격 : <span id="unit_price">${productVO.pro_price}</span>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col">
                        수량 : <input type="number" id="btb_quantity" value="1" style="width: 50px;">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col">
                        총 상품금액 : <span id="tot_price">${productVO.pro_price}</span>
                      </div>
                    </div>
                  </div><br>
                  <div class="row">
                    <div class="col-md-6">
                      <button name="btn_buy" id="btn_buy" type="button" class="btn btn-success"
                        data-pro_num="${productVO.pro_num}">구매하기</button>
                    </div>
                    <button name="btn_cart_add" type="button" class="btn btn-success"
                      data-pro_num="${productVO.pro_num}">장바구니</button>
                  </div>
                </div>
              </div>

              <div class="col-12">

                <div id="tabs_pro_detail">
                  <ul>
                    <li><a href="#tabs_prodetail">상품설명</a></li>
                    <li><a href="#tabs_proreview">상품후기</a></li>
                  </ul>
                  <div id="tabs_prodetail">
                    <p>${productVO.pro_content}</p>
                  </div>
                  <div id="tabs_proreview">
                    <p>상품후기 목록</p>
                    <div class="row">
                      <div class="col-md-12" id="review_list">
                        
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-8 text-center" id="review_paging">
                        <!-- 상품후기 페이징 -->
                      </div>
                      <div class="col-md-4 text-right"><button class="btn btn-primary" id="btn_review_write">상품후기작성</button></div>
                    </div>
                  </div>

                </div>

              </div>


              <div class="row text-center">
                <div class="col-md-12"></div>
                <div class="col-md-6">
                  <form id="actionForm" action="" method="get">

                    <input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum}" />
                    <input type="hidden" name="amount" id="amount" value="${pageMaker.cri.amount}" />
                    <input type="hidden" name="type" id="type" value="${pageMaker.cri.type}" />
                    <input type="hidden" name="keyword" id="keyword" value="${pageMaker.cri.keyword}" />

                    <input type="hidden" name="cg_code" id="cg_code" value="${cg_code}" />
                    <input type="hidden" name="cg_name" id="cg_name" value="${cg_name}" />

                  </form>

                </div>
              </div>
              <%@include file="/WEB-INF/views/comm/footer.jsp" %>
            </div>


            <%-- <%@include file="/WEB-INF/views/comm/plugIn.jsp" %> --%>

              
              <script>
                $(function () {
                  $("#tabs_pro_detail").tabs();
                });
              </script>

              <!-- 카테고리 메뉴 자바스크립트 작업소스 -->
              <script src="/js/category_menu.js"></script>


              <script>
                $(document).ready(function () {

                  let actionForm = $("#actionForm");

                  // [이전] 1 2 3 4 5 [다음] 이벤트 설정 <a>태그
                  $(".movepage").on("click", function (e) {
                    e.preventDefault(); // a태그의 링크기능 제거 + href속성에 페이지 번호를 숨겨둠.

                    actionForm.attr("action", "/user/product/pro_list");
                    actionForm.find("input[name='pageNum']").val($(this).attr("href"));

                    actionForm.submit();
                  });

                  // 장바구니 추가 name="btn_cart_add"
                  $("button[name='btn_cart_add']").on("click", function () {
                    // console.log("장바구니");

                    $.ajax({
                      url: '/user/cart/cart_add',
                      type: 'post',
                      data: { pro_num: $(this).data("pro_num"), cart_amount: $("#btb_quantity").val() }, // 일단 상품 코드값과 수량 1로 보낸다.
                      dataType: 'text',
                      success: function (result) {
                        if (result == "success") {
                          alert("장바구니에 추가됨.");
                          if (confirm("장바구니로 이동하시겠습니까?")) {
                            location.href = "/user/cart/cart_list";
                          }
                        }
                      }
                    });

                  });

                  // 상품 이미지 또는 상품명 클릭시 상세 페이지로 데이터와 페이지를 보내는 작업.
                  $(".btn_pro_img").on("click", function () {
                    // console.log("상품상세 페이지 이동 작동확인.") // 동작 확인 완료.

                    // 주소 정보 입력.
                    actionForm.attr("action", "/user/product/pro_detail");

                    // data-pro_num="${ProductVO.pro_num}"
                    let pro_num = $(this).data("pro_num"); // data-pro_num에서 상품코드를 가져오는 작업.

                    actionForm.find("input[name='pro_num']").remove();
                    //  <input tepe="hidden" name="pro_num" value="상품코드" >
                    actionForm.append("<input tepe='hidden name='pro_num' value='" + pro_num + "' >")

                    actionForm.submit();
                  })

                  // 수량변경시
                  $("#btb_quantity").on("change", function () {
                    let tot_price = parseInt($("#unit_price").text()) * parseInt($("#btb_quantity").val());
                    // let tot_price = $("#unit_price").text() * $("#btb_quantity").val();
                    // parseInt() - 정수 변환.

                    // 총 상품금액 표시.
                    $("#tot_price").text(tot_price);
                  })

                  // 구매하기(주문)]
                  $("#btn_buy").on("click", function () {

                    // console.log("pro_num - " ,$(this).data('pro_num'))

                    let url = "/user/order/order_ready?pro_num=" + $(this).data('pro_num') + "&cart_amount=" + $('#btb_quantity').val();
                    // console.log(url);
                    location.href = url;
                  })

                  // 상품후기 작성
                  $("#btn_review_write").on("click", function () {

                    $("#rew_content").val("");
                    $("#rew_num").text("");
                    $("#rew_regdate").text("");

                    $("#btn_review_save").show();
                    $("#btn_review_modify").hide();// 수정 버튼 숨기기
                    $('#review_Modal').modal('show');
                  });

                  // 별 평점 클릭시. 평점 태그 5개 ★
                  $("p#star_rv_score a.rv_score").on("click", function(e) {
                    e.preventDefault();

                    // $(this) : 클릭한 a태그
                    // 선택 했을 때 이전 선택자 제거작업.
                    $(this).parent().children().removeClass("on");

                    // 선택한 a태그인 별과 이전 별에 class에 .on을 입혀 바꿔주는 작업.
                    $(this).addClass("on").prevAll("a").addClass("on");

                  });

                  // 상품명 목록을 불러오는 작업.(이벤트를 사용하지 않고, 직접 호출.)
                  let reviewPage = 1; // 목록에서 첫번째 페이지를 의미
                  let url = `/user/review/list/${productVO.pro_num}/` + reviewPage;

                  getReviewInfo(url);

                  function getReviewInfo(url) {
                    $.getJSON(url, function(data) {

                      // console.log("상품후기", data.list[0].rew_content);
                      // console.log("페이징정보", data.pageMaker.total);

                      printReviewList(data.list, $("#review_list"), $("#reviewTemplate"));

                      // review_paging
                      printPaging(data.pageMaker, $("#review_paging"));
                    });
                  }

                  // 상품후기 작업 함수
                  let printReviewList = function(reviewDate, target, template) {
                    let templateObj = Handlebars.compile(template.html());
                    let reviewHtml = templateObj(reviewDate);

                    // 상품후기목록 위치를 참조하여, 추가
                    $("#review_list").children().remove();
                    target.append(reviewHtml);

                  }

                  // 사용자정의 Helper (핸들바의 함수정의)
                  // 상품후기 등록일 milisecond -> 자바 스크립트의 Date객체로 변환
                  Handlebars.registerHelper("converDate", function(reviewtime) {

                    const dateObj = new Date(reviewtime);
                    let year = dateObj.getFullYear();
                    let month = dateObj.getMonth();
                    let date = dateObj.getDate();
                    let hour = dateObj.getHours();
                    let minute = dateObj.getMinutes();

                    return year + "/" + month + "/" + date + " " + hour + " : " + minute
                  })

                  // 평점(숫자)를 별로 출력하기.
                  Handlebars.registerHelper("displayStar", function(rating) {

                    let starStr = "";
                    switch(rating) {
                      case 1:
                        starStr = "★☆☆☆☆";
                        break;
                      case 2:
                        starStr = "★★☆☆☆";
                        break;
                      case 3:
                        starStr = "★★★☆☆";
                        break;
                      case 4:
                        starStr = "★★★★☆";
                        break;
                      case 5:
                        starStr = "★★★★★";
                        break;
                    }

                    return starStr;

                  })

                  // 상품후기 수정/삭제 버튼 표시
                  Handlebars.registerHelper("authControlView",function(mbsp_id, rew_num, rew_score) {
                    let str = "";
                    let login_id = '${sessionScope.loginStatus.mbsp_id}';

                    // 로그인 한 사용자와 상품후기 등록 사용자의 동일여부체크
                    if(login_id == mbsp_id) {
                      str += '<button type="button" name="btn_review_edit" data-rew_score="' + rew_score + '" class="btn btn-info">수정</button>';
                      str += '<button type="button" name="btn_review_del" data-rew_num="' + rew_num + '" class="btn btn-danger">삭제</button>';

                      // console.log(str);
                      return new Handlebars.SafeString(str);
                    }

                  });

                  // 상품후기 수정버튼 클릭
                  $("div#review_list").on("click", "button[name='btn_review_edit']", function() {

                    
                    // 이후 데이터베이스에서 불러와 보여지는 것이 자바 스크립트에 띄워진 정보를 불러와 읽혀주게 만든다.
                    // console.log("번호 : ", $(this).parent().parent().find(".rew_num").text()); // 확인완료
                    // console.log("내용 : ", $(this).parent().parent().find(".rew_content").text()); // 확인완료
                    // console.log("점수 : ", $(this).parent().parent().find(".rew_score").text()); // 확인완료
                    // console.log("날짜 : ", $(this).parent().parent().find(".rew_regdate").text()); // 확인완료
                    
                    // id="rew_content"
                    // 평점작업
                    let rew_score = $(this).data("rew_score");
                    console.log("별평점", rew_score);
                    $("#star_rv_score a.rv_score").each(function(index, item) {
                      if(index < rew_score) {
                        $(item).addClass("on");
                      }else{
                        $(item).removeClass("on");
                      }
                    })
                    $("#rew_content").val($(this).parent().parent().find(".rew_content").text())
                    $("#rew_num").text($(this).parent().parent().find(".rew_num").text());
                    $("#rew_regdate").text($(this).parent().parent().find(".rew_regdate").text());
                    
                    $("#btn_review_modify").show();
                    $("#btn_review_save").hide(); // 저장 버튼 숨기기
                    // $("#btn_review_modify").data("rew_num", $(this).parent().parent().find(".rew_num").text());
                    $("#review_Modal").modal('show');
                  })

                  // 상품후기 수정하기
                  $("#btn_review_modify").on("click", function() {

                    let rew_num = $("#rew_num").text();
                    let rew_content = $("#rew_content").val();

                    let rew_score = 0;

                    
                    $("p#star_rv_score a.rv_score").each(function(index, item) {
                      if($(this).attr("class") == "rv_score on") {
                        rew_score += 1;
                      }
                    });

                    console.log(rew_num, rew_content, rew_score);
                    
                    let review_data = {rew_num : rew_num, rew_content : rew_content, rew_score : rew_score}

                    $.ajax({
                      url: '/user/review/modify',
                      // stringify 레스트 API방식으로 보내기 위해선 headers 작업을 해야한다.
                      headers: {
                        "Content-Type" : "application/json", "X-HTTP-Method-Override" : "PUT"
                      },
                      type: 'put',
                      data: JSON.stringify(review_data), // 데이터 포멧을 object -> json 으로 변환
                      dataType: 'text',
                      success: function(result) {
                        if(result == 'success') {
                          alert("상품평이 등록되었습니다.")
                          $("#review_Modal").modal('hide'); // 부트스트랩 4.6 버전의 자바스크립트 명령어.

                          // 상품평 목록을 불러오는 작업.
                          getReviewInfo(url);

                          

                        }
                      }
                    })


                  })

                  // 상품후기 삭제버튼 클릭
                  $("div#review_list").on("click", "button[name='btn_review_del']", function() {
                    // console.log("상품후기 삭제");

                    let rew_num = $(this).data("rew_num");

                    $.ajax({
                      url: '/user/review/delete/' + rew_num,
                      // stringify 레스트 API방식으로 보내기 위해선 headers 작업을 해야한다.
                      headers: {
                        "Content-Type" : "application/json", "X-HTTP-Method-Override" : "DELETE"
                      },
                      type: 'delete',
                      dataType: 'text',
                      success: function(result) {
                        if(result == 'success') {
                          alert("상품평이 삭제되었습니다.")

                          url = `/user/review/list/${productVO.pro_num}/` + reviewPage;
                          getReviewInfo(url);


                        }
                      }
                    })
                  })

                  // 페이징 번호 클릭
                  $("div#review_paging").on("click", "nav#navigation ul a", function(e) {
                    e.preventDefault();
                    // console.log("페이지번호");

                    reviewPage = $(this).attr("href"); // 상품후기 선택 페이지번호

                    url = `/user/review/list/${productVO.pro_num}/` + reviewPage;

                    getReviewInfo(url); // 스프링에서 상품후기, 페이지번호 데이터를 가져오는 함수.
                  });

                  // 상품후기 페이징 기능 작업 함수
                  let printPaging = function(pageMaker, target) {
                    
                    /*
                    <nav aria-label="Page navigation example">
                      <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                      </ul>
                    </nav>
                    */

                    let pagingStr = '<nav id="navigation" aria-label="Page navigation example">';
                    pagingStr += '<ul class="pagination">'

                    // 이전 표시 여부
                    if(pageMaker.prev) {
                      pagingStr += '<li class="page-item"><a class="page-link" href="#">' + (pageMaker.startPage-1) + '</a></li>'
                    }

                    // 페이지 번호 출력
                    for(let i=pageMaker.startPage; i<=pageMaker.endPage; i++) {

                      let className = pageMaker.cri.pageNum == i ? 'active' : '';

                      pagingStr += '<li class="page-item"><a class="page-link ' + className + '" href="' + i + '">' + i + '</a></li>';
                    }

                    // 다음 표시 여부
                    if(pageMaker.prev) {
                    pagingStr += '<li class="page-item"><a class="page-link" href="#">' + (pageMaker.startPage+1) + '</a></li>'
                    }

                    pagingStr += '</ul>';
                    pagingStr += '</nav>';

                    target.children().remove();
                    target.append(pagingStr);

                  }


                  // 상품후기 저장
                  $("#btn_review_save").on("click", function() {

                    // 별 평점 값
                    let rew_score = 0;
                    let rew_content = $("#rew_content").val();

                    $("p#star_rv_score a.rv_score").each(function(index, item) {
                      if($(this).attr("class") == "rv_score on") {
                        rew_score += 1;
                      }
                    });

                    // 별을 선택하지 않았을 경우 체크
                    if(rew_score == 0) {
                      alert("평점을 선택해 주세요.");
                      return;
                    }

                          // 후기 체크
                    if(rew_content == "") {
                      alert ("상품 리뷰 내용을 작성 해 주세요");
                      return;
                    }

                    // ajax로 스프링에서 리뷰데이터를 전송하는 작업.
                    let review_data = {pro_num : $(this).data("pro_num"), rew_content : rew_content, rew_score : rew_score};

                    $.ajax({
                      url: '/user/review/new',
                      // stringify 레스트 API방식으로 보내기 위해선 headers 작업을 해야한다.
                      headers: {
                        "Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"
                      },
                      type: 'post',
                      data: JSON.stringify(review_data), // 데이터 포멧을 object -> json 으로 변환
                      dataType: 'text',
                      success: function(result) {
                        if(result == 'success') {
                          alert("상품평이 등록되었습니다.")
                          $("#review_Modal").modal('hide'); // 부트스트랩 4.6 버전의 자바스크립트 명령어.

                          // 상품평 목록을 불러오는 작업.
                          getReviewInfo(url);


                        }
                      }
                    })

                  });

                }); // ready event end
              </script>

              <!-- 상품후기 모델 -->
              <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
                crossorigin="anonymous"></script>
              <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
                integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
                crossorigin="anonymous"></script>

              <div class="modal fade" id="review_Modal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">상품후기</h5>
                      <b>   </b><span id="rew_num"></span><b>   </b><span id="rew_regdate"></span>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                    <div class="modal-body">
                      <form>
                        <div class="form-group">
                          <label for="recipient-name" class="col-form-label">평점</label>
                          
                          <p id="star_rv_score">
                            <a class="rv_score" href="#">★</a>
                            <a class="rv_score" href="#">★</a>
                            <a class="rv_score" href="#">★</a>
                            <a class="rv_score" href="#">★</a>
                            <a class="rv_score" href="#">★</a>
                          </p>
                        </div>
                        <div class="form-group">
                          <label for="rew_content" class="col-form-label">상품평</label>
                          <textarea class="form-control" id="rew_content" name="rew_content"></textarea>
                        </div>
                      </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                      <button type="button" id="btn_review_save" class="btn btn-primary" data-pro_num="${productVO.pro_num}">저장</button>
                      <button type="button" id="btn_review_modify" class="btn btn-primary">수정</button>
                    </div>
                  </div>
                </div>
              </div>

      </body>



      </html>