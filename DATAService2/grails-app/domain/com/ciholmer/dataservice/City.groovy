package com.ciholmer.dataservice

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * City
 * Data for City and its associated postal and country codes
 */
@ToString(includeNames = true, includeFields = true, excludes= 'dateCreated,lastUpdated,metaClass')
@EqualsAndHashCode

class City {
	
	/* Default (injected) attributes of GORM */
	Long	id
	Long	version
	
	/* Automatic timestamping of GORM */
	Date	dateCreated
	Date	lastUpdated
	
	String cityName
	String stateName
	String postalCode
	String countryCode // either ios2 or iso3
	
    static constraints = {
			postalCode blank:false, nullable:false
			stateName blank:false, nullable:false
			cityName blank:false, nullable:false
			countryCode minSize:2, maxSize:3, blank:false, nullable:false, matches: "[A-Z]+"
	}
}
