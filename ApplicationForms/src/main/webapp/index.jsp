<html>
<head>
	<title>Application Forms</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
	<meta charset="UTF-8"/>	
	<link rel="stylesheet" href="application.css"/>
</head>
<body>
<div id="content">
<div id="content_bg"></div>
<h1>College application form:</h1>
<form action="Register" method="post">
	First Name:<span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fname" required="required" autofocus="autofocus"/><br/>
	Last Name:<span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lname" required="required"/><br/>
	Date of birth:<span class="mandatory">*</span> <input type="date"  name="dob" required="required"/><br/>
	Contact:<span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="number" name="contact" required="required"/><br/>
	Email:<span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email" required="required"/><br/>
	Address:<span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" maxlength="500" required="required"/><br/>
	Select Course:<span class="mandatory">*</span> <select name="course" required="required">
					<option value="Please select a course" selected="selected" disabled="disabled" hidden="hidden">Please select a course</option>
					<option value="BBA">BBA</option>
					<option value="B.Tech">B.Tech</option>
					<option value="others">Others</option>					
				</select><br/>
	Reference:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="reference"/><br/>
	<input id="apply" type="submit" name="apply" value="Apply Now"/>
</form>
</div>
</body>
</html>
