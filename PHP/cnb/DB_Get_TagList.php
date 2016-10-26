<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 

$msgid = $_REQUEST['msg_id'];
 

$r=mysql_query("select re_cndid from header where msg_id = '$msgid'",$con);
 
while($row=mysql_fetch_array($r))
{
	    $flag[]=$row;
}
 

print(json_encode($flag));
 
mysql_close($con);
 
?>
