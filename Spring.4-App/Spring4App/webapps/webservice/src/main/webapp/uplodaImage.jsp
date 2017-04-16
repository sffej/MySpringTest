<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
</head>
<body>
  
  <fieldset style="width:300px;height:100px;">
  <legend style="font-size: 14px;font-weight: bold;">Upload Image</legend>
  <form action="rs/uploadimage-service/uploadImage" method="POST" enctype="multipart/form-data" >
    <table>
    <tr>
    <td>Select File</td>
    <td><input type="file" name="image" > </td>
    </tr>
    <tr>
    <td></td>
    <td align="right">
    <input type="submit" value="Upload" />
    </td>
    </tr>
    </table>
  </form>
  </fieldset>
  <br />
</body>
</html>