<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!-- 
	web路径：
	不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
	以/开始的相对路径，找资源，以服务器的路径为标准，需要加上项目名


 -->
<script type="text/javascript" src="${APP_PATH }/static/js/jquery.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!--标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!--按钮 -->
		<div class="row">
			 <div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
			 </div>
		</div>
		<!--显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<th>#</th>
						<th>name</th>
						<th>gender</th>
						<th>email</th>
						<th>departmentName</th>
						<th>action</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<th>${emp.empId }</th>
							<th>${emp.empName }</th>
							<th>${emp.gender }</th>
							<th>${emp.email }</th>
							<th>${emp.department.deptName }</th>
							<th>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true">
									update
									</span>
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-remove" aria-hidden="true">								
									delete
									</span>
								</button>
							</th>
						</tr>					
					</c:forEach>
				</table>
			</div>
		</div>
		<!--显示分页数据 -->
		<div>
			<!-- 分页文字信息 -->
			<div class="col-md-6">
				当前第${pageInfo.pageNum }页，共${pageInfo.pages }页,总${pageInfo.total }条记录
			</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  <!-- ===========================首页按钮================================= -->
				  	<c:if test="${pageInfo.pageNum==1}">
				  		<li><a href="#">首页</a></li>				  	
				  	</c:if>
				  	<c:if test="${pageInfo.pageNum!=1}">
				  		<li><a href="${APP_PATH }/emps?pn=1">首页</a></li>				  	
				  	</c:if>
				    <!-- ===========================前一页按钮================================= -->
				    <c:if test="${pageInfo.pageNum !=1 }">
					    <li>
					      <a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <!-- ===========================页码按钮================================= -->
				    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num== pageInfo.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>   
					    <c:if test="${page_Num != pageInfo.pageNum }">
					    	<li><a href="${APP_PATH }/emps?pn=${page_Num}">${page_Num }</a></li>
					    </c:if>
				    </c:forEach>
				    <!-- ===========================后一页按钮================================= -->
				    	<c:if test="${pageInfo.pageNum!=pageInfo.pages }">
				    		<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
				       	 		<span aria-hidden="true">&raquo;</span></a></li>
				     	 	
				    	</c:if>
				     <!-- ===========================尾页按钮================================= -->
				    <li><a href="${APP_PATH }/emps?pn=${pageInfo.pages }">末页</a></li>
				  </ul>
				</nav>
			</div>
		</div>	
	
	</div>
</body>
</html>