<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where mssv = " . $username . "";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['mssv'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && $dbpassword == $password) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function logInAdmin($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where id_lib = " . $username . "";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['id_lib'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && $dbpassword == $password) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUpStu($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql =
            "UPDATE " . $table . "
            SET password = '". $password ."' WHERE mssv = ". $username ."" ;
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function signUpAdmin($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql =
            "UPDATE " . $table . "
            SET password = '". $password ."' WHERE id_lib = ". $username ."" ;
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    // function signUpStu($table, $fullname, $email, $username, $password)
    // {
    //     $fullname = $this->prepareData($fullname);
    //     $username = $this->prepareData($username);
    //     $password = $this->prepareData($password);
    //     $email = $this->prepareData($email);
    //     $password = password_hash($password, PASSWORD_DEFAULT);
    //     $this->sql =
    //         "INSERT INTO " . $table . " (mssv,name_stu,birth,phone_stu,class,majors,course,address_stu,date_crt,password) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
    //     if (mysqli_query($this->connect, $this->sql)) {
    //         return true;
    //     } else return false;
    // }

}

?>
