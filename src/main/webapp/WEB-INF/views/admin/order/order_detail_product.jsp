<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


                    <table class="table table-sm">
                        <caption style="display: table-caption; text-align: center; color: red;">[주문상세정보]</caption>
                        <thead>
                            <tr>
                                <th scope="col">주문번호</th>
                                <th scope="col">상품코드</th>
                                <th scope="col">상품 이미지</th>
                                <th scope="col">상품명</th>
                                <th scope="col">주문수량</th>
                                <th scope="col">주문금액</th>
                                <th scope="col">비고</th>
                            </tr>
                        </thead>
                        <tbody>
							<c:forEach items="${orderProductList }" var="OrderDetailProductVO">
                            <tr>
                                <td scope="row">${OrderDetailProductVO.orderdetailVO.ord_code }</th>
                                <td>${OrderDetailProductVO.orderdetailVO.pro_num }</td>
                                <td><img
                                        src="/admin/order/imageDisplay?dateFolderName=${OrderDetailProductVO.productVO.pro_up_folder }&fileName=${OrderDetailProductVO.productVO.pro_img }">
                                </td>
                                <td>${OrderDetailProductVO.productVO.pro_name }</td>
                                <td>${OrderDetailProductVO.orderdetailVO.dt_amount }</td>
                                <td>${OrderDetailProductVO.productVO.pro_price }</td>
                                <td><button type="button" class="btn btn-danger" name="btn_order_delete"
                                        data-ord_code="${OrderDetailProductVO.orderdetailVO.ord_code }" data-pro_num="${OrderDetailProductVO.orderdetailVO.pro_num }">삭제</button></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
