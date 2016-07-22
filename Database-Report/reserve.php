<?php
    if(!isset($_POST["reserve"])) {
        header("Location:frontend.php");
    }
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>填寫資料</title>
    <link rel="stylesheet" type="text/css" href="css/pure.min.css">
    <style>
    .container {
        font-family: "微軟正黑體";
        border: 1.5px solid white;
        border-radius: 10px;
        margin: 50px 10% 0px 10%;
        padding: 20px;
        background: rgba(0, 0, 0, 0.5);
        color: white;
    }
    body{
        background: url(img/paint-1280557_1920.jpg);
    }
    input, #message{
        color: black;
    }

</style>
</head>


<body>
    <div class="container">
        <form method="post" class="pure-form pure-form-aligned" action="infosql.php">
            <fieldset>
                <div class="pure-control-group">
                    <label for="title">借用名稱：</label>
                    <input type="text" name="title" id="title" placeholder="Group-title">
                </div>
                <br />
                <div class="pure-control-group">
                    <label for="name">借用人：</label>
                    <input type="text" name="name" id="name" placeholder="Name">
                </div>
                <br />
                <!--div class="pure-control-group">
                    <label for="classroom">借用教室：</label>
                    <input type="text" name="classroom" id="classroom" placeholder="Group-title">
                </div-->
                <br />
                <div class="pure-control-group">
                    <label for="email">聯絡信箱：</label>
                    <input type="text" name="email" id="email" placeholder="Email">
                </div>
                <br />
                <div class="pure-control-group">
                    <label for="department">系所：</label>
                    <input type="text" name="department" id="department" placeholder="Department">
                </div>
                <br />
                <div class="pure-control-group">
                    <label for="professor">教授：</label>
                    <input type="text" name="professor" id="professor" placeholder="Professor">
                </div>
                <br />
                <div class="pure-control-group">
                    <label for="message">備註：</label>
                    <textarea name="message" id="message" row="10" placeholder="Message"></textarea>
                </div>
                <div>
                    <?php
                        $checked = $_POST['reserve'];
                        for($i=0; $i < count($checked); $i++){
                            echo '<input type="hidden" name="time[]" value="'.$checked[$i].'" >';
                        }
                        if(isset($_POST['month'])){
                            $url = $_POST['month'];
                            echo '<input type="hidden" name="month" value="'.$url.'" >';
                        }
                    ?>
                </div>
                <div class="pure-controls">
                    <input type="submit" name="submit" value="submit" id="submit" class="pure-button pure-button-primary">
                </div>
            </fieldset>
        </form>
    </div>
</body>

</html>