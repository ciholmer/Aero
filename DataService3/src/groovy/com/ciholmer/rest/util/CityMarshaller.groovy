package com.ciholmer.rest.util
 
import grails.converters.*
import com.ciholmer.rest.City
 
class CityMarshaller {
    @javax.annotation.PostConstruct
    void register() {
        log.info "Registering City Marshaller ..."
        JSON.registerObjectMarshaller (City) { City city ->
            def output = [:]
            output['name of city'] = city.cityName
            output['country of city'] = city.countryCode
            output['last update'] = city.dateCreated.format('dd MMM yyyy HH:mm:ss')
            return output;
        }
        log.info "Finished registering City Marshaller!"
    }
}