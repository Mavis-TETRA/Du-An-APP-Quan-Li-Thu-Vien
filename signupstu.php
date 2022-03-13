<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['mssv']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->signUpStu("student",  $_POST['mssv'], $_POST['password'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
