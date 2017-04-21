<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="tabHead">
    <spring:theme code="product.features"/>
</div>
<div class="tabBody">
   <h2><spring:theme code="product.features"/></h2>
   <ul type="circle">
       <c:forEach items="${product.additionalInfoList}" var="info">
            <li><c:out value="${info.content}" /> </li>
       </c:forEach>
   </ul>
</div>