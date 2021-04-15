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
    <title>S'inscrire</title>
</head>

<body style="font-family: 'Montserrat', sans-serif; ">


	
    <div class="container" style="padding: 0%;">
        <div class="row">
            <div class="col-sm" style="padding: 6%; margin-left: -160px; ">
                <div class="col-sm border" style="padding: 15%;">
                    <div class="form-group ">
                        <div class="btn-group btn-group-toggle" data-toggle="buttons"> 
                            <label class="btn btn-primary">
                                <input type="radio" name="options" id="option2"> Se connecter
                            </label>
                            <label class="btn btn-light active">
                                <input type="radio" name="options"
                                    style="border-radius: 1.5em; border-color: black; width: 150px ;" id="option1"
                                    onclick="'${pageContext.request.contextPath}/register'"> S'inscrire
                            </label>
                        </div>
                        <form action="connexion" method="post" style="align-content: center;">
                            <div class="text-danger" role="alert">
  					Votre demande d'inscription a été rejetée
				</div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email :</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                                    style="background-color: #E8EFF6; border-color: transparent;"
                                    aria-describedby="emailHelp">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mot de passe :</label>
                                    <input type="password" name="mdp" class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault" style="font-size: 10px;">
                                        I accept to share my data with us. I acknowledge that the
                                        collection and use of my personal data will follow
                                        the treatment as described on their privacy policies
                                    </label>
                                </div>
                                <button type="submit" name="Inscription" class="btn btn-primary"
                                    style="  padding:8px 25px; margin-left: 150px; border-radius: 2em;">Se connecter</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
    </div>




</body>

</html>