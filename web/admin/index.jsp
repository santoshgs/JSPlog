<%-- 
    Document   : Administrator index
    Created on : 27 Dec, 2012, 11:35:23 PM
    Author     : Santosh
--%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String siteName="JSP Blog";%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>

        <title><%= siteName %> - Admin</title>

        <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
        <meta name="description" content="Site Description Here" />

        <link rel="stylesheet" type="text/css" media="screen" href="../css/NIITSpecialStyle.css" />

    </head>

    <body>

        <!-- wrap starts here -->
        <div id="wrap">

            <!--header -->
            <div id="header">			

                <h1 id="logo-text"><a href="index.html" title=""><%= siteName %></a></h1>		
                <p id="slogan">JSP based blogging system</p>	

                <div  id="nav">
                    <ul>
                        <li class="first" id="current"><a href="../index.jsp">Home</a></li>
                        <li><a href='AddPost.view'>New Post</a></li>	
                        <li><a href='../Logout.do'>Logout</a></li>	
                    </ul>		
                </div>	

                <div id="header-image"></div>

                <!--header ends-->					
            </div>


            <!-- content -->
            <div id="content-outer" class="clear"><div id="content-wrap">

                    <div id="content">

                        <div id="left">			

                            <h2>List of all posts:</h2>
                            <%
                                URL url = new URL("file:///C:/dev/Apache%20Tomcat%207.0.27/bin/index.txt");
                                URLConnection con = url.openConnection();
                                con.connect();
                                InputStream is = (InputStream) con.getContent();
                                InputStreamReader isr = new InputStreamReader(is);
                                BufferedReader br = new BufferedReader(isr);
                                String line = br.readLine();
                                while (line != null) {
                                    out.println(line);
                                    line = br.readLine();
                                }
                                br.close();
                            %> 			

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
