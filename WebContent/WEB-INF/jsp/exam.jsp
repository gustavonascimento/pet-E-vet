<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam</title>
</head>
<body>
	<form method = "POST" action='CustomerServlet' name="formAddCustomer">
		Data do atendimento : <input 
				type="text" readonly="readonly" name="exam_date"
				value="<c:out value="${exam.date}"/>" /> <br />
		Hora do atendimento :	<input
				type="text" name="exam_time"
				value="<c:out value="${exam.time}" />" /> <br />
		Tipo de exame :	<input
				type="text" name="exam_clinical_examination"
				value="<c:out value="${exam.clinicalExamination}" />" /> <br />
		Exames adicionais :	<input
				type="text" name="exam_additional_examination"
				value="<c:out value="${exam.additionalExamination}" />" /> <br />		
	</form>

</body>
</html>