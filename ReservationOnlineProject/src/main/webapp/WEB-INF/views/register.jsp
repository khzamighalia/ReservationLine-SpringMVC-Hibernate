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

<body>
<br>
<br>
<br>


       <div class="container">
        <div class="row">
            <div class="col-sm" >
                <div class="col-sm border" >
                    <div class="form-group ">
                        <div class="btn-group btn-group-toggle" data-toggle="buttons">
                            <label class="btn btn-light active">
                                <input type="radio" name="options"
                                    style=" border-color: black;" id="option1"
                                    onclick="location.href='${pageContext.request.contextPath}/connexion'"> Se connecter
                            </label>
                            <label class="btn btn-danger">
                                <input type="radio" name="options" id="option2" onclick="location.href='${pageContext.request.contextPath}/register'"> S'inscrire
                            </label>
                        </div>
                        <form action="register" method="post" style="align-content: center;">
                                                        <p>Si vous n'avez pas de compte, Inscrivez vous </p>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Nom complet:</label>
                                <input type="text" name="nom" class="form-control" id="exampleInputPassword1"
                                    style="background-color: #E8EFF6; border-color: transparent;">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email :</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                                    style="background-color: #E8EFF6; border-color: transparent;"
                                    aria-describedby="emailHelp">

                                </input>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mot de passe :</label>
                                    <input type="password" name="mdp" class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Confirmation de mot de passe :</label>
                                    <input type="password" name="Cmdp" class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">

                                </div>
              
                                <button type="submit" name="Inscription" class="btn btn-outline-danger"
                  >S'inscrire</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    </div>

    
      






</body>

</html>