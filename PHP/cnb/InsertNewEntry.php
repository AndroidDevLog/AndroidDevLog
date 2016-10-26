<?php
 
$host='127.0.0.1';
 
$uname='root';
 
$pwd='root';
 
$db='cnb';
 

$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
 
mysql_select_db($db,$con) or die("db selection failed");
 

 
$secnbid = $_REQUEST['se_cnbid'];
 
$seuid = $_REQUEST['se_uid'];
 
$msg = $_REQUEST['msg'];
 
$recount = $_REQUEST['recount'];
 

if($r=mysql_query("select max(msg_id) as asd from header",$con))
{
	 
	    while($row=mysql_fetch_array($r))
		        {
				 
				        $msgid = $row['asd'];
					    }
	     
	        $msgid = $msgid + 1;
}
 
else {
	 
	    $msgid = 1;
}
 

 
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
