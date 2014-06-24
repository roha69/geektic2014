package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.Geek;
import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.dao.Interet;
import com.ninja_squad.geektic.dao.InteretDAO;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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
