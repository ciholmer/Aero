// Place your Spring DSL code here
import com.ciholmer.dataservice.util.*

import grails.rest.render.xml.*
import grails.rest.render.json.*
import com.ciholmer.dataservice.City


beans = {
    cityMarshallerRegistrar(CityMarshaller)
	
	cityXmlRenderer(XmlRenderer, City) {
		excludes = ['class', 'dateCreated']
	}
	cityJSONRenderer(JsonRenderer, City) {
		excludes = ['class', 'dateCreated']
	}
	cityXmlCollectionRenderer(XmlCollectionRenderer, City) {
		excludes = ['class', 'dateCreated']
	}
	cityJSONCollectionRenderer(JsonCollectionRenderer, City) {
		excludes = ['class', 'dateCreated']
	}
}
