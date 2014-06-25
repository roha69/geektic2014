package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.Interet;
import com.ninja_squad.geektic.dao.InteretDAO;

@RestController
@Transactional
@RequestMapping("/api/interet")
@Service
public class InteretService {
	
	@Autowired
	private InteretDAO interetDAO;
	
    @RequestMapping(method = GET)
    public List<Interet> listinterets(){
    	return interetDAO.findAll();
    }
    
}
