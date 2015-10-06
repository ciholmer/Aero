// Place your Spring DSL code here
import grails.rest.render.xml.*
import grails.rest.render.json.*
import com.ciholmer.rest.City
//import com.ciholmer.rest.util.*
 
beans = {
	//cityMarshallerRegistrar(CityMarshaller)
	
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