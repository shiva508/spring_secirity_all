<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<spring:url var="jquery" value="${pageContext.request.contextPath }/components/js/jquery.min.js"></spring:url>
<spring:url var="bootstrapminjs" value="${pageContext.request.contextPath }/components/js/bootstrap.min.js"></spring:url>
<spring:url var="bootstrapjs" value="${pageContext.request.contextPath }/components/js/bootstrap.js"></spring:url>
<spring:url var="bootstrapdatepickerjs"
	value="${pageContext.request.contextPath }/components/js/bootstrap-datepicker.js"></spring:url>
<spring:url var="jqueryuijs" value="${pageContext.request.contextPath }/components/js/jquery-ui.js"></spring:url>
<spring:url var="jquerydataTablesminjs"
	value="${pageContext.request.contextPath }/components/js/jquery.dataTables.min.js"></spring:url>
<spring:url var="select2minjs" value="${pageContext.request.contextPath }/components/js/select2.min.js"></spring:url>
<spring:url var="sweetalertminjs"
	value="${pageContext.request.contextPath }/components/js/sweetalert.min.js"></spring:url>

<spring:url var="bootstrapthemecss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.css"></spring:url>
<spring:url var="bootstrapthememincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.min.css"></spring:url>
<spring:url var="bootstrapcss" value="${pageContext.request.contextPath }/components/css/bootstrap.css"></spring:url>
<spring:url var="bootstrapcssmap"
	value="${pageContext.request.contextPath }/components/css/bootstrap.css.maps"></spring:url>
<spring:url var="bootstrapmincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap.min.css"></spring:url>
<spring:url var="dataTablesbootstrapcss"
	value="${pageContext.request.contextPath }/components/css/dataTables.bootstrap.css"></spring:url>
<spring:url var="datepickercss" value="${pageContext.request.contextPath }/components/css/datepicker.css"></spring:url>
<spring:url var="select2mincss" value="${pageContext.request.contextPath }/components/css/select2.min.css"></spring:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <script>
 
	$(document).ready(function() {
		$(document).ready(function() {
			$('.js-example-basic-single').select2();
		});
		 
	});
	function showUserDrapDown(){
		  $(".users").show();
	}
	
	function showDrapDown(){
		  $(".admin").show();
	  }
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MN2S</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath }/">Register</a></li>
      <li class="dropdown"><a onclick="showDrapDown()"  class="dropdown-toggle" data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
        <ul class="dropdown-menu admin" >
          <li><a href="${pageContext.request.contextPath}/users">Show All Users</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
        <li class="dropdown"><a onclick="showUserDrapDown()"  class="dropdown-toggle" data-toggle="dropdown" href="#">User <span class="caret"></span></a>
        <ul class="dropdown-menu users" >
          <li><form:form action="${pageContext.request.contextPath }/logout" method="POST">
      <a  href="#">  <input class="btn btn-success" type="submit" value="LOGOUT"></a>
      
    
      </form:form > </li></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li> </ul>
  </div>
</nav>
</body>
</html>