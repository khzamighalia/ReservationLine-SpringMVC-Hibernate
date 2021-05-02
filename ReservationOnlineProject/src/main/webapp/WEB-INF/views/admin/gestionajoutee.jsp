<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Public/Style/Connexion.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css">
<script src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
</head>

<body style="font-family: 'Montserrat', sans-serif;">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img src="../resources/img/logo.png" style="width: 180px"></img>
</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="nav navbar-nav ml-auto">
      <li class="nav-item">
      <button type="button" class="btn btn-outline-danger text-danger"><a class="nav-link" href="${pageContext.servletContext.contextPath}/deconnexion">Se déconnecter</a>
      </button> 
        </li>

    </ul>
   </nav>

    <br>
<div class="container">
        <div class="row">
            <div class="col-9">
                    <h2 class="text-danger">Les dates disponibles </h2>
                        <div class="container" style="padding: 1%;">
        <div class="text-success" role="alert" style="padding: 2%; ">
            La date est ajouté avec succés
        </div>
    </div>
        <table class="table ">
            <tr>
                <th> Date </th><th> Places</th>
            </tr>
        <c:forEach items="${listRes}" var="g">
            <tr>
                <td>${g.date}</td>
                <td>${g.nmbr_places}</td>
            </tr>
        </c:forEach>
        </table>
        </div>
   
          <div class="col-3">
             <div class="border" style="width : 360px" >
                    <div class="form-group ">
                        <form action="registeresrv123" method="post">
                            <p style="text-align: center;;">Ajoutez les horaires disponibles !</p>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Date :</label>
                                <input type="date" name="date"  class="form-control"
					    		id="date" style="background-color: #E8EFF6; border-color: transparent;">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Nombre de places :</label>
                                    <input type="number" name="nmbr_places" min="1" step="1" class="form-control"
								id="nbrjrs" style="background-color: #E8EFF6; border-color: transparent;"
								aria-describedby="Nombre de jours">
                                </div>
                                <button type="submit" id="idAjoutButton" class="btn btn-danger" >Ajouter</button>
                                    
                                    </form>
                        </div>
                    </div>

    </div>
    <div></div>
    
    </div>
    </div>

    <div class="container">
        <h2 class="text-danger">Liste de validation</h2>
        <table class="table ">
            <tr>
                <th>Nom Complet</th><th>Email</th>
            </tr>
        <c:forEach items="${listUser}" var="p">
            <tr>
                <td>${p.nom_complet}</td>
                <td>${p.email}</td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="accepter" > <i class="fas fa-check text-success"></i></button>
                </form></td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="refuser" ><i class="fas fa-times text-warning"></i></button>
                </form></td>
            </tr>
        </c:forEach>
        </table>
    </div>
    
    







</body>
<script type="text/javascript">

 
function checkDate() {

	  var startDate = new Date(document.getElementById('date').value);
	  var today = new Date();
	  if (startDate.getTime() > today.getTime()) {
	    return true;
	  }
	  else return false;
	}
function validateMyForm()
{
	
  if(checkDate()==false)
  { 
    alert("La date ne doit pas être alterieur à la date d'aujourd'hui");
 
    return false;
  }else
 
  return true;
}
 
</script>

</html>