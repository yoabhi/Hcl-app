<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['mob']) && isset($_POST['sel_course']) && isset($_POST['ques']) && isset($_POST['state']) && isset($_POST['city'])) {
 
    $name = $_POST['name'];
    $email = $_POST['email'];
    $mob = $_POST['mob'];
	$sel_course = $_POST['sel_course'];
	$ques = $_POST['ques'];
	$state = $_POST['state'];
	$city = $_POST['city'];
	
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO enquiry(name, email,mob,sel_course,ques,state,city) VALUES('$name','$email','$mob','$sel_course','$ques','$state','$city')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "upload successfully .";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>