<?php
 
$host = '127.0.0.1';
$uname = 'root';
$pwd = 'root';
$db = "Sample";
 
$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
mysql_select_db($db,$con) or die("db selection failed");
 
$id = $_REQUEST['id'];
 
$flag[pass] = 'Unknown';
$flag[name] = 'Unknown';
$flag[id] = 'Unknown';
 
$r = mysql_query("select * from student where id = '$id'",$con);
 
while($row = mysql_fetch_array($r))
{
    $flag[pass] = $row[pwd];
    $flag[name] = $row[uname];
    $flag[id] = $row[id];
}
 
print(json_encode($flag));
mysql_close($con);
 
?>
