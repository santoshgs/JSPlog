<%-- 
    Document   : index
    Created on : 27 Dec, 2012, 11:35:23 PM
    Author     : Santosh
--%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String siteName = "JSP Blog";%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <title>Login to <%= siteName%></title>

        <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
        
        <link rel="stylesheet" type="text/css" media="screen" href="css/NIITSpecialStyle.css" />
    </head>
    <body>

        <!-- wrap starts here -->
        <div id="wrap">

            <!--header -->
            <div id="header">			

                <h1 id="logo-text"><a href="index.jsp" title="">JSP Blog</a></h1>		
                <p id="slogan">JSP based blogging system</p>	

                <div  id="nav">
                    <ul>
                        <li class="first" id="current"><a href="index.jsp">Home</a></li>
                    </ul>		
                </div>	

                <div id="header-image"></div>

                <!--header ends-->					
            </div>

            <!-- content -->
            <div id="content-outer" class="clear"><div id="content-wrap">

                    <div id="content">

                        <div id="left">			
                            <%@include file="loginForm.html" %>
                        </div>
                    </div>	

                    <!-- content end -->	
                </div></div>

            <!-- footer starts -->		
            <div id="footer-bottom">
                <div class="bottom-left">
                    <p>
                        &copy; 2012 <strong>Santosh G.S.</strong>&nbsp; &nbsp; &nbsp;
                    </p>
                </div>

                <div class="bottom-right">
                    <p>					
                        <a href="http://www.santoshgs.com/">Say hi!</a>							
                    </p>
                </div>
                <!-- footer ends -->		
            </div>

        </div>

    </body>
</html>
