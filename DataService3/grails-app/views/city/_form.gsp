<%@ page import="com.ciholmer.rest.City" %>



<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'postalCode', 'error')} required">
	<label for="postalCode">
		<g:message code="city.postalCode.label" default="Postal Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="postalCode" required="" value="${cityInstance?.postalCode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'stateName', 'error')} required">
	<label for="stateName">
		<g:message code="city.stateName.label" default="State Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="stateName" required="" value="${cityInstance?.stateName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'cityName', 'error')} required">
	<label for="cityName">
		<g:message code="city.cityName.label" default="City Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cityName" required="" value="${cityInstance?.cityName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'countryCode', 'error')} required">
	<label for="countryCode">
		<g:message code="city.countryCode.label" default="Country Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryCode" maxlength="3" pattern="${cityInstance.constraints.countryCode.matches}" required="" value="${cityInstance?.countryCode}"/>

</div>

