<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="./fragments/staticFiles.jsp"/>
	<body>
		<div class="container">
			<h2>New Entity</h2>
			<form:form id="add-entity-form" action="/entity/create" method="POST" 
					modelAttribute="entity" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">Name</label>
					<div class="controls">
						<form:input path="name"/>
						<form:errors path="name" cssClass="error"/>
					</div>
				</div>
				<button type="submit" class="btn btn-success">Add Entity</button>
			</form:form>
	    </div>
	</body>
</html>