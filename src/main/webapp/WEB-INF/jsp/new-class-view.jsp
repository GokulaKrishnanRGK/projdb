<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Class</title>
</head>
<body>
<%@ include file="header-view.jsp" %>
<form method="POST" action="/create-class">
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td><label>Class name: </label></td>
                        <td><label>
                            <input name="className" type="text"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td><label>Description: </label></td>
                        <td><label>
                            <input name="description" type="text"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td><label>Term: </label></td>
                        <td><label>
                            <select name="term">
                                <option selected value="SPRING2023">Spring 2023</option>
                                <option value="FALL2023">Fall 2023</option>
                                <option value="SPRING2024">Spring 2024</option>
                                <option value="FALL2024">Fall 2024</option>
                            </select>
                        </label></td>
                    </tr>
                </table>
                <label>Choose students from below list: </label>
                <table>
                    <tr>
                        <td><label>Filter by Firstname: </label></td>
                        <td><input type="text" id="filterInput0" onkeyup="filterTable(0)"></td>
                    </tr>
                    <tr>
                        <td><label>Filter by Lastname: </label></td>
                        <td><input type="text" id="filterInput1" onkeyup="filterTable(1)"><br></td>
                    </tr>
                    <tr>
                        <td><label>Filter by Email: </label></td>
                        <td><input type="text" id="filterInput2" onkeyup="filterTable(2)"><br></td>
                    </tr>
                </table>
                <table border="1" id="userTable" onmouseover="scrollToBottom()">
                    <thead>
                    <tr>
                        <th onclick="sortTable(0)">Firstname</th>
                        <th onclick="sortTable(1)">Lastname</th>
                        <th onclick="sortTable(2)">Email</th>
                        <th>Select</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.students}" var="student">
                        <tr>
                            <td>${student['firstname']}</td>
                            <td>${student['lastname']}</td>
                            <td>${student['email']}</td>
                            <td><input type="checkbox" name="studentIds"
                                       value="${student['userId']}"
                                       onclick="handleCheckboxSelection(this)"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input type="submit" value="Create"/>
            </td>
            <td>
                <table border="1" id="selectedTable">
                    <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Selected rows will be dynamically added here -->
                    </tbody>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>

<script>
  function scrollToBottom() {
    var table = document.getElementById("userTable");
    table.scrollTop = table.scrollHeight;
  }

  function handleCheckboxSelection(checkbox) {
    var selectedTable = document.getElementById("selectedTable");
    var userTable = document.getElementById("userTable");

    if (checkbox.checked) {
      // Clone the selected row and append it to the second table
      var cloneRow = checkbox.parentNode.parentNode.cloneNode(true);
      selectedTable.querySelector('tbody').appendChild(cloneRow);

      // Remove the selected row from the first table
      userTable.querySelector('tbody').removeChild(checkbox.parentNode.parentNode);
    } else {
      // Clone the deselected row and append it back to the first table
      var cloneRow = checkbox.parentNode.parentNode.cloneNode(true);
      userTable.querySelector('tbody').appendChild(cloneRow);

      // Remove the deselected row from the second table
      selectedTable.querySelector('tbody').removeChild(checkbox.parentNode.parentNode);
    }
  }

  // Function to remove a row from the selected table
  function removeSelectedRow(button) {
    var selectedTable = document.getElementById("selectedTable");
    var userTable = document.getElementById("userTable");

    // Clone the removed row and append it back to the first table
    var cloneRow = button.parentNode.parentNode.cloneNode(true);
    userTable.querySelector('tbody').appendChild(cloneRow);

    // Remove the row from the second table
    selectedTable.querySelector('tbody').removeChild(button.parentNode.parentNode);
  }

  // Function to sort the table by a specific column
  function sortTable(columnIndex) {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("userTable");
    switching = true;

    while (switching) {
      switching = false;
      rows = table.rows;

      for (i = 1; i < (rows.length - 1); i++) {
        shouldSwitch = false;
        x = rows[i].getElementsByTagName("td")[columnIndex];
        y = rows[i + 1].getElementsByTagName("td")[columnIndex];

        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }

      if (shouldSwitch) {
        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
        switching = true;
      }
    }
  }

  // Function to filter the table based on user input
  function filterTable(columnIndex) {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("filterInput" + columnIndex);
    filter = input.value.toUpperCase();
    table = document.getElementById("userTable");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[columnIndex];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

</script>

<style>
  /* Add your custom styles here */
  table {
    max-width: 1000px; /* Set a maximum width for the table */
    max-height: 1000px; /* Set a maximum height for the table */
    overflow: auto; /* Enable both horizontal and vertical scrolling if needed */
    margin-bottom: 20px;
    border-collapse: collapse; /* Optional: Collapse borders for better appearance */
  }
</style>
</html>

