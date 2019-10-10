
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.usuarioLogado != null}">
    <%@include file="header.jsp" %>
</c:if>

<style>
#fundo {
	background: #D3D3D3;
	
}
img {
	opacity: 0.5;
	border-radius: 120px;
}
</style>
<body id=fundo>
<title>Sobre</title>
<div class="container">
    <br>
    <h3></h3>
    <h5></h5>
    <hr>

    <div class="row">
        <div class="col-sm-6">
            <div class="card border-primary">
                <div class="card-header bg-primary text-white"></div>
                <div class="card-body">
                    <p class="card-text"></p>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card border-primary">
                <div class="card-header bg-primary text-white"></div>
                <div class="card-body">
                    <p class="card-text"></p>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-6">
            <div class="card border-primary ">
                <div class="card-header bg-primary text-white"></div>
                <div class="card-body">
                    <p class="card-text"></p>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card border-primary">
                <div class="card-header bg-primary text-white"></div>
                <div class="card-body">
                    <p class="card-text"></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
