<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<header class="main-header">

				<!-- Logo -->
				<a href="/admin/admin_menu" class="logo">
					<!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><b>A</b>LT</span>
					<!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><b>Admin</b> DocMall</span>
				</a>

				<!-- Header Navbar -->
				<nav class="navbar navbar-static-top" role="navigation">
					<!-- Sidebar toggle button-->
					<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
						<span class="sr-only">Toggle navigation</span>
					</a>
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">

							<li>
								<a href="#" id="btn_post_it">메모장</a>
							</li>

							<li class="dropdown messages-menu">
								<!-- Menu toggle button -->
								<a href="/">[Docmall]</a>
							</li>
						</ul>
						<ul class="nav navbar-nav">
							<li class="dropdown messages-menu">
								<!-- Menu toggle button -->
								<a href="#">최근접속시간: [
									<fmt:formatDate value="${sessionScope.adminStatus.admin_visit_date }"
										pattern="yyyy-MM-dd hh:mm:ss" />]
								</a>
							</li>
						</ul>
						<c:if test="${sessionScope.adminStatus != null }">
							<ul class="nav navbar-nav">
								<li class="dropdown messages-menu">
									<!-- Menu toggle button -->
									<a href="/admin/logout">로그아웃</a>
								</li>
							</ul>
						</c:if>

<!-- 
						<div id="layout_post_it"
							style="position: absolute; width: 500px; left: 420px; top: 103px; padding: 20px; border: 5px solid rgb(119, 119, 119); background-color: rgb(255, 255, 255); z-index: 1000;">

							<meta http-equiv="X-UA-Compatible" content="IE=Edge">
							<meta http-equiv="content-type" content="text/html; charset=utf-8">
							<meta http-equiv="p3p"
								content="CP=&quot;CAO DSP AND SO&quot; policyref=&quot;/w3c/p3p.xml&quot;"> -->

							<!-- 간단메모 -->
<!-- 
							<div>
								<div class="maintitle" style="border:0 none;">간단메모</div>

								<div class="alignCenter">

									<textarea id="admin_postit_content" name=""
										style="width:500px; height:394px; border:1px solid #777777; background:url(/admin/images/common/memo_bg.gif); line-height:22px;">모든 관리자가 동일하게 사용할 수 있는 간단메모입니다.</textarea>

								</div>
								<div style="width:100%; text-align:right;">최종수정 : <span
										id="admin_postit_date">2009-09-04 15:16:49</span></div>

								<div class="alignCenter">
									<a href="#" onclick="onPostItAjax('MODIFY'); return false;"><button>적용</button></a>
									<a href="#" onclick="hidePostIt(); return false"><button>닫기</button></a>
								</div>
								-->



							</div>

						</div>
					</div>
				</nav>

						
				<script>
					
						// $(document).ready(function () {
						// 	$("#btn_post_it").on("click", function () {
						// 		onPostItAjaxShow();
						// 	});
						// });

				</script>

			</header>