<!-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){
   		$('#fun').click(function(){
   			n1 = document.getElementById('n1').value;
   			n2 = document.getElementById('n2').value;
   			op = document.getElementById('op').value;
   			jsndata = JSON.stringify({ "n1":n1, "n2":n2});
   			$.ajax({
                    url: window.location+"calculate/"+op,
                    type: 'POST',
                    contentType :'application/json',
                    data: jsndata,
                    
                    success: function (response) {
                    res = JSON.parse(response);
                    if(typeof res !== 'object')
						{
						 document.getElementById("result").innerHTML=response;
						}
						else
						{
                		 document.getElementById("result").innerHTML=
                		 "Sum : "+res.sum+" | Diff : "+res.diff+" | Product : "+res.product+" | Quotient : "+res.quotient;
						}
                    }, 
                    
                    error : function (response){
                    alert("failed to perform operation! Please check entered values and try again later");
                    }
             });
   		});
	});
   </script>
</head>
<body>

	<br>
	<h1>Calculator Service</h1>
	<form method="post" action="add">
		<input  id="n1" type="text" name="number1"/>
		<input id="n2" type="text" name="number2"/>
		<select id="op" name="method">
			  <option value="add">Add</option>
			  <option value="sub">Subtract</option>
			  <option value="mul">Multiply</option>
			  <option value="div">Divide</option>
			  <option value="all">ALL</option>
		</select>
		<input id="fun" type="button" value="RESULT"/>
	</form><br>
	<h2>Result is : </h2>
	<h2 id="result"></h2>
	<hr><br>
	<br><br>
	<!-- <h1>Database Service</h1>
	
	<a href="welcome">welcome</a><br>
	<a href="signup">Sign up</a><br>
	<a href="login">Login</a><br><br><hr> 
	 -->
</body>
</html>
