<%@ include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="InsertProduction"  modelAttribute="product" method="post">
   <table>
     <tr>
        <td>ProductName</td>
        <td><form:input path="productName"/>
        </td>
     </tr>
     
      <tr>
        <td>Price</td>
        <td><form:input path="price"/>
        </td>
     </tr>
    
    <tr>
        <td>Stock</td>
        <td><form:input path="stock"/>
        </td>
     </tr>
     
     <tr>
        <td>Category</td>
          <td><form:select path="categoryID">
              <from:option value="0" label="--Select List--"/>
              <from:option items="$(CategoryList)"/>
             </form:select>
        </td>
     </tr>
     <tr>
        <td>Supplier</td>
        <td><form:input path="supplier"/>
        </td>
     </tr>
     <tr>
        <td>Product Description</td>
        <td><form:input path="productDesc"/>
        </td>
     </tr>
     <tr>
        <td></td>
        <td><form:input path="submit" value="Insert"/>
        </td>
     </tr>
    
    
   </table>
   </form:form>
