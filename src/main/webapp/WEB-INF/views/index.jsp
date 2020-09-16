<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="./base.jsp"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container mt-3">
<div class = "row">

<div class= "col-md-12">
<h1 class= "text-center mb-3">Welcome to Product CRUD App</h1>
<table class="table">

  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
         <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <!-- <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr> -->
    <c:forEach items="${product}" var="p">
     <tr>
      <th scope="row">${p.id}</th>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td class= "font-weight-bold">&#8377; ${p.price}</td>
      <td><a href = "delete/${p.id}"><i class="fas fa-trash-alt"></i>

      </a><a href = "update/${p.id}"><i class="fas fa-pen-nib"></i>

      </a></td>
    </tr>
    
    </c:forEach>
  </tbody>
</table>


</div>
<div class="container text-center">

<a class="btn btn-outline-success" href="add-product" role="button">Add Product</a>

</div>
</div>

</div>
</body>
</html>