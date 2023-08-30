
package com.xdev.jasperreportexample_v12;

import javax.servlet.annotation.WebServlet;

import com.rapidclipse.framework.server.RapServlet;


@WebServlet(urlPatterns = "/*", asyncSupported = true)
public class AppServlet extends RapServlet
{
	public AppServlet()
	{
		super();
	}
}
