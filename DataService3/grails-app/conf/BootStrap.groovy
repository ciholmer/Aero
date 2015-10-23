import com.ciholmer.rest.City
import grails.util.Environment
//import org.springframework.web.context.support.WebApplicationContextUtils

class BootStrap {
	def init = { servletContext ->
		// Get spring context
		//def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )
		// register Custom Object Marshaller
		//springContext.getBean( "cityMarshallerRegistrar").register()

		def result = '################## running in UNCLEAR mode.'
		println "Application starting ... "
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
				result = 'now running in DEV mode.'
				seedTestData()
				break;
			case Environment.TEST:
				result = 'now running in TEST mode.'
				break;
			case Environment.PRODUCTION:
				result = 'now running in PROD mode.'
				seedProdData()
				break;
		}
		println "current environment: $Environment.current"
		println "$result"
	}

	def destroy = { println "Application shutting down... " }

	private void seedTestData() {
		def city = null
		println "Stating loading citites into database"
		city = new City(cityName: 'Munich', stateName: 'BY', postalCode: "81927", countryCode: 'DE')
		assert city.save(failOnError:true, flush:true, insert: true)
		city.errors = null

		city = new City(cityName: 'Berlin', stateName: 'BE',postalCode: "10115", countryCode: 'DE')
		assert city.save(failOnError:true, flush:true, insert: true)
		city.errors = null

		assert City.count == 2;
		println "Finished loading $City.count cities into database"

	}
	private void seedProdData() {

		if (City.count == 0){
			def city = null
			log.debug("Begining Data Import")
			println "Stating loading citites into database"

			city = new City(cityName: 'Munich', stateName: 'BY', postalCode: "81927", countryCode: 'DE')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			city = new City(cityName: 'Berlin', stateName: 'BE',postalCode: "10115", countryCode: 'DE')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			city = new City(cityName: 'Washington', stateName: 'DC',postalCode: "20001", countryCode: 'US')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			city = new City(cityName: 'Washington', stateName: 'DC',postalCode: "20002", countryCode: 'US')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			city = new City(cityName: 'Dulles', stateName: 'VA',postalCode: "20101", countryCode: 'US')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			city = new City(cityName: 'Sterling', stateName: 'VA',postalCode: "20164", countryCode: 'US')
			assert city.save(failOnError:true, flush:true, insert: true)
			city.errors = null

			assert City.count == 6;
			println "Finished loading $City.count cities into database"
		}else{
			println "Curent DB city count - $City.count. Not loading new cities into database"
		}
		/* Argh
		 * println "Starting Prod Data Import"
		 def filePath = "data/zip_codes.csv"
		 println "Loading classpath:$filePath"
		 def importFile = this.class.classLoader.getResource("data/zip_codes.csv").file
		 def i = 1
		 importFile.splitEachLine(',') {fields ->
		 city = new City(
		 cityName :	fields[0],
		 stateName :	fields[1],
		 postalCode :	fields[3],
		 countryCode :	fields[4] )
		 city.validate()
		 if (city.hasErrors()){
		 log.debug("Could not import line ${i} due to ${importFile.errors}")
		 } else {
		 log.debug("Importing line ${i}: ${importFile.toString()}")
		 city.save(failOnError: true, flush: true)
		 }
		 ++i
		 }*/
		println "Finished loading $City.count cities into database"
	}
}