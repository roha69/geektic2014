package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.Geek;
import com.ninja_squad.geektic.dao.GeekDAO;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Transactional
@RequestMapping("/api/geek")
@Service
public class GeekService {
	
	@Autowired
	private GeekDAO geekDAO;
	
    @RequestMapping(value = " /id/{id}",method = GET)
    public Geek getGeek(@PathVariable Long id) {
    	return geekDAO.findById(id);
    }
    
    @RequestMapping(method = GET)
    public List<Geek> listGeeks(){
   
    	return geekDAO.findAll();
    }
    
}
