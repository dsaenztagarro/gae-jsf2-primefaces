package com.davlanca.billmanager.util;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.mobile.device.site.SitePreferenceUtils;

public final class MobileFilter implements Filter {
	private FilterConfig filterConfig = null;

	private static final Logger log = Logger.getLogger(MobileFilter.class.getName());
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (filterConfig == null)
			return;
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		Device device = DeviceUtils.getRequiredCurrentDevice(httpServletRequest);
		SitePreference sitePreference = SitePreferenceUtils.getCurrentSitePreference(httpServletRequest);
		
		String isMobileDevice = Global.FALSE;
        if (device.isMobile() || sitePreference == SitePreference.MOBILE) {
            isMobileDevice = Global.TRUE;
        }
 
        log.info("isMobileDevice: " + isMobileDevice);
        
        httpServletRequest.getSession().setAttribute("isMobileDevice", isMobileDevice);
        
		chain.doFilter(request, response);
	}
}