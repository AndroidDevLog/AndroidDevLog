<?php
$host='127.0.0.1';
$uname='root';
$pwd='root';
$db="android";

$con = mysql_connect($host, $uname, $pwd) or die('Connection Failed');
mysql_select_db($db, $con) or die('Database Selection Failed');

$query = mysql_query("SELECT * FROM sample", $con);

while($row = mysql_fetch_array($query)) {
	$flag[] = $row;
}

print(json_encode($flag));
mysql_close($con);
?>
