import com.ciholmer.dataservice.City
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_DATAService_city_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/city/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cityInstance, field: 'postalCode', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("city.postalCode.label"),'default':("Postal Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("postalCode"),'required':(""),'value':(cityInstance?.postalCode)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cityInstance, field: 'stateName', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("city.stateName.label"),'default':("State Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("stateName"),'required':(""),'value':(cityInstance?.stateName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cityInstance, field: 'cityName', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("city.cityName.label"),'default':("City Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("cityName"),'required':(""),'value':(cityInstance?.cityName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cityInstance, field: 'countryCode', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("city.countryCode.label"),'default':("Country Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("countryCode"),'maxlength':("3"),'pattern':(cityInstance.constraints.countryCode.matches),'required':(""),'value':(cityInstance?.countryCode)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443979881287L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
