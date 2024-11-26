<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kids Learning App</title>
    <style>
        body {
            font-family: 'Comic Sans MS', sans-serif;
            background-color: #FFF7E9; /* Soft peach */
            color: #333;
            text-align: center;
        }
        h1 {
            color: #FF8A5C; /* Warm orange */
            margin-bottom: 20px;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 90%;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #FFB084;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #FF8A5C;
            color: white;
            font-size: 16px;
        }
        td {
            background-color: #FFF3E1;
            font-size: 14px;
        }
        tr:hover {
            background-color: #FFE1C5;
        }
        p {
            color: #555;
        }
    </style>
</head>
<body>
    <h1>Kids Learning App - Lesson Library</h1>
    <p>Explore fun and interactive lessons tailored for young learners!</p>

    <?php
    // Load the XML file
    $xml = simplexml_load_file("data.xml") or die("<p style='color:red;'>Error: Cannot load XML file.</p>");

    // Display the data in a table
    echo "<table>";
    echo "<tr>
            <th>Lesson Title</th>
            <th>Topic</th>
            <th>Level</th>
            <th>Duration</th>
            <th>Description</th>
          </tr>";
    foreach ($xml->lesson as $lesson) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($lesson->title) . "</td>";
        echo "<td>" . htmlspecialchars($lesson->topic) . "</td>";
        echo "<td>" . htmlspecialchars($lesson->level) . "</td>";
        echo "<td>" . htmlspecialchars($lesson->duration) . "</td>";
        echo "<td>" . htmlspecialchars($lesson->description) . "</td>";
        echo "</tr>";
    }
    echo "</table>";
    ?>
</body>
</html>
