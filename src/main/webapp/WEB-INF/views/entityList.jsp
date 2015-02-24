<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<!DOCTYPE html>
<html>
	<jsp:include page="./fragments/staticFiles.jsp"/>
	<body>
		<div class="container">
			<h2>Entities</h2>
			<datatables:table id="entities" data="${entities}" row="entity" 
				cssClass="table table-striped" theme="bootstrap2" info="false" pageable="false">
				<datatables:column title="ID" property="id" cssStyle="width: 350px;"/>
				<datatables:column title="Name" property="name" cssStyle="width: 350px;"/>
			</datatables:table>
			<a href="/entity/create" class="btn btn-success">Add Entity</a>
		</div>
	</body>
</html>