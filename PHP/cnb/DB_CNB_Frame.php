<?php
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 
 
$r=mysql_query("select * from cnb",$con);
 
while($row=mysql_fetch_array($r))
{
    $flag[]=$row;
}
 
print(json_encode($flag));
 
mysql_close($con);
 
?>
