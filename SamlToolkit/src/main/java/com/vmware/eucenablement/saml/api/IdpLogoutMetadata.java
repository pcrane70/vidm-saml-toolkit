/*
 * VMware Identity Manager SAML Toolkit

Copyright (c) 2016 VMware, Inc. All Rights Reserved.

This product is licensed to you under the BSD-2 license (the "License").  You may not use this product except in compliance with the BSD-2 License.

This product may include a number of subcomponents with separate copyright notices and license terms. Your use of these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.

*/

package com.vmware.eucenablement.saml.api;

/**
 * IdpLogoutMetadata includes the information for single logout service from
 * VIDM
 *
 *
 */
public interface IdpLogoutMetadata {
	String getBinding();

	String getLocation();

	String getResponseLocation();
}