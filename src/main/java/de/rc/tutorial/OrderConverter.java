package de.rc.tutorial;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.extensions.model.timeline.TimelineEvent;

//Converter for the model class Order.java  
@FacesConverter("org.primefaces.extensions.showcase.converter.OrderConverter")  
public class OrderConverter implements Converter, Serializable {  

	private static final long serialVersionUID = 1L;

	private List<TimelineEvent> events;  

 public OrderConverter() {  
 }  

 public Object getAsObject(FacesContext context, UIComponent component, String value) {  
     if (StringUtils.isBlank(value) || events == null || events.isEmpty()) {  
         return null;  
     }  

     for (TimelineEvent event : events) {  
         if (((Order) event.getData()).getNumber() == Integer.valueOf(value)) {  
             return event;  
         }  
     }  

     return null;  
 }  

 public String getAsString(FacesContext context, UIComponent component, Object value) {  
     if (value == null) {  
         return null;  
     }  

     return String.valueOf(((Order) ((TimelineEvent) value).getData()).getNumber());  
 }  

 public List<TimelineEvent> getEvents() {  
     return events;  
 }  

 public void setEvents(List<TimelineEvent> events) {  
     this.events = events;  
 }  
}  