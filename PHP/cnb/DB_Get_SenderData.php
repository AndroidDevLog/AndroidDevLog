<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 
$secnbid = $_REQUEST['se_cnbid'];
 
$seuid = $_REQUEST['se_uid'];
 
if($secnbid == 1) {
	 
	    $r=mysql_query("select * from admin where ad_id = '$seuid'",$con);
	     
	        while($row=mysql_fetch_array($r))
			    {
				            $flag['se_name']=$row['ad_name'];
					        }
		 

		    $flag['se_cnb'] = 'Admin';
}
 

if($secnbid == 2) {
	 
	    $r=mysql_query("select * from hod where ho_id = '$seuid'",$con);
	     
	        while($row=mysql_fetch_array($r))
			    {
				            $flag['se_name']=$row['ho_name'];
					        }
		 

		    $flag['se_cnb'] = 'HOD';
}
 

if($secnbid == 3) {
	 
	    $r=mysql_query("select * from staff where stf_id = '$seuid'",$con);
	     
	        while($row=mysql_fetch_array($r))
			    {
				            $flag['se_name']=$row['stf_name'];
					        }
		 

		    $flag['se_cnb'] = 'Staff';
}
 

if($secnbid == 4) {
	 
	    $r=mysql_query("select * from student where std_id = '$seuid'",$con);
	     
	        while($row=mysql_fetch_array($r))
			    {
				            $flag['se_name']=$row['std_name'];
					        }
		 
		    $flag['se_cnb'] = 'Student';
}
 

print(json_encode($flag));
 
mysql_close($con);
 
?>

Step 21 : Open www/cnb folder in C Drive create DB_Show_Previous_Msg.php and add following code :

<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='password';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 
$secnbid = $_REQUEST['se_cnbid'];
 
$seuid = $_REQUEST['se_uid'];
 
$r=mysql_query("select * from header where se_cnbid = '$secnbid' and se_uid = '$seuid'",$con);
 
while($row=mysql_fetch_array($r))
{
	    $msg['msgid']=$row['msg_id'];
}
 
$msgid = $msg['msgid'];
 

$r = mysql_query("select * from header where msg_id = '$msgid'", $con);
 
while($row = mysql_fetch_array($r)) {
	 
	    $flag[] = $row;
	     
}
 

print(json_encode($flag));
 
mysql_close($con);
 
?>

Step 22 : Open www/cnb folder in C Drive create DB_Update_Msg.php and add following code :

<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='password';
 
$db="cnb";
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 

 
$secnbid = $_REQUEST['se_cnbid'];
 
$seuid = $_REQUEST['se_uid'];
 
$msgid = $_REQUEST['msg_id'];
 
$msg = $_REQUEST['msg'];
 
$recount = $_REQUEST['recount'];
 

 
$r=mysql_query("delete from header where msg_id = '$msgid'",$con);
 

$flag = 0;
 
for($i=0; $i<$recount; $i++) {
	 
	    $geterror = "recnbid".$i;
	     
	        $errorid[$i] = $_REQUEST[$geterror];
	     
	        $er = $errorid[$i];
		 
		    if($r = mysql_query("insert into header values ('$secnbid', '$seuid', '$msgid', '$msg', '$er', now())", $con)) {
			     
			            $flag = $flag + 1;
				     
				        }
}
 

 
if ($flag == $recount) {
	 
	    $fl['code'] = 1;
}
 
else {
	 
	    $fl['code'] = 0;
}
 

 
print(json_encode($fl));
 
mysql_close($con);
 
?>
