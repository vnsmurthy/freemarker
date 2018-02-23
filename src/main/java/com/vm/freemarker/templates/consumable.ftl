<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>
  <p>${title}</p>
  <table>
  <tr>
    <th>ID</th>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Scores</th>
    <th>Graders</th>
  </tr>
  <#list students as student>
  <tr>
    <td>${student.id}</td>
    <td>${student.firstName}</td> 
    <td>${student.lastName}</td>
    <td>
	    <#list student.examScores as score>
	    	<p> subject: ${score.subject} score: ${score.score} </p>
	    </#list> 
    </td>
    <td>
       <#list student.examScores as score>
       <#if score.graders??>
	       	<#list score.graders as grader>
	       		<p> Name: ${grader.firstName} ${grader.lastName} </p>
	       	</#list>
       	</#if>
	   </#list>
    </td>
  </tr>
  </#list>
  </table>
</body>
</html>