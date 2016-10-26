<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 

$recnbid = $_REQUEST['re_cnbid'];
 

$r=mysql_query("select count(*) from header where re_cndid = '$recnbid'",$con);
 
while($row=mysql_fetch_array($r))
{
	    $flag['count']=$row[0];
}
 

print(json_encode($flag));
 
mysql_close($con);
 
?>
