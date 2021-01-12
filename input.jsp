<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>文本处理测试</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<form action="test01" method="get">
				<div class="form-group">
					<textarea class="form-control" rows="20" autoHeight="true" name="comment" id="comment" placeholder='请复制粘贴题目'></textarea>
				</div>
				<input type="submit" class="btn btn-outline-primary" value="提交" />
			</form>
		</div>
	</body>
</html>
