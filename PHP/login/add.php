<?php
 
$host = '127.0.0.1';
$uname = 'root';
$pwd = 'root';
$db = "Sample";
 
$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
mysql_select_db($db,$con) or die("db selection failed");
 
$id = $_REQUEST['id'];
$name = $_REQUEST['name'];
$pass = $_REQUEST['pass'];
 
$flag['code'] = 0;
 
if($r = mysql_query("insert into student values('$name', '$pass', '$id') ",$con))
{
    $flag['code']=1;
}
 
print(json_encode($flag));
mysql_close($con);
 
?>
