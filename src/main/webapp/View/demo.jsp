<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xml:lang>
<title>Demo</title>
<!-- Demo git up code  -->
<!--Pooop-->
<body>

    <h2>JavaScript Confirm Box</h2>


    <button onclick="myFunction()">Try it</button>

    <p id="demo"></p>

    <script>
        function myFunction() {
            var txt;
            if (confirm("Press a button!")) {
                txt = "You pressed OK!";
            } else {
                txt = "You pressed Cancel!";
            }
            document.getElementById("demo").innerHTML = txt;
        }
    </script>

</body>

</html>