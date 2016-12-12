/*
 * VMware Identity Manager SAML Toolkit

Copyright (c) 2016 VMware, Inc. All Rights Reserved.

This product is licensed to you under the BSD-2 license (the "License").  You may not use this product except in compliance with the BSD-2 License.

This product may include a number of subcomponents with separate copyright notices and license terms. Your use of these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.

*/
package com.vmware.eucenablement.saml.impl;

import java.util.ArrayList;
import java.util.List;

import com.vmware.eucenablement.saml.api.IdpLogoutMetadata;
import com.vmware.eucenablement.saml.api.IdpMainMetadata;
import com.vmware.eucenablement.saml.api.IdpSsoMetadata;

public class IdpMainMetadataImpl implements IdpMainMetadata {

	/**X509 certificate of VIDM for signing*/
	private String signingKey = null;

	/**X509 certificate of VIDM for encrpytion*/
	private String encrpytionKey = null;

	/**URI of VIDM for idp*/
	private String idpUri = null;

	/**metadata list of single sign on service for VIDM*/
	private List<IdpSsoMetadata> ssoMetadataList = new ArrayList<IdpSsoMetadata>();

	/**metadata list of single log out service for VIDM*/
	private List<IdpLogoutMetadata> logoutMetadataList = new ArrayList<IdpLogoutMetadata>();

	@Override
	public String getSigningKey() {
		return this.signingKey;
	}

	@Override
	public String getEncrpytionKey() {
		return this.encrpytionKey;
	}

	@Override
	public List<IdpSsoMetadata> getSsoMetadata() {
		return ssoMetadataList;
	}

	@Override
	public List<IdpLogoutMetadata> getLogoutMetadata() {
		return this.logoutMetadataList;
	}


    /**
     * Sets the X509 certificate of VIDM for signing.
     *
     * @param signingKey X509 certificate of VIDM for signing
     */
	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}

    /**
     * Sets the X509 certificate of VIDM for encryption.
     *
     * @param signingKey X509 certificate of VIDM for encryption
     */
	public void setEncrpytionKey(String encrpytionKey) {
		this.encrpytionKey = encrpytionKey;
	}

    /**
     * Add the SSO information.
     *
     * @param binding 	binding type of SSO service on VIDM
     * @param location 	URI, usually a URL, for the location of the SSO service on VIDM
     */
	public void addSsoMetadata(String binding, String location) {
		IdpSsoMetadata ssoMetadata = new IdpSsoMetadataImpl(binding, location);
		if (this.ssoMetadataList != null) {
			this.ssoMetadataList.add(ssoMetadata);
		}
	}

    /**
     * Add the single logout information on VIDM.
     *
     * @param binding 			binding type of SLO service on VIDM
     * @param location 			URI, usually a URL, for the location of the SLO service on VIDM
     * @param responseLocation 	the SLO responses should be sent to this location
     */
	public void addLogoutMetadata(String binding, String location, String responseLocation) {
		IdpSingleLogoutMetadataImpl logoutMetadata = new IdpSingleLogoutMetadataImpl(binding, location,
				responseLocation);
		this.logoutMetadataList.add(logoutMetadata);
	}


	/**
     * set the Idp URI.
     *
     * @param uri 	IDP URI
     */
	public void setIdpUri(String uri) {
		this.idpUri = uri;
	}

	@Override
	public String getIdpUri() {
		return idpUri;
	}

}
