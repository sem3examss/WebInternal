<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
    <body>
        <h1 align="center">Gayatri vidya parishad college of engineering(A)</h1>
        <h3 align="center">Room_no:216 Hostlers</h3> 
        <br/>
        <table border="2" align="center">
            <tr> 
                <th> Name </th>
                <th> Roll_no </th>
                <th> Department </th>
                <th> year </th>
                <th> section </th>
            </tr>
            	<xsl:for-each select="college/student">
            <tr>
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="department"/></td>
                    <td><xsl:value-of select="year"/></td>
                    <td><xsl:value-of select="section"/></td>
            </tr>
                </xsl:for-each>
        </table>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>