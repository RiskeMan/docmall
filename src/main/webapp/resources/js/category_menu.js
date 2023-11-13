$(document).ready(function() {

  // 1차 카테고리 오버
  $("div#category_menu li a").on("mouseover", function(e) {
    e.preventDefault(); // a태그의 링크 기능 제거
    // console.log("1차 카테고리 마우스 오버");
  
    let sel_first_category = $(this);
    let cg_code = $(this).data("cg_code");
  
    // console.log("1차 카테고리 코드", cg_code);
    // return;
  
    let url = "/category/secondCategory/" + cg_code;
    $.getJSON(url, function(category) {
      // console.log(category);
      let str = '<ul class="nav justify-content-center" id="second_Category">';
      for(let i=0; i<category.length; i++) {
        str += '<li class = "nav-item">'
        str += '<a class="nav-link active" href="#" data-cg_code="' + category[i].cg_code + '" data-cg_name="' + category[i].cg_name + '">' + category[i].cg_name + '</a>'
        str += '</li>'
      }
  
      str += '</ul>'
  
      // console.log(str);
      // HTML DOM을 이용한 작업 패턴. 이후 str을 참조시켜 하단에 작업시키면 된다.
  
      sel_first_category.parent().parent().next().remove();
      sel_first_category.parent().parent().after(str);
  
    });
  });
  
    // 2차 카테고리 선택
    /*
    $("#정적태그 참조 선택자").on("이벤트명", "동적 태그 참조 선택자", function() {

    });
    */
    $("div#category_menu").on("click", "ul#second_Category li a", function(e) {
      
      let cg_code = $(this).data("cg_code");
      let cg_name = $(this).data("cg_name"); 
      
      // console.log(cg_name);

      // 한글이나 특수문자를 서버에 보낼 때 오류가 느는 경우
      // 인코딩 과정을 통하여 보내 처리할 수 있다.
      location.href = `/user/product/pro_list?cg_code=${cg_code}&cg_name=${cg_name}`;

    })

  });