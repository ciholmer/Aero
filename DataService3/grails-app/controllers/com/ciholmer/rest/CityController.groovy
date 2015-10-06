package com.ciholmer.rest

import grails.rest.RestfulController

class CityController extends RestfulController {
    static responseFormats = ['html', 'json', 'xml']
    CityController() {
        super(City)
    }
	
	def index(Integer max){
		params.max = Math.min(max ?:10, 100)
		def c = City.createCriteria()
		def results = c.list (params) {
			if(params.id){
				idEq(params.id.toInteger())
			}else if(params.cityName){
				eq('cityName', params.cityName)
			}else if(params.countryCode){
				eq('countryCode', params.countryCode)
			}else if(params.postalCode){
				eq('postalCode', params.postalCode)
			}
		}
		//respond results, model:[cityInstanceCount: results.totalCount]
		respond results
		
		//URL DATAService/city?countryCode=DE
		//
	}
}