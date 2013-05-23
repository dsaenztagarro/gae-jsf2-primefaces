package com.davlanca.billmanager.util;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIOutput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.mobile.device.site.SitePreferenceUtils;

import com.davlanca.billmanager.service.BillServiceImpl;

/**
 * @author <a href="mailto:gesuino.napoli">Gesuino Napoli</a>
 *
 */
public class MobileViewHandler extends ViewHandlerWrapper {

	private static final Logger log = Logger.getLogger(MobileViewHandler.class.getName());
	
    private ViewHandler wrapped;

    public MobileViewHandler(ViewHandler wrapped) {
    	this.wrapped = wrapped;
    }

    @Override
    public ViewHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public String calculateRenderKitId(FacesContext context) {
    	/*HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Device device = DeviceUtils.getRequiredCurrentDevice(request);
        SitePreference sitePreference = SitePreferenceUtils.getCurrentSitePreference(request);

        log.info("Device.isMobile: " + (device.isMobile()? Global.TRUE : Global.FALSE));
        log.info("Device.isNormal: " + (device.isNormal()? Global.TRUE : Global.FALSE));
        log.info("Device.isTablet: " + (device.isTablet()? Global.TRUE : Global.FALSE));
        log.info("SitePreference.isMobile: " + (sitePreference == SitePreference.MOBILE? Global.TRUE : Global.FALSE));
        log.info("SitePreference.isNormal: " + (sitePreference == SitePreference.NORMAL? Global.TRUE : Global.FALSE));

        if (device.isMobile() || sitePreference == SitePreference.MOBILE) {
            return "PRIMEFACES_MOBILE";
        }
        
        request.setAttribute("isMobile", device.isMobile()? "T" : "F");
        request.setAttribute("isNormal", device.isNormal()? "T" : "F");
        request.setAttribute("isTablet", device.isTablet()? "T" : "F");*/

        return this.wrapped.calculateRenderKitId(context);
    }
}
