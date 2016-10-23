<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto</title>
</head>
<body>

	<form action="${linkTo[ProductController].save}" method="post">
		<label>
			Nome
			<input name="product.name">
		</label>
		<label>
			Pre�o
			<input name="product.price">
		</label>
		<label>
			Descri��o
			<textarea name="product.description"></textarea>
		</label>
		<label>
			Status
			<select name="product.status">
				<c:forEach items="${status}" var="s">
					<option value="${s}">${s}</option>
				</c:forEach>
			</select>
		</label>		
		<input type="submit" value="Salvar">
	</form>

</body>
</html>