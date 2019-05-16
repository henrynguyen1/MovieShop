<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : ShipmentPage.xsl
    Created on : 16 May 2019, 3:25 PM
    Author     : HenryNguyen
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>ShipmentPage.xsl</title>
            </head>
            <body>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Shipments">
            <table width="500" class="table table-bordered">
                <tbody>
<tr>
                        <td>Order: </td>
                        <td width="400px"> 
                            <xsl:apply-templates select="Order"/>
                   
                        </td>
                    </tr>  
                    <tr>
                        <td>Items</td>
                        <td>
                            <xsl:apply-templates select="items"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td>
                            <xsl:apply-templates select="Quantity"/>
                        </td>
                     
                    <tr>
                        <td>Order Status</td>
                        <td>
                            <xsl:apply-templates select="Order Status"/>
                        </td>
                    </tr>
                    
    </xsl:template>

</xsl:stylesheet>

                    <tr>

</xsl:stylesheet>
