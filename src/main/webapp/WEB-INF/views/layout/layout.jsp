<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="menu" />
	</div>

	<div>
		<tiles:insertAttribute name="body" />
	</div>
</body>
</html>