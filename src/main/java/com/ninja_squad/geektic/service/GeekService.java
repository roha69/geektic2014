package com.ninja_squad.geektic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.Geek;
import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.dao.Interet;
import com.ninja_squad.geektic.dao.Geek.enumGenre;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Transactional
@RequestMapping("/api/geek")
@Service
public class GeekService {
	
	@Autowired
	private GeekDAO geekDAO;
	
    @RequestMapping(method = GET)
    public Geek getGeek(Long id) {
    	return geekDAO.findById(1L);
    }
}
