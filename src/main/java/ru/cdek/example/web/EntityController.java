package ru.cdek.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import ru.cdek.example.model.Entity;
import ru.cdek.example.service.EntityService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class EntityController {

	private static final Logger logger = LoggerFactory.getLogger(EntityController.class);
			
	@Autowired
	private EntityService entityService;
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@RequestMapping(value = "/entities", method = RequestMethod.GET) 
	public String showEntityList(Map<String, Object> model) {
		model.put("entities", entityService.findEntities());
		return "entityList";
	}
	
	@RequestMapping(value = "/entity/create", method = RequestMethod.GET)
	public String initEntity(Map<String, Object> model) {
		Entity entity = new Entity();
		model.put("entity", entity);
		return "createEntity";
	}
	
	@RequestMapping(value = "/entity/create", method = RequestMethod.POST)
	public String createEntity(@Valid Entity entity, BindingResult result, SessionStatus status) {
		if(result.hasErrors()) {
			return "createEntity";
		} else {
			this.entityService.saveEntity(entity);
			status.setComplete();
			return "redirect:/entities";
		}
	}
}
