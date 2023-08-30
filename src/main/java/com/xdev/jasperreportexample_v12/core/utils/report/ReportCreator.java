
package com.xdev.jasperreportexample_v12.core.utils.report;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rapidclipse.framework.server.resources.ApplicationResource;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class ReportCreator
{

	private static final Logger        logger =
		LoggerFactory.getLogger(ReportCreator.class);
	private JRBeanCollectionDataSource dataSource;
	private String                     templatePath;
	private Map<String, Object>        parameterMap;

	public JRBeanCollectionDataSource getDataSource()
	{
		return this.dataSource;
	}

	public void setDataSource(final JRBeanCollectionDataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public String getTemplatePath()
	{
		return this.templatePath;
	}

	public void setTemplatePath(final String templatePath)
	{
		this.templatePath = templatePath;
	}

	public Map<String, Object> getParameterMap()
	{
		return this.parameterMap;
	}

	public void setParameterMap(final Map<String, Object> parameterMap)
	{
		this.parameterMap = parameterMap;
	}

	public StreamResource loadAndFillPDFReport() throws JRException, IOException
	{
		final JasperReport report = JasperCompileManager.compileReport(
			ApplicationResource.createInputStream(this.getClass(), this.templatePath));
		
		// final JasperReport report = (JasperReport)JRLoader.loadObject(
		// ApplicationResource.createInputStream(this.getClass(), this.templatePath));

		final StreamResource source = new StreamResource("", new InputStreamFactory()
		{

			@Override
			public InputStream createInputStream()
			{
				byte[] b = null;

				try
				{
					b = JasperRunManager.runReportToPdf(report, ReportCreator.this.parameterMap,
						ReportCreator.this.dataSource);
				}
				catch(final JRException ex)
				{
					ex.printStackTrace();
					System.out.println(ex.getMessage());
					ReportCreator.logger.info("Logger:" + ex.getMessage());
				}

				return new ByteArrayInputStream(b);
			}
		});

		source.setContentType("application/pdf");

		return source;
	}
}
