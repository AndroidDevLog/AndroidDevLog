<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 

$key = $_REQUEST['cnbid'];
 
switch($key)
{
 
    case 1 :
 
        $r=mysql_query("select * from admin",$con);
 
        while($row=mysql_fetch_array($r))
        {
            $flag[]=$row;
        }
 
        break;
 
    case 2 :
 
        $r=mysql_query("select * from hod",$con);
 
        while($row=mysql_fetch_array($r))
        {
            $flag[]=$row;
        }
 
        break;
 
    case 3 :
 
        $r=mysql_query("select * from staff",$con);
 
        while($row=mysql_fetch_array($r))
        {
            $flag[]=$row;
        }
 
        break;
 
    case 4 :
 
        $r=mysql_query("select * from student",$con);
 
        while($row=mysql_fetch_array($r))
        {
            $flag[]=$row;
        }
 
        break;
 
}
 
 
print(json_encode($flag));
 
mysql_close($con);
 
?>
