package com.ciholmer.dataservice

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
	
	
	/* Does not follow Rest model, need to override index
	def search(String property, String value) {
		
		respond City.createCriteria().list {
		  like property, "%$value%"
		}
	}
		
	def search(){
		def results = City.createCriteria().list {
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
			render results
	}
	
	def show(City cityInstance) {
		respond cityInstance
	}
	*/
}
