<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Database Manager for Kids</title>
    <style>
        /* Styling is the same as your original code */
        body {
            font-family: 'Comic Sans MS', sans-serif;
            background-color: #FFFBF0;
            color: #444;
            text-align: center;
        }
        h1 {
            color: #FF6F61;
        }
        h2 {
            color: #6AB7FF;
        }
        form {
            margin: 20px auto;
            padding: 15px;
            background-color: #FFF5E4;
            border: 2px solid #FF6F61;
            border-radius: 10px;
            max-width: 400px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-size: 16px;
        }
        input, button, select {
            margin-top: 10px;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #FF6F61;
            border-radius: 5px;
        }
        button {
            background-color: #FF6F61;
            color: #FFF;
            cursor: pointer;
        }
        button:hover {
            background-color: #FF8A75;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            background: #FFF5E4;
            border: 1px solid #FF6F61;
            border-radius: 5px;
            padding: 10px;
            margin: 5px auto;
            display: inline-block;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            border: 1px solid #FF6F61;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #FF8A75;
            color: white;
        }
        td {
            background-color: #FFF5E4;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Database Manager!</h1>
    <p>Learn and play with databases!</p>

    <!-- Form to create a database -->
    <form method="POST" action="">
        <label for="db_name">🌟 Enter Database Name:</label><br>
        <input type="text" id="db_name" name="db_name" placeholder="E.g., MyDatabase" required>
        <button type="submit" name="create_db">Create Database</button>
    </form>

    <hr>

    <h2>Available Databases 📚</h2>
    <ul>
        <?php
        // Database connection parameters
        $servername = "localhost";
        $username = "root";
        $password = "";

        // Create connection
        $conn = new mysqli($servername, $username, $password);

        // Check connection
        if ($conn->connect_error) {
            die("<p style='color:red;'>Connection failed: " . $conn->connect_error . "</p>");
        }

        // Handle database creation
        if (isset($_POST['create_db'])) {
            $db_name = $conn->real_escape_string($_POST['db_name']);
            $sql = "CREATE DATABASE `$db_name`";
            if ($conn->query($sql) === TRUE) {
                echo "<p style='color:green;'>Database <strong>$db_name</strong> created successfully!</p>";
            } else {
                echo "<p style='color:red;'>Error creating database: " . $conn->error . "</p>";
            }
        }

        // Fetch and display databases
        $result = $conn->query("SHOW DATABASES");
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $db_name = $row['Database'];
                echo "<li>
                    <form method='POST' action=''>
                        <input type='hidden' name='view_db' value='$db_name'>
                        <button type='submit'>View Tables in $db_name</button>
                    </form>
                </li>";
            }
        } else {
            echo "<li>No databases found.</li>";
        }

        $conn->close();
        ?>
    </ul>

    <?php
    // Handle viewing database tables and their contents
    if (isset($_POST['view_db'])) {
        $db_name = $_POST['view_db'];
        echo "<h2>Tables in Database: $db_name</h2>";

        // Connect to the selected database
        $conn = new mysqli($servername, $username, $password, $db_name);

        if ($conn->connect_error) {
            die("<p style='color:red;'>Connection failed: " . $conn->connect_error . "</p>");
        }

        // Fetch tables in the database
        $result = $conn->query("SHOW TABLES");
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_array()) {
                $table_name = $row[0];
                echo "<form method='POST' action=''>
                        <input type='hidden' name='view_table' value='$table_name'>
                        <input type='hidden' name='db_name' value='$db_name'>
                        <button type='submit'>View Entries in Table: $table_name</button>
                    </form>";
            }
        } else {
            echo "<p>No tables found in the database.</p>";
        }

        $conn->close();
    }

    // Handle viewing entries in a specific table
    if (isset($_POST['view_table'])) {
        $db_name = $_POST['db_name'];
        $table_name = $_POST['view_table'];
        echo "<h2>Entries in Table: $table_name (Database: $db_name)</h2>";

        // Connect to the selected database
        $conn = new mysqli($servername, $username, $password, $db_name);

        if ($conn->connect_error) {
            die("<p style='color:red;'>Connection failed: " . $conn->connect_error . "</p>");
        }

        // Fetch entries from the table
        $result = $conn->query("SELECT * FROM `$table_name`");
        if ($result->num_rows > 0) {
            echo "<table><tr>";
            // Display column names
            while ($field_info = $result->fetch_field()) {
                echo "<th>" . $field_info->name . "</th>";
            }
            echo "</tr>";
            // Display rows
            while ($row = $result->fetch_assoc()) {
                echo "<tr>";
                foreach ($row as $value) {
                    echo "<td>" . htmlspecialchars($value) . "</td>";
                }
                echo "</tr>";
            }
            echo "</table>";
        } else {
            echo "<p>No entries found in the table.</p>";
        }

        $conn->close();
    }
    ?>
</body>
</html>
